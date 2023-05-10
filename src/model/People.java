package model;

import model.Exceptions.EmptyArrayException;

public class People extends SubjectInView {
    String Name;
    String Position;
    String Email;

    Library BooksOnHand;
    int numOfBooksOnHand;

    public People(String Name, String Position, Library BooksOnHand, int NumOfBooksOnHand, String Email){
        this.Name = Name;
        this.Position = Position;
        this.BooksOnHand = BooksOnHand;
        this.numOfBooksOnHand = numOfBooksOnHand;
        this.Email = Email;
    }

    public String getPosition() {
        return Position;
    }

    public String getName() {
        return Name;
    }

    public String getBooksOnHand() throws EmptyArrayException {
        return BooksOnHand.getBookNames();
    }
    public Library getBooks() {
        return this.BooksOnHand;
    }

    public void setBooksOnHand(Library booksOnHand) {
        BooksOnHand = booksOnHand;
    }

    public int getNumOfBooksOnHand() {
        return this.BooksOnHand.Items.size();
    }

    public String getEmail() {
        return Email;
    }
}
