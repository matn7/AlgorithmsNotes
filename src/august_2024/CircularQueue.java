package august_2024;

public class CircularQueue {

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(5);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);

        System.out.println();
    }

    int size;
    int[] array;
    int headIndex = -1;
    int tailIndex = -1;

    public CircularQueue(int size) {
        this.size = size;
        array = new int[size];
    }

    // O(n) time |
    public int enqueue(int value) {
        if (headIndex == -1 && tailIndex == -1) {
            headIndex = 0;
            tailIndex = 0;
            array[tailIndex] = value;
        } else {
            int nextIndex = (1 + tailIndex) % size;
            if (isFull()) {
                throw new RuntimeException("Queue is Full");
            }
            array[nextIndex] = value;
            tailIndex = nextIndex;
        }
        return value;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        int value = array[headIndex];
        if (headIndex == tailIndex) {
            headIndex = -1;
            tailIndex = -1;
            return value;
        }
        int nextIndex = (1 + headIndex) % size;
        headIndex = nextIndex;
        return value;
    }

    public boolean isEmpty() {
        return headIndex == -1;
    }

    public boolean isFull() {
        return (tailIndex + 1) % size == headIndex;
    }

}
