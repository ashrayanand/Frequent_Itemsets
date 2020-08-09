import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 *  Example of how to use the MSAPRIORI algorithm in source code.
 */
public class MainTestMSApriori_saveToFile {

    public static void main(String [] arg) throws IOException{

        String input = fileToPath("docword.kos.txt");
        String output = fileToPath("output.txt");  // the path for saving the frequent itemsets found
        String words = fileToPath("vocab.kos.txt");

        double beta=0.5;
        double LS=0.1;
        System.out.println("MSAPRIORI with beta= "+beta+" and LS= "+LS);
        BufferedReader reader = new BufferedReader(new FileReader(words));
        String line;
        Map<Integer, String> mapWords = new HashMap<Integer, String>();
        int i=1;
        while (((line = reader.readLine()) != null)) {
            mapWords.put(i,line);
            i++;
        }

        // Applying the MSApriori algorithm
        MSApriori apriori = new MSApriori();
        apriori.runAlgorithm(input, output, beta, LS,mapWords);
        apriori.printStats();
    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException{
        URL url = MainTestMSApriori_saveToFile.class.getResource(filename);
        System.out.println("url:"+url);
        return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
    }
}