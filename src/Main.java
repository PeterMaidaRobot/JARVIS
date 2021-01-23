import JARVIS.JarvisSingleton;
import Output.PollyDemo;

public class Main {

    public static void main(String[] args) {
        JarvisSingleton.getInstance().run();

//        try {
//            PollyDemo.runDemo();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
