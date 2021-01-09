package Command;

public class ShutdownCommand implements ICommand {

    String commandText;
    String[] commandWords;

    public ShutdownCommand(String commandText) {
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
        return "Shutting down";
    }
}
