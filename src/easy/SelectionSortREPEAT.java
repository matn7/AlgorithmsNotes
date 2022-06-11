package easy;

public class SelectionSortREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        selectionSort(array);
    }

    // OK - repeated 04/03/2022
    // O(n^2) time | O(1) space
    public static int[] selectionSort(int[] array) {
        // Write your code here.
        int currentIdx = 0;
        //                            s
        // array = [2, 3, 5, 5, 6, 8, 9]
        //                            c
        //                                i
        while (currentIdx < array.length - 1) {
            int smallestIdx = currentIdx;
            for (int i = currentIdx + 1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) { // 8 > 9
                    smallestIdx = i;
                }
            }
            swap(currentIdx, smallestIdx, array);
            currentIdx++;
        }
        return array; // [2, 3, 5, 5, 6, 8, 9]
    }

    private static void swap(int currentIdx, int smallestIdx, int[] array) {
        int temp = array[currentIdx];
        array[currentIdx] = array[smallestIdx];
        array[smallestIdx] = temp;
    }

}
