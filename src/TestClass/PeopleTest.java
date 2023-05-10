package TestClass;

import model.Book;
import model.Exceptions.EmptyArrayException;
import model.Library;
import model.Literature;
import model.People;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleTest {
    People k ;
    @BeforeEach
    public void InitializePeople() throws EmptyArrayException {
        Library l  = new Library();
        Literature a = new Book("John Green", "Looking for Alaska",221,"Penguin Books", "Romance",true,true,true);
        Literature b = new Book("Micheal Walker", "How to Run",111,"Turtle Books", "Action",false,true,true);
        Literature c = new Book("Harrison Wells", "Flashpoint",333,"Crows Books", "Sci-Fi",true,false,true);
        l.AddBook(a);
        l.AddBook(b);
        l.AddBook(c);
        k = new People("Reasha", "Person", l,l.getBooks().length,"Mow@gmail.com");
    }
    @Test
    public void TestgetPosition(){
        assertEquals(k.getPosition(),"Person");
    }
    @Test
    public void TestgetName(){
        assertEquals(k.getName(),"Reasha");
    }
    @Test
    public void TestgetBooksonHand() throws EmptyArrayException {
        System.out.println(k.getBooksOnHand());
        assertEquals(k.getBooksOnHand(),"[Looking for Alaska, How to Run, Flashpoint]");
    }

    @Test
    public void testGetBooks() throws EmptyArrayException {
         assertEquals(k.getBooks().getBookNames(),"[Looking for Alaska, How to Run, Flashpoint]");
    }

    @Test
    public void testSetBooksOnHand() throws EmptyArrayException {
        Library l  = new Library();
        Literature a = new Book("John Green", "Looking for Alaska",221,"Penguin Books", "Romance",true,true,true);
        Literature b = new Book("Micheal Walker", "How to Run",111,"Turtle Books", "Action",false,true,true);
        l.AddBook(a);
        l.AddBook(b);
        k.setBooksOnHand(l);

        assertEquals(k.getBooks().getBookNames(),"[Looking for Alaska, How to Run]");


    }
    @Test
    public void TestGetNumOfBooksOnHand(){
        assertEquals(k.getNumOfBooksOnHand(),3);
    }
    @Test
    public void TestGetEmail(){
        assertEquals(k.getEmail(),"Mow@gmail.com");
    }




}
