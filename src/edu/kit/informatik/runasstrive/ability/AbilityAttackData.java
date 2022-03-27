package edu.kit.informatik.runasstrive.ability;

public class AbilityAttackData implements AttackData {

    private final int damage;
    private final boolean breaksFocus;

    public AbilityAttackData(int damage, boolean breaksFocus) {
        this.damage = damage;
        this.breaksFocus = breaksFocus;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public boolean breaksFocus() {
        return this.breaksFocus;
    }
}
