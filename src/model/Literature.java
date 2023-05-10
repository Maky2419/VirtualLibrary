package model;

public abstract class Literature {
    String Author = "";
    String BookName = "";
    String Publisher = "";
    String Genre = "";
    boolean availability;

    public Literature(){
        this.Author = "Unknown";
        this.BookName = "No BookName";
        this.Publisher = "No Publisher";
        this.Genre = "No Genre listed";

    }
    public Literature(String AuthorName, String BookName,String Publisher, String Genre,Boolean availability){
        this.Author = AuthorName;
        this.BookName = BookName;
        this.Publisher = Publisher;
        this.Genre = Genre;
        this.availability = availability;
    }

    public String getAuthorName(){
        return this.Author;
    }
    public String getBookName(){
        return this.BookName;
    }
    public String getPublisher(){
        return this.Publisher;

    }public String getGenre(){
        return this.Genre;
    }

    public void setAuthor(String m){
        this.Author= m;
    }
    public void setBookName(String m){
        this.BookName = m;
    }
    public void setPublisher(String m){
        this.Publisher = m;
    }
    public void setGenre(String m){
        this.Genre = m;
    }

    public abstract String toString();

    public String Class() {
        if (this instanceof Book) {
            return "Book";
        } else if (this instanceof AudioBook) {
            return "AudioBook";
        } else {
            return "";
        }

    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
