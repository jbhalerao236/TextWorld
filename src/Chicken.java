public class Chicken extends Creature{

    private Level.Room currentRoom;
    String chickenNum;

    public Chicken(Level.Room currentRoom, String chickenNum){
        super(currentRoom, chickenNum);
        this.chickenNum = chickenNum;
        this.currentRoom = currentRoom;

    }

    @Override
    public void act(){
        Level.Room next = getCurrentRoom().getRandomNeighbor();
        if (next != null){
            this.move();
        }

    }

    public void move() {
        Level.Room next = currentRoom.getRandomNeighbor();
        moveToRoom(next);
    }

}