package udemy.stackandqueue;

public class FindMinElementInStackMy {

    Stack<Element> stack = new Stack<>();

    public void push(int value) throws Stack.StackOverflowException, Stack.StackUnderflowException {
        if (stack.isEmpty()) {
            stack.push(new Element(value, value, value));
        } else {
            Element top = stack.peek();
            int currMin = Math.min(top.min, value);
            int currMax = Math.max(top.max, value);
            stack.push(new Element(currMin, currMax, value));
        }
    }

    public Element pop() throws Stack.StackUnderflowException {
        if (stack.isEmpty()) {
            throw new Stack.StackUnderflowException();
        }
        return stack.pop();
    }

    public int getMin() throws Stack.StackUnderflowException {
        if (stack.isEmpty()) {
            throw new Stack.StackUnderflowException();
        }
        Element top = stack.peek();
        return top.min;
    }


    private static class Element {
        int min;
        int max;
        int value;

        public Element(int min, int max, int value) {
            this.min = min;
            this.max = max;
            this.value = value;
        }
    }

}
