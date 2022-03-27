package edu.kit.informatik.runasstrive;

import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.ability.RunaAbilityType;
import edu.kit.informatik.runasstrive.entity.Entity;
import edu.kit.informatik.runasstrive.entity.monster.Monster;
import edu.kit.informatik.runasstrive.entity.monster.MonsterType;
import edu.kit.informatik.runasstrive.event.entity.EntityStageEnterEvent;
import edu.kit.informatik.runasstrive.stage.RunasStriveStage;
import edu.kit.informatik.runasstrive.stage.Stage;
import edu.kit.informatik.runasstrive.stage.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Implements a level of the game.
 * This class will take care of shuffling the cards
 * and spawning the monsters in all the stages.
 * It will also give the winner team their rewards.
 *
 * @author uvgsj
 * @version v0.1
 */
public class RunasStriveLevel implements Level {

    private static final int MAX_STAGES = 4;
    /**
     * Describes the amount of monsters where the index is the stage.
     */
    private static final int[] MONSTERS = {1, 2, 2, 0};

    private final Game game;
    private final int level;
    private final List<EntityApplicable> playerAbilities;
    private final List<Entity> monsters;
    private Stage stage;

    /**
     * Creates a new level.
     *
     * @param game The game of the level
     * @param level The level number of the level
     */
    RunasStriveLevel(Game game, int level) {
        this.game = game;
        this.level = level;
        this.playerAbilities = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    private int getMonsterAmount(int room) {
        return MONSTERS[room - 1];
    }

    private Entity createMonster(MonsterType type) {
        return new Monster(this.game, type);
    }

    private List<Entity> getMonsters(int room) {
        int amount = this.getMonsterAmount(room);
        List<Entity> monsters = amount == 0 ? List.of(this.createMonster(MonsterType.getBoss(this.level)))
            : new ArrayList<>(this.monsters.subList(0, amount));
        this.monsters.removeAll(monsters);
        return monsters;
    }

    private void createRoom(int room) {
        this.stage = new RunasStriveStage(this, room, List.of(this.game.getPlayer()), this.getMonsters(room));
        this.game.getEventManager().notify(new EntityStageEnterEvent(this.game.getPlayer(), this.stage));
        this.stage.start();
    }

    private Stream<EntityApplicable> getPlayerAbilities() {
        return Arrays.stream(RunaAbilityType.values()).filter(type ->
            !this.game.getPlayer().getType().hasDefaultAbility(type)).map(type -> type.createAbility(this.level));
    }

    private void next() {
        this.createRoom(this.stage.getStage() + 1);
    }

    private void next(List<EntityApplicable> remove) {
        this.playerAbilities.removeAll(remove);
        this.game.getPlayer().addAbilities(remove);
        this.game.getPlayer().heal(this::next);
    }

    @Override
    public void start(int[] seeds) {
        this.getPlayerAbilities().forEach(this.playerAbilities::add);
        Collections.shuffle(this.playerAbilities, new Random(seeds[0]));
        MonsterType.getTypes(this.level).stream().map(this::createMonster).forEach(this.monsters::add);
        Collections.shuffle(this.monsters, new Random(seeds[1]));
        this.createRoom(1);
    }

    @Override
    public void onStageEnd(Team winner) {
        if (this.stage.getStage() >= MAX_STAGES || !winner.hasMember(this.game.getPlayer()))
            this.game.onLevelEnd(winner);
        else {
            int killed = this.getMonsterAmount(this.stage.getStage());
            int offer = Math.min(this.playerAbilities.size() - 1, killed * 2);
            List<EntityApplicable> loot = new ArrayList<>(this.playerAbilities.subList(0, offer));
            this.game.getPlayer().reward(this::next, loot, killed);
        }
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}