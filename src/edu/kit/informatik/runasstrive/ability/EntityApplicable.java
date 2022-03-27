package edu.kit.informatik.runasstrive.ability;

import edu.kit.informatik.runasstrive.ability.action.DefensiveAction;
import edu.kit.informatik.runasstrive.ability.action.OffensiveAction;

public interface EntityApplicable {

    int getFocusChange();

    AttackData attack(DefensiveAction action);

    int defend(OffensiveAction action);

    int reflect(OffensiveAction action);

    ApplicableType getType();

}