package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MoveToEnd2 {

    public static void main(String[] args) {
        int[] elements = {2, 1, 2, 2, 2, 3, 4, 2};
        List<Integer> array = new ArrayList<>();
        for (int element : elements) {
            array.add(element);
        }

        moveElementToEnd(array, 2);
    }

    // O(n) time | O(1) space
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int start = 0;
        int end = array.size() - 1;
        while (start < end) {
            while (array.get(end) == toMove && start < end) {
                end--;
            }
            while (array.get(start) != toMove && start < end) {
                start++;
            }

            if (start >= end) {
                break;
            }

            swap(array, start, end);
            start++;
            end--;
        }
        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
