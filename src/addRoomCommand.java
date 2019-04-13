public class addRoomCommand implements Command {

    Level level;
    String roomName;

    public addRoomCommand(Level level){
        this.level = level;
    }


    @Override
    public void initialize(String userInput) {
        this.roomName = getRoomName(userInput);
    }

    private String getRoomName(String userInput) {
        int indexOfFirstSpace = userInput.indexOf(" ");
        int indexOfSecondSpace = userInput.substring(indexOfFirstSpace + 1).indexOf(" ");
        return userInput.substring(indexOfSecondSpace + 1);
    }

    @Override
    public boolean execute() {
        level.addRoom(roomName);
        return true;
    }
}