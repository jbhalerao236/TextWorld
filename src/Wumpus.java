public class Wumpus extends Creature{
    private Player player;
    private Level.Room wumpusCurrentRoom;

    public Wumpus(Level.Room wumpusCurrentRoom, Player player, String name){
        super(wumpusCurrentRoom, name);
        this.wumpusCurrentRoom = wumpusCurrentRoom;
        this.player = player;
    }

    @Override

    public void act(){
        Level.Room next = getNextRoom();
        if (next != null){
            moveToRoom(next);
        }
    }

    private Level.Room getNextRoom() {
        Level.Room playerRoom = player.getCurrentRoom();
        Level.Room next = wumpusCurrentRoom.getRandomNeighbor();

        for (Level.Room room : player.getCurrentRoom().getNeighbors()) {
            while (next.equals(room) || next.equals(room)) {
                next = wumpusCurrentRoom.getRandomNeighbor();
            }
        }

        return next;
    }
}