package model;

import model.Exceptions.EmptyArrayException;

import java.util.LinkedList;

public class Patrons extends People implements MasterObserver  {

    int booksCurrentlyBorrowed;
    String MembershipStatus;
    Librarian LibrarianOne;

    public Patrons(String Name, String Position, Library B, int num, String Email, int NumOfPreviouslyBorrowed, String MembershipStatus) {
        super(Name, Position, B, num, Email);
this.booksCurrentlyBorrowed = NumOfPreviouslyBorrowed;
this.MembershipStatus = MembershipStatus;

    }

    public int getNumOfPreviouslyBorrowed() {
        return booksCurrentlyBorrowed;
    }

    public String getMembershipStatus() {
        return MembershipStatus;
    }

    public void borrow(Librarian k, String NameFromUser ) throws EmptyArrayException {

        Library temp = k.getBooks();
        if(temp.getBookNames().contains(NameFromUser)){
          //  System.out.println((temp.ReturnSingleObject(NameFromUser)).getBookName());
            Literature o = (temp.ReturnSingleObject(NameFromUser));
            this.BooksOnHand.Items.add(o);
            k.BooksOnHand.Items.remove(o);
            update(o);
        }
        else{
            System.out.println("Book does not exist");
        }


    }
    public void returnBook(Librarian k,String NameFromUser) throws EmptyArrayException {
        Library temp = this.BooksOnHand;
        if(temp.getBookNames().contains(NameFromUser)){
            //System.out.println((temp.ReturnSingleObject(NameFromUser)).getBookName());
            Literature o = (temp.ReturnSingleObject(NameFromUser));
            this.BooksOnHand.Items.remove(o);
            k.BooksOnHand.Items.add(o);
            update(o);
        }
        else{
           // System.out.println("Book does not exist");
        }


    }

    @Override
    public void update(Literature a) throws EmptyArrayException {
      //  System.out.println(a.BookName + " " + a.isAvailability());
        a.setAvailability(!a.availability);
      //  System.out.println(a.BookName + " " + a.isAvailability());
//        notifyObservers(this.BooksOnHand,b);
    }

}
