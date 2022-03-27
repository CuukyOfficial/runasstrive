package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.Level;

public interface Stage {

    void start();

    void next();

    int getStage();

    Level getLevel();

    Team[] getTeams();

}