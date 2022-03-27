package edu.kit.informatik.runasstrive.event;

import edu.kit.informatik.runasstrive.stage.Team;

public class GameEndEvent extends Event {

    private final Team winner;

    public GameEndEvent(Team winner) {
        this.winner = winner;
    }

    public Team getWinner() {
        return this.winner;
    }
}