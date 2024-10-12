package star;

import java.util.ArrayList;

public class SortStack {

    public static void main(String[] args) {
        int[] arr = {-5, 2, -2, 4, 3, 1};
        ArrayList<Integer> stack = new ArrayList<>();
        for (int a : arr) {
            stack.add(a);
        }

        SortStack sortStack = new SortStack();
        sortStack.sortStack(stack);
    }

    // O(n^2) time | O(n) space
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        sortStackHelper(stack);
        return stack;
    }

    private void sortStackHelper(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer top = stack.remove(stack.size() - 1);
        sortStackHelper(stack);
        merge(stack, top);
    }

    private void merge(ArrayList<Integer> stack, Integer elem) {
        if (stack.isEmpty()) {
            stack.add(elem);
        } else {
            Integer top = stack.get(stack.size() - 1);
            if (top <= elem) {
                stack.add(elem);
            } else {
                Integer removed = stack.remove(stack.size() - 1);
                merge(stack, elem);
                stack.add(removed);
            }
        }
    }
}
