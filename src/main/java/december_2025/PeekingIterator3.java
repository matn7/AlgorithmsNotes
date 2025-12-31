package december_2025;

import java.util.Iterator;

public class PeekingIterator3 implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer nextElement;

    public PeekingIterator3(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            nextElement = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer val = nextElement;
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
        return val;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}