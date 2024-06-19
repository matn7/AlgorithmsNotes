package may_2024;

import java.util.Stack;

public class Queue {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.dequeue()); // 2
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue()); // 3
        System.out.println(queue.peek()); // 4
        System.out.println(queue.isEmpty()); // false
        System.out.println();
    }

    Stack<Integer> forward = new Stack<>();
    Stack<Integer> reverse = new Stack<>();

    // O(n) time
    public int enqueue(int value) {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(value);
        return value;
    }

    // O(n) time
    public int dequeue() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return reverse.pop();
    }

    // O(n) time
    public int peek() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return reverse.peek();
    }

    // O(1) time
    public boolean isEmpty() {
        return forward.isEmpty() && reverse.isEmpty();
    }


}
