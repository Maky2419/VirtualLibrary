package model;

import java.util.LinkedList;

public class Librarian extends People{
    int StartShiftTime;
    int EndShiftTime;

    public Librarian(String Name, String Position, Library BooksOnHand, int NumOfBooksOnHand, String Email, int Start, int End) {
        super(Name, Position, BooksOnHand, NumOfBooksOnHand, Email);
        this.StartShiftTime = Start;
        this.EndShiftTime = End;
    }


    public int getEndShiftTime() {
        return EndShiftTime;
    }

    public int getStartShiftTime() {
        return StartShiftTime;
    }

    public void setEndShiftTime(int endShiftTime) {
        EndShiftTime = endShiftTime;
    }

    public void setStartShiftTime(int startShiftTime) {
        StartShiftTime = startShiftTime;
    }
    public void RemovesetLibrarianBooks(Literature Book){
        BooksOnHand.removeBook(Book.BookName);
    }
    public void AddsetLibrarianBooks(Literature Book){
        BooksOnHand.AddBook(Book);
    }
}
