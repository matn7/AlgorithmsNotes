package september_2023;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        ThreeNumberSort threeNumberSort = new ThreeNumberSort();
        threeNumberSort.threeNumberSort3(array, order);
    }

    // O(n) time | O(1) space
    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        // [0, 0, 1,  1,  1, 0, -1, -1]
        //        f          l
        //                   i
        int start = 0;
        int idx = 0;
        int end = array.length - 1;
        while (idx <= end) {
            int curr = array[idx];
            int startVal = order[0];
            int endVal = order[2];
            if (curr == startVal) { // -1 == 0
                swap(array, idx, start);
                idx++;
                start++;
            } else if (curr == endVal) { // -1 == -1
                swap(array, idx, end);
                end--;
            } else {
                idx++;
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // O(n) time | O(1) space
    public int[] threeNumberSort2(int[] array, int[] order) {
        int[] valueCounts = {0, 0, 0};

        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            if (curr == order[0]) {
                valueCounts[0] += 1;
            } else if (curr == order[1]) {
                valueCounts[1] += 1;
            } else {
                valueCounts[2] += 1;
            }
        }
        int counter = 0;
        for (int i = 0; i < valueCounts[0]; i++) {
            array[counter] = order[0];
            counter++;
        }
        for (int i = 0; i < valueCounts[1]; i++) {
            array[counter] = order[1];
            counter++;
        }
        for (int i = 0; i < valueCounts[2]; i++) {
            array[counter] = order[2];
            counter++;
        }
        return array;
    }

    // O(n) time | O(1) space
    public int[] threeNumberSort3(int[] array, int[] order) {
        // [0, 1, 0, -1, -1, 0, 1, 1]
        //        *
        //     f
        int firstValue = order[0];
        int firstIdx = 0;
        for (int i = 0; i < array.length; i++) {
            int curr = array[i];
            if (curr == firstValue) {
                swap(array, i, firstIdx);
                firstIdx++;
            }
        }
        int lastValue = order[2];
        int lastIdx = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            int curr = array[i];
            if (curr == lastValue) {
                swap(array, i, lastIdx);
                lastIdx--;
            }
        }
        return array;

    }

}
