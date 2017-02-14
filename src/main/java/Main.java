import algorithms.ChangeDetector;
import io.FileHandler;
import io.WebCrawler;
import models.WebPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Roshan on 2/10/2017.
 */
public class Main {
    public static void loadWebsites() throws IOException {
//        //https://news.google.com/
//        WebPage webPage1 = new WebPage("https://news.google.com/");
//        webPage1.save();
//
//        //http://edition.cnn.com/
//        WebPage webPage2 = new WebPage("http://edition.cnn.com/");
//        webPage2.save();
//
//        //http://www.nbcnews.com/
//        WebPage webPage3 = new WebPage("http://www.nbcnews.com/");
//        webPage3.save();
//
//        //http://www.lankadeepa.lk/
//        WebPage webPage4 = new WebPage("http://www.lankadeepa.lk/");
//        webPage4.save();
//
//        //http://www.sundaytimes.lk/
//        WebPage webPage5 = new WebPage("http://www.sundaytimes.lk/");
//        webPage5.save();

        //http://www.huffingtonpost.com/
        WebPage webPage6 = new WebPage("http://www.huffingtonpost.com/");
        webPage6.save();

        //https://www.nytimes.com/
        WebPage webPage7 = new WebPage("http://www.huffingtonpost.com/");
        webPage7.save();

        //http://www.foxnews.com/
        WebPage webPage8 = new WebPage("http://www.huffingtonpost.com/");
        webPage8.save();

        //https://www.theguardian.com/international
        WebPage webPage9 = new WebPage("http://www.huffingtonpost.com/");
        webPage9.save();

        //http://www.latimes.com/
        WebPage webPage10 = new WebPage("http://www.huffingtonpost.com/");
        webPage10.save();

        //http://www.mawbima.lk/
        WebPage webPage11 = new WebPage("http://www.huffingtonpost.com/");
        webPage11.save();

        //http://www.ada.lk/
        WebPage webPage12 = new WebPage("http://www.huffingtonpost.com/");
        webPage12.save();

        //http://www.divaina.com/
        WebPage webPage13 = new WebPage("http://www.huffingtonpost.com/");
        webPage13.save();

        //http://www.usatoday.com/
        WebPage webPage14 = new WebPage("http://www.huffingtonpost.com/");
        webPage14.save();

        //https://www.yahoo.com/news/
        WebPage webPage15 = new WebPage("http://www.huffingtonpost.com/");
        webPage15.save();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        loadWebsites();

//        FileHandler fileHandler = new FileHandler();
//
//        String content1 = fileHandler.read("lankadeepa-1.html");
//        WebPage webPage1 = new WebPage("https://news.google.com/", content1);
//        String content2 = fileHandler.read("lankadeepa-2.html");
//        WebPage webPage2 = new WebPage("https://news.google.com/", content2);
//
//        long startTime = System.nanoTime();
//        HashMap<String, ArrayList<String>> result = ChangeDetector.compare(WebCrawler.crawl(webPage1.getDoc()), WebCrawler.crawl(webPage2.getDoc()));
//        long endTime = System.nanoTime();
//
//
//        System.out.println("Similar");
//        for(String line: result.get("Similar")){
//            System.out.println(line);
//        }
//        System.out.println("-------------------------");
//
//        System.out.println("Changed");
//        for(String line: result.get("Changed")){
//            System.out.println(line);
//        }
//        System.out.println("-------------------------");
//
//        System.out.println("Missing");
//        for(String line: result.get("Missing")){
//            System.out.println(line);
//        }
//        System.out.println("-------------------------");
//
//        System.out.println("New");
//        for(String line: result.get("Missing")){
//            System.out.println(line);
//        }
//        System.out.println("-------------------------");
//
//        System.out.println("Took "+(endTime - startTime) + " ns");
        simulate();
    }

    public static void simulate() throws IOException, InterruptedException {
        ArrayList<WebPage> webPagesStart = new ArrayList<WebPage>();
        ArrayList<WebPage> webPagesEnd = new ArrayList<WebPage>();
        ArrayList<String> webAddresses = new ArrayList<String>();
        webAddresses.add("https://news.google.com/");
        webAddresses.add("http://edition.cnn.com/");
        webAddresses.add("http://www.nbcnews.com/");
        webAddresses.add("http://www.lankadeepa.lk/");
        webAddresses.add("http://www.sundaytimes.lk/");
        webAddresses.add("http://www.huffingtonpost.com");
        webAddresses.add("https://www.nytimes.com");
        webAddresses.add("http://www.foxnews.com");
        webAddresses.add("https://www.theguardian.com/international");
        webAddresses.add("http://www.latimes.com/");
        webAddresses.add("http://www.ada.lk/");
        webAddresses.add("http://www.divaina.com/");
        webAddresses.add("http://www.usatoday.com/");
        webAddresses.add("https://www.yahoo.com/news/");

        System.out.println("Web address initialization complete");
        System.out.println("Initial crawl start");
        for(String address: webAddresses){
            System.out.println("Fetching : " + address);
            webPagesStart.add(new WebPage(address));
        }

        System.out.println("Initial crawl complete");
        System.out.println("Wait...");
        Thread.sleep(300000);

        System.out.println("Final crawl start");
        for(String address: webAddresses){
            System.out.println("Fetching : " + address);
            webPagesEnd.add(new WebPage(address));
        }
        System.out.println("Final crawl complete");
        System.out.println("Analyzing");
        for(int i=0; i<webPagesStart.size(); i++){
            WebPage initial = webPagesStart.get(i);
            WebPage modified = webPagesEnd.get(i);

            long startTime = System.nanoTime();
            HashMap<String, ArrayList<String>> result = ChangeDetector.compare(WebCrawler.crawl(initial.getDoc()), WebCrawler.crawl(modified.getDoc()));
            long endTime = System.nanoTime();

            System.out.println("Web page : " + initial.getUrl());
            System.out.println("Took "+(endTime - startTime) + " ns");

            if(result.get("Missing").size() == 0 && result.get("New").size() == 0){
                System.out.println("Structure does not change");
            }else{
                System.out.println("Structure changed");
            }

            System.out.println("Similar : " + String.valueOf(result.get("Similar").size()));
            System.out.println("Changed : " + String.valueOf(result.get("Changed").size()));
            System.out.println("Missing : " + String.valueOf(result.get("Missing").size()));
            System.out.println("New : " + String.valueOf(result.get("New").size()));
            System.out.println("------------------------------------------------------------");
        }


    }
}
