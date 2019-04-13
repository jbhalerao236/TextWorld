public abstract class Creature {

    protected Level.Room currentRoom;
    String creatureType;

    public Creature(Level.Room currentRoom, String creatureType){
        this.currentRoom = currentRoom;
        this.creatureType = creatureType;
    }

    public void setCurrentRoom(Level.Room room) {
        this.currentRoom = room;
    }

    protected Level.Room getCurrentRoom(){
        return currentRoom;
    }

    public void setName(String name) {
        this.creatureType = name;
    }

    public String getCreatureType() {
        return creatureType;
    }

    protected void moveToRoom(Level.Room next){
        currentRoom.removeCreature(this);
        this.setCurrentRoom(next);
        next.addCreature(this);
    }

    public abstract void act();
}