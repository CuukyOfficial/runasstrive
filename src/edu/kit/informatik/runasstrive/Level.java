package edu.kit.informatik.runasstrive;

import edu.kit.informatik.runasstrive.stage.Team;

public interface Level {

    void onStageEnd(Team winner);

    void start(int[] seeds);

    int getLevel();

}