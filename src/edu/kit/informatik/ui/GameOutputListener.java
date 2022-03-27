package edu.kit.informatik.ui;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.entity.player.EntityPlayer;
import edu.kit.informatik.runasstrive.event.GameEndEvent;
import edu.kit.informatik.runasstrive.event.GameStartEvent;
import edu.kit.informatik.runasstrive.event.SubscriptionHolder;
import edu.kit.informatik.runasstrive.event.entity.EntityAbilityGetEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityAbilityUseEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityDamageEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityDeathEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityFocusGainEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityHealthGainEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityStageEnterEvent;
import edu.kit.informatik.runasstrive.event.entity.EntityTurnEvent;
import edu.kit.informatik.runasstrive.event.entity.PlayerDiceUpgradeEvent;
import edu.kit.informatik.runasstrive.stage.Stage;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Prints out every event that will happen while the game is running.
 *
 * @author uvgsj
 * @version v0.1
 */
public class GameOutputListener {

    /**
     * Registers all listeners to print out all game events.
     *
     * @param subscriptionHolder The subscriptionHolder that will be subscribed to
     */
    public GameOutputListener(SubscriptionHolder subscriptionHolder) {
        subscriptionHolder.subscribe(GameStartEvent.class, this::onGameStart);
        subscriptionHolder.subscribe(EntityAbilityUseEvent.class, this::onAbilityUse);
        subscriptionHolder.subscribe(EntityDamageEvent.class, this::onEntityDamage);
        subscriptionHolder.subscribe(EntityFocusGainEvent.class, this::onEntityFocus);
        subscriptionHolder.subscribe(EntityHealthGainEvent.class, this::onEntityHeal);
        subscriptionHolder.subscribe(PlayerDiceUpgradeEvent.class, this::onEntityDiceUpgrade);
        subscriptionHolder.subscribe(EntityDeathEvent.class, this::onEntityDeath);
        subscriptionHolder.subscribe(EntityStageEnterEvent.class, this::onStageEnter);
        subscriptionHolder.subscribe(EntityTurnEvent.class, this::onEntityTurn);
        subscriptionHolder.subscribe(EntityAbilityGetEvent.class, this::onEntityAbilityGet);
        subscriptionHolder.subscribe(GameEndEvent.class, this::onGameEnd);
    }

    private boolean isPlayer(Entity entity) {
        return entity instanceof EntityPlayer;
    }

    private void onGameStart(GameStartEvent event) {
        System.out.println(Message.WELCOME);
    }

    private void onAbilityUse(EntityAbilityUseEvent event) {
        System.out.println(Message.EVENT_ABILITY_USE.format(event.getEntity(), event.getAbility()));
    }

    private void onEntityDamage(EntityDamageEvent event) {
        System.out.println(Message.EVENT_DAMAGE.format(event.getEntity(), event.getDamage(),
            event.getDamageType().getSource()));
    }

    private void onEntityFocus(EntityFocusGainEvent event) {
        System.out.println(Message.EVENT_FOCUS_GAIN.format(event.getEntity(), event.getAmount()));
    }

    private void onEntityHeal(EntityHealthGainEvent event) {
        System.out.println(Message.EVENT_HEALTH_GAIN.format(event.getEntity(), event.getAmount()));
    }

    private void onEntityDiceUpgrade(PlayerDiceUpgradeEvent event) {
        System.out.println(Message.EVENT_DICE_UPGRADE.format(event.getEntity(), event.getUpgrade()));
    }

    private void onEntityDeath(EntityDeathEvent event) {
        System.out.println(Message.EVENT_DEATH.format(event.getEntity()));
    }

    private void onStageEnter(EntityStageEnterEvent event) {
        System.out.println(Message.EVENT_STAGE_ENTER.format(event.getEntity(), event.getStage().getStage(),
            event.getStage().getLevel().getLevel()));
    }

    private void printTeam(Team team) {
        for (Entity entity : team.getMember()) {
            if (this.isPlayer(entity)) {
                System.out.println(Message.EVENT_LEVEL_PLAYER.format(entity, entity.getHealth(),
                    entity.getMaxHealth(), entity.getFocus(), entity.getMaxFocus()));
            } else {
                System.out.println(Message.EVENT_LEVEL_OPPONENT.format(entity, entity.getHealth(),
                    entity.getFocus(), entity.getNext()));
            }
        }
    }

    private void onEntityTurn(EntityTurnEvent event) {
        if (!this.isPlayer(event.getEntity()))
            return;

        Stage stage = event.getStage();
        System.out.println(Message.EVENT_LEVEL_LINE);
        for (int i = 0; i < stage.getTeams().length; i++) {
            Team print = stage.getTeams()[i];
            this.printTeam(print);
            if (i != stage.getTeams().length - 1)
                System.out.println(Message.EVENT_LEVEL_VERSUS);
        }
        System.out.println(Message.EVENT_LEVEL_LINE);
    }

    private void onEntityAbilityGet(EntityAbilityGetEvent event) {
        for (EntityApplicable ability : event.getAbilities())
            System.out.println(Message.EVENT_ABILITY_GAIN.format(event.getEntity(), ability));
    }

    private void onGameEnd(GameEndEvent event) {
        if (Arrays.stream(event.getWinner().getMember()).noneMatch(this::isPlayer))
            return;

        String winner = Arrays.stream(event.getWinner().getMember()).map(Objects::toString)
            .collect(Collectors.joining(", "));
        System.out.println(Message.EVENT_ENTITY_WIN.format(winner));
    }
}