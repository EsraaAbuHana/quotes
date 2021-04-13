/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
//        String quotesInfoJson=new String(Files.readAllBytes(Paths.get("app/src/main/resources/recentquotes.json")));
        Gson gson=new Gson();
        String[] arrayOfQuotes;
        Reader reader=new FileReader("app/src/main/resources/recentquotes.json");
//        Quotes convertedObject=gson.fromJson(reader,Quotes.class);//

        App[] convertedArray=gson.fromJson(reader,App[].class);

        System.out.println(convertedArray);

    }
}
