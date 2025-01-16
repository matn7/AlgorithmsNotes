package november_2024;

import java.util.ArrayList;
import java.util.List;

public class MinStack2 {

    List<Element> stack;

    public MinStack2() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new Element(val, val));
        } else {
            int currMin = stack.get(stack.size() - 1).min;
            if (val < currMin) {
                stack.add(new Element(val, val));
            } else {
                stack.add(new Element(val, currMin));
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.get(stack.size() - 1).val;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.get(stack.size() - 1).min;
    }

    static class Element {
        int val;
        int min;

        public Element(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

}
