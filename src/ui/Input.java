package ui;

import model.*;
import model.Exceptions.EmptyArrayException;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Input {
    public static Library readFullLibrary() throws IOException {
        File source = new File("Data/Files.txt");
        Scanner in = new Scanner(source);
        Library lib1 = new Library();
        Literature m = null;

        while (in.hasNextLine()) {

            String data = in.nextLine();
            String[] arr = data.split(",");
           // System.out.println(Arrays.toString(arr));

            if(arr[0].equals("Book")){
                m = new Book(arr[1], arr[2],Integer.parseInt(arr[3]),arr[4], arr[5],Boolean.parseBoolean(arr[6]),Boolean.parseBoolean(arr[7]),Boolean.parseBoolean(arr[8]));
                lib1.AddBook(m);
               // System.out.println("Book added");
                }
            else if(arr[0].equals("AudioBook")){
                m = new AudioBook(arr[1],arr[2],arr[3],arr[4],Integer.parseInt(arr[5]),Boolean.parseBoolean(arr[6]));

                lib1.AddBook(m);
            }

        }
        in.close();

        return lib1;
    }

    public static LinkedList<Patrons> readPatrons(Library lib) throws IOException, EmptyArrayException {
        File source = new File("Data/Patrons.txt");
        Scanner in = new Scanner(source);
        LinkedList<Patrons> p = new LinkedList<>();
        Patrons m;

        while (in.hasNextLine()) {

            String data = in.nextLine();
            String[] arr = data.split(",");

            Library lib1 = new Library();

                m = new Patrons(arr[0], arr[1], lib1, Integer.parseInt(arr[3]), arr[4], Integer.parseInt(arr[5]), arr[6]);
                String[] Books = arr[2].split("/");

                for(int i = 0 ; i< Books.length; i++){

                    for(int k = 0; k< lib.getLinkedList().size();k++){

                        if(Books[i].equals(lib.getBooks()[k])){

                            Literature o = (lib.ReturnSingleObject(Books[i]));

                            lib1.AddBook(o);
                        }
                    }
                }
                p.add(m);

        }
        in.close();
        return p;
    }

    public static void Write(Library lib) throws IOException, EmptyArrayException {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("Data/Files.txt");
        System.out.println(lib.getNumOfBooks());

            for (int i = 0; i < lib.getNumOfBooks(); i++) {
                if(lib.Classes()[i].equals("Book")){
                    myWriter.write(lib.Classes()[i] + "," + lib.getAuthorNames()[i] +","+ lib.getBooks()[i] + ","+ lib.getNumOfPagesBooks()[i]+"," + lib.getPublisherNameBooks()[i] + ","+ lib.getGenresBooks()[i] +","+ lib.getPicturesArray()[i]+","+lib.getHardCover()[i]+","+ lib.Availabilities()[i]+"\n");
                    myWriter.flush();
                }
                else if(lib.Classes()[i].equals("AudioBook")){
                    myWriter.write(lib.Classes()[i] + "," + lib.getAuthorNames()[i] +","+ lib.getBooks()[i] + "," + lib.getPublisherNameBooks()[i] + ","+ lib.getGenresBooks()[i]  + "," + lib.getArrayofDurations()[i]+"," + lib.Availabilities()[i]+"\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }finally {
            myWriter.close();
        }

    }

    public static String getDataFromWeb() throws IOException {
        BufferedReader br = null;

        try {
            String theURL = "https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();
            StringBuilder k = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }
            char[] c = new char[sb.length()-12];

            for(int i = 0; i<c.length; i++){
                c[i] = sb.charAt(i);
            }
            for(int i = 0; i<c.length; i++){
                k.append(c[i]);
            }

            String Value = String.valueOf(k);
            Value = Value + "" +
                    "made by Mohammad Ahsan Kalam";
            return (Value);

        }
        catch(Exception e1){

        }finally {

            if (br != null) {
                br.close();
            }
        }
        return null;
    }


    public static void WritePatrons(LinkedList<Patrons> p) throws IOException, EmptyArrayException {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter("Data/Patrons.txt");


            for (Patrons Pat:p) {
                String Sep = "";
                for(int i = 0; i< Pat.getBooks().getBooks().length; i++){

                        Sep = Sep + Pat.getBooks().getBooks()[i] + "/";



                }
                myWriter.write( Pat.getName() + "," +Pat.getPosition()+","+ Sep+ ","+Pat.getNumOfBooksOnHand()+ ","+ Pat.getEmail()+ ","+ Pat.getNumOfPreviouslyBorrowed()+ ","+ Pat.getMembershipStatus()+"\n");
                myWriter.flush();
            }

            System.out.println("Successfully wrote to patron file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }finally {
            myWriter.close();
        }


    }

}

