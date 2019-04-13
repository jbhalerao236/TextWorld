public class Popstar extends Creature{
    private Player player;
    private Level.Room popstarCurrentRoom;


    public Popstar(Level.Room popstarCurrentRoom, Player player, String name){
        super(popstarCurrentRoom, name);
        this.popstarCurrentRoom = popstarCurrentRoom;
        this.player = player;
    }

    @Override
    public void act(){
        Level.Room next = getPlayerRoom();
        if (next != null){
            this.moveToRoom(next);
        }
    }

    private Level.Room getPlayerRoom() {
        Level.Room next = this.currentRoom;
        if (next.neighboringCreatures(player.getCurrentRoom())) {
            next = player.getCurrentRoom();
            return next;
        }

        for (Level.Room popstarRoom : popstarCurrentRoom.getNeighbors()){
            for (Level.Room playerRoom : player.getCurrentRoom().getNeighbors()){
                if (popstarRoom.equals(playerRoom)){
                    next = popstarRoom;
                }
            }
        }
        return next;
    }
}
