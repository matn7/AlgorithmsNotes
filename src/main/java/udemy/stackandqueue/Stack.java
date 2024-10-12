package udemy.stackandqueue;

public class Stack<T> {

    private static int MAX_SIZE = 40;

    private Element<T> top;
    private int size = 0;

    // O(1) time
    public void push(T data) throws StackOverflowException {
        if (size == MAX_SIZE) {
            throw new StackOverflowException();
        }

        Element element = new Element(data, top);
        top = element;
        size++;
    }

    // O(1) time
    public T pop() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException();
        }
        T data = top.getData();
        top = top.getNext();

        size--;

        return data;
    }

    public T peek() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException();
        }
        return top.getData();
    }

    // O(1) time
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1) time
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    // O(1) time
    public int getSize() {
        return size;
    }

    public static class Element<T> {
        private T data;
        private Element next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class StackOverflowException extends Exception {
    }

    public static class StackUnderflowException extends Exception {
    }
}
