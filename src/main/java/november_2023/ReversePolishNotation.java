package november_2023;

import java.util.*;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] input = {"1", "2", "3", "+", "2", "*", "-"};
        List<String> operations = new ArrayList<>();
        for (String i : input) {
            operations.add(i);
        }

        System.out.println(reversePolishNotation(operations));
        System.out.println(reversePolishNotationV2(operations));
        System.out.println(reversePolishNotationV3(operations));
    }

    // O(n) time | O(n) space
    public static int reversePolishNotation(List<String> operations) {
        Stack<String> stack = new Stack<>();
        Set<String> arithmeticOperations = new HashSet<>();
        arithmeticOperations.add("+");
        arithmeticOperations.add("-");
        arithmeticOperations.add("*");
        arithmeticOperations.add("/");

        for (String operation : operations) {
            if (arithmeticOperations.contains(operation)) {
                Integer b = Integer.valueOf(stack.pop());
                Integer a = Integer.valueOf(stack.pop());
                int res = 0;
                if (operation.equals("+")) {
                    res = a + b;
                } else if (operation.equals("-")) {
                    res = a - b;
                } else if (operation.equals("*")) {
                    res = a * b;
                } else if (operation.equals("/")) {
                    res = a / b;
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(operation);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    // O(n) time | O(n) space
    public static int reversePolishNotationV2(List<String> operations) {
        Map<String, Operator<Integer>> operationMap = new HashMap<>();
        operationMap.put("+", (a, b) -> a + b);
        operationMap.put("-", (a, b) -> a - b);
        operationMap.put("*", (a, b) -> a * b);
        operationMap.put("/", (a, b) -> a / b);

        Stack<String> stack = new Stack<>();
        for (String operation : operations) {
            if (operationMap.containsKey(operation)) {
                Integer b = Integer.parseInt(stack.pop());
                Integer a = Integer.parseInt(stack.pop());
                Operator<Integer> function = operationMap.get(operation);
                int result = function.operate(a, b);
                stack.push(String.valueOf(result));
            } else {
                stack.push(operation);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    @FunctionalInterface
    public interface Operator<T> {
        T operate(T a, T b);
    }

    // O(n) time | O(n) space
    public static int reversePolishNotationV3(List<String> operations) {
        Map<String, Operator<Integer>> operationMap = new HashMap<>();
        operationMap.put("+", (a, b) -> a + b);
        operationMap.put("-", (a, b) -> a - b);
        operationMap.put("*", (a, b) -> a * b);
        operationMap.put("/", (a, b) -> a / b);

//        Stack<String> stack = new Stack<>();
//        for (String operation : operations) {
//            if (operationMap.containsKey(operation)) {
//                Integer b = Integer.parseInt(stack.pop());
//                Integer a = Integer.parseInt(stack.pop());
//                Operator<Integer> function = operationMap.get(operation);
//                int result = function.operate(a, b);
//                stack.push(String.valueOf(result));
//            } else {
//                stack.push(operation);
//            }
//        }
        Iterator<String> iterator = operations.iterator();
        return reversePolishNotationV3Helper(iterator, operationMap);
    }

    private static int reversePolishNotationV3Helper(Iterator<String> iterator, Map<String, Operator<Integer>> operationMap) {
        String next = iterator.next();
        if (operationMap.containsKey(next)) {
            Operator<Integer> function = operationMap.get(next);
            return function.operate(reversePolishNotationV3Helper(iterator, operationMap), reversePolishNotationV3Helper(iterator, operationMap));
        }
        return Integer.parseInt(next);
    }


}
