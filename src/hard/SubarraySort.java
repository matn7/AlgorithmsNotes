package hard;

import java.util.*;

public class SubarraySort {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};

        subarraySort(array);
    }

    public static int[] subarraySort(int[] array) {
        if (array.length <= 1) {
            return new int[] {-1, -1};
        }
        // Write your code here.
        Map<Integer, Boolean> sortedIndexMap = new HashMap<>();
        List<Integer> unsortedIndex = new ArrayList<>();
        List<Integer> unsortedValue = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                sortedIndexMap.put(i, Boolean.TRUE);
            } else {
                unsortedIndex.add(i + 1);
                unsortedValue.add(array[i + 1]);
            }
        }

        int startIdx = -1;
        int endIdx = -1;
        // find place for min

        if (!unsortedIndex.isEmpty() && !unsortedValue.isEmpty()) {
            Collections.sort(unsortedValue);
            for (int i = 0; i < array.length; i++) {
                if (array[i] > unsortedValue.get(0)) {
                    startIdx = i;
                    break;
                }
            }
            endIdx = unsortedIndex.get(unsortedIndex.size() - 1) + 1;

        }


        return new int[] {startIdx, endIdx};
    }

}
