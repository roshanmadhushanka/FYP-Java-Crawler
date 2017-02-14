package io;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Roshan on 2/10/2017.
 */
public class WebCrawler {
    public static ArrayList<String> crawl(String url) throws IOException {
        /*
        Crawl through a given URL to cache the data from a website

        url : web address that needs to crawl

        return : ArrayList of tag address with content
         */
        Document doc = Jsoup.connect(url).get();
        ArrayList<String> labels = new ArrayList<String>();
        traverse(doc.children(), labels, doc.nodeName());
        return labels;
    }

    private static void traverse(Elements elements, ArrayList<String> labels, String parent){
        /*
        Recursively traverse through the tree and create an address -> content array for each html tag
        Base method : crawl

        elements : tags inside a particular tag
        labels   : list of address and content mapping
        parent   : maintain the address for each recursive call

        return : null
         */
        int id = 0;
        String label;
        for(Element element: elements){
            id += 1;
            if((element.children().size() == 0) && !element.ownText().equals("")){
                label = parent + "->" + element.nodeName() + String.valueOf(id) + ":-:" + element.ownText();
                labels.add(label);
            }else{
                parent = parent + "->" + element.nodeName() + String.valueOf(id);
                traverse(element.children(), labels, parent);
            }
        }
    }
}
