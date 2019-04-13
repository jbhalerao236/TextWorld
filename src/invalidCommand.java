public class invalidCommand implements Command {

    @Override
    public void initialize(String userString){
    }

    @Override
    public boolean execute() {
        return false;
    }
}