package edu.kit.informatik.runasstrive.entity.monster;

import edu.kit.informatik.runasstrive.ability.ApplicableType;
import edu.kit.informatik.runasstrive.ability.EntityApplicable;
import edu.kit.informatik.runasstrive.ability.MonsterAbilityType;
import edu.kit.informatik.runasstrive.ability.RunaAbilityType;
import edu.kit.informatik.runasstrive.entity.EntityElement;
import edu.kit.informatik.runasstrive.entity.EntityType;
import edu.kit.informatik.runasstrive.entity.LivingEntityElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains all the (default) monster types.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum MonsterType implements EntityType {

    // LEVEL 1
    /**
     * The monster spider king
     */
    SPIDER_KING("Spider King", 50, 1, true, LivingEntityElement.LIGHTNING,
        new AbilityInfo(1, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK, RunaAbilityType.FOCUS,
            MonsterAbilityType.LIGHTNING)),
    /**
     * The monster frog
     */
    FROG("Frog", 16, 1, LivingEntityElement.WATER,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.WATER)),
    /**
     * The monster ghost
     */
    GHOST("Ghost", 15, 1, LivingEntityElement.ICE,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.ICE)),
    /**
     * The monster gorgon
     */
    GORGON("Gorgon", 13, 1, LivingEntityElement.FIRE,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.FIRE)),
    /**
     * The monster skeleton
     */
    SKELETON("Skeleton", 14, 1, LivingEntityElement.LIGHTNING,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.LIGHTNING)),
    /**
     * The monster spider
     */
    SPIDER("Spider", 15, 1,
        new AbilityInfo(1, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK)),
    /**
     * The monster goblin
     */
    GOBLIN("Goblin", 12, 1,
        new AbilityInfo(1, MonsterAbilityType.SMASH, MonsterAbilityType.DEFLECT)),
    /**
     * The monster rat
     */
    RAT("Rat", 14, 1,
        new AbilityInfo(1, MonsterAbilityType.BLOCK, MonsterAbilityType.CLAW)),
    /**
     * The monster mushroomlin
     */
    MUSHROOMLIN("Mushroomlin", 20, 1,
        new AbilityInfo(1, MonsterAbilityType.DEFLECT, MonsterAbilityType.SCRATCH)),

    // LEVEL 2
    /**
     * The monster mega saurus
     */
    MEGA_SAURUS("Mega Saurus", 100, 2, true,
        new AbilityInfo(2, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK, RunaAbilityType.FOCUS),
        new AbilityInfo(1, MonsterAbilityType.FIRE, MonsterAbilityType.LIGHTNING)),
    /**
     * The monster snake
     */
    SNAKE("Snake", 31, 2, LivingEntityElement.ICE,
        new AbilityInfo(2, MonsterAbilityType.BITE, RunaAbilityType.FOCUS, MonsterAbilityType.ICE)),
    /**
     * The monster dark elf
     */
    DARK_ELF("Dark Elf", 34, 2,
        new AbilityInfo(2, RunaAbilityType.FOCUS),
        new AbilityInfo(1, MonsterAbilityType.WATER, MonsterAbilityType.LIGHTNING)),
    /**
     * The monster shadow blade
     */
    SHADOW_BLADE("Shadow Blade", 27, 2, LivingEntityElement.LIGHTNING,
        new AbilityInfo(2, MonsterAbilityType.SCRATCH, RunaAbilityType.FOCUS, MonsterAbilityType.LIGHTNING)),
    /**
     * The monster hornet
     */
    HORNET("Hornet", 32, 2, LivingEntityElement.FIRE,
        new AbilityInfo(2, MonsterAbilityType.SCRATCH, RunaAbilityType.FOCUS),
        new AbilityInfo(1, MonsterAbilityType.FIRE),
        new AbilityInfo(2, MonsterAbilityType.FIRE)),
    /**
     * The monster tarantula
     */
    TARANTULA("Tarantula", 33, 2,
        new AbilityInfo(2, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK, MonsterAbilityType.SCRATCH)),
    /**
     * The monster bear
     */
    BEAR("Bear", 40, 2,
        new AbilityInfo(2, MonsterAbilityType.CLAW, MonsterAbilityType.DEFLECT, MonsterAbilityType.BLOCK)),
    /**
     * The monster mushroomlon
     */
    MUSHROOMLON("Mushroomlon", 50, 2,
        new AbilityInfo(2, MonsterAbilityType.DEFLECT, MonsterAbilityType.SCRATCH, MonsterAbilityType.BLOCK)),
    /**
     * The monster wild boar
     */
    WILD_BOAR("Wild Boar", 27, 2,
        new AbilityInfo(2, MonsterAbilityType.SCRATCH, MonsterAbilityType.DEFLECT, MonsterAbilityType.SCRATCH));

    private final String name;
    private final int maxHealth;
    private final int level;
    private final boolean boss;
    private final EntityElement element;
    private final AbilityInfo[] abilities;

    MonsterType(String name, int maxHealth, int level, boolean boss, EntityElement element, AbilityInfo... abilities) {
        if (boss && getBoss(level) != null)
            throw new IllegalStateException("Cannot have two bosses in one level");

        this.name = name;
        this.maxHealth = maxHealth;
        this.level = level;
        this.boss = boss;
        this.element = element;
        this.abilities = abilities;
    }

    MonsterType(String name, int maxHealth, int level, boolean boss, AbilityInfo... abilities) {
        this(name, maxHealth, level, boss, null, abilities);
    }

    MonsterType(String name, int maxHealth, int level, AbilityInfo... abilities) {
        this(name, maxHealth, level, false, null, abilities);
    }

    MonsterType(String name, int maxHealth, int level, EntityElement element, AbilityInfo... abilities) {
        this(name, maxHealth, level, false, element, abilities);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public int getStartFocus() {
        return 0;
    }

    @Override
    public EntityElement getElement() {
        return this.element;
    }

    @Override
    public boolean hasDefaultAbility(ApplicableType type) {
        return Arrays.stream(this.abilities).anyMatch(info -> info.hasAbility(type));
    }

    @Override
    public List<EntityApplicable> getAbilities(int stage) {
        return Arrays.stream(this.abilities).map(AbilityInfo::build)
            .flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Returns all the types of monster spawning in that level except bosses.
     *
     * @param level The level
     * @return The types of monster
     */
    public static List<MonsterType> getTypes(int level) {
        return Arrays.stream(values()).filter(m -> !m.boss && m.level == level).collect(Collectors.toList());
    }

    /**
     * Returns the boss of the given level
     *
     * @param level The level
     * @return The boss
     */
    public static MonsterType getBoss(int level) {
        return Arrays.stream(values()).filter(m -> m.boss && m.level == level).findAny().orElse(null);
    }
}