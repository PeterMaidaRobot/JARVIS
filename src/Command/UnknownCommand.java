package Command;

public class UnknownCommand implements ICommand {

    private final String commandText;
    private final String[] commandWords;

    public UnknownCommand(String commandText) {
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
        return "Error interpreting command: " + commandText;
    }
}
