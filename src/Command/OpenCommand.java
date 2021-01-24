package Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OpenCommand implements ICommand {

    private final String commandText;
    private final String[] commandWords;

    public OpenCommand(String commandText) {
        this.commandText = commandText;
        this.commandWords = commandText.split(" ");
    }

    public String getText() {
        return commandText;
    }

    public String[] getWords() {
        return commandWords;
    }

    /*
        process() - opens an application with the case insensitive name in the Applications folder
     */
    public String process() {
        String application = commandWords[1];
//        System.out.println(application);

        try {

            // get the name of the application
            String[] cmd = {
                    "/bin/sh",
                    "-c",
                    "ls /Applications | grep -i " + application
            };
            Process proc = Runtime.getRuntime().exec(cmd);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

            // Read the output from the command
            String realFilename = stdInput.readLine(); // we are assuming the first line is the one with the filename
//            System.out.println(realFilename);

            // open the application

            proc = Runtime.getRuntime().exec("open /Applications/" + realFilename);

            stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));

//            // Read the output from the command
//            realFilename = stdInput.readLine();
//            while (realFilename != null) {
//                System.out.println(realFilename);
//                realFilename = stdInput.readLine();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Opened " + application;
    }
}
