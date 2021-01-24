package Command;

import Output.OutputMedian;
import Output.SmsOutput;
import Output.VerbalOutput;

public class CommandController extends Thread {

    private String commandText;
    private OutputMedian outputMedian;

    public CommandController(String commandText, OutputMedian outputMedian) {
        this.commandText = commandText;
        this.outputMedian = outputMedian;
    }

    public void run() {
        ICommand inputCommand = getCommand();
        String outputResponse = inputCommand.process();

        if (outputMedian.isTextOutput()) {
            // Text output
            System.out.println(outputResponse);
        }

        if (outputMedian.isSmsOutput()) {
            // SMS Output
            SmsOutput smsOutput = new SmsOutput();
            smsOutput.sendOutputTextMessage(outputResponse);
        }

        if (outputMedian.isVerbalOutput()) {
            // Verbal Output
            VerbalOutput verbalOutput = new VerbalOutput();
            verbalOutput.speak(outputResponse);
        }
    }

    /*
    getCommand() - determine which Command object the commandText belongs to
    */
    private ICommand getCommand() {
        commandText = commandText.toLowerCase();

        if (commandText.contains("hi") ||
                commandText.contains("hello") ||
                commandText.contains("hey")) {
            return new GreetingCommand(commandText);
        } else if (commandText.contains("shutdown")) {
            return new ShutdownCommand(commandText);
        } else if (commandText.contains("open")) {
            return new OpenCommand(commandText);
        }

        return new UnknownCommand(commandText);
    }
}
