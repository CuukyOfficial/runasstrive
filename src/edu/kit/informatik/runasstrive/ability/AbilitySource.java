package edu.kit.informatik.runasstrive.ability;

public enum AbilitySource implements ApplicableSource {

    PHYSICAL("phy."),
    MAGICAL("mag.");

    private final String displayName;

    AbilitySource(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getName() {
        return this.displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}