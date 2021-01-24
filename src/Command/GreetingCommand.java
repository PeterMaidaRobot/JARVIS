package Command;

public class GreetingCommand implements ICommand {

    private final String commandText;
    private final String[] commandWords;

    public GreetingCommand(String commandText) {
        this.commandText = commandText;
        this.commandWords = commandText.split(" ");
    }

    public String getText() {
        return commandText;
    }

    public String[] getWords() {
        return commandWords;
    }

    public String process() {
        return "Hello, Sir";
    }
}
