package model;

import model.Exceptions.EmptyArrayException;

import java.util.ArrayList;
import java.util.List;

public class SubjectInView {
        List<MasterObserver> observers = new ArrayList<>();

        public void addObserver(MasterObserver Ob){
            observers.add((MasterObserver) Ob);

        }
        public void removeObserver(MasterObserver ob){
            observers.remove(ob);
        }
        public void notifyObservers() throws EmptyArrayException {




        }


}
