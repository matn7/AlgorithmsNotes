package udemy.heaps;

import java.lang.reflect.Array;

// A generic heap can hold data of any type
// note that the generic type has o extend comparable - this is how we check for the highest priority
public abstract class Heap<T extends Comparable> {
    private static int MAX_SIZE = 40;
    protected T[] array;
    protected int count = 0;

    public Heap(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public Heap(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    public int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= count) {
            return -1;
        }

        return leftChildIndex;
    }

    public int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= count) {
            return -1;
        }

        return rightChildIndex;
    }

    public int getParentIndex(int index) {
        if (index < 0 || index > count) {
            return -1;
        }

        return (index - 1) / 2;
    }

    protected abstract void siftDown(int index);

    protected abstract void siftUp(int index);

    protected void swap(int index1, int index2) {
        T tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public T getElementAtIndex(int index) {
        return array[index];
    }

    public T getHighestPriority() throws HeapEmptyException {
        if (isEmpty()) {
            throw new HeapEmptyException();
        }
        return array[0];
    }

    public abstract void printHeapArray();

    public static class HeapFullException extends Exception {}

    public static class HeapEmptyException extends Exception {}
}
