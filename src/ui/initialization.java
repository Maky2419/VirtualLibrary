package ui;

import model.Book;
import model.Exceptions.EmptyArrayException;
import model.Exceptions.UserInputtedErrorException;
import model.Librarian;
import model.Library;
import model.Patrons;

import java.util.*;

public abstract class initialization {
    public static void run(Library lib,Librarian lib1,Patrons Bob) throws EmptyArrayException {

      System.out.println( lib.getBookNames() + "\n \n");
           userGuide(lib,Bob,lib1);

    }
    public static void userGuide(Library lib,Patrons Bob,Librarian lib1) throws EmptyArrayException {
        int choice = -1;
        int personChoice = -1;
        boolean breakPoint = true;

        Scanner k = new Scanner(System.in);
        while(breakPoint !=false) {
            System.out.println("Pick one");
            System.out.println("Are you a Librarian or a Patron? (0 --> General Viewing),(1 --> Librarian),(2 --> Patron), or (End Program --> 3)");
            personChoice = k.nextInt();k.nextLine();
            if (personChoice == 2) {
                RunPatron(choice,lib,Bob,lib1);

            }
            if(personChoice == 3){
                breakPoint = false;
            }
            if (personChoice == 1) {
                RunLibrarian(choice,lib);
            }
            if(personChoice == 0){
                RunGeneral(choice,lib);
            }
    }

    }
    public static void RunGeneral(int choice,Library lib) throws EmptyArrayException {
        Scanner k = new Scanner(System.in);


        System.out.println(" 1. To view all books with author names, 2. View books by Genre ");
        choice = k.nextInt();
        k.nextLine();

        if (choice == 1) {
            for(int i = 0; i < lib.getBooks().length; i++){
                System.out.println("Book Name: "+ lib.getBooks()[i] + " written by: "+ lib.getAuthorNames()[i]);
            }
        }
        if (choice == 2) {
            lib.HashmapsInsertions();
            HashMap<String, ArrayList> HM = lib.getAllGenres();
            String[] Types = {"Horror","Action","Adventure","Comedy","Crime and Mystery","Fantasy","Historic","Sci-fi","Romance","Science fiction","Thriller"};

            for(int i = 0; i < Types.length; i++){
                ArrayList m = HM.get(Types[i]);
                if(m.isEmpty()){
                }
                else{
                    System.out.println(Types[i] + " --> " + (Arrays.toString(m.toArray())).replaceAll("\\[|\\]", ""));
                }
            }

        }
    }

    public static void RunLibrarian(int choice, Library lib) throws EmptyArrayException {
        Scanner k = new Scanner(System.in);


        System.out.println(" 1. To view an authors book, 2. Add a book, 3. Remove a book, 4.Alphabetically Rearrange books, 5. Cost of all Books ");
        choice = k.nextInt();
        k.nextLine();

        if (choice == 1) {

            System.out.println("What is the name of the Author(If a list of unnamed Books if requested please type 'Unknown' ");
            String AuthorNameFromUser = k.nextLine();
            System.out.println(lib.returnBookTitle(AuthorNameFromUser));
        }
        if (choice == 2) {
            boolean Pictures = true;
            boolean HardCover = true;
            int num = 0;
            String[] Types = {"Horror","Action","Adventure","Comedy","Crime and Mystery","Fantasy","Historic","Sci-fi","Romance","Science fiction","Thriller"};
            boolean litFlag = true;
            String Chosen = "";

            while(litFlag){
                try {
                    System.out.println("Is it a Book or an Audio Book");
                     Chosen = k.nextLine();

                    if (Chosen.toUpperCase().equals("BOOK")) {
                        litFlag = false;
                    }
                    else if (Chosen.toUpperCase().equals("AUDIO BOOK")) {
                        litFlag = false;
                    }
                    else{
                        throw new UserInputtedErrorException();
                    }

                }catch(UserInputtedErrorException e1){
                    System.out.println("Please enter a correct type of Book either Audio or in Hand.");
                }
            }

            System.out.println("What is the name of the Book");
            String BookName = k.nextLine();
            System.out.println("What is the name of the Author");
            String AuthorName = k.nextLine();
            System.out.println("What is the name of the Publisher");
            String Publish = k.nextLine();

            Boolean flag = true;
            String Genre = null;
            while(flag){
                try {
                    System.out.println("What is the genre");
                    Genre = k.next();

                    if (Arrays.toString(Types).contains(Genre)) {
                        flag = false;
                    }
                    else{
                        throw new UserInputtedErrorException();
                    }

                }catch(UserInputtedErrorException e1){
                    System.out.println("Please enter a current genre, below states some of the options");
                    for(int i = 0; i < Types.length; i++){
                        System.out.println("--> "  + Types[i]);
                    }

                }
            }
            if (Chosen.toUpperCase().equals("BOOK")){
//                System.out.println("Does it have Pictures ?(Y/N)");
//                String d = k.nextLine();
//                System.out.println("Does it have a hardCover?(Y/N)");
//                String m = k.nextLine();
//
//
//
//                if(m.toUpperCase().equals("Y")){
//                    HardCover = true;
//                }
//                else{
//                    HardCover = false;
//                }
//
//                if(d.toUpperCase().equals("Y")){
//                    Pictures = true;
//                }
//                else{
//                    Pictures = false;
//                }

                System.out.println("How many number of pages in the book");
                num = k.nextInt();k.nextLine();
            }
            else{
                System.out.println("Duration of AudioBook");
                num = k.nextInt();k.nextLine();
            }

            lib.CreateNewBook(Chosen,AuthorName, BookName,num,Publish,Genre,Pictures,HardCover);
        }
        if (choice == 3) {

            System.out.println("What is the name of the Book you would like to remove");
            String selectedValue = k.nextLine();

            System.out.println(lib.removeBook(selectedValue));
        }
        if (choice == 4) {
            lib.PutBooksInAlphabeticOrder(lib);

        }
        if (choice == 5) {
            lib.costOfBooks();
        }
    }
    public static void RunPatron(int choice,Library lib,Patrons bobs,Librarian lib1) throws EmptyArrayException {
        Scanner k = new Scanner(System.in);
        System.out.println(" 1. To view an authors book, 2. Borrow a book, 3. Return a book ");
        choice = k.nextInt();
        k.nextLine();

        if(choice == 1){
            System.out.println("What is the name of the Author(If a list of unnamed Books if requested please type 'Unknown' ");
            String AuthorNameFromUser = k.nextLine();
            System.out.println(lib.returnBookTitle(AuthorNameFromUser));
        }
        else if(choice == 2){
            System.out.println("Which book would you like to borrow");
            String NameFromUser = k.nextLine();
            System.out.println("Old Patrons Array: " +bobs.getBooksOnHand());
            System.out.println("Old Librarian Array"+lib1.getBooksOnHand());
            bobs.borrow(lib1,NameFromUser);
            System.out.println("New Patrons Array: " + bobs.getBooksOnHand());
            System.out.println("New Librarian Array: "+ lib1.getBooksOnHand());

        }else if(choice == 3){
            System.out.println("Which book would you like to return");
            String NameFromUser = k.nextLine();
            System.out.println("Old Patrons Array: " +bobs.getBooksOnHand());
            System.out.println("Old Librarian Array"+lib1.getBooksOnHand());
            bobs.returnBook(lib1, NameFromUser);
            System.out.println("New Patrons Array: " + bobs.getBooksOnHand());
            System.out.println("New Librarian Array: "+ lib1.getBooksOnHand());

        }
       else{

        }



    }


}



