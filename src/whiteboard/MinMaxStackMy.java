package whiteboard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinMaxStackMy {

    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();

        minMaxStack.push(2);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());

        System.out.println("===");
        minMaxStack.push(0);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());

        System.out.println("===");
        minMaxStack.push(5);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());

        System.out.println("===");
        minMaxStack.push(4);
        System.out.println(minMaxStack.getMin());
        System.out.println(minMaxStack.getMax());
        System.out.println(minMaxStack.peek());
    }

    // #2: 05/07/2022
    // Feel free to add new properties and methods to the class.
    static class MinMaxStack {
        Stack<Element> stack = new Stack<>();

        // O(1) time | O(1) space
        public int peek() {
            // Write your code here.
            if (!stack.isEmpty()) {
                return stack.peek().value;
            }
            return -1;
        }

        // O(1) time | O(1) space
        public int pop() {
            // Write your code here.
            if (!stack.isEmpty()) {
                Element topElement = stack.pop();
                return topElement.value;
            }
            return -1;
        }

        // O(1) time | O(1) space
        public void push(Integer number) {
            // Write your code here.
            Map<String, Integer> minMaxMap = new HashMap<>();
            if (stack.isEmpty()) {
                minMaxMap.put("min", number);
                minMaxMap.put("max", number);
                Element newElement = new Element(number, minMaxMap);
                stack.push(newElement);
            } else {
                Element topElement = stack.peek();
                minMaxMap.put("min", Math.min(number, topElement.minMaxMap.get("min")));
                minMaxMap.put("max", Math.max(number, topElement.minMaxMap.get("max")));
                Element newElement = new Element(number, minMaxMap);
                stack.push(newElement);
            }
        }

        // O(1) time | O(1) space
        public int getMin() {
            // Write your code here.
            if (!stack.isEmpty()) {
                Element topElement = stack.peek();
                return topElement.minMaxMap.get("min");
            }
            return -1;
        }

        // O(1) time | O(1) space
        public int getMax() {
            // Write your code here.
            if (!stack.isEmpty()) {
                Element topElement = stack.peek();
                return topElement.minMaxMap.get("max");
            }
            return -1;
        }
    }

    static class Element {
        int value;
        Map<String, Integer> minMaxMap;

        public Element(int value, Map<String, Integer> minMaxMap) {
            this.value = value;
            this.minMaxMap = minMaxMap;
        }
    }

}
