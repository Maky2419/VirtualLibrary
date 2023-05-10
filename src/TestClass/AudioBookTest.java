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
public class AudioBookTest {

    AudioBook a;
    @BeforeEach
    public void InitializeBook(){
        a = new AudioBook("James Gun", "Turtles", "PublisherMan", "Horror", 20,true);

    }
    @Test
    public void TestgetDurationOfBooks(){
        InitializeBook();
        assertEquals(a.getDurationOfBooks(),20);
    }
    @Test
    public void TesttoStringMethod(){
        InitializeBook();
        System.out.println(a.toString());
        assertEquals(a.toString(),"James Gun,Turtles,PublisherMan,Horror,20"+ "\n");
    }
}
