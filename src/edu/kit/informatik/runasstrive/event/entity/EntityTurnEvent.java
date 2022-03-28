package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.stage.Stage;

/**
 * Event which will be called when an entity takes turn.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityTurnEvent extends EntityEvent {

    private final Stage stage;

    /**
     * Creates a new entity turn event.
     *
     * @param entity The entity that takes turn
     * @param stage The stage the entity is in
     */
    public EntityTurnEvent(Entity entity, Stage stage) {
        super(entity);

        this.stage = stage;
    }

    /**
     * The stage the entity is currently in.
     *
     * @return The stage
     */
    public Stage getStage() {
        return this.stage;
    }
}