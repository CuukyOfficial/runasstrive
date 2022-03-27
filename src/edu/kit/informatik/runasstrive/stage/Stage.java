package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.Level;

public interface Stage {

    void start();

    void next();

    boolean isOver();

    int getStage();

    Level getLevel();

    Team[] getOpponents(Team team);

    Team[] getTeams();

}