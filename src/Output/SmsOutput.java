package Output;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SmsOutput {

    // Find your Account Sid and Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    private static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    private static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");


    /*
    sendOutputTextMessage() - sends text from Twilio server
    */
    public void sendOutputTextMessage(String text) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(System.getenv("MY_PHONE_NUMBER")), // to
                new com.twilio.type.PhoneNumber(System.getenv("TWILIO_PHONE_NUMBER")), // from
                text)
                .create();
        //System.out.println(message.getSid());
    }
}
