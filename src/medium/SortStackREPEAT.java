package medium;

import java.util.ArrayList;

public class SortStackREPEAT {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(-5);
        stack.add(2);
        stack.add(-2);
        stack.add(4);
        stack.add(3);
        stack.add(1);

        // [-5, 2, -2, 4, 3, 1]

        SortStackREPEAT sortStack = new SortStackREPEAT();
        sortStack.sortStack(stack);
    }

    // O(n^2) time | O(n) space
    // rec([]) => []
    // rec([-5]) => [-5]
    // rec([-5, 2]) => [-5, 2]
    // rec([-5, 2, -2]) => [-5,-2,2]
    // rec([-5, 2, -2, 4]) => [-5,-2,2,4]
    // rec([-5, 2, -2, 4, 3]) => [-5,-2,2,3,4]
    // rec([-5, 2, -2, 4, 3, 1])
    // OK - repeated 17/02/2022
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.
        if (stack.isEmpty()) {
            return stack;
        }

        Integer top = stack.remove(stack.size() - 1); // 1 |
        sortStack(stack);
        insertInSortedOrder(stack, top); // [-5]

        return stack; // [-5,-2,1,2,3,4]
    }

    // rec([-5,-2],1) => [-5,-2,1]
    // rec([-5,-2,2],1) => [-5,-2,1,2]
    // rec([-5,-2,2,3],1) => [-5,-2,1,2,3]
    // rec([-5,-2,2,3,4],1) => [-5,-2,1,2,3,4]
    // rec([-5,-2,2], 3) => [-5,-2,2,3]
    // rec([-5,-2,2,4], 3) => [-5,-2,2,3,4]
    // rec([-5,-2,2], 4)
    // rec([-5], -2) => [-5, -2]
    // rec([-5, 2], -2)
    // rec([-5], 2) => [-5, 2]
    // rec([], -5) => [-5]
    private void insertInSortedOrder(ArrayList<Integer> stack, Integer value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }

        Integer top = stack.remove(stack.size() - 1); // 4 | 3
        insertInSortedOrder(stack, value); // [-5, -2, 2,3]
        stack.add(top);
    }

}
