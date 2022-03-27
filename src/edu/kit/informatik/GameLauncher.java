package edu.kit.informatik;

import edu.kit.informatik.runasstrive.Game;
import edu.kit.informatik.runasstrive.RunasStrive;
import edu.kit.informatik.runasstrive.entity.EntityType;
import edu.kit.informatik.runasstrive.event.GameStartEvent;
import edu.kit.informatik.ui.GameOutputListener;
import edu.kit.informatik.ui.Message;
import edu.kit.informatik.ui.interaction.ChooseInteraction;
import edu.kit.informatik.ui.interaction.EnterSeedInteraction;

import java.util.Arrays;

/**
 * Launches the game with a given entity type as player.
 *
 * @param <T> The type of the entity
 * @author uvsgj
 * @version v0.1
 */
public class GameLauncher<T extends EntityType> {

    private final Game game;
    private T type;
    private int[] seeds;

    /**
     * Uses the given entities to ask the player which character he/she wants to play.
     *
     * @param entities The entities to choose from
     */
    GameLauncher(T[] entities) {
        this.game = new RunasStrive();
        new GameOutputListener(game.getEventManager());
        this.game.getEventManager().notify(new GameStartEvent());
        new ChooseInteraction<>(type -> {
            this.type = type;
            this.receivedSeeds();
        }, entities, Message.CHARACTER_SELECT.toString()).interact();
    }

    private void receivedSeeds() {
        new EnterSeedInteraction(seeds -> {
            this.seeds = Arrays.stream(seeds).mapToInt(Integer::valueOf).toArray();
            this.start();
        }).interact();
    }

    private void start() {
        this.game.start(this.type, this.seeds);
    }
}