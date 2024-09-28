package august_2024;

import udemy.stackandqueue.Queue;

import java.lang.reflect.Array;

public class CircularQueueV2<T> {
    // special empty value for the head of the queue to flag when there are no elements in a queue
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;
    private T[] elements;

    // the head is initialized to a special value which indicate that the queue is empty
    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueueV2(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        // this is the first element enqueued, set the head index to the tail index
        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        T data = elements[headIndex];
        // this was the last element in the queue
        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        // when the queue is full this means that the head index and tail index are right next to one another
        int nextIndex = (tailIndex + 1) % elements.length;
        return nextIndex == headIndex;
    }

    public static class QueueOverflowException extends Exception {}

    public static class QueueUnderflowException extends Exception {}

}
