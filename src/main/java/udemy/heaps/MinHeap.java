package udemy.heaps;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public MinHeap(Class<T> clazz) {
        super(clazz);
    }

    public MinHeap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    public void insert(T value) throws HeapFullException {
        if (count >= array.length) {
            throw new HeapFullException();
        }

        array[count] = value;
        siftUp(count);

        count++;
    }

    public T removeHighestPriority() throws HeapEmptyException {
        T min = getHighestPriority();

        array[0] = array[count - 1];
        count--;
        siftDown(0);

        return min;
    }

    @Override
    protected void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        // find the minimum of the left and right child elements
        int smallerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ?
                    leftIndex : rightIndex;
        } else if (leftIndex != -1) {
            smallerIndex = leftIndex;
        } else if (rightIndex != -1) {
            smallerIndex = rightIndex;
        }

        // if the left and right child do not exist stop shifting down
        if (smallerIndex == -1) {
            return;
        }

        // compare the smaller child with the current index to see if a swap
        // and further shift down is needed
        if (getElementAtIndex(smallerIndex).compareTo(getElementAtIndex(index)) < 0) {
            swap(smallerIndex, index);
            siftDown(smallerIndex);
        }
    }

    @Override
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0) {
            swap(parentIndex, index);

            siftUp(parentIndex);
        }
    }

    @Override
    public void printHeapArray() {
        for (T element : array) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }
}
