package edu.kit.informatik.ui;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.player.Player;
import edu.kit.informatik.runasstrive.entity.player.PlayerBehaviour;
import edu.kit.informatik.runasstrive.entity.player.RewardType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The default reward types a user can choose from.
 * For more details see {@link RewardType}.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum UserRewardType implements RewardType {

    NEW_ABILITY_CARDS("new ability cards") {
        @Override
        public void onChoose(PlayerBehaviour behaviour, Consumer<List<EntityApplicable>> choose,
                             List<EntityApplicable> options, int amount) {
            behaviour.chooseLoot(choose, options, amount);
        }
    },
    NEXT_PLAYER_DICE("next player dice") {
        @Override
        public void onChoose(PlayerBehaviour behaviour, Consumer<List<EntityApplicable>> choose,
                             List<EntityApplicable> options, int amount) {
            behaviour.upgradeDice();
            choose.accept(new ArrayList<>());
        }

        @Override
        public boolean canChoose(Player player) {
            return player.canUpgradeDice();
        }
    };

    private final String message;

    UserRewardType(String message) {
        this.message = message;
    }

    @Override
    public boolean canChoose(Player player) {
        return true;
    }

    @Override
    public String toString() {
        return this.message;
    }
}