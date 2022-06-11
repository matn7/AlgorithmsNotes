package hard;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSortREPEAT {

    public static void main(String[] args) {
        RadixSortREPEAT radixSortREPEAT = new RadixSortREPEAT();
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(8762, 654, 3008, 345, 87, 65, 234, 12, 2));
        radixSortREPEAT.radixSort(array);
        System.out.println();
        double value = 9 * Math.log(9);
        double value2 = 4 * (9 + 10);
        System.out.println(value);
        System.out.println(value2);
    }


    // b = 10
    // d = 4 - (8762 has 4 digits)
    // n = 9 - num elements in array
    // 4 * (9 + 10) = 76
    // nlog(n) = 9 * log(9) = 19.7
    // O(d * (n + b)) time (d - num of digits, b number of counts) | O(n + b) space
    // OK - repeated 02/02/2022
    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        // Write your code here.
        // [8762, 654, 3008, 345, 87, 65, 234, 12, 2]
        if (array.size() == 0) {
            return array;
        }
        int maxNumber = Integer.MIN_VALUE;
        for (Integer element : array) {
            if (element > maxNumber) {
                maxNumber = element;
            }
        }
        // maxNumber = 8762
        int digit = 0;
        // 8762 / (10^1) = 876
        while (maxNumber / (Math.pow(10, digit)) > 0) {
            countingSort(array, digit);
            digit++;
        }
        return array;
    }

    // // [8762, 654, 3008, 345, 87, 65, 234, 12, 2]
    // digit = 1
    private void countingSort(ArrayList<Integer> array, int digit) {
        int[] sortedArray = new int[array.size()];
        int[] countArray = new int[10]; // 0-9 digit

        // sortedArray = []
        // countArray = [0, 0, 3, 0, 2, 2, 0, 1, 1, 0]
        double digitColumn = Math.pow(10, digit); // 10^0 = 1
        for (Integer num : array) {
            int countIndex = (int) (num / digitColumn) % 10; // (2 / 1) % 10 = 2
            countArray[countIndex] += 1;
        }

        // countArray = [0, 0, 3, 3, 5, 7, 7, 8, 9, 9]
        for (int idx = 1; idx < 10; idx++) {
            //
            countArray[idx] += countArray[idx - 1];
        }
        // sortedArray = [8762, 12, 2, 654, 234, 345, 65, 87, 3008]
        // countArray = [0, 0, 0, 3, 3, 5, 7, 7, 8, 9]
        for (int idx = array.size() - 1; idx >= 0; idx--) {
            int countIndex = (int) (array.get(idx) / digitColumn) % 10; // (8762 / 1) % 10 = 2
            countArray[countIndex] -= 1;
            int sortedIndex = countArray[countIndex]; // 0
            sortedArray[sortedIndex] = array.get(idx);
        }

        for (int idx = 0; idx < array.size(); idx++) {
            array.set(idx, sortedArray[idx]);
        }
        // array = [8762, 12, 2, 654, 234, 345, 65, 87, 3008]
    }

}
