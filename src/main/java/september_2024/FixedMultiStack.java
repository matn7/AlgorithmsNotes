package september_2024;

public class FixedMultiStack {

    private int numOfStacks = 3;
    private int capacity;
    int[] values;
    int[] sizes;

    public FixedMultiStack(int stackSize) {
        capacity = stackSize;
        values = new int[stackSize * numOfStacks];
        sizes = new int[numOfStacks];
    }

    public void push(int stackNum, int value) throws RuntimeException {
        if (isFull(stackNum)) {
            throw new RuntimeException("Stack is full");
        }

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException();
        }

        int topIdx = indexOfTop(stackNum);
        int value = values[topIdx];
        values[topIdx] = 0;
        sizes[stackNum]--;
        return value;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException("Stack in Empty");
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    public boolean isFull(int stackNum) {
        return sizes[stackNum] == capacity;
    }

    private int indexOfTop(int stackNum) {
        int offset = stackNum * capacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
