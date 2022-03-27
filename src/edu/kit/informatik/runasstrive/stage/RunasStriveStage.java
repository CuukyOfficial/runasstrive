package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.Level;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.util.SaveIterator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RunasStriveStage implements Stage {

    private final Level level;
    private final int room;
    private final List<Team> teams;
    private SaveIterator<Team> round;

    @SafeVarargs
    public RunasStriveStage(Level level, int room, List<Entity>... teams) {
        this.level = level;
        this.room = room;
        this.teams = Arrays.stream(teams).map(entity ->
            new StageTeam(this, entity)).collect(Collectors.toList());
    }

    @Override
    public void start() {
        this.round = new SaveIterator<>(this.teams);
        this.next();
    }

    @Override
    public void next() {
        if (this.isOver()) {
            this.level.onStageEnd(this.teams.get(0));
            return;
        }

        if (this.round.isFinished()) {
            this.start();
        } else this.round.next().turn();
    }

    @Override
    public boolean isOver() {
        this.teams.removeIf(Team::isDead);
        return this.teams.size() <= 1;
    }

    @Override
    public int getStage() {
        return this.room;
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    @Override
    public Team[] getOpponents(Team team) {
        return this.teams.stream().filter(teams -> !teams.equals(team)).toArray(Team[]::new);
    }

    @Override
    public Team[] getTeams() {
        return this.teams.toArray(Team[]::new);
    }
}