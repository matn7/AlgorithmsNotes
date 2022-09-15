package udemy.stackandqueue;

public class TwoStackQueueMy<T> {

    Stack<T> forward = new Stack<>();
    Stack<T> reverse = new Stack<>();

    public void enqueue(T data) throws Stack.StackOverflowException, Stack.StackUnderflowException {
        while (!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }
        forward.push(data);
    }

    public T dequeue() throws Stack.StackUnderflowException, Stack.StackOverflowException {
        while (!forward.isEmpty()) {
            reverse.push(forward.pop());
        }
        T topElement = reverse.pop();
        return topElement;
    }

}
