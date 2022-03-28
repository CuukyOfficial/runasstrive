package edu.kit.informatik;

import edu.kit.informatik.runasstrive.entity.RunaType;

/**
 * Main class to launch the game.
 *
 * @author uvgsj
 * @version v0.1
 */
public final class Main {

    private Main() {}

    /**
     * Main Method.
     * Launches the game and tells it to use Runa as character selection.
     *
     * @param args Arguments for launching the game
     */
    public static void main(String[] args) {
        if (args.length != 0) {
            System.out.println("Error, no start arguments expected");
            return;
        }

        new GameLauncher<>(RunaType.values());
    }
}