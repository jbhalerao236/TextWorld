public class takeCommand implements Command {
    Level level;
    String itemName;

    public takeCommand(Level level){
        this.level = level;
    }

    @Override
    public void initialize(String userInput) {
        this.itemName = getItemName(userInput);
    }

    private String getItemName(String userInput) {
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    @Override
    public boolean execute() {
        Player p = level.getPlayer();
        p.takeItem(itemName);
        return true;
    }
}