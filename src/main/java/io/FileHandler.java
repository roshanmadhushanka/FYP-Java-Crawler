package io;

import java.io.*;

/**
 * Created by Roshan on 2/10/2017.
 */
public class FileHandler {
    public String readHTML(String path) throws IOException {
        /*
        Read HTML from file

        path : location of the file
         */

        // Open file to read
        File file = new File(path);
        FileReader reader = new FileReader(file);

        // Create buffer
        char[] f = new char[(int) file.length()];

        // Perform file read operation
        reader.read(f);
        reader.close();

        return new String(f);
    }

    public void writeHTML(String data, String path) throws IOException {
        /*
        Write HTML to a file

        data : HTML data
        path : location where to written
         */

        // Create file to write
        File file = new File(path);
        file.createNewFile();

        // Perform file write operation
        FileWriter writer = new FileWriter(file);
        writer.write(data);
        writer.flush();
        writer.close();
    }


}
