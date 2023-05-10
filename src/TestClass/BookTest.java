package TestClass;
import model.AudioBook;
import model.Book;
import model.Library;
import model.Literature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    Book a;
    @BeforeEach
    public void InitializeBook(){
        a = new Book("John Green", "Looking for Alaska",16,"Penguin Books", "Romance",true,true,true);

    }

    @Test
    public void SetDifferentGenreTest(){
        InitializeBook();
        a.setGenre("Funny");
        assertEquals( a.getGenre(),"Funny");
    }
    @Test
    public void getAuthorNameTest(){
        InitializeBook();
       assertEquals( a.getAuthorName(),"John Green");
    }
    @Test
    public void getBookNameTest(){
        InitializeBook();
        assertEquals( a.getBookName(),"Looking for Alaska");
    }
    @Test
    public void getNumOfPagesTest(){
        InitializeBook();
        assertEquals( a.getNumOfPages(),16);
    }
    @Test
    public void getPublisherTest(){
        InitializeBook();
        assertEquals( a.getPublisher(),"Penguin Books");
    }

    @Test
    public void getGenreTest(){
        InitializeBook();
        assertEquals( a.getGenre(),"Romance");
    }
    @Test
    public void setAuthorNameTest(){
        InitializeBook();
        String S = "Reasha";
        a.setAuthor(S);
        assertEquals(a.getAuthorName(),S);
    }
    @Test
    public void setBookNameTest(){
        InitializeBook();
        String S = "How to train your dragon";
        a.setBookName(S);
                assertEquals( a.getBookName(),S);
    }
     @Test
    public void setNumOfPagesTest(){
        InitializeBook();
         int S = 204;
         a.setNumberOfPages(S);
         assertEquals( a.getNumOfPages(),S);
    }
    @Test
    public void setPublisherNameTest(){
        InitializeBook();
        String S = "John Stewart";
        a.setPublisher(S);
        assertEquals( a.getPublisher(),S);
    }
    @Test
    public void setGenreTest(){
        InitializeBook();
        String S = "Romance";
        assertEquals( a.getGenre(),S);
    }

    @Test
    public void CreateBookWithParams(){
        Book k = new Book();
        assertEquals(k.getNumOfPages(),0);
        assertEquals(k.HasPictures(),true);
        assertEquals(k.hasHardCover(),true);
    }

    @Test
    public void testSetPicture(){
        InitializeBook();
        a.setPictures(false);
        assertEquals(a.HasPictures(),false);
    }

    @Test
    public void TestsetHardCover(){
        InitializeBook();
        a.setHardCover(false);
        assertEquals(a.hasHardCover(),false);
    }

    @Test
    public void CostOfBooksTest(){
        InitializeBook();
        assertEquals(a.costOfBooks(),4.0);
    }
    @Test
    public void TesttoString(){
        assertEquals(a.toString(),"John Green,Looking for Alaska,16,Penguin Books,Romance,true,true");
    }
    @Test
    public void testClass(){
        Literature one = new Book();
        Literature two = new AudioBook();
        assertEquals(one.Class(),"Book");
        assertEquals(two.Class(),"AudioBook");

    }
}
