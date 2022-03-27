package edu.kit.informatik.runasstrive.stage;

import edu.kit.informatik.runasstrive.entity.Entity;

public interface Team {

    boolean hasMember(Entity entity);

    boolean isDead();

    void turn();

    void next();

    Entity[] getMember();

    Stage getStage();

}