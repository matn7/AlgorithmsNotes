package november_2024;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Integer> stack;
    List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            minStack.add(val);
        } else {
            Integer currMin = minStack.get(minStack.size() - 1);
            if (val < currMin) {
                minStack.add(val);
            } else {
                minStack.add(currMin);
            }
        }
        stack.add(val);
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        stack.remove(stack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        return minStack.get(minStack.size() - 1);
    }

}
