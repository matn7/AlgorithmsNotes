package september_2023;

import java.util.ArrayList;

public class SortStack {

    public static void main(String[] args) {
        int[] nums = {-5, 2, -2, 4, 3, 1};

        ArrayList<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            stack.add(num);
        }

        SortStack sortStack = new SortStack();
        ArrayList<Integer> result = sortStack.sortStack(stack);
        System.out.println();
    }

    // O(n^2) time | O(n) space
    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.
        if (stack.isEmpty()) {
            return stack;
        }
        int removedElement = stack.remove(stack.size() - 1);
        sortStack(stack);
        mergeStack(stack, removedElement);
        return stack;
    }

    private void mergeStack(ArrayList<Integer> stack, int removedElement) {
        if (stack.isEmpty()) {
            stack.add(removedElement);
        } else {
            // [-5], -2
            if (stack.get(stack.size() - 1) > removedElement) { // 2 > -2
                int currentTopOfStack  = stack.remove(stack.size() - 1); // 2
                mergeStack(stack, removedElement);
                stack.add(currentTopOfStack);
            } else {
                stack.add(removedElement);
            }
        }
    }


    // f([]) removedElement = -5
    // f([-5]) removedElement = 2
    // f([-5, 2) removedElement = -2
    // f([-5, 2, -2]) removedElement = 4
    // f([-5, 2, -2, 4]) removedElement = 3
    // f([-5, 2, -2, 4, 3]) removedElement = 1
    // f([-5, 2, -2, 4, 3, 1])

}
