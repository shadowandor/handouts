package it.unimi.di.prog2.h15c;

import java.util.NoSuchElementException;

import it.unimi.di.prog2.h13.ArrayIntSet;

/**
 * A subtipe of {@link ArrayIntSet} able to return the maximum value
 */
public class MaxArraySet extends ArrayIntSet{

    private int bigger = 0;

    /**
     * 
     * AF :
     * 
     * -Same as IntSet
     * 
     * RI :
     * 
     * -bigger : if size() > 0, isIn(bigger) is true and for every x if isIn(x) -> bigger >= x
     * 
     */
    
    /**
     * Create an empty {@link MaxArrayIntSet}
     */
    public MaxArrayIntSet() {
        super();
        bigger = 0;
    }

    /**
     * Return the maximuim value of an IntSet
     * @return the maximum value of the IntSet
     * @throws NoSuchElementException if the IntSet is empty
     */
    public int Max() throws NoSuchElementException{
        if (size == 0) throw new NoSuchElementException("An empty Set has no maximum");
        return bigger;
    }

    @Override
    public void remove(int x) {
        if (isIn(x) && bigger == x) {
            super.remove(x);
            bigger = Integer.MIN_VALUE;
            for (int i=0; i<size; i++) if (bigger < els[i]) bigger = els[i];
        } else {
            super.remove(x);
        }
    }
}
