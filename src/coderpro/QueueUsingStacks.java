package coderpro;


import java.util.Stack;

// O(n) time | O(n) space
public class QueueUsingStacks <T> {

    Stack<T> forward = new Stack<>();
    Stack<T> reverse = new Stack<>();

    public void enqueue(T value) {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(value);
    }

    public T dequeue() throws Exception {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return reverse.pop();
    }

    public T peek() {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        if (reverse.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return reverse.peek();
    }

}
