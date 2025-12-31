package december_2025;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            nextVal = iterator.next();
        }
    }

    // zwraca następny element bez przesuwania iteratora
    public Integer peek() {
        return nextVal;
    }

    @Override
    public Integer next() {
        Integer res = nextVal;
        if (iterator.hasNext()) {
            nextVal = iterator.next();
        } else {
            nextVal = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}
