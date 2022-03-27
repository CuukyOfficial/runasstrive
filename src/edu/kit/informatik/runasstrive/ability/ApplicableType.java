package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.ActionType;
import edu.kit.informatik.runasstrive.entity.EntityElement;

public interface ApplicableType {

    String getName();

    ActionType getAction();

    ApplicableSource getSource();

    boolean needsDice();

    EntityElement[] getEffective();

    EntityApplicable createAbility(int level);

}