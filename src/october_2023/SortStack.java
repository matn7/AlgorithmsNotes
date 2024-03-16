package october_2023;

import java.util.ArrayList;
import java.util.List;

public class SortStack {

    public static void main(String[] args) {
        int[] nums = {-5, 2, -2, 4, 3, 1};
        List<Integer> stack = new ArrayList<>();
        for (int num : nums) {
            stack.add(num);
        }

        sortStack(stack);
    }

    // O(n^2) time | O(n) space
    public static List<Integer> sortStack(List<Integer> stack) {
        sortStackHelper(stack);
        return stack;
    }

    private static void sortStackHelper(List<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer removed = stack.remove(stack.size() - 1); // 1
        sortStackHelper(stack);
        merge(removed, stack);
    }

    private static void merge(int num, List<Integer> stack) {
        if (stack.isEmpty()) {
            stack.add(num);
        } else {
            Integer topElement = stack.get(stack.size() - 1);
            if (topElement <= num) {
                stack.add(num);
            } else {
                Integer removed = stack.remove(stack.size() - 1);
                merge(num, stack);
                stack.add(removed);
            }
        }
    }

}
