package hard;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));

        RadixSort radixSort = new RadixSort();
        radixSort.radixSort(array);
    }

    // O(d * (n + b)) b base of num system (10), d largest num (8764 -> 4), n input array | O(n) space
    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        // Write your code here.
        if (array.isEmpty()) {
            return array;
        }
        // what is max num
        int maxNumber = -9999;
        for (Integer element : array) {
            if (element > maxNumber) {
                maxNumber = element;
            }
        }

        int digit = 0;

        while (Math.floor(maxNumber / (Math.pow(10, digit))) > 0) {
            System.out.println(maxNumber / (Math.pow(10, digit)));
            countingSort(array, digit);
            digit++;
        }

        return array;
    }

    private void countingSort(ArrayList<Integer> array, int digit) {
        int[] sortedArray = new int[array.size()];
        int[] countArray = {0,0,0,0,0,0,0,0,0,0};

        double digitColumn = Math.pow(10, digit);
        for (Integer num : array) {
            int countIndex = (int) (Math.floor(num / digitColumn) % 10);
            countArray[countIndex] += 1;
        }

        for (int idx = 1; idx < 10; idx++) {
            countArray[idx] += countArray[idx - 1];
        }

        for (int idx = array.size() - 1; idx >= 0; idx--) {
            int countIndex = (int) (Math.floor(array.get(idx) / digitColumn) % 10);
            countArray[countIndex] -= 1;
            int sortedIndex = countArray[countIndex];
            sortedArray[sortedIndex] = array.get(idx);
        }

        for (int idx = 0; idx < array.size(); idx++) {
            array.remove(idx);
            array.add(idx, sortedArray[idx]);
        }
        System.out.println();
    }

}
