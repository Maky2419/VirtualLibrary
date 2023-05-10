package model;

import model.Exceptions.EmptyArrayException;
import model.Exceptions.NoBookTitleException;
import model.Exceptions.UserInputtedErrorException;

// When we add an animal we need to notify everyone
import java.util.*;

public class Library extends SubjectInView implements Maintence,Financial,Cloneable {
    LinkedList<Literature> Items = new LinkedList();
    String[] Types = {"Horror","Action","Adventure","Comedy","Crime and Mystery","Fantasy","Historic","Sci-fi","Romance","Science fiction","Thriller"};

    int NumOfBooks;
    HashMap<String, ArrayList> AllGenres = new HashMap();
    Scanner k = new Scanner(System.in);

    public Library() {
        NumOfBooks = 0;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

public void HashmapsInsertions(){
    AllGenres.clear();
    for(int i = 0; i< Types.length;i++){
        ArrayList k = new ArrayList();
    for (Literature Lit: Items) {
            if(Lit.Genre .equals(Types[i])){
               k.add(Lit.getBookName());
            }
        }
    AllGenres.put(Types[i],k);

    }
//
//    for(int i = 0; i< Types.length;i++) {
//    ArrayList m = AllGenres.get(Types[i]);
//    System.out.println(Types[i] + "===" + Arrays.toString(m.toArray()));
//    }

}

    public HashMap<String, ArrayList> getAllGenres() {
        return AllGenres;
    }

    public int getNumOfBooks() {
        return this.NumOfBooks;
    }

    //REQUIRES:Linked list of Books to exist
    //EFFECTS:  returns a String of array of Books linkedList.
    public String getBookNames() throws EmptyArrayException {
        if (Items.toArray().length == 0) {

            return "Array is Empty";

        } else {
            String[] AllBooks = new String[Items.toArray().length];

            for (int i = 0; i < (Items.toArray()).length; i++) {
                AllBooks[i] = ((Book) (Items.toArray()[i])).getBookName();
            }
            return Arrays.toString(AllBooks);
        }

    }

    public String[] getBooks() throws EmptyArrayException {
        String[] AllBooks = new String[0];
        try{
            if (Items.toArray().length == 0) {
                throw new EmptyArrayException();

            } else {
                 AllBooks = new String[Items.toArray().length];

                for (int i = 0; i < (Items.toArray()).length; i++) {
                    AllBooks[i] = ((Book) (Items.toArray()[i])).getBookName();
                }
            }
        }
        catch (EmptyArrayException e1) {
            System.out.println("The Library contains no books, nothing can be displayed");
        } finally {
            return AllBooks;}


    }

    public int[] getNumOfPagesBooks() throws EmptyArrayException {
        int[] AllBooks = new int[0];
        try{
            if (Items.toArray().length == 0) {
                throw new EmptyArrayException();

            } else {
                AllBooks = new int[Items.toArray().length];

                for (int i = 0; i < (Items.toArray()).length; i++) {
                    AllBooks[i] = ((Book) (Items.toArray()[i])).getNumOfPages();
                }
            }
        }
        catch (EmptyArrayException e1) {
            System.out.println("The Library contains no books, nothing can be displayed");
        } finally {
            return AllBooks;}

    }

    public String[] getPublisherNameBooks() throws EmptyArrayException {
        String[] AllBooks = new String[0];
        try {
            if (Items.toArray().length == 0) {
                throw new EmptyArrayException();
            } else {
                AllBooks = new String[Items.toArray().length];

                for (int i = 0; i < (Items.toArray()).length; i++) {
                    AllBooks[i] = ((Book) (Items.toArray()[i])).getPublisher();
                }
            }

        } catch (EmptyArrayException e1) {
            System.out.println("The Library contains no books, nothing can be displayed");

            System.out.println(AllBooks.length);
        } finally {

        return AllBooks;
    }

}

            public String[] getGenresBooks(){
                String[] AllBooks = new String[0];
                try {
                    if (Items.toArray().length == 0) {
                        throw new EmptyArrayException();
                    } else {
                        AllBooks = new String[Items.toArray().length];

                        for (int i = 0; i < (Items.toArray()).length; i++) {
                            AllBooks[i] = ((Book) (Items.toArray()[i])).getGenre();
                        }
                    }
                }
                catch(EmptyArrayException e1){
                    System.out.println("The Library contains no books, nothing can be displayed");
                } finally {
                    return AllBooks;
                }

            }

            public String[] getAuthorNames(){
                String[] AuthorNames  = new String[0];
        try{
            if (Items.toArray().length == 0) {
                throw new EmptyArrayException();
            } else {
                AuthorNames = new String[Items.toArray().length];

                for (int i = 0; i < (Items.toArray()).length; i++) {
                    AuthorNames[i] = ((Book) (Items.toArray()[i])).getAuthorName();
                }
            }
        }catch(EmptyArrayException e1){
            System.out.println("The Library contains no books, nothing can be displayed");
        } finally {
            return AuthorNames;
        }
            }

            public Boolean[] getPicturesArray(){
                Boolean[] ValReturn = new Boolean[0];
        try{
            if (Items.toArray().length == 0) {
                throw new EmptyArrayException();
            } else {
                int count = 0;
                String[] arr = Classes();
                for(int i = 0; i <  Items.toArray().length; i++){
                    if(arr[i].equals("Book")){
                        count ++;
                    }
                }
                 ValReturn = new Boolean[count];
                for(int i = 0; i <  Items.toArray().length; i++){
                    boolean k = ((Book) (Items.toArray()[i])).HasPictures();
                    if(arr[i].equals("Book")){
                        ValReturn[i] = k;
                    }
                }
            }
            }catch(EmptyArrayException e1){
        System.out.println("The Library contains no books, nothing can be displayed");
    } finally {
        return ValReturn;
    }
                }


            public String[] Classes(){
                String[] Cl  = new String[0];
                try{
                    if (Items.toArray().length == 0) {
                        throw new EmptyArrayException();
                    } else {
                         Cl = new String[Items.toArray().length];

                        for (int i = 0; i < (Items.toArray()).length; i++) {
                            Cl[i] = ((Literature) (Items.toArray()[i])).Class();
                        }

                    }
            }catch(EmptyArrayException e1){
        System.out.println("The Library contains no books, nothing can be displayed");
    } finally {
        return Cl;
    }

            }

            public LinkedList getLinkedList(){
                return Items;
            }

            //REQUIRES:Linked list of Books to exist
            //EFFECTS:  returns a String which outputs the author's name and the books he/she wrote.
            public String returnBookTitle(String AuthorNameFromUser) {
                String selec =AuthorNameFromUser + " Wrote: " ;
                String[] AllAuthors = new String[0];
                String[] AllBooks = new String[0];
                try{
                    if (Items.toArray().length == 0) {
                        throw new EmptyArrayException();
                    } else {
                        AllAuthors = new String[Items.toArray().length];
                         AllBooks = new String[Items.toArray().length];

                        for (int i = 0; i < (Items.toArray()).length; i++) {
                            AllAuthors[i] = ((Book) (Items.toArray()[i])).getAuthorName();
                            AllBooks[i] = ((Book) (Items.toArray()[i])).getBookName();
                        }

                        System.out.println(Arrays.toString(AllAuthors));

                        for (int i = 0; i < AllAuthors.length; i++) {
                            if (AllAuthors[i].equals(AuthorNameFromUser)) {
                                selec = selec + ((Book) (Items.toArray()[i])).getBookName() + ", ";
                            }else{
                                if (selec.equals(AuthorNameFromUser + " Wrote: ")) {
                                    throw new NoBookTitleException();
                                }
                            }
                        }


                    }
                } catch(EmptyArrayException e1){
                    selec = "The Library contains no books, nothing can be displayed";
                }catch (NoBookTitleException e2){
                        selec = AuthorNameFromUser + " Wrote:" + " No books";
                }
                finally {
                    return (selec);
                }
            }
            public Literature ReturnSingleObject(String k) throws EmptyArrayException {
                for(int i = 0; i< Items.size(); i++){
                    if(getBooks()[i].equals(k)){
                        return (Literature) Items.get(i);
                    }
                }
                return (Literature) Items.get(0);
            }

            //Modifies this, adds object to object LinkedList.
                public void CreateNewBook(String Chosen,String AuthorName, String BookName,Integer num,String Publisher, String Genre,boolean HP,boolean HardCover) {
                        Literature l;
                    if(Chosen.toUpperCase().equals("BOOK")){
                        l = new Book(AuthorName,BookName,num,Publisher,Genre,HP,HardCover,true);


                    }
                    else{
                        l= new AudioBook(AuthorName,BookName,Publisher, Genre,num,true);
                    }
                    Items.add(l);
                    NumOfBooks = NumOfBooks + 1;



                }
                // Requires Books linked List to exist.
                // Modifies this
                // Effects size of Books linkedList and objects in Books LinkedList.
                public void AddBook(Literature book){
                    Items.add(book);
                    NumOfBooks++;

                }

            // Modifies this
            // Effects size of Books linkedList and objects in Books LinkedList by removing Object from linkedlist.

                public String removeBook (String selectedValue) {
                    String[] AllBooks = new String[0];
                    String Value = "";
                    try {
                        if (Items.toArray().length == 0) {
                            throw new EmptyArrayException();
                        } else {
                            List<String> list = Arrays.asList(getBooks());
                            if(list.contains(selectedValue)){

                            }
                            else{
                                throw new UserInputtedErrorException();
                            }
                            NumOfBooks--;
                            for (int i = 0; i < (Items.toArray()).length; i++) {
                                if (((Literature) (Items.toArray()[i])).getBookName().equals(selectedValue)) {
                                    Items.remove(Items.toArray()[i]);

                                }
                            }
                             AllBooks = new String[Items.toArray().length];

                            for (int i = 0; i < (Items.toArray()).length; i++) {
                                AllBooks[i] = ((Book) (Items.toArray()[i])).getBookName();
                            }
                            Value = "New book list is " + Arrays.toString(AllBooks);
                        }
                    } catch(EmptyArrayException e1){
        System.out.println("The Library contains no books, nothing can be displayed");
    }catch (UserInputtedErrorException e2){
                        Value = "No book removed, Book doesn't exist";
    } finally {
                        return Value;
    }




                }


            @Override
            public void PutBooksInAlphabeticOrder(Library lib) {
                Object temp;
                String[] AllBooks = new String[Items.toArray().length];
                Object[] Arr = new Object[Items.toArray().length];

                for (int i = 0; i < (Items.toArray()).length; i++) {
                    AllBooks[i] = ((Literature) (Items.toArray()[i])).getBookName();
                    Arr[i] = ((Literature) (Items.toArray()[i]));
                }

                for (int j = 0; j < Arr.length - 1; j++) {
                    for (int i = j + 1; i < Arr.length; i++) {
                        if (AllBooks[j].compareTo(AllBooks[i]) > 0) {
                            temp = Arr[j];

                            Arr[j] = Arr[i];
                            Arr[i] = temp;
                        }
                    }
                }

                Items.clear();
                for (int j = 0; j < Arr.length; j++) {
                    Items.add((Literature) Arr[j])   ;
                }

                System.out.println("The Books in the Library have been sorted in Alphabetic Order.");

            }

            @Override
            public double costOfBooks() throws EmptyArrayException {
                int[] k = getNumOfPagesBooks() ;
                double sum = 0;
                for(int m = 0 ; m<k.length; m++){
                    sum = sum +(k[m]*0.25);
                }
                System.out.println("The cost of all the books in the Library are "+ sum);
                return sum;
            }

            public String[] getArrayofDurations(){
                String[] arr = Classes();
                LinkedList dur = new LinkedList();
        for(int i = 0; i <  Items.toArray().length; i++){
            if(arr[i].equals("AudioBook")){
                dur.add(((AudioBook) (Items.toArray()[i])).getDurationOfBooks());
            }
        }
              return (String[]) dur.toArray();

            }

            public Boolean[] getHardCover(){

                int count = 0;
                String[] arr = Classes();
                for(int i = 0; i <  Items.toArray().length; i++){
                    if(arr[i].equals("Book")){
                        count ++;
                    }
                }
                Boolean[] ValReturn = new Boolean[count];
                for(int i = 0; i <  Items.toArray().length; i++){
                    boolean k = ((Book) (Items.toArray()[i])).hasHardCover();
                    if(arr[i].equals("Book")){
                        ValReturn[i] = k;
                    }
                }
                return (ValReturn);

            }

            public String[] Availabilities(){

                String[] ValReturn = new String[Items.size()];
                for(int i = 0; i <  Items.toArray().length; i++){
                    boolean k = ((Literature) (Items.toArray()[i])).isAvailability();
                        ValReturn[i] = Boolean.toString(k);

                }
                return (ValReturn);

            }

}



