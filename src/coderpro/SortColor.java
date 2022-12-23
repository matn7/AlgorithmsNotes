package coderpro;

import java.util.HashMap;
import java.util.Map;

public class SortColor {

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 0, 1, 1, 2, 0, 0, 0, 1, 0, 0, 0};
        SortColor sortColor = new SortColor();
        sortColor.sortColors2(nums);
    }

    // O(n) time | O(1) space
    public int[] sortColors2(int[] colors) {
        int lowIndex = 0;
        int highIndex = colors.length - 1;
        int currIndex = 0;

        while (currIndex <= highIndex) {
            if (colors[currIndex] == 0) {
                swap(colors, lowIndex, currIndex);
                lowIndex++;
                currIndex++;
            } else if (colors[currIndex] == 2) {
                swap(colors, highIndex, currIndex);
                highIndex--;
            } else {
                currIndex++;
            }
        }
        return colors;
    }

    // O(n) time | O(3) space
    public int[] sortColors(int[] colors) {
        Map<Integer, Integer> colorsMap = new HashMap<>();
        for (int c : colors) {
            if (colorsMap.containsKey(c)) {
                colorsMap.put(c, colorsMap.get(c) + 1);
            } else {
                colorsMap.put(c, 1);
            }
        }
        int index = 0;
        for (int i = 0; i < colorsMap.get(0); i++) {
            colors[index] = 0;
            index++;
        }
        for (int i = 0; i < colorsMap.get(1); i++) {
            colors[index] = 1;
            index++;
        }
        for (int i = 0; i < colorsMap.get(2); i++) {
            colors[index] = 2;
            index++;
        }
        return colors;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
