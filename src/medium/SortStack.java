package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(-5);
        stack.add(2);
        stack.add(-2);
        stack.add(4);
        stack.add(3);
        stack.add(1);

        SortStack sortStack = new SortStack();
        ArrayList<Integer> integers = sortStack.sortStack(stack);

        System.out.println();

    }

    // O(n^2) time | O(n) space
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return stack;
        }

        Integer top = stack.remove(stack.size() - 1);

        sortStack(stack);

        insertInSortedOrder(stack, top);

        return stack;
    }

    private void insertInSortedOrder(ArrayList<Integer> stack, Integer value) {
        if (stack.size() == 0 || stack.get(stack.size() - 1) <= value) {
            stack.add(value);
            return;
        }
        Integer top = stack.remove(stack.size() - 1);
        insertInSortedOrder(stack, value);
        stack.add(top);
    }

}
