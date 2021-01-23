package Input;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import spark.Spark;

import static spark.Spark.*;

import java.util.Map;
import java.util.HashMap;

public class SmsListener extends Thread {
    public void run() {
//        try {
//            // Displaying the thread that is running
//            System.out.println ("Thread " +
//                    Thread.currentThread().getId() +
//                    " is running");
//
//        } catch (Exception e) {
//            // Throwing an exception
//            System.out.println ("Exception is caught");
//        }
//

        // used to test the ngrok tunnel on a webpage
        get("/JARVIS", (req, res) -> {
            return "JARVIS is running.";
        });

        post("/JARVIS", (req, res) -> {

            getHttpRequest(req.body());

            res.type("application/xml");
            Body body = new Body
                    .Builder("Hello Sir")
                    .build();
            Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
            return twiml.toXml();
        });
    }


    /*
    THIS IS NOT!!! THE CORRECT WAY TO DO THIS!!!!!
    HOWEVER IT IS NOT BROKEN AND IT WORKS?!? SOOOOOO....
 */
    private HashMap<String, String> getHttpRequest(String str) {
        HashMap<String, String> map = new HashMap<>();

        for (String set : str.split("&")) {

            String[] pair = set.split("=");
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1);
            System.out.println(word2);

            // only let my phone number send messages to JARVIS!
            // if we recieved a message from my phone, run the command with it
            // TODO ****************************************
            // Then check if the input is the same as my phone number environment variable...
            // Then make another helper function that translates the %2B and other ascii back into their normal cahracters

        }

        return map;
    }

    public void stopRunning() {
        Spark.stop(); // Thread also has a stop method
    }

}