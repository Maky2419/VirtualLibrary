package TestClass;
import model.Book;
import model.Exceptions.EmptyArrayException;
import model.Exceptions.NoBookTitleException;
import model.Exceptions.UserInputtedErrorException;
import model.Library;
import model.Literature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LibraryTest {
    Library lib;
    @BeforeEach
    public void setUp(){
        lib = new Library();
        Literature a = new Book("John Green", "Looking for Alaska",221,"Penguin Books", "Romance",true,true,true);
        Literature b = new Book("Micheal Walker", "How to Run",111,"Turtle Books", "Action",false,true,true);
        Literature c = new Book("Harrison Wells", "Flashpoint",333,"Crows Books", "Sci-Fi",true,false,true);

        lib.AddBook(a);
        lib.AddBook(b);
        lib.AddBook(c);
    }
@Test
    public void returnBookTitleTestAuthorExists(){
    setUp();
    String Author = "John Green";
    assertEquals(lib.returnBookTitle(Author),Author + " Wrote: Looking for Alaska, ");

    }
    @Test
    public void returnBookTitleTestAuthorDoesNotExist(){
        setUp();
        String Author = " ";
        assertEquals(lib.returnBookTitle(Author),Author+" Wrote: No books");

    }
    @Test
    public void returnBookTitleTestAuthorwithMultiple(){
        Book d = new Book("John Green", "Looking for China",221,"Penguin Books", "Romance",false,false,true);
        setUp();
        lib.AddBook(d);

        String Author = "John Green";
        assertEquals(lib.returnBookTitle(Author),Author+" Wrote: Looking for Alaska, Looking for China, ");

    }


    @Test
    public void removeBookTestExistingAuthor(){
        setUp();
        String Name = "Flashpoint";
        assertEquals( lib.removeBook(Name),"New book list is [Looking for Alaska, How to Run]");
    }
    @Test
    public void removeBookTestNoAuthor(){
        setUp();
        String Name = "Sage";
        assertEquals( lib.removeBook(Name),"No book removed, Book doesn't exist");
    }
    @Test
    public void AddBookTest(){
        setUp();
        Book k = new Book("Charmi Patel", "Life of Patels",18,"Shiza Books", "Comedy",true,true,true);
        lib.AddBook(k);
        assertEquals(lib.getNumOfBooks(), 4);

    }
    @Test
    public void GetNumOfBooksTest(){
        setUp();
        Book k = new Book("Charmi Patel", "Life of Patels",18,"Shiza Books", "Comedy",true,true,true);
        for(int i = 0; i<13; i++){
            lib.AddBook(k);
        }
        assertEquals(lib.getNumOfBooks(), 16);

    }
@Test
    public void DisplayBooksTest() throws EmptyArrayException {

    assertEquals(lib.getBookNames(),"[Looking for Alaska, How to Run, Flashpoint]");
        }

    @Test
    public void getBooksTest() throws EmptyArrayException {
        String[] arr = {"Looking for Alaska", "How to Run", "Flashpoint"};

        assertEquals(lib.getBooks()[0], arr[0]);
        assertEquals(lib.getBooks()[1], arr[1]);
        assertEquals(lib.getBooks()[2], arr[2]);


    }
    @Test
    public void getNumOfPagesBooksTest() throws EmptyArrayException {
        int[] arr = {221,111,333};

        assertEquals(lib.getNumOfPagesBooks()[0], arr[0]);
        assertEquals(lib.getNumOfPagesBooks()[1], arr[1]);
        assertEquals(lib.getNumOfPagesBooks()[2], arr[2]);


    }

    @Test
    public void getPublisherNameBooksTest() throws EmptyArrayException {
        String[] arr = {"Penguin Books", "Turtle Books", "Crows Books"};

        assertEquals(lib.getPublisherNameBooks()[0], arr[0]);
        assertEquals(lib.getPublisherNameBooks()[1], arr[1]);
        assertEquals(lib.getPublisherNameBooks()[2], arr[2]);


    }

    @Test
    public void getGenresBooksTest() {
        String[] arr = {"Romance", "Action", "Sci-Fi"};

        assertEquals(lib.getGenresBooks()[0], arr[0]);
        assertEquals(lib.getGenresBooks()[1], arr[1]);
        assertEquals(lib.getGenresBooks()[2], arr[2]);


    }

    @Test
    public void getAuthorNamesTest() {
        String[] arr = {"John Green", "Micheal Walker", "Harrison Wells"};

        assertEquals(lib.getAuthorNames()[0], arr[0]);
        assertEquals(lib.getAuthorNames()[1], arr[1]);
        assertEquals(lib.getAuthorNames()[2], arr[2]);


    }

    @Test
    public void getPictureArrayTest() {
        boolean[] arr = {true,false,true};

        assertEquals(lib.getPicturesArray()[0], arr[0]);
        assertEquals(lib.getPicturesArray()[1], arr[1]);
        assertEquals(lib.getPicturesArray()[2], arr[2]);


    }

    @Test
    public void testEmptyArrayExceptionWithGetBooks() throws EmptyArrayException {
        Library lib1 = new Library();
           String[] AllBooks = lib1.getPublisherNameBooks();
         assertEquals(AllBooks.length,0);

    }
    @Test
    public void testNoBookTitle() throws NoBookTitleException {
        setUp();

        String Value = lib.returnBookTitle("Macbooks");
        assertEquals(Value,"Macbooks" + " Wrote:" + " No books");

    }

    @Test
    public void testNoRemovableBookTitle() throws UserInputtedErrorException {
        setUp();

        String Value = lib.removeBook("Macbooks");
        assertEquals(Value,"No book removed, Book doesn't exist");

    }
    @Test
    public void TestPutBooksInAlphabeticOrder() throws EmptyArrayException {
        lib.PutBooksInAlphabeticOrder(lib);

        assertEquals(lib.getBookNames(),"[Flashpoint, How to Run, Looking for Alaska]");
    }

    @Test
    public void TestCostOfBooks() throws EmptyArrayException {

        assertEquals(lib.costOfBooks(),166.25);
    }

}
