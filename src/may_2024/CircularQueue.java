package may_2024;

public class CircularQueue {

    int size;
    int[] array;

    public CircularQueue(int size) {
        this.size = size;
        this.array = new int[size];
    }

    int headIdx = -1;
    int tailIdx = -1;

    public int enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is Full!");
        }
        if (headIdx == -1) {
            headIdx = 0;
            tailIdx = 0;
            array[tailIdx] = value;
        } else {
            int nextIdx = (tailIdx + 1) % size;
            array[nextIdx] = value;
            tailIdx = nextIdx;
        }
        return value;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        int valueToRemove = array[headIdx];
        if (headIdx == tailIdx) {
            headIdx = -1;
            tailIdx = -1;
        } else {
            int nextIndex = (headIdx + 1) % size;
            headIdx = nextIndex;
        }
        return valueToRemove;
    }

    private boolean isEmpty() {
        return headIdx == -1;
    }

    private boolean isFull() {
        int nextIdx = (tailIdx + 1) % size;
        if (nextIdx == headIdx) {
            return true;
        }
        return false;
    }
}
