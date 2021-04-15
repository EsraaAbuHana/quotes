package quotes;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Quotes {
 String author;
 String text;
// String[] ArrayOfQuotes;
//ArrayList<String>quotesArray;


 public String getAuthor() {
  return author;
 }

 public void setAuthor(String author) {
  this.author = author;
 }

 public String getText() {
  return text;
 }

 public void setText(String text) {
  this.text = text;
 }

 public Quotes(String author, String text) {
  this.author = author;
  this.text = text;
 }

 ///lab 09**************************************************
 public static void main(String[] args) {
  String apiURL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
  try {
 URL url=new URL(apiURL);
   String jsonData=getJsonFromApi(url);
  } catch () {

  }

 }
 public static String getJsonFromApi() throws IOException{
//  HttpsURLConnection connection=(HttpsURLConnection) url.open;
 }
}