package whiteboard;

public class ThreeNumberSort {

    public static void main(String[] args) {
        int[] array = {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = {0, 1, -1};

        ThreeNumberSort tns = new ThreeNumberSort();
        tns.threeNumberSort(array, order);
    }

    // O(n) time | O(1) space
    public int[] threeNumberSort(int[] array, int[] order) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;
        int idx = 0;
        while (idx <= end) {
            if (array[idx] == order[0]) {
                swap(array, start, idx);
                start++;
                idx++;
            } else if (array[idx] == order[2]) {
                swap(array, end, idx);
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
        // Write your code here.
        int[] valuesCounts = {0, 0, 0};

        for (int element : array) {
            if (element == order[0]) {
                valuesCounts[0]++;
            } else if (element == order[1]) {
                valuesCounts[1]++;
            } else {
                valuesCounts[2]++;
            }
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            int value = order[i];
            int count = valuesCounts[i] + j;
            for (int c = j; c < count; c++) {
                array[c] = value;
                j++;
            }
        }
        return array;
    }

    // O(n) time | O(1) space
    public int[] threeNumberSort3(int[] array, int[] order) {
        int firstValue = order[0];
        int thirdValue = order[2];

        int firstIdx = 0;
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] == firstValue) {
                swap(array, idx, firstIdx);
                firstIdx++;
            }
        }

        int thirdIdx = array.length - 1;
        for (int idx = array.length - 1; idx >= 0; idx--) {
            if (array[idx] == thirdValue) {
                swap(array, idx, thirdIdx);
                thirdIdx--;
            }
        }

        return array;
    }

}
