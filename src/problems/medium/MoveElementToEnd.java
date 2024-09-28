package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        moveElementToEnd(array, 2);

    }

    // O(n) time | O(1) space
    // OK - repeated 12/02/2022
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        //                   ij
        // array = [4, 1, 3, 2, 2, 2, 2, 2]
        // array = [4, 1, 2, 2, 2, 3, 2, 2]
        // array = [2, 1, 2, 2, 2, 3, 4, 2]
        //                   ij
        // array = [4, 1, 3, 2, 2, 2, 2, 2]
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove) {
                j--;
            }
            if (array.get(i) == toMove) { // 2 == 2
                swap(i, j, array);
            }
            i++;
        }
        return array;
    }

    private static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

}
