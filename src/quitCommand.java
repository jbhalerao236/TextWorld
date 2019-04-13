public class quitCommand implements Command {
    public quitCommand(Level level) {}

    @Override
    public void initialize(String userInput) {
        System.out.println("Quit Game");
    }

    @Override
    public boolean execute() {
        return false;
    }
}