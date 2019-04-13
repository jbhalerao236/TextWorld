public class dropCommand implements Command {

    Level level;
    private String itemName;

    public dropCommand(Level level) {
        this.level = level;
    }

    public void initialize(String userInput) {
        this.itemName = getItemName(userInput);
    }

    private String getItemName(String userInput) {
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    @Override
    public boolean execute() {
        Player p = level.getPlayer();
        p.dropItem(itemName);
        return true;
    }
}