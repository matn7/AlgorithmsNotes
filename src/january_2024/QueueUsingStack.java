package january_2024;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> forward = new Stack<>();
    Stack<Integer> reverse = new Stack<>();

    public static void main(String[] args) {

        QueueUsingStack queue = new QueueUsingStack();
//        queue.enqueue(12);
//        queue.enqueue(123);
//        queue.enqueue(124);
//        queue.enqueue(125);
//
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        queue.enqueue(126);
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());

        System.out.println();
        queue.enqueue2(122);
        queue.enqueue2(123);
        queue.enqueue2(124);
        queue.enqueue2(125);
        System.out.println(queue.dequeue2());
        System.out.println(queue.dequeue2());
        queue.enqueue2(126);
        System.out.println(queue.dequeue2());
        System.out.println(queue.dequeue2());
        System.out.println(queue.dequeue2());
        System.out.println(queue.dequeue2());

    }

    // O(n) time | O(n) space
    public void enqueue(int value) {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(value);
    }

    // O(n) time | O(n) space
    public int dequeue() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return reverse.pop();
    }

    // O(n) time | O(1) space
    public int peek() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return reverse.pop();
    }


    // O(n) time | O(n) space
    public void enqueue2(int value) {
        forward.push(value);
    }

    // O(n) time | O(n) space
    public int dequeue2() {
        if (!reverse.isEmpty()) {
            return reverse.pop();
        }
        if (!forward.isEmpty()) {
            while (!forward.isEmpty()) {
                reverse.add(forward.pop());
            }
            return reverse.pop();
        }
        throw new RuntimeException("Queue is empty");
    }


}
