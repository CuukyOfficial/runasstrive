package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.stage.Stage;

/**
 * Event which will be called when a new stage has been entered by an entity.
 *
 * @author uvgsj
 * @version v0.1
 */
public class EntityStageEnterEvent extends EntityEvent {

    private final Stage stage;

    /**
     * Creates a new stage enter event.
     *
     * @param entity The entity that entered the stage
     * @param stage The stage that has been entered
     */
    public EntityStageEnterEvent(Entity entity, Stage stage) {
        super(entity);
        this.stage = stage;
    }

    /**
     * The stage that has been entered.
     *
     * @return The stage
     */
    public Stage getStage() {
        return this.stage;
    }
}