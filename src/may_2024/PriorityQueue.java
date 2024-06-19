package may_2024;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PriorityQueue {

    private final List<Integer> queue;

    Comparator<Integer> comparator;

    public PriorityQueue(List<Integer> arr) {
        this(arr, (o1, o2) -> o1 - o2);
    }

    public PriorityQueue(List<Integer> arr, Comparator<Integer> comparator) {
        this.comparator = comparator;
        this.queue = arr;
        prepareQueue();
    }

    public int push(int value) {
        queue.add(value);
        siftUp(queue.size() - 1);
        return value;
    }

    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        int valueToRemove = queue.get(0);
        queue.set(0, queue.get(queue.size() - 1));
        siftDown(0);
        queue.remove(queue.size() - 1);
        return valueToRemove;
    }

    public int peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        return queue.get(0);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void printElements() {
        queue.forEach(num -> System.out.print(num + " "));
    }

    private void prepareQueue() {
        int parentIdx = getParentIdx(queue.size() - 1);
        for (int i = parentIdx; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftUp(int currentIdx) {
        int parentIdx = getParentIdx(currentIdx);

        while (queue.get(currentIdx) < queue.get(parentIdx)) {
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = getParentIdx(currentIdx);
        }
    }

    private void siftDown(int currentIdx) {
        int leftChildIdx = getLeftChildIdx(currentIdx);
        while (leftChildIdx < queue.size() - 1) {
            int rightChildIdx = getRightChildIdx(currentIdx);
            int idxToSwap;
            if (rightChildIdx > queue.size() - 1) {
                rightChildIdx = -1;
            }
            if (rightChildIdx != -1 && queue.get(rightChildIdx) < queue.get(leftChildIdx)) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }
            if (queue.get(idxToSwap) < queue.get(currentIdx)) {
                swap(idxToSwap, currentIdx);
                currentIdx = idxToSwap;
                leftChildIdx = getLeftChildIdx(currentIdx);
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = queue.get(i);
        queue.set(i, queue.get(j));
        queue.set(j, temp);
    }

    private int getLeftChildIdx(int idx) {
        return idx * 2 + 1;
    }

    private int getRightChildIdx(int idx) {
        return idx * 2 + 2;
    }

    private int getParentIdx(int idx) {
        return (idx - 1) / 2;
    }
}
