import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {

    private ArrayList<Creature> creatures = new ArrayList<>();
    private HashMap<String, Room> rooms;
    Player player;

    public Level(Player player){
        this.rooms = new HashMap<>();
        this.player = player;
    }

    public void addRoom(String name, String description) {
        Room newRoom = new Room(name);
        newRoom.setDescription(description);
        rooms.put(name, newRoom);
    }


    public void addRoom(String roomName) {
        this.addRoom(roomName, "newRoom");                                      
        this.addUndirectedEdge(player.getCurrentRoom().getName(), roomName);    
    }                                                                           

        public void addDirectedEdge(String name1, String name2){
                  Room newRoom1 = rooms.get(name1);
                  Room newRoom2 = rooms.get(name2);
                  newRoom1.addNeighbor(newRoom2);
        }



    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }


    public Room getRoom(String name) {
        return rooms.get(name);
    }


    public void createRandomChickens(int numChickens){
        for (int i = 0; i < numChickens; i ++){
            Creature c = new Chicken(getRoom("hall"),"Chicken #" + i);
            getRoom("hall").addCreature(c);
        }
    }

    public void createWumpus(int n){
        for (int i = 0; i < n; i++){
            Creature w = new Wumpus(getRoom("hall"), player,"Wumpus #" + i);
            getRoom("hall").addCreature(w);
        }
    }

    public void createPopstars(int numPopstars){
        for (int i = 0; i < numPopstars; i++){
            Creature p = new Popstar(getRoom("hall"), player, "Popstar #" + i);
            getRoom("hall").addCreature(p);
        }
    }


    public void updateCreatures() {
        this.creatures = numTotalCreatures();
        for (Creature c : creatures){
            c.act();
        }
    }

    private ArrayList<Creature> numTotalCreatures() {
        for (Room roomObj : rooms.values()){
            List<Creature> creaturesInRooms = roomObj.getCreatures();
            for (Creature c: creaturesInRooms){
                this.creatures.add(c);
            }
        }
        return this.creatures;
    }

    public Player getPlayer() {
        return this.player;
    }

    public class Room{

        public String name;
        public HashMap<String, Room> neighbors;
        private String description;
        public List <Item> items = new ArrayList <>();
       // public List <Creature> creatures = new ArrayList<>();


        public Room(String name){
            this.name = name;
            this.neighbors = new HashMap<String, Room>();
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private void addNeighbor(Room room){
            neighbors.put(room.name,room);
        }

        public String getNeighborNames(){
            String names = "";
            for (String name : neighbors.keySet()){
                names += name + " ";
            }
            return names;
        }

        public ArrayList<Room> getNeighbors(){
            ArrayList<Level.Room> neighbors;
            neighbors = new ArrayList<>(rooms.values());
            return neighbors;
        }

        public Room getNeighbor(String name){
            return neighbors.get(name);
        }

        public String getName() {
            return name;
        }

        public List<Item> getItems(){
            return items;
        }

        public String displayItems(){
            String output = "";

            for (Item i : items){
                output += i.getName() + ", ";
            }

            return output;
        }

        public void addItem(String name){
            Item i = new Item(name);
            items.add(i);
        }

        public void addItem(String name, String description){
            Item i = new Item(name, description);
            items.add(i);
        }

        public void addItem(Item item){
            if (item == (null)){
                System.out.println("Item cannot be picked up");
            }
            items.add(item);
        }

        public Item removeItem(String name){
            for (Item i : items){
                if (i.getName().equals(name)){
                    items.remove(i);
                    return i;
                }
            }
            return null;
        }

        public List<Creature> getCreatures(){
            return creatures;
        }

        public String displayCreatures(){
            String output = "";

            for (Creature i : creatures){
                output += i.getCreatureType() + ", ";
            }

            return output;
        }

        public void addCreature(Creature creature){
            if (creature == (null)){
                System.out.println("Cannot add creature");
            }
            creatures.add(creature);
        }

        public void removeCreature(Creature creature){
            creatures.remove(creature);
        }

        public Room getRandomNeighbor() {
            ArrayList<Level.Room> neighbors = this.getNeighbors();
            Level.Room next = neighbors.get((int)(Math.random()*neighbors.size()));
            return next;
        }

        protected boolean neighboringCreatures(Level.Room playerRoom){
            ArrayList<Level.Room> playerNeighbors = playerRoom.getNeighbors();
            for (Level.Room room : playerNeighbors){
                if (room.equals(playerRoom)){
                    return true;
                }
            }
            return false;
        }


    }
}