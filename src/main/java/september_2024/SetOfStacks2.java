package september_2024;

import java.util.ArrayList;

public class SetOfStacks2 {

    // Book
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;

    public SetOfStacks2(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    void push(int v) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(v);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    int pop() {
        Stack last = getLastStack();
        if (last == null) {
            throw new RuntimeException("Empty Stack");
        }
        int v = last.pop();
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public boolean isEmpty() {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removed_item;
        if (removeTop) {
            removed_item = stack.pop();
        } else {
            removed_item = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }

    class Stack {
        private int capacity;
        public Node top;
        public Node bottom;
        public int size = 0;

        public Stack(int capacity) {
            this.capacity = capacity;
        }

        public boolean isFull() {
            return capacity == size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void join(Node above, Node below) {
            if (below != null) {
                below.above = above;
            }
            if (above != null) {
                above.below = below;
            }
        }

        public boolean push(int v) {
            if (size >= capacity) {
                return false;
            }
            size++;
            Node n = new Node(v);
            if (size == 1) {
                bottom = n;
            }
            join(n, top);
            top = n;
            return true;
        }

        public int pop() {
            Node t = top;
            top = top.below;
            size--;
            return t.value;
        }

        public int removeBottom() {
            Node b = bottom;
            bottom = bottom.above;
            if (bottom != null) {
                bottom.below = null;
            }
            size--;
            return b.value;
        }
    }

    class Node {
        public Node above;
        public Node below;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

}
