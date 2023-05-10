package model;

import java.util.Scanner;

public class Book extends Literature implements Financial {
    Scanner k = new Scanner(System.in);

int NumberOfPages = -1;
    boolean Pictures;
    boolean isHardCover;


public Book(){
this.NumberOfPages = 0;
this.Pictures = true;
this.isHardCover = true;

}
public Book(String AuthorName, String BookName,Integer NumOfPage,String Publisher, String Genre,boolean HP,boolean HardCover,boolean availability){
    this.Author = AuthorName;
    this.BookName = BookName;
    this.NumberOfPages = NumOfPage;
    this.Publisher = Publisher;
    this.Genre = Genre;
    this.isHardCover = HardCover;
    this.Pictures = HP;
    this.availability = availability;
}


    public Integer getNumOfPages(){
        return this.NumberOfPages;
    }
    public void setNumberOfPages(Integer m){
        this.NumberOfPages = m;
    }
    public Boolean HasPictures(){
        return this.Pictures;
    }
    public void setPictures(boolean m){
        this.Pictures = m;
    }

    public Boolean hasHardCover(){
        return this.isHardCover;
    }
    public void setHardCover(boolean m){
        this.isHardCover = m;
    }




    @Override
    public double costOfBooks() {
        return (getNumOfPages()*0.25);
    }

    public String toString(){
        return (getAuthorName() +","+ getBookName() + ","+ getNumOfPages()+"," + getPublisher() + ","+ getGenre() +","+ HasPictures()+","+hasHardCover());

    }
}