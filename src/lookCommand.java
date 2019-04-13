public class lookCommand implements Command {
    Player player;

    public lookCommand (Player player){
        this.player = player;
    }

    @Override
    public void initialize(String userString) {}

    @Override
    public boolean execute() {
        Level.Room playerRoom = player.getCurrentRoom();
        System.out.println("Items: " + playerRoom.displayItems());
        System.out.println("Creature List: " + playerRoom.displayCreatures());

        return true;
    }
}