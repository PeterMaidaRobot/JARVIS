package Command;

public class ShutdownCommand implements ICommand {

    private final String commandText;
    private final String[] commandWords;

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
        JARVIS.JarvisSingleton.getInstance().stopJarvis();
        return "Shutting down";
    }
}
