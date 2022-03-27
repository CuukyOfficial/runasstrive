package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.stage.Stage;

public class EntityTurnEvent extends EntityEvent {

    private final Stage stage;

    public EntityTurnEvent(Entity entity, Stage stage) {
        super(entity);

        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }
}