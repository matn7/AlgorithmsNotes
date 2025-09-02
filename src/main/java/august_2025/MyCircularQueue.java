package august_2025;

public class MyCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println();
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println();
        System.out.println(myCircularQueue.Rear());
    }


    int k;
    int[] arr;
    int head = -1;
    int tail = -1;

    public MyCircularQueue(int k) {
        this.k = k;
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (head == -1 && tail == -1) {
            head = 0;
            tail = 0;
            arr[tail] = value;
        } else {
            int nextIdx = (tail + 1) % k;
            if (isFull()) {
                return false;
            }
            arr[nextIdx] = value;
            tail = nextIdx;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        int val = arr[head];
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        int nextIdx = (head + 1) % k;
        head = nextIdx;
        return true;

    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % k == head;
    }

}
