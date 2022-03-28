package edu.kit.informatik.ui;

/**
 * Contains all the user messages the game will print out.
 * Message#toString will also return the message.
 *
 * @author uvgsj
 * @version v0.1
 */
public enum Message {

    // Init
    /**
     * Welcome message
     */
    WELCOME("Welcome to Runa's Strive"),
    /**
     * Select character message
     */
    CHARACTER_SELECT("Select Runa's character class"),
    /**
     * Shuffle abilities info message
     */
    ENTER_SEEDS_INFO("To shuffle ability cards and monsters, enter two seeds"),
    /**
     * Enter seeds message
     */
    ENTER_SEEDS_ENTER("Enter seeds [%s--%s] separated by comma:"),

    // Events
    /**
     * Ability use message
     */
    EVENT_ABILITY_USE("%s uses %s"),
    /**
     * Entity death message
     */
    EVENT_DEATH("%s dies"),
    /**
     * Entity damage message
     */
    EVENT_DAMAGE("%s takes %s %s damage"),
    /**
     * Level enter message
     */
    EVENT_LEVEL_ENTER("%s enters Stage %s of Level %s"),
    /**
     * Focus gain message
     */
    EVENT_FOCUS_GAIN("%s gains %s focus"),
    /**
     * Health gain message
     */
    EVENT_HEALTH_GAIN("%s gains %s health"),
    /**
     * Level separator message
     */
    EVENT_LEVEL_LINE("----------------------------------------"),
    /**
     * Player display message
     */
    EVENT_LEVEL_PLAYER("%s (%s/%s HP, %s/%s FP)"),
    /**
     * Versus message
     */
    EVENT_LEVEL_VERSUS("vs."),
    /**
     * Opponent display message
     */
    EVENT_LEVEL_OPPONENT("%s (%s HP, %s FP): attempts %s next"),
    /**
     * Dice upgrade message
     */
    EVENT_DICE_UPGRADE("%s upgrades her die to a %s"),
    /**
     * Stage enter message
     */
    EVENT_STAGE_ENTER("%s enters Stage %s of Level %s"),
    /**
     * Ability gain message
     */
    EVENT_ABILITY_GAIN("%s gets %s"),
    /**
     * Entity win message
     */
    EVENT_ENTITY_WIN("%s won!"),

    // Fight
    /**
     * Card select message
     */
    PICK_PLAY_CARD("Select card to play"),
    /**
     * Select target message
     */
    CHOOSE_TARGET("Select %s's target."),
    /**
     * Choose dice message
     */
    CHOOSE_DICE("Enter dice roll [%s--%s]:"),
    /**
     * Pick reward type message
     */
    PICK_REWARD_TYPE("Choose %s's reward"),
    /**
     * Pick loot cards message
     */
    PICK_LOOT_CARDS("Pick %s card(s) as loot"),
    /**
     * Pick heal cards message
     */
    PICK_HEAL_CARDS("%s (%s/%s HP) can discard ability cards for healing (or none)"),
    /**
     * Pick new ability message
     */
    PICK_NEW_ABILITY("new ability cards"),
    /**
     * Pick next player dice message
     */
    PICK_PLAYER_DICE("next player dice"),

    // Misc
    /**
     * Choose entry format
     */
    CHOOSE_ENTRY("%s) %s"),
    /**
     * Enter number message
     */
    ENTER_NUMBER("Enter number [%s--%s]:"),
    /**
     * Enter numbers message
     */
    ENTER_NUMBERS("Enter numbers [%s--%s] separated by comma:");

    private final String message;

    /**
     * Creates new message.
     *
     * @param message The message
     */
    Message(String message) {
        this.message = message;
    }

    /**
     * Uses String#format to format the message.
     *
     * @param objects The objects the message will be formatted with.
     * @return The formatted String
     */
    public String format(Object... objects) {
        return String.format(this.message, objects);
    }

    @Override
    public String toString() {
        return this.message;
    }
}