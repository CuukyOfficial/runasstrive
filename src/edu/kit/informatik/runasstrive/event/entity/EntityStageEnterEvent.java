package edu.kit.informatik.runasstrive.event.entity;

import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.stage.Stage;

public class EntityStageEnterEvent extends EntityEvent {

    private final Stage stage;

    public EntityStageEnterEvent(Entity entity, Stage stage) {
        super(entity);
        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }
}