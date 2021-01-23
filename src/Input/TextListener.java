package Input;

import JARVIS.*;

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

        while (isRunning) {
            try {
                // Reading data using readLine
                String input = reader.readLine();
                if (input.equals("stop")) {
                    // stop all of JARVIS
                    JarvisSingleton.getInstance().stopJarvis();
                } else {
                    System.out.println(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopRunning() {
        isRunning = false;
    }
}
