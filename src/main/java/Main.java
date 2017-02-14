import io.FileHandler;
import io.WebCrawler;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Roshan on 2/10/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        ArrayList<String> labels = WebCrawler.crawl("http://www.javatpoint.com/jsoup-examples");
//        for(String s: labels){
//            System.out.println(s);
//        }

        FileHandler fileHandler = new FileHandler();
        fileHandler.writeHTML("Hello World I am Roshan", "Hello.txt");
        System.out.println(fileHandler.readHTML("Hello.txt"));
    }
}
