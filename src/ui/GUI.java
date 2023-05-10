package ui;


import model.Exceptions.EmptyArrayException;
import model.Librarian;
import model.Library;
import model.Patrons;

import java.awt.EventQueue;


import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import static java.util.Collections.replaceAll;


public class GUI {

        private JFrame frame;
        private JTextField text_Book;
        private JTextField text_Author;
        private JTextField text_Publisher;
        private JTextField textField;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        GUI window = null;
                        try {
                            window = new GUI();
                        } catch (EmptyArrayException e) {
                            throw new RuntimeException(e);
                        }
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the application.
         */
        public GUI() throws IOException, EmptyArrayException {
            initialize();
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() throws IOException, EmptyArrayException {
            final String[] Chosen = {""};
            LinkedList LibrariansLinkedList = new LinkedList<>();
            Library Mainlib = Input.readFullLibrary();
            Library libOfLibr = new Library();

            for(int i = 0; i < Mainlib.getLinkedList().size();i++){
                System.out.println(Mainlib.getBooks()[i] + " " + Mainlib.Availabilities()[i]);
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

            //All Labels/Variables and Panels declared and Initialized

            frame = new JFrame();
            frame.setBounds(100, 100, 700, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            String[] LitTypes = {"Book","Audio Book"};
            String[] TF = {"True","False"};
            String[] Types = {"Horror","Action","Adventure","Comedy","Crime and Mystery","Fantasy","Historic","Sci-fi","Romance","Science fiction","Thriller"};

            JPanel Card = new JPanel();
            Card.setBounds(0, 0, 700, 472);
            frame.getContentPane().add(Card);
            Card.setLayout(new CardLayout(0, 0));

            JPanel MainMenu = new JPanel();
            MainMenu.setBackground(new Color(0, 250, 154));
            Card.add(MainMenu, "name_861501863852625");
            MainMenu.setLayout(null);

            JLabel WelcomeLabel = new JLabel(Input.getDataFromWeb());
            WelcomeLabel.setVerticalAlignment(SwingConstants.TOP);
            WelcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
            WelcomeLabel.setBounds(33, 200, 647, 158);
            MainMenu.add(WelcomeLabel);

            JButton btnProceedtoMain = new JButton("Proceed to Options Page");

            btnProceedtoMain.setBounds(184, 250, 340, 43);
            MainMenu.add(btnProceedtoMain);

            JPanel MainOptions = new JPanel();
            MainOptions.setBackground(new Color(0, 250, 154));
            Card.add(MainOptions, "name_861501890974458");
            MainOptions.setLayout(null);

            JLabel GeneralViewing = new JLabel("General Viewing page");
            GeneralViewing.setForeground(Color.MAGENTA);
            GeneralViewing.setBackground(Color.YELLOW);
            GeneralViewing.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            GeneralViewing.setBounds(22, 64, 263, 39);
            MainOptions.add(GeneralViewing);

            JLabel lblLibrarianView = new JLabel("Librarian view");
            lblLibrarianView.setForeground(Color.MAGENTA);
            lblLibrarianView.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblLibrarianView.setBounds(22, 191, 263, 39);
            MainOptions.add(lblLibrarianView);

            JLabel lblPatronView = new JLabel("Patron View");
            lblPatronView.setForeground(Color.MAGENTA);
            lblPatronView.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblPatronView.setBounds(22, 354, 263, 39);
            MainOptions.add(lblPatronView);

            JLabel lblNewLabel = new JLabel("------------->");
            lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel.setBounds(275, 68, 263, 25);
            MainOptions.add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("-------------------->");
            lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_1.setBounds(182, 196, 356, 25);
            MainOptions.add(lblNewLabel_1);

            JLabel lblNewLabel_1_1 = new JLabel("-------------------->");
            lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_1_1.setBounds(166, 359, 356, 25);
            MainOptions.add(lblNewLabel_1_1);

            JButton GotoGeneral = new JButton("Proceed to General Viewing");


            GotoGeneral.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            GotoGeneral.setForeground(Color.MAGENTA);
            GotoGeneral.setBackground(Color.CYAN);
            GotoGeneral.setBounds(481, 51, 213, 70);
            MainOptions.add(GotoGeneral);

            JButton GotoLibrarian = new JButton("Proceed Librarian Viewing");

            GotoLibrarian.setForeground(Color.MAGENTA);
            GotoLibrarian.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            GotoLibrarian.setBackground(Color.CYAN);
            GotoLibrarian.setBounds(481, 175, 213, 70);
            MainOptions.add(GotoLibrarian);

            JButton GotoPatron = new JButton("Proceed to Patron Viewing");

            GotoPatron.setForeground(Color.MAGENTA);
            GotoPatron.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            GotoPatron.setBackground(Color.CYAN);
            GotoPatron.setBounds(481, 339, 213, 70);
            MainOptions.add(GotoPatron);

            JButton ReturntoMainMenu = new JButton("Back");

            ReturntoMainMenu.setBounds(6, 6, 117, 29);
            MainOptions.add(ReturntoMainMenu);

            JPanel GeneralOptions = new JPanel();
            GeneralOptions.setBackground(new Color(0, 250, 154));
            Card.add(GeneralOptions, "name_863392042771667");
            GeneralOptions.setLayout(null);

            JLabel lblViewListBy = new JLabel("View list by Author/Genre");
            lblViewListBy.setForeground(Color.MAGENTA);
            lblViewListBy.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblViewListBy.setBackground(Color.YELLOW);
            lblViewListBy.setBounds(6, 219, 292, 39);
            GeneralOptions.add(lblViewListBy);

            JLabel lblNewLabel_2 = new JLabel("------------->");
            lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2.setBounds(296, 224, 236, 25);
            GeneralOptions.add(lblNewLabel_2);

            JButton btnProceedToAuthorviewing = new JButton("Proceed to AuthorViewing");

            btnProceedToAuthorviewing.setForeground(Color.MAGENTA);
            btnProceedToAuthorviewing.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToAuthorviewing.setBackground(Color.CYAN);
            btnProceedToAuthorviewing.setBounds(497, 206, 197, 70);
            GeneralOptions.add(btnProceedToAuthorviewing);

            JButton btnNewButton_2_7 = new JButton("Back");

            btnNewButton_2_7.setBounds(6, 6, 117, 29);
            GeneralOptions.add(btnNewButton_2_7);

            JPanel GeneralViewingAuthorGenre = new JPanel();
            GeneralViewingAuthorGenre.setBackground(new Color(0, 250, 154));
            Card.add(GeneralViewingAuthorGenre, "name_861501890974458");
            GeneralViewingAuthorGenre.setLayout(null);

            JButton AuthorBtn = new JButton("Click for Author");
            AuthorBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            AuthorBtn.setBounds(6, 76, 193, 67);
            GeneralViewingAuthorGenre.add(AuthorBtn);

            JTextArea lblNewLabel_3 = new JTextArea();
            lblNewLabel_3.setEditable(false);
            lblNewLabel_3.setBounds(211, 7, 483, 460);
            lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            GeneralViewingAuthorGenre.add(lblNewLabel_3);

            JButton GenreViewBtn = new JButton("Click for Genre");
            GenreViewBtn.setBounds(6, 274, 193, 67);
            GeneralViewingAuthorGenre.add(GenreViewBtn);

            JButton btnNewButton_2_5 = new JButton("Back");

            btnNewButton_2_5.setBounds(6, 7, 117, 29);
            GeneralViewingAuthorGenre.add(btnNewButton_2_5);

            JPanel LibrarianViewAuthor = new JPanel();
            LibrarianViewAuthor.setBackground(new Color(0, 250, 154));
            Card.add(LibrarianViewAuthor, "name_861501890974458");
            LibrarianViewAuthor.setLayout(null);

            JComboBox CBAuthor = new JComboBox(Mainlib.getAuthorNames());
            CBAuthor.setBounds(28, 117, 150, 27);
            LibrarianViewAuthor.add(CBAuthor);

            JButton EnterBtnLibrarian = new JButton("Enter");
            EnterBtnLibrarian.setBounds(28, 194, 150, 29);
            LibrarianViewAuthor.add(EnterBtnLibrarian);

            JTextArea ViewBooksbyAuthor = new JTextArea();
            ViewBooksbyAuthor.setEditable(false);
            ViewBooksbyAuthor.setBounds(207, 6, 487, 460);
            ViewBooksbyAuthor.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
            LibrarianViewAuthor.add(ViewBooksbyAuthor);

            JButton btnNewButton_2_4 = new JButton("Back");

            btnNewButton_2_4.setBounds(6, 6, 117, 29);
            LibrarianViewAuthor.add(btnNewButton_2_4);

            JPanel LibrarianAdd = new JPanel();
            LibrarianAdd.setBackground(new Color(0, 250, 154));
            Card.add(LibrarianAdd, "name_861501890974458");
            LibrarianAdd.setLayout(null);

            JLabel lblNewLabel_4 = new JLabel("Name of Book");
            lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4.setBounds(22, 104, 161, 26);
            LibrarianAdd.add(lblNewLabel_4);

            text_Book = new JTextField();
            text_Book.setBounds(22, 142, 161, 34);
            LibrarianAdd.add(text_Book);
            text_Book.setColumns(10);

            JComboBox CBBook = new JComboBox(LitTypes);
            CBBook.setBounds(175, 45, 161, 40);
            LibrarianAdd.add(CBBook);

            JButton AddNewBook = new JButton("Add new Book");
            AddNewBook.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
            AddNewBook.setBounds(446, 420, 172, 29);
            LibrarianAdd.add(AddNewBook);

            JButton btnNewButton_1 = new JButton("Select type of Book");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            btnNewButton_1.setBounds(348, 45, 182, 41);
            LibrarianAdd.add(btnNewButton_1);

            JLabel lblNewLabel_4_1 = new JLabel("Name of Author");
            lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4_1.setBounds(22, 220, 161, 26);
            LibrarianAdd.add(lblNewLabel_4_1);

            text_Author = new JTextField();
            text_Author.setColumns(10);
            text_Author.setBounds(22, 252, 161, 34);
            LibrarianAdd.add(text_Author);

            JLabel lblNewLabel_4_2 = new JLabel("Name of the Publisher");
            lblNewLabel_4_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4_2.setBounds(22, 320, 226, 26);
            LibrarianAdd.add(lblNewLabel_4_2);

            text_Publisher = new JTextField();
            text_Publisher.setColumns(10);
            text_Publisher.setBounds(22, 358, 207, 34);
            LibrarianAdd.add(text_Publisher);

            JLabel lblNewLabel_4_3 = new JLabel("Genre");
            lblNewLabel_4_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4_3.setBounds(22, 428, 130, 23);
            LibrarianAdd.add(lblNewLabel_4_3);

            JComboBox CBGenre = new JComboBox(Types);
            CBGenre.setBounds(96, 420, 152, 46);
            LibrarianAdd.add(CBGenre);

            JLabel lblNewLabel_4_4 = new JLabel("Number of Pages");
            lblNewLabel_4_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4_4.setBounds(420, 104, 198, 26);
            LibrarianAdd.add(lblNewLabel_4_4);

            textField = new JTextField();
            textField.setColumns(10);
            textField.setBounds(420, 142, 198, 34);
            LibrarianAdd.add(textField);

            JLabel lblNewLabel_4_5 = new JLabel("Picture(True/False)");
            lblNewLabel_4_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4_5.setBounds(420, 220, 198, 26);
            LibrarianAdd.add(lblNewLabel_4_5);

            JLabel lblNewLabel_4_6 = new JLabel("HardCover(True/False)");
            lblNewLabel_4_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_4_6.setBounds(420, 320, 219, 26);
            LibrarianAdd.add(lblNewLabel_4_6);

            JComboBox CBGenre_1 = new JComboBox(TF);
            CBGenre_1.setBounds(420, 247, 198, 46);
            LibrarianAdd.add(CBGenre_1);

            JComboBox CBGenre_2 = new JComboBox(TF);
            CBGenre_2.setBounds(411, 353, 207, 46);
            LibrarianAdd.add(CBGenre_2);

            JLabel lblNewLabel_5_1 = new JLabel("Add a Book to the Librarians Collection of Books");
            lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_5_1.setBounds(134, 6, 560, 25);
            LibrarianAdd.add(lblNewLabel_5_1);

            JButton btnNewButton_2_3 = new JButton("Back");

            btnNewButton_2_3.setBounds(5, 8, 117, 29);
            LibrarianAdd.add(btnNewButton_2_3);

            JPanel LibrarianRemove = new JPanel();
            LibrarianRemove.setBackground(new Color(0, 250, 154));
            Card.add(LibrarianRemove, "name_861501890974458");
            LibrarianRemove.setLayout(null);

            JButton RemoveBtn = new JButton("Enter");
            RemoveBtn.setBounds(226, 290, 210, 29);
            LibrarianRemove.add(RemoveBtn);

            JComboBox CBRemove = new JComboBox(Mainlib.getBooks());
            CBRemove.setBounds(226, 152, 210, 85);
            LibrarianRemove.add(CBRemove);

            JLabel lblNewLabel_5 = new JLabel("Remove a Book from the Librarians Collection of Books");
            lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_5.setBounds(134, 6, 560, 25);
            LibrarianRemove.add(lblNewLabel_5);

            JButton btnNewButton_2 = new JButton("Back");

            btnNewButton_2.setBounds(6, 8, 117, 29);
            LibrarianRemove.add(btnNewButton_2);


            JPanel LibrarianCost = new JPanel();
            LibrarianCost.setBackground(new Color(0, 250, 154));
            Card.add(LibrarianCost, "name_861501890974458");
            LibrarianCost.setLayout(null);

            JButton btnCost = new JButton("Get Cost of all Books");

            btnCost.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            btnCost.setBounds(181, 195, 318, 130);
            LibrarianCost.add(btnCost);

            JLabel lblNewLabel_5_2 = new JLabel("Get Cost of all books");
            lblNewLabel_5_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_5_2.setBounds(135, 10, 560, 25);
            LibrarianCost.add(lblNewLabel_5_2);

            JButton btnNewButton_2_1 = new JButton("Back");

            btnNewButton_2_1.setBounds(6, 6, 117, 29);
            LibrarianCost.add(btnNewButton_2_1);

            JPanel PatronBorrow = new JPanel();
            PatronBorrow.setBackground(new Color(0, 250, 154));
            Card.add(PatronBorrow, "name_861501890974458");
            PatronBorrow.setLayout(null);

            JButton PatronBorrowbtn = new JButton("Enter");
            PatronBorrowbtn.setBounds(236, 321, 210, 29);
            PatronBorrow.add(PatronBorrowbtn);

            JLabel lblNewLabel_5_3 = new JLabel("Borrow a Book from the Librarians Collection of Books");
            lblNewLabel_5_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            lblNewLabel_5_3.setBounds(134, 6, 560, 25);
            PatronBorrow.add(lblNewLabel_5_3);

            JComboBox CBRemove_1 = new JComboBox(librarian1.getBooks().getBooks());
            CBRemove_1.setBounds(236, 183, 210, 85);
            PatronBorrow.add(CBRemove_1);

            JButton btnNewButton_2_2 = new JButton("Back");

            btnNewButton_2_2.setBounds(6, 8, 117, 29);
            PatronBorrow.add(btnNewButton_2_2);

            JPanel PatronReturn = new JPanel();
            PatronReturn.setBackground(new Color(0, 250, 154));
            Card.add(PatronReturn, "name_861501890974458");
            PatronReturn.setLayout(null);

            JButton PatronReturnBtn = new JButton("Enter");
            PatronReturnBtn.setBounds(235, 274, 210, 29);
            PatronReturn.add(PatronReturnBtn);

            JLabel PatronReturnLbl = new JLabel("Return a Book from the Librarians Collection of Books");
            PatronReturnLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
            PatronReturnLbl.setBounds(135, 10, 560, 25);
            PatronReturn.add(PatronReturnLbl);

            JComboBox CBPatronReturn = new JComboBox(Bob.getBooks().getBooks());
            CBPatronReturn.setBounds(215, 177, 246, 85);
            PatronReturn.add(CBPatronReturn);

            JButton btnNewButton_2_8 = new JButton("Back");

            btnNewButton_2_8.setBounds(6, 6, 117, 29);
            PatronReturn.add(btnNewButton_2_8);

            JPanel PatronView = new JPanel();
            PatronView.setBackground(new Color(0, 250, 154));
            Card.add(PatronView, "name_868021992294291");
            PatronView.setLayout(null);

            JLabel lblReturnBookaudiobook = new JLabel("Return Book/AudioBook");
            lblReturnBookaudiobook.setForeground(Color.MAGENTA);
            lblReturnBookaudiobook.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblReturnBookaudiobook.setBackground(Color.YELLOW);
            lblReturnBookaudiobook.setBounds(12, 125, 292, 39);
            PatronView.add(lblReturnBookaudiobook);

            JLabel lblNewLabel_2_1 = new JLabel("------------->");
            lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2_1.setBounds(302, 130, 236, 25);
            PatronView.add(lblNewLabel_2_1);

            JButton btnProceedToReturning = new JButton("Proceed to Returning");

            btnProceedToReturning.setForeground(Color.MAGENTA);
            btnProceedToReturning.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToReturning.setBackground(Color.CYAN);
            btnProceedToReturning.setBounds(503, 112, 197, 70);
            PatronView.add(btnProceedToReturning);

            JLabel lblBorrowBookaudiobook = new JLabel("Borrow Book/AudioBook");
            lblBorrowBookaudiobook.setForeground(Color.MAGENTA);
            lblBorrowBookaudiobook.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblBorrowBookaudiobook.setBackground(Color.YELLOW);
            lblBorrowBookaudiobook.setBounds(6, 284, 292, 39);
            PatronView.add(lblBorrowBookaudiobook);

            JLabel lblNewLabel_2_2 = new JLabel("------------->");
            lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2_2.setBounds(296, 289, 236, 25);
            PatronView.add(lblNewLabel_2_2);

            JButton btnProceedToBorrowing = new JButton("Proceed to Borrowing");

            btnProceedToBorrowing.setForeground(Color.MAGENTA);
            btnProceedToBorrowing.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToBorrowing.setBackground(Color.CYAN);
            btnProceedToBorrowing.setBounds(497, 271, 197, 70);
            PatronView.add(btnProceedToBorrowing);

            JButton btnNewButton_2_8_1 = new JButton("Back");

            btnNewButton_2_8_1.setBounds(6, 6, 117, 29);
            PatronView.add(btnNewButton_2_8_1);

            JPanel LibrarianViews = new JPanel();
            LibrarianViews.setBackground(new Color(0, 250, 154));
            LibrarianViews.setLayout(null);
            Card.add(LibrarianViews, "name_868839974500750");

            JLabel ViewAuthor = new JLabel("View Author Books");
            ViewAuthor.setForeground(Color.MAGENTA);
            ViewAuthor.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            ViewAuthor.setBackground(Color.YELLOW);
            ViewAuthor.setBounds(6, 68, 292, 39);
            LibrarianViews.add(ViewAuthor);

            JLabel lblNewLabel_2_1_1 = new JLabel("------------->");
            lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2_1_1.setBounds(296, 72, 236, 25);
            LibrarianViews.add(lblNewLabel_2_1_1);

            JButton btnProceedToReturning_1 = new JButton("Proceed to viewing");

            btnProceedToReturning_1.setForeground(Color.MAGENTA);
            btnProceedToReturning_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToReturning_1.setBackground(Color.CYAN);
            btnProceedToReturning_1.setBounds(497, 54, 197, 70);
            LibrarianViews.add(btnProceedToReturning_1);

            JLabel lblBorrowBookaudiobook_1 = new JLabel("Remove Book from Librarian");
            lblBorrowBookaudiobook_1.setForeground(Color.MAGENTA);
            lblBorrowBookaudiobook_1.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 20));
            lblBorrowBookaudiobook_1.setBackground(Color.YELLOW);
            lblBorrowBookaudiobook_1.setBounds(6, 258, 292, 39);
            LibrarianViews.add(lblBorrowBookaudiobook_1);

            JLabel lblNewLabel_2_2_1 = new JLabel("------------->");
            lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2_2_1.setBounds(296, 263, 236, 25);
            LibrarianViews.add(lblNewLabel_2_2_1);

            JButton btnProceedToBorrowing_1 = new JButton("Proceed to Removing");

            btnProceedToBorrowing_1.setForeground(Color.MAGENTA);
            btnProceedToBorrowing_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToBorrowing_1.setBackground(Color.CYAN);
            btnProceedToBorrowing_1.setBounds(497, 245, 197, 70);
            LibrarianViews.add(btnProceedToBorrowing_1);

            JButton btnNewButton_2_8_1_1 = new JButton("Back");

            btnNewButton_2_8_1_1.setBounds(6, 6, 117, 29);
            LibrarianViews.add(btnNewButton_2_8_1_1);

            JLabel lblReturnBookaudiobook_1_1 = new JLabel("Add Book");
            lblReturnBookaudiobook_1_1.setForeground(Color.MAGENTA);
            lblReturnBookaudiobook_1_1.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblReturnBookaudiobook_1_1.setBackground(Color.YELLOW);
            lblReturnBookaudiobook_1_1.setBounds(6, 167, 292, 39);
            LibrarianViews.add(lblReturnBookaudiobook_1_1);

            JLabel lblNewLabel_2_1_1_1 = new JLabel("------------->");
            lblNewLabel_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2_1_1_1.setBounds(283, 172, 236, 25);
            LibrarianViews.add(lblNewLabel_2_1_1_1);

            JButton btnProceedToReturning_1_1 = new JButton("Proceed to Adding");

            btnProceedToReturning_1_1.setForeground(Color.MAGENTA);
            btnProceedToReturning_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToReturning_1_1.setBackground(Color.CYAN);
            btnProceedToReturning_1_1.setBounds(497, 154, 197, 70);
            LibrarianViews.add(btnProceedToReturning_1_1);

            JLabel lblReturnBookaudiobook_1_2 = new JLabel("Get the cost of all books");
            lblReturnBookaudiobook_1_2.setForeground(Color.MAGENTA);
            lblReturnBookaudiobook_1_2.setFont(new Font("Kohinoor Gujarati", Font.PLAIN, 25));
            lblReturnBookaudiobook_1_2.setBackground(Color.YELLOW);
            lblReturnBookaudiobook_1_2.setBounds(6, 378, 292, 39);
            LibrarianViews.add(lblReturnBookaudiobook_1_2);

            JLabel lblNewLabel_2_1_1_2 = new JLabel("------------->");
            lblNewLabel_2_1_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
            lblNewLabel_2_1_1_2.setBounds(296, 383, 236, 25);
            LibrarianViews.add(lblNewLabel_2_1_1_2);

            JButton btnProceedToReturning_1_2 = new JButton("Proceed to Cost");

            btnProceedToReturning_1_2.setForeground(Color.MAGENTA);
            btnProceedToReturning_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
            btnProceedToReturning_1_2.setBackground(Color.CYAN);
            btnProceedToReturning_1_2.setBounds(497, 365, 197, 70);
            LibrarianViews.add(btnProceedToReturning_1_2);


           /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to MainOption Page
            */
            btnNewButton_2_7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(true);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(false);

                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to MainMenu Page
            */
            ReturntoMainMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(true);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });
 /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to MainOption Page
            */
            btnProceedtoMain.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(true);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });
 /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to GeneralViewingAuthorGenre Page
            */
            btnProceedToAuthorviewing.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(true);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });

             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to GeneralOptions Page
            */
            GotoGeneral.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(true);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianViews Page
            */
            GotoLibrarian.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(true);
                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to GeneralOptions Page
            */
            btnNewButton_2_5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(true);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });

             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to PatronReturn Page and updates contents of ComboBox CBPatronReturn
            */
            btnProceedToReturning.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(true);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);
                    try {
                        CBPatronReturn.setModel(new JComboBox<>(Bob.getBooks().getBooks()).getModel());
                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to PatronBorrow Page and updates contents of CBRemove_1
            */
            btnProceedToBorrowing.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(true);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);

                    try {
                        System.out.println(librarian1.getBooks().getBookNames());
                        CBRemove_1.setModel(new JComboBox<>(librarian1.getBooks().getBooks()).getModel());
                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to PatronView Page
            */
            btnNewButton_2_8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(true);
                    LibrarianViews.setVisible(false);
                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to PatronView Page
            */
            btnNewButton_2_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(true);
                    LibrarianViews.setVisible(false);
                }
            });

             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianCost Page
            */
            btnProceedToReturning_1_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(true);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(true);
                    LibrarianViews.setVisible(false);
                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianRemove Page
            */
            btnProceedToBorrowing_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(true);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);


                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianAdd Page
            */
            btnProceedToReturning_1_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(true);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);



                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianViewAuthor Page
            */
            btnProceedToReturning_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(true);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });
             /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianView Page
            */
            btnNewButton_2_3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(true);
                }
            });
            /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianView Page
            */
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(true);
                }
            });
            /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianView Page
            */
            btnNewButton_2_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(true);
                }
            });
            /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to LibrarianView Page
            */
            btnNewButton_2_4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(true);
                }
            });
            /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to MainOptions Page
            */
            btnNewButton_2_8_1_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(true);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });
            /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to PatronView Page
            */
            GotoPatron.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(false);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(true);
                    LibrarianViews.setVisible(false);
                }
            });
            /*
           REQUIRES : GUI Panels to be enabled.
           EFFECTS : Changes to MainOptions Page
            */
            btnNewButton_2_8_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MainOptions.setVisible(true);
                    GeneralOptions.setVisible(false);
                    MainMenu.setVisible(false);
                    GeneralViewingAuthorGenre.setVisible(false);
                    LibrarianViewAuthor.setVisible(false);
                    LibrarianAdd.setVisible(false);
                    LibrarianRemove.setVisible(false);
                    LibrarianCost.setVisible(false);
                    PatronBorrow.setVisible(false);
                    PatronReturn.setVisible(false);
                    PatronView.setVisible(false);
                    LibrarianViews.setVisible(false);
                }
            });
  /*
           REQUIRES : Authorbtn to be enabled
           MODIFIES:Contents of lblNewLabel_3
           EFFECTS: Displays list of all books and the author who wrote them.
            */

            AuthorBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String Value = "";
                    try {
                    for(int i = 0; i < Mainlib.getBooks().length; i++){

                      Value = Value + ("Book Name: "+ Mainlib.getBooks()[i] + " written by: "+ Mainlib.getAuthorNames()[i] + "\n\n") ;}
                        } catch (EmptyArrayException ex) {
                            throw new RuntimeException(ex);
                        }

                    lblNewLabel_3.setText(Value);

                }
            });

              /*
           REQUIRES :GenreViewBtn to be enabled and vsible.
           MODIFIES:Contents of lblNewLabel_3
           EFFECTS: Displays list of all books and the types.

            */
            GenreViewBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String Value = "";
                    Mainlib.HashmapsInsertions();
                    HashMap<String, ArrayList> HM = Mainlib.getAllGenres();
                    String[] Types = {"Horror","Action","Adventure","Comedy","Crime and Mystery","Fantasy","Historic","Sci-fi","Romance","Science fiction","Thriller"};

                    for(int i = 0; i < Types.length; i++){
                        ArrayList m = HM.get(Types[i]);
                        if(m.isEmpty()){
                        }
                        else{
                            Value = Value +(Types[i] + " --> " + (Arrays.toString(m.toArray())).replaceAll("\\[|\\]", "")+ "\n\n");
                        }
                    }

                    lblNewLabel_3.setText(Value);
                }
            });
  /*
           REQUIRES :EnterBtnLibrarian to be enabled and visible.
           MODIFIES:Contents of ViewBooksbyAuthor
           EFFECTS: Displays books written by specific author.

            */
            EnterBtnLibrarian.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String val = (String) CBAuthor.getSelectedItem();

                    if(val.charAt(0) == ' '){
                        val = val.substring(1);
                    }
                    //val = val.replaceAll("\\s", "");
                    ViewBooksbyAuthor.setText(Mainlib.returnBookTitle(val));

                }
            });

            /*
           REQUIRES :LibrairanAdd Panel to be enabled.
           MODIFIES:visibility of labels and textfields on the screen
           EFFECTS: depending on which option is selected some questions are hidden from the user as they are not required.

            */
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   if(CBBook.getSelectedItem().equals(LitTypes[0])){
                       Chosen[0] = LitTypes[0].toString();
                       lblNewLabel_4_4.setText("Number of Pages");
                       lblNewLabel_4_5.setVisible(true);
                       CBGenre_1.setVisible(true);
                       CBGenre_2.setVisible(true);
                       lblNewLabel_4_6.setVisible(true);

                   }
                   else{
                       lblNewLabel_4_4.setText("Duration of Audio");
                       lblNewLabel_4_5.setVisible(false);
                       CBGenre_1.setVisible(false);
                       CBGenre_2.setVisible(false);
                       lblNewLabel_4_6.setVisible(false);
                   }
                }
            });

            /*
           REQUIRES :LibrarianAdd to be enabled and visible.
           MODIFIES:Librarian Object as well as contents of Librbary.
           EFFECTS: Adds new book to Library.

            */
            AddNewBook.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    boolean Pictures = true;
                    boolean HardCover = true;
                    int num = 0;

if(!text_Book.getText().equals("") &&!text_Author.getText().equals("")&&!text_Publisher.getText().equals("")&& !textField.getText().equals("")){



                    String BookName = text_Book.getText();

                    String AuthorName = text_Author.getText();

                    String Publish = text_Publisher.getText();


                    String Genre = (String) CBGenre.getSelectedItem();



                        if(CBGenre_2.getSelectedItem().equals("True")){
                            HardCover = true;
                        }
                        else{
                            HardCover = false;
                        }

                        if(CBGenre_1.getSelectedItem().equals("True")){
                            Pictures = true;
                        }
                        else{
                            Pictures = false;
                        }


                        num = Integer.parseInt(textField.getText());



                    Mainlib.CreateNewBook(Chosen[0],AuthorName, BookName,num,Publish,Genre,Pictures,HardCover);
                    JFrame parent = new JFrame();

                    JOptionPane.showMessageDialog(parent, "New Book Added");}
else{
    JFrame parent = new JFrame();

    JOptionPane.showMessageDialog(parent, "Fill in all text boxes please");
}
                }
            });
/*
           REQUIRES :LibrairanRemove Panel to be enabled and visible.
           MODIFIES:Librarian Object as well as contents of Librbary.
           EFFECTS: Removes chosen book from Librarian .

            */
            RemoveBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Mainlib.removeBook((String) CBRemove.getSelectedItem());
                    try {
                        System.out.println(Mainlib.getBookNames());
                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        CBRemove.setModel(new JComboBox<>(Mainlib.getBooks()).getModel());
                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }

                    JFrame parent = new JFrame();

                    JOptionPane.showMessageDialog(parent, "Book Removed Successfully");
                }
            });
/*
           REQUIRES :LibrarianCost Panel to be enabled and visible.
           EFFECTS: Displays cost of all books in the Library in CAD in a pop-up view.

            */
            btnCost.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {double k = 0;
                    try {
                         k =  Mainlib.costOfBooks();
                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }
                    LibrarianCost.setVisible(true);
                    PatronView.setVisible(false);
                    JFrame parent = new JFrame();

                    JOptionPane.showMessageDialog(parent, "The Total cost is CAD " + k);
                }
            });

/*
           REQUIRES :PatronBorrow Panel to be enabled and visible.
           MODIFIES:Librarian Object as well as Patron Objects Personal Libraires.
           EFFECTS: moves one book from Librairan to Patron.

            */
            PatronBorrowbtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(CBRemove_1.getItemCount() == 0){
                            JFrame parent = new JFrame();

                            JOptionPane.showMessageDialog(parent, "No Book to be borrowed");
                        }else {
                            Bob.borrow(librarian1, (String) CBRemove_1.getSelectedItem());
                            CBRemove_1.setModel(new JComboBox<>(librarian1.getBooks().getBooks()).getModel());
                            JFrame parent = new JFrame();

                            JOptionPane.showMessageDialog(parent, "Book has been borrowed");
                        }

                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }

                }
            });

            /*
           REQUIRES :PatronBorrow Panel to be enabled and visible.
           MODIFIES:Librarian Object as well as Patron Objects Personal Libraires.
           EFFECTS: moves one book from Patron to Librarian.

            */
            PatronReturnBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(CBPatronReturn.getItemCount() == 0){
                            JFrame parent = new JFrame();

                            JOptionPane.showMessageDialog(parent, "No Book to be returned");
                        }
                        else{
                            Bob.returnBook(librarian1, (String) CBPatronReturn.getSelectedItem());
                            CBPatronReturn.setModel(new JComboBox<>(Bob.getBooks().getBooks()).getModel());
                            JFrame parent = new JFrame();

                            JOptionPane.showMessageDialog(parent, "Book has been returned");
                        }

                    } catch (EmptyArrayException ex) {
                        throw new RuntimeException(ex);
                    }


                }
            });
/*

           MODIFIES:Contents of Files.txt and Patron.txt
           EFFECTS: Closes the Program while saving the new data of the program.

            */
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    if (JOptionPane.showConfirmDialog(frame,
                            "Are you sure to close this window?", "Really Closing?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        try {
                            Input.WritePatrons(PatronsList);
                            Input.Write(Mainlib);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (EmptyArrayException e) {
                            throw new RuntimeException(e);
                        }

                        System.exit(0);
                    }
                }
            });




        }
    }


