
package book;
import java.util.*;

public class Book {

       private String name;
    private String contents;
    private int publishingYear;

    public Book(String name, int publishingYear, String contents) {
        this.name = name;
        this.publishingYear = publishingYear;
        this.contents = contents;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishingYear() {
        return this.publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

       @Override
    public String toString() {
        return "Name: " + this.name + " (" + this.publishingYear + ")\n"
                + "Contents: " + this.contents;
    }
    public static void main(String[] args) {
      HashMap<String, Book> bookCollection = new HashMap<String, Book>();  
    Book senseAndSensibility = new Book("Sense and Sensibility", 1811, "...");
Book prideAndPrejudice = new Book("Pride and Prejudice", 1813, "....");


bookCollection.put(senseAndSensibility.getName(), senseAndSensibility);

    }
    
}
