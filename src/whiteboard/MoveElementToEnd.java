package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        int[] array = {2, 1, 2, 2, 2, 3, 4, 2};
        List<Integer> arrList = new ArrayList<>();

        for (int element : array) {
            arrList.add(element);
        }

        moveElementToEnd(arrList, 2);
    }

    // O(n) time | O(1) space
    // #2: 21/06/2022
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            if (array.get(left) == toMove) {
                while (right >= 0 && array.get(right) == toMove) {
                    right--;
                }
                if (left < right) {
                    swap(array, left, right);
                } else {
                    break;
                }
                left++;
                right--;
            } else {
                while (left < array.size() - 1 && array.get(left) != toMove) {
                    left++;
                }
            }
        }
        return array;
    }

    private static void swap(List<Integer> array, int left, int right) {
        Integer temp = array.get(left);
        array.set(left, array.get(right));
        array.set(right, temp);
        System.out.println();
    }

}
