package whiteboard;

import java.util.ArrayList;

public class SortStack {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        int[] array = {-5, 2, -2, 4, 3, 1};

        for (int element : array) {
            stack.add(element);
        }

        SortStack sortStack = new SortStack();
        ArrayList<Integer> result = sortStack.sortStack(stack);
        System.out.println();

    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        sortStackHelper(stack);
        return stack;
    }

    private void sortStackHelper(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int currVal = stack.remove(stack.size() - 1);
        sortStackHelper(stack);
        merge(stack, currVal);
    }

    private void merge(ArrayList<Integer> stack, int currVal) {
        if (stack.isEmpty()) {
            stack.add(currVal);
            return;
        }
        int topElement = stack.get(stack.size() - 1);
        if (topElement < currVal) {
            stack.add(currVal);
            return;
        }
        Integer popped = stack.remove(stack.size() - 1);
        merge(stack, currVal);
        stack.add(popped);
    }

}
