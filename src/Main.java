import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, Command> commands = new HashMap<>();
    private static Player p = new Player("Jessica", "me");
    private static Level level = new Level(p);
    public static void main(String[] args) {

        level.addRoom("hall", "a long dark hallway");
        level.addRoom("closet", "a dark, dark, closet");
        level.addRoom("dungeon", "a scary dungeon");


        Item ball = new Item ("ball","a round toy that bounces");
        Item hammer = new Item ("hammer", "tool to hammer things");
        level.getRoom("hall").addItem(ball);
        level.getRoom("dungeon").addItem(hammer);

        level.addDirectedEdge("hall", "dungeon");
        level.addUndirectedEdge("hall", "closet");

        p.setCurrentRoom(level.getRoom("hall"));

        String response = "";
        Scanner s = new Scanner(System.in);

        level.createRandomChickens(4);
        level.createWumpus(3);
        level.createPopstars(2);
        initializeCommands();


        do {

            System.out.println("You are in " + p.getCurrentRoom().getName());
            System.out.println("Next action?");
            System.out.print("");
            response = s.nextLine();
            Command command = findCommand(response);
            command.execute();
            level.updateCreatures();

        } while(!response.equals("quit"));


    }

    private static void initializeCommands(){
        commands.put("take",new takeCommand(level));
        commands.put("look", new lookCommand(p));
        commands.put("add room", new addRoomCommand(level));
        commands.put("drop",new dropCommand(level));
        commands.put("go", new goCommand(level));
        commands.put("quit", new quitCommand(level));
    }

    private static Command findCommand(String response){
        String commandName = getCommandName(response);

        Command c = commands.get(commandName);
        if (c == null){
            return new invalidCommand();
        }
        c.initialize(response);

        return c;
    }

    private static String getCommandName(String response) {
        if (response.indexOf(" ") == -1){
            return response;
        }
        return response.substring(0, response.indexOf(" "));
    }


}