package september_2023;

import java.util.ArrayList;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {8762, 654, 3008, 345, 87, 65, 234, 12, 2};
        ArrayList<Integer> array = new ArrayList<>();
        for (int a : arr) {
            array.add(a);
        }

        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(array);
    }

    // O(d * (n + b)) time | O(n + b) space
    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        if (array.isEmpty()) {
            return array;
        }
        int maxNumber = Integer.MIN_VALUE;
        for (int num : array) {
            maxNumber = Math.max(maxNumber, num);
        }

        int digit = 0;

        while (maxNumber / (Math.pow(10, digit)) > 0) {
            countingSort(array, digit);
            digit++;
        }
        return array;
    }

    private void countingSort(ArrayList<Integer> array, int digit) {
        int[] sortedArray = new int[array.size()];
        int[] countArray = new int[10];

        int digitColumn = (int) Math.pow(10, digit);
        for (int num : array) {
            int countIndex = (num / digitColumn) % 10;
            countArray[countIndex] += 1;
        }

        for (int idx = 1; idx < 10; idx++) {
            countArray[idx] += countArray[idx - 1];
        }

        for (int idx = array.size() - 1; idx >= 0; idx--) {
            int countIndex = (array.get(idx) / digitColumn) % 10;
            countArray[countIndex] -= 1;
            int sortedIdx = countArray[countIndex];
            sortedArray[sortedIdx] = array.get(idx);
        }

        for (int idx = 0; idx < array.size(); idx++) {
            array.set(idx, sortedArray[idx]);
        }
    }

}
