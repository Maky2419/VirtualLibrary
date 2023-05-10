package ui;
import model.Exceptions.EmptyArrayException;
import model.Librarian;
import model.Library;
import model.Patrons;

import java.io.IOException;
import java.util.LinkedList;

// Visualizations of your library.
public class Main {
    public static void main(String[] args) throws IOException, EmptyArrayException, CloneNotSupportedException {
       System.out.println(Input.getDataFromWeb());

        LinkedList LibrariansLinkedList = new LinkedList<>();
        Library Mainlib = Input.readFullLibrary();
        Library libOfLibr = new Library();

        for(int i = 0; i < Mainlib.getLinkedList().size();i++){
            //System.out.println(Mainlib.getBooks()[i] + " " + Mainlib.Availabilities()[i]);
            if(Mainlib.Availabilities()[i].equals("true")){
                libOfLibr.AddBook(Mainlib.ReturnSingleObject(Mainlib.getBooks()[i]));
                }
            }

        Mainlib.HashmapsInsertions();
        LinkedList<Patrons> PatronsList = Input.readPatrons(Mainlib);
        Librarian librarian1 = new Librarian("Ahsan", "Head of Library", libOfLibr, 0, "Maky.47.2004@gmail.com",12,4);
        LibrariansLinkedList.add(librarian1);
        Patrons Bob = PatronsList.getFirst();
        Mainlib.addObserver(Bob);
        initialization.run(Mainlib,librarian1,Bob);
        Input.WritePatrons(PatronsList);
        Input.Write(Mainlib);
    }
    }