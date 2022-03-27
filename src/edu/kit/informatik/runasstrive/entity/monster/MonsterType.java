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

public enum MonsterType implements EntityType {

    // LEVEL 1
    SPIDER_KING("Spider King", 50, 1, true, LivingEntityElement.LIGHTNING,
        new AbilityInfo(1, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK, RunaAbilityType.FOCUS,
            MonsterAbilityType.LIGHTNING)),
    FROG("Frog", 16, 1, LivingEntityElement.WATER,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.WATER)),
    GHOST("Ghost", 15, 1, LivingEntityElement.ICE,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.ICE)),
    GORGON("Gorgon", 13, 1, LivingEntityElement.FIRE,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.FIRE)),
    SKELETON("Skeleton", 14, 1, LivingEntityElement.LIGHTNING,
        new AbilityInfo(1, RunaAbilityType.FOCUS, MonsterAbilityType.LIGHTNING)),
    SPIDER("Spider", 15, 1,
        new AbilityInfo(1, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK)),
    GOBLIN("Goblin", 12, 1,
        new AbilityInfo(1, MonsterAbilityType.SMASH, MonsterAbilityType.DEFLECT)),
    RAT("Rat", 14, 1,
        new AbilityInfo(1, MonsterAbilityType.BLOCK, MonsterAbilityType.CLAW)),
    MUSHROOMLIN("Mushroomlin", 20, 1,
        new AbilityInfo(1, MonsterAbilityType.DEFLECT, MonsterAbilityType.SCRATCH)),

    // LEVEL 2
    MEGA_SAURUS("Mega Saurus", 100, 2, true,
        new AbilityInfo(2, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK, RunaAbilityType.FOCUS),
        new AbilityInfo(1, MonsterAbilityType.FIRE, MonsterAbilityType.LIGHTNING)),
    SNAKE("Snake", 31, 2, LivingEntityElement.ICE,
        new AbilityInfo(2, MonsterAbilityType.BITE, RunaAbilityType.FOCUS, MonsterAbilityType.ICE)),
    DARK_ELF("Dark Elf", 34, 2,
        new AbilityInfo(2, RunaAbilityType.FOCUS),
        new AbilityInfo(1, MonsterAbilityType.WATER, MonsterAbilityType.LIGHTNING)),
    SHADOW_BLADE("Shadow Blade", 27, 2, LivingEntityElement.LIGHTNING,
        new AbilityInfo(2, MonsterAbilityType.SCRATCH, RunaAbilityType.FOCUS, MonsterAbilityType.LIGHTNING)),
    HORNET("Hornet", 32, 2, LivingEntityElement.FIRE,
        new AbilityInfo(2, MonsterAbilityType.SCRATCH, RunaAbilityType.FOCUS),
        new AbilityInfo(1, MonsterAbilityType.FIRE),
        new AbilityInfo(2, MonsterAbilityType.FIRE)),
    TARANTULA("Tarantula", 33, 2,
        new AbilityInfo(2, MonsterAbilityType.BITE, MonsterAbilityType.BLOCK, MonsterAbilityType.SCRATCH)),
    BEAR("Bear", 40, 2,
        new AbilityInfo(2, MonsterAbilityType.CLAW, MonsterAbilityType.DEFLECT, MonsterAbilityType.BLOCK)),
    MUSHROOMLON("Mushroomlon", 50, 2,
        new AbilityInfo(2, MonsterAbilityType.DEFLECT, MonsterAbilityType.SCRATCH, MonsterAbilityType.BLOCK)),
    WILD_BOAR("Wild Boar", 27, 2,
        new AbilityInfo(2, MonsterAbilityType.SCRATCH, MonsterAbilityType.DEFLECT, MonsterAbilityType.SCRATCH));

    private final String name;
    private final int maxHealth;
    private final int level;
    private final boolean boss;
    private final EntityElement element;
    private final AbilityInfo[] abilities;

    MonsterType(String name, int maxHealth, int level, boolean boss, EntityElement element, AbilityInfo... abilities) {
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
    public List<EntityApplicable> getAbilities(int level) {
        return Arrays.stream(this.abilities).map(AbilityInfo::build)
            .flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static List<MonsterType> getTypes(int level) {
        return Arrays.stream(values()).filter(m -> !m.boss && m.level == level).collect(Collectors.toList());
    }

    public static MonsterType getBoss(int level) {
        return Arrays.stream(values()).filter(m -> m.boss && m.level == level).findAny().orElse(null);
    }
}