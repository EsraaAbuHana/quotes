package quotes;


public class Quotes {

    @Override
    public String toString() {
        return "Quotes{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

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





}