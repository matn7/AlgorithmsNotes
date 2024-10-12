package udemy.heaps;

public class MaxHeap<T extends Comparable> extends Heap<T>  {

    public MaxHeap(Class<T> clazz) {
        super(clazz);
    }

    public MaxHeap(Class<T> clazz, int size) {
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
        T max = getHighestPriority();

        array[0] = array[count - 1];
        count--;
        siftDown(0);

        return max;
    }


    @Override
    protected void siftDown(int index) {
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        // find the minimum of the left and right child elements
        int largerIndex = -1;
        if (leftIndex != -1 && rightIndex != -1) {
            largerIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ?
                    rightIndex : leftIndex;
        } else if (leftIndex != -1) {
            largerIndex = leftIndex;
        } else if (rightIndex != -1) {
            largerIndex = rightIndex;
        }

        // if the left and right child do not exist stop shifting down
        if (largerIndex == -1) {
            return;
        }

        // compare the smaller child with the current index to see if a swap
        // and further shift down is needed
        if (getElementAtIndex(largerIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(largerIndex, index);
            siftDown(largerIndex);
        }
    }

    @Override
    protected void siftUp(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) > 0) {
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
