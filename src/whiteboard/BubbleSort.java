package whiteboard;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        bubbleSort(array);
    }

    // O(n^2) time | O(1) space
    // #2: 24/06/2022
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        int last = 0;
        boolean swapped = true;
        int i = 0;
        while (last < array.length) {
            for (int j = 1; j < array.length - last; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    swapped = true;
                }
            }
            last++;
            if (!swapped) {
                break;
            }
            swapped = false;
            i++;
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    // O(n^2) time | O(1) space
//    public static int[] bubbleSort(int[] array) {
//        // Write your code here.
//        for (int i = 0; i < array.length; i++) {
//            boolean swapped = false;
//            for (int j = 1; j < array.length - i; j++) {
//                if (array[j] < array[j-1]) {
//                    swap(array, j, j - 1);
//                    swapped = true;
//                }
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//        return array;
//    }
//
//    private static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

}
