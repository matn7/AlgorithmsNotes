package december_2025;

import java.util.Iterator;

public class PeekingIterator2 implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer nextElem;

    public PeekingIterator2(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            nextElem = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElem;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int res = nextElem;
        if (this.iterator.hasNext()) {
            nextElem = iterator.next();
        } else {
            nextElem = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextElem != null;
    }
}
