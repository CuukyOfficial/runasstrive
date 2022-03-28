package edu.kit.informatik.runasstrive.event;

import edu.kit.informatik.runasstrive.stage.Team;

/**
 * Event which is called when the game ends.
 *
 * @author uvgsj
 * @version v0.1
 */
public class GameEndEvent implements Event {

    private final Team winner;

    /**
     * Creates new game end event.
     *
     * @param winner The winner of the game
     */
    public GameEndEvent(Team winner) {
        this.winner = winner;
    }

    /**
     * Gets the winner of the game
     *
     * @return The winner of the game
     */
    public Team getWinner() {
        return this.winner;
    }
}