package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.Level;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.util.NumberUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RunasStriveStage implements Stage {

    private final Level level;
    private final int room;
    private final List<Team> teams;
    private int current;

    @SafeVarargs
    public RunasStriveStage(Level level, int room, List<Entity>... teams) {
        this.level = level;
        this.room = room;
        this.teams = Arrays.stream(teams).map(StageTeam::new).collect(Collectors.toList());
    }

    private Team[] getOpponents(Entity from) {
        return this.teams.stream().filter(team -> !team.hasMember(from)).toArray(Team[]::new);
    }

    private Team getCurrentTeam() {
        return this.teams.get(this.current);
    }

    private void turn() {
        Entity turn = this.getCurrentTeam().getTurnEntity();
        turn.turn(this, this.getOpponents(turn));
    }

    @Override
    public void start() {
        this.turn();
    }

    @Override
    public void next() {
        if (this.teams.removeIf(Team::isDead) && this.teams.size() <= 1) {
            this.level.onStageEnd(this.teams.size() == 0 ? null : this.teams.get(0));
            return;
        }

        if (this.getCurrentTeam().hasFinished()) {
            this.current = NumberUtils.getNext(this.current, this.teams.size());
            this.getCurrentTeam().prepareTurn();
        }

        this.turn();
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
    public Team[] getTeams() {
        return this.teams.toArray(Team[]::new);
    }
}