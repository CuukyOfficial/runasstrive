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
    WELCOME("Welcome to Runa's Strive"),
    CHARACTER_SELECT("Select Runa's character class"),
    ENTER_SEEDS_INFO("To shuffle ability cards and monsters, enter two seeds"),
    ENTER_SEEDS_ENTER("Enter seeds [%s--%s] separated by comma:"),

    // Events
    EVENT_ABILITY_USE("%s uses %s"),
    EVENT_DEATH("%s dies"),
    EVENT_DAMAGE("%s takes %s %s damage"),
    EVENT_LEVEL_ENTER("%s enters Stage %s of Level %s"),
    EVENT_FOCUS_GAIN("%s gains %s focus"),
    EVENT_HEALTH_GAIN("%s gains %s health"),
    EVENT_LEVEL_LINE("----------------------------------------"),
    EVENT_LEVEL_PLAYER("%s (%s/%s HP, %s/%s FP)"),
    EVENT_LEVEL_VERSUS("vs."),
    EVENT_LEVEL_OPPONENT("%s (%s HP, %s FP): attempts %s next"),
    EVENT_DICE_UPGRADE("%s upgrades her die to a %s"),
    EVENT_STAGE_ENTER("%s enters Stage %s of Level %s"),
    EVENT_ABILITY_GAIN("%s gains %s"),
    EVENT_ENTITY_WIN("%s wins!"),

    // Fight,
    PICK_PLAY_CARD("Select card to play"),
    CHOOSE_TARGET("Select %s's target."),
    CHOOSE_DICE("Enter dice roll [%s--%s]:"),
    PICK_REWARD_TYPE("Choose %s's reward"),
    PICK_LOOT_CARDS("Pick %s card(s) as loot"),
    PICK_HEAL_CARDS("%s (%s/%s) can discard ability cards for healing (or none)"),

    // Misc
    LIST_ENTRY_FORMAT("%s(%s)"),
    CHOOSE_ENTRY("%s) %s"),
    ENTER_NUMBER("Enter number [%s--%s]:"),
    ENTER_NUMBERS("Enter numbers [%s--%s] separated by comma:");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    /**
     * Uses String#format to format the message.
     *
     * @param objects The objects the message will be formatted with.
     * @return
     */
    public String format(Object... objects) {
        return String.format(this.message, objects);
    }

    @Override
    public String toString() {
        return this.message;
    }
}