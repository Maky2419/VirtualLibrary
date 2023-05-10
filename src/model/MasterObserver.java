package model;

import model.Exceptions.EmptyArrayException;

public interface MasterObserver {
        void update(Literature a) throws EmptyArrayException;

}
