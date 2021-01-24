package Input;

import Command.CommandController;
import Output.OutputMedian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextListener extends Thread {

    boolean isRunning;

    public TextListener() {
        isRunning = true;
    }

    public void run() {
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine, avoid causing holds by only reading once it's ready
        while (isRunning) {
            try {
                if (reader.ready()) {
                    String input = reader.readLine();

                    // Spin a new thread to process this Command
                    // Send a response on the same median that was provided.
                    OutputMedian outputMedian = new OutputMedian();
                    outputMedian.turnOnTextOutput();
                    CommandController commandController = new CommandController(input, outputMedian);
                    commandController.start();

                } else {
                    // sleep for a bit. An optional delay between polling
                    Thread.sleep(50);
                }

            } catch (IOException e) {
                // caused by the reader
                e.printStackTrace();
            } catch (InterruptedException e) {
                // caused by sleeping thread
                e.printStackTrace();
            }

        }
    }

    public void stopRunning() {
        isRunning = false;
    }
}
