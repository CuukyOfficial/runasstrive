package edu.kit.informatik.runasstrive.ability.action;

import edu.kit.informatik.runasstrive.ability.ApplicableType;

public interface OffensiveAction extends Action {

    ApplicableType getActionType();

    int getDamage();

}