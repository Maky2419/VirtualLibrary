package model;

public class AudioBook extends Literature{
    int DurationOfBooks = 0;
public AudioBook(String Author, String BookName, String Publisher, String Genre, int DurationofBooks,boolean availability){
    this.Author = Author;
    this.BookName = BookName;
    this.Publisher = Publisher;
    this.Genre = Genre;
    this.DurationOfBooks = DurationofBooks;
    this.availability = availability;

}

    public AudioBook() {
       this.DurationOfBooks = 10;
    }

    public int getDurationOfBooks() {
        return DurationOfBooks;
    }

    @Override
    public String toString() {
        return (getAuthorName() +","+ getBookName() + "," + getPublisher() + ","+ getGenre()  + "," + getDurationOfBooks()+"\n");

    }
}
