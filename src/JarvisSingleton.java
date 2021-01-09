import Command.*;

// Java program to demonstrate BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import com.amazonaws.services.polly.*;

public class JarvisSingleton {

    // create an object of JarvisSingleton
    private static JarvisSingleton instance = new JarvisSingleton();


    // make the constructor private so that this class cannot be instantiated
    private JarvisSingleton() {
    }


    // Get the only object available
    public static JarvisSingleton getInstance() {
        return instance;
    }


    public void run() {
        System.out.println("Starting JARVIS...");

        while (true) {
            // TODO break into, threads getText getSpeech getTextMessage that spin off things

            String inputText = getInputText(); // Amazon Lex?
            //System.out.println("Input: \n" + inputText);

            ICommand inputCommand = getCommand(inputText);
            String outputResponse = inputCommand.process();
            //System.out.println("Output: \n" + outputResponse);
            System.out.println(outputResponse);

            convertTextToSpeech(outputResponse, "Brian");

            if (inputCommand instanceof ShutdownCommand) {
                break;
            }
        }

        System.out.println("Closing JARVIS...");
    }

    /*
        getCommand() - determine which Command object the commandText belongs to
     */
    private ICommand getCommand(String commandText) {
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

    /*
        getInputText() - gets the typed command input from the command line
     */
    private String getInputText() {
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /*
        getInputTextMessage() - gets text from Twilio server
     */
    private String getInputTextMessage() {
        // An input can be typed, texted, or spoken...

        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /*
    verbal input, with a STT
     */
    private String getInputVerbal() {

        return "";
    }



    public  String convertTextToSpeech(final String text, final String polyVoiceId) {
        // TODO check database/cache to see if we have to call Amazon Polly or not

        //System.out.println("Converting " + text + " to speech");
        //log.info("Converting " + text + " to speech");

        // Create speech synthesis request.
        return "Converting " + text + " to speech";

//        SynthesizeSpeechRequest synthesizeSpeechRequest = new SynthesizeSpeechRequest()
//                .withText(text)
//                .withVoiceId(polyVoiceId)
//                .withOutputFormat(OutputFormat.Mp3);
//
//        // Get the synthesized speech audio stream.
//        SynthesizeSpeechResult synthesizeSpeechResult = awsPollyClient.synthesizeSpeech(synthesizeSpeechRequest);
//
//        // store audio stream of Polly to S3 as an MP3 file
//        byte[] bytes = null;
//        try {
//            bytes = IOUtils.toByteArray(synthesizeSpeechResult.getAudioStream());
//        } catch (IOException e) {
//            System.out.println("Could not get bytes from the audio stream " + e.getMessage());
//            //log.error("Could not get bytes from the audio stream " + e.getMessage());
//        }
//
//        ObjectMetadata omd = new ObjectMetadata();
//        omd.setContentType(synthesizeSpeechResult.getContentType());
//        omd.setContentLength(bytes.length);
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        String fileName = getRandomString();
//        final PutObjectRequest s3Put = new PutObjectRequest(pollySpeechBucket, fileName, byteArrayInputStream, omd).withCannedAcl(CannedAccessControlList.PublicRead);
//
//        amazonS3Client.putObject(s3Put);
//
//        return S3URL;

    }


    // TTS

    // STT


    // getSpeechToText
    // convertTextToCommand - merge with below?
    // Command.process() - merge with above?
    // getTextToSpeech
    // Say speech

}