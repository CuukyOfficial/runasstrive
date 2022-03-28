package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.Level;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.util.SaveIterator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This will take care of alle the teams.
 * A stage ends if every team of the stage is dead.
 *
 * @author uvgsj
 * @version v0.1
 */
public class RunasStriveStage implements Stage {

    private final Level level;
    private final int stage;
    private final List<Team> teams;
    private SaveIterator<Team> round;

    /**
     * Creates a new stage.
     *
     * @param level The level of the stage
     * @param stage The stage number of the stage
     * @param teams The teams of the stage
     */
    @SafeVarargs
    public RunasStriveStage(Level level, int stage, List<Entity>... teams) {
        this.level = level;
        this.stage = stage;
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
        return this.stage;
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