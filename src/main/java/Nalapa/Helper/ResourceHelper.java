package Nalapa.Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ananta on 10/1/15.
 */
public class ResourceHelper {

    public static String[] getStringsFromFile (String filename) throws IOException {
        BufferedReader reader =  new BufferedReader(new FileReader(filename));
        String line = null;     
        ArrayList<String> ret = new ArrayList<String>();
        while ((line = reader.readLine()) != null)
            ret.add(line);
        return ret.toArray(new String[ret.size()]);
    }

    public static String[] getStringsFromURL (String url) throws IOException {
        URL tURL = new URL(url);
        Scanner tScanner = new Scanner(tURL.openStream());
        ArrayList<String> ret = new ArrayList<String>();
        while(tScanner.hasNextLine()) {
            String line = tScanner.nextLine();
            ret.add(line);
        }
        return ret.toArray(new String[ret.size()]);
    }
}
