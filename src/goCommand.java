public class goCommand implements Command {
    Level level;
    String roomName;

    public goCommand(Level level) {
        this.level = level;
    }

    @Override
    public void initialize(String userInput) {
        this.roomName = getCommand(userInput);
    }

    private String getCommand(String userInput) {
        return userInput.substring(userInput.indexOf(" ") + 1);
    }

    @Override
    public boolean execute() {
        Player p = level.getPlayer();
        Level.Room nextRoom = level.getRoom(this.roomName);
        if (nextRoom!= null){
            p.setCurrentRoom(nextRoom);
            return true;
        }
        System.out.println("Cannot go to room");
        return false;
    }
}