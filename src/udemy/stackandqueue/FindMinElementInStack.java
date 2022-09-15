package udemy.stackandqueue;

public class FindMinElementInStack {

    public static class MinimumStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minimumStack = new Stack<>();

        public void push(int data) throws Stack.StackOverflowException, Stack.StackUnderflowException {
            int min = data;
            if (!minimumStack.isEmpty()) {
                if (min > minimumStack.peek()) {
                    min = minimumStack.peek();
                }
            }
            stack.push(data);
            minimumStack.push(min);
        }
        public int pop() throws Stack.StackUnderflowException {
            minimumStack.pop();
            return stack.pop();
        }

        // O(1) time
        public int getMinimum() throws Stack.StackUnderflowException {
            return minimumStack.peek();
        }

    }

}
