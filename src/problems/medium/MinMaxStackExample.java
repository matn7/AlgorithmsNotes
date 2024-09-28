package problems.medium;


import java.util.*;

public class MinMaxStackExample {

    // Feel free to add new properties and methods to the class.
    // OK - repeated 10/02/2022
    static class MinMaxStack {
        // [{}]
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // O(1) time | O(1) space
        public int peek() {
            // Write your code here.
            return stack.peek();
        }

        // O(1) time | O(1) space
        public int pop() {
            // Write your code here.
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.pop();
        }

        // O(1) time | O(1) space
        public void push(Integer number) {
            // Write your code here.
            // push(5)
            // push(7)
            // push(2)
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            // {"min": 2, "max": 7}
            if (!minMaxStack.isEmpty()) {
                Map<String, Integer> lastMinMax = minMaxStack.get(minMaxStack.size() - 1);
                // {"min": 5, "max": 7}
                newMinMax.put("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.put("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            // [{"min": 5, "max": 5}, {"min": 5, "max": 7}, {"min": 2, "max": 7}]
            stack.add(number);
            // [5, 7, 2]
        }

        // O(1) time | O(1) space
        public int getMin() {
            // Write your code here.
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        // O(1) time | O(1) space
        public int getMax() {
            // Write your code here.
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}
