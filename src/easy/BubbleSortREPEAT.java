package easy;

public class BubbleSortREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        bubbleSort(array);
    }

    // OK - repeated 02/03/2022
    // O(n^2) time | O(1) space
    // rec([8, 5, 2, 9, 5, 6, 3])
    public static int[] bubbleSort(int[] array) {
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            isSorted = true;
            //  i  i1
            // [2, 3, 5, 5, 6, 8, 9]
            //        s  s  s  s  s
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) { // 8 > 4
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            counter++; // 2
        }
        return array; // [2, 3, 5, 5, 6, 8, 9]
    }

//    // O(n^2) time | O(1) space
//    public static int[] bubbleSort(int[] array) {
//        // Write your code here.
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 1; j < array.length - i; j++) {
//                if (array[j - 1] > array[j]) {
//                    swap(array, j - 1, j);
//                }
//            }
//        }
//        return array;
//    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
