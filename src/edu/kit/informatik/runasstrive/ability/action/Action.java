package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.entity.Entity;

public interface Action {

    Entity getSource();

    Entity getTarget();

}