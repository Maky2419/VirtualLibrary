package TestClass;

import model.*;
import model.Exceptions.EmptyArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianTest {
    Librarian Librarian1;
    @BeforeEach
    public void InitializeLibrarian(){
        Library l  = new Library();
        Literature a = new Book("John Green", "Looking for Alaska",221,"Penguin Books", "Romance",true,true,true);
        Literature b = new Book("Micheal Walker", "How to Run",111,"Turtle Books", "Action",false,true,true);
        Literature c = new Book("Harrison Wells", "Flashpoint",333,"Crows Books", "Sci-Fi",true,false,true);

        l.AddBook(a);
        l.AddBook(b);
        l.AddBook(c);
        Librarian1 = new Librarian("John", "Manager", l, 4, "Email@mail.com", 0, 12);

    }
@Test
    public void getEndShiftTimeTest() {

    assertEquals(Librarian1.getEndShiftTime(),12);
    }

    @Test
    public void getStartShiftTimeTest() {
        assertEquals(Librarian1.getStartShiftTime(),0);
    }
    @Test
    public void setEndShiftTimeTest() {
        int endShiftTime = 3;
        Librarian1.setEndShiftTime(endShiftTime);
       assertEquals(Librarian1.getEndShiftTime(),3);
    }
    @Test
    public void setStartShiftTimeTest() {
       int  startShiftTime = 3;
        Librarian1.setStartShiftTime(startShiftTime);
        assertEquals(Librarian1.getStartShiftTime(),3);

    }
@Test
    public void RemovesetLibrarianBooksTest() throws EmptyArrayException {
         Literature Book = new Book("John Green", "Looking for Alaska",221,"Penguin Books", "Romance",true,true,true);

        Librarian1.RemovesetLibrarianBooks(Book);
    }
    @Test
    public void AddsetLibrarianBooksTest(){
        Literature Book = new Book("Charmi", "Reasha",900,"Evlyn", "Horror",true,true,true);
        Librarian1.AddsetLibrarianBooks(Book);
    }


}
