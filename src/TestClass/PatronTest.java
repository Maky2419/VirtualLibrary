package TestClass;

import model.*;
import model.Exceptions.EmptyArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PatronTest {
    Patrons k;

    @BeforeEach
    public void Initialize() throws EmptyArrayException {
        Library l = new Library();
        Literature a = new Book("John Green", "Looking for Alaska", 221, "Penguin Books", "Romance", true, true,true);
        Literature b = new Book("Micheal Walker", "How to Run", 111, "Turtle Books", "Action", false, true,true);
        Literature c = new Book("Harrison Wells", "Flashpoint", 333, "Crows Books", "Sci-Fi", true, false,true);
        l.AddBook(a);
        l.AddBook(b);
        l.AddBook(c);
        k = new Patrons("Reasha", "Person", l, l.getBooks().length, "Mow@gmail.com", 0, "Gold");


    }
    public Librarian InitializeLibrarian(){
        Library l  = new Library();
        Literature b = new Book("Micheal Walker", "Commons",111,"Turtle Books", "Action",false,true,true);
        Literature c = new Book("Harrison Wells", "Fipke",333,"Crows Books", "Sci-Fi",true,false,true);


        l.AddBook(b);
        l.AddBook(c);
       Librarian Librarian1 = new Librarian("John", "Manager", l, 4, "Email@mail.com", 0, 12);
return Librarian1;
    }

    @Test
    public void TestgetNumOfPreviouslyBorrowed() {
        assertEquals(k.getNumOfPreviouslyBorrowed(),0);
    }
    @Test
    public void TestgetMembershipStatus() {
        assertEquals(k.getMembershipStatus(),"Gold");
    }
    @Test
    public void Testborrow() throws EmptyArrayException {
        Librarian l = InitializeLibrarian();
        String fromUser = "Commons";

        k.borrow(l,fromUser);

        assertEquals(k.getBooks().getBookNames(),"[Looking for Alaska, How to Run, Flashpoint, Commons]");
        assertEquals(l.getBooks().getBookNames(),"[Fipke]");

    }
    @Test
    public void TestborrowDNE() throws EmptyArrayException {
        Librarian l = InitializeLibrarian();
        String fromUser = "mowz";

        k.borrow(l,fromUser);

        assertEquals(k.getBooks().getBookNames(),"[Looking for Alaska, How to Run, Flashpoint]");
        assertEquals(l.getBooks().getBookNames(),"[Commons, Fipke]");

    }

    @Test
    public void TestReturnBookDNE() throws EmptyArrayException {
        Librarian l = InitializeLibrarian();
        String fromUser = "mowz";

        k.returnBook(l,fromUser);
System.out.println(k.getBooks().getBookNames());
        System.out.println(l.getBooks().getBookNames());

        assertEquals(k.getBooks().getBookNames(),"[Looking for Alaska, How to Run, Flashpoint]");
        assertEquals(l.getBooks().getBookNames(),"[Commons, Fipke]");

    }

    @Test
    public void TestReturnBook() throws EmptyArrayException {
        Librarian l = InitializeLibrarian();
        String fromUser = "How to Run";

        k.returnBook(l,fromUser);
        System.out.println(k.getBooks().getBookNames());
        System.out.println(l.getBooks().getBookNames());

        assertEquals(k.getBooks().getBookNames(),"[Looking for Alaska, Flashpoint]");
        assertEquals(l.getBooks().getBookNames(),"[Commons, Fipke, How to Run]");

    }

}
