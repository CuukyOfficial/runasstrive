package edu.kit.informatik.runasstrive.ability;

/**
 * Represents all ability sources.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum AbilitySource implements ApplicableSource {

    /**
     * Physical ability source
     */
    PHYSICAL("phy."),
    /**
     * Magical ability source
     */
    MAGICAL("mag.");

    private final String displayName;

    /**
     * Creates new ability source
     *
     * @param displayName The name of the source
     */
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