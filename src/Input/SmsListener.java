package Input;

import Command.CommandController;
import Output.OutputMedian;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import spark.Spark;

import static spark.Spark.*;

import java.util.HashMap;

public class SmsListener extends Thread {

    private boolean isValidPhoneNumber = false;
    private String message = "";

    public void run() {

        // used to test the ngrok tunnel on a webpage
        get("/JARVIS", (req, res) -> {
            return "JARVIS is running.";
        });

        post("/JARVIS", (req, res) -> {

            getHttpRequest(req.body());

            if (isValidPhoneNumber) {
                OutputMedian outputMedian = new OutputMedian();
                outputMedian.turnOnSmsOutput();
                CommandController commandController = new CommandController(message, outputMedian);
                commandController.start();
            }

            return null;
        });
    }


    /*
    THIS IS NOT!!! THE CORRECT WAY TO DO THIS!!!!!
    HOWEVER IT IS NOT BROKEN AND IT WORKS?!? SOOOOOO....
    */
    private void getHttpRequest(String str) {
        for (String set : str.split("&")) {

            String[] pair = set.split("=");
            String key = pair[0];
            String value = pair[1];

            // Convert the ascii in the body back to it's symbols
            // i.e.  %2B = +
            value = convertHexToAscii(value);
            if (key.equals("From") && value.equals(System.getenv("MY_PHONE_NUMBER"))) {
                isValidPhoneNumber = true;
            }

            if (key.equals("Body")) {
                message = value;
            }
        }
    }

    public void stopRunning() {
        Spark.stop(); // Thread also has a stop method
    }

    /*
        converts %hex to an ascii and + to a space
     */
    private String convertHexToAscii(String value) {
        //System.out.println("Incoming: " + value);
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '%') {
                String hex = value.substring(i+1, i+3);
                value = value.substring(0, i) + ((char) Integer.parseInt(hex, 16)) + value.substring(i+3);
                // index i is still in the right spot because we replaced the '%' with the ascii char
            } else if (value.charAt(i) == '+') {
                value = value.substring(0, i) + " " + value.substring(i+1);
            }
        }
        //System.out.println("Outgoing: " + value);
        return value;
    }

}