/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
//        String apiURL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        String apiURL="http://ron-swanson-quotes.herokuapp.com/v2/quotes";
                Quotes[] convertedArray=getAllQuotes();
        System.out.println(convertedArray);

        Quotes randomQuote=convertedArray[(int) (Math.random()*convertedArray.length)] ;
        System.out.println(randomQuote);

        try {
            URL url = new URL(apiURL);
            String jsonData = getJsonFromAPI(url);
            Quotes formismaticQuote = getFormismaticQuoteAsObject(jsonData);
            addToJsonFile(formismaticQuote);
            Quotes[] test=getAllQuotes();
            System.out.println(formismaticQuote);
            System.out.println(test[test.length-1]);
            System.out.println(test.length);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    public static  Quotes[] getAllQuotes(){
        final File f = new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String path = "../app/src/main/resources/recentquotes.json";
        System.out.println(f);
        if (f.compareTo(new File("C:\\Users\\user\\401\\quotes\\app\\build\\classes\\java\\main")) != 0){
            path = "../src/main/resources/recentquotes.json";
        };
        try{
            Gson gson=new Gson();
            String[] arrayOfQuotes;
//            Reader reader=new FileReader("../app/src/main/resources/recentquotes.json");
            Reader reader=new FileReader(path);

            Quotes[] convertedArray=gson.fromJson(reader,Quotes[].class);
            return  convertedArray;
        }catch (Exception ex){
            System.out.println(ex);

        }
   return new   Quotes[0];
    }
public static void addToJsonFile(Quotes quotes){
try {
    Quotes[] listOfQuotes=getAllQuotes();
//    List<Quotes> list = Arrays.asList(listOfQuotes);
    List<Quotes> list1 = new ArrayList<Quotes>();
    Collections.addAll(list1, listOfQuotes);
    System.out.println(list1);
    list1.add(quotes);
    final File f = new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    String path = "../app/src/main/resources/recentquotes.json";
    System.out.println(f);
    if (f.compareTo(new File("C:\\Users\\user\\401\\quotes\\app\\build\\classes\\java\\main")) != 0){
        path = "../src/main/resources/recentquotes.json" ;
    };
    try (Writer writer = new FileWriter(path)) {
        Gson gson = new GsonBuilder().create();
        gson.toJson(list1, writer);
    }
}catch (Exception ex){
    System.out.println(ex);
}


}
    public static String getJsonFromAPI(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();
        String content = "";
        if(status == 200) {
            BufferedReader reader = getBufferedReader(connection);
            content = getContent(reader);
            reader.close();
        } else{
            System.out.println("Error in the API");
        }

        connection.disconnect();

        return content;
    }

    private static String getContent(BufferedReader reader) throws IOException {    //String vs StringBuilder
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();

        while(currentLine != null){
            builder.append(currentLine);
            currentLine = reader.readLine();
        }
        return builder.toString();
    }

    private static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }

    static Quotes getFormismaticQuoteAsObject(String jsonData) {
        Gson gson = new Gson();
        String[] formismaticQuote = gson.fromJson(jsonData, String[].class);
        Quotes quotes=new Quotes("not mintioned",formismaticQuote[0]);

        return quotes;
    }

}
