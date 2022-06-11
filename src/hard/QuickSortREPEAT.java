package hard;

public class QuickSortREPEAT {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        quickSort(array);
    }

    // Right pointer values greater than pivot
    // Left <= pivot ---> Left++ (element already sorted with respect of pivot)
    // Right >= pivot ---> Right--
    // Left > pivot && right < pivot ---> swap(Left, Right) (both element in respect of pivot not match)
    // After first iteration all number greater than pivot on the right, and all smaller on the left
    // When Right < Left swap Right with pivot
    // Apply quick sort on smaller (space complexity)

    // Worst: Position pivot at end of iteration. If pivot divides array of 1 tiny list and second huge. O(n^2) time
    // Best: Pivot divides array exactly in half. O(n*log(n)) time
    // Average: O(n*log(n)) time | O(log(n)) space (recursion, frames of call stack)
    // OK - repeated 27/01/2022
    public static int[] quickSort(int[] array) {
        // Write your code here.
        quickSortHelper(array, 0, array.length - 1);
        return array;
    }

    private static void quickSortHelper(int[] array, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        //  0  1  2  3  4  5  6
        // [8, 5, 2, 9, 5, 6, 3]
        // [8, 5, 2, 3, 5, 6, 9]
        // [6, 5, 2, 3, 5, 8, 9]
        //  p              r  l
        // ---------------------
        // [6, 5, 2, 3, 5, 8*, 9*] (* sorted)
        // [5, 5, 2, 3, 6, 8*, 9*] (* sorted)
        //  p           r  l
        // ---------------------
        // [5, 5, 2, 3, 6*, 8*, 9*] (* sorted)
        // [3, 5, 2, 5, 6*, 8*, 9*] (* sorted)
        //  p        r  l
        // ---------------------
        // [3, 5, 2, 5*, 6*, 8*, 9*] (* sorted)
        // [3, 2, 5, 5*, 6*, 8*, 9*] (* sorted)
        // [2, 3, 5, 5*, 6*, 8*, 9*] (* sorted)
        //  p  r  l
        // ----------------------
        // [2, 3, 5*, 5*, 6*, 8*, 9*] (* sorted)
        //  prl
        // [2*, 3*, 5*, 5*, 6*, 8*, 9*] (* sorted)
        int pivotIdx = startIdx; // 0
        int leftIdx = startIdx + 1; // 1
        int rightIdx = endIdx; // 2
        while (rightIdx >= leftIdx) {
            // 5 > 3 && 2 < 5
            if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                swap(array, leftIdx, rightIdx);
            }
            // 2 <= 3
            if (array[leftIdx] <= array[pivotIdx]) {
                leftIdx++;
            }
            // 5 >= 3
            if (array[rightIdx] >= array[pivotIdx]) {
                rightIdx--;
            }
        }
        swap(array, pivotIdx, rightIdx);

        // 5 - 1 - 0 < 6 - (5 + 1) = 4 < 0
        // 4 - 1 - 0 < 4 - (4 - 1) = 3 < 1
        // 3 - 1 - 0 < 3 - (3 - 1) = 2 < 1
        // 2 - 1 - 0 < 2 - (1 + 1) = 1 < 0
        // s                               r                        e
        // --------------------------------------------------------->
        // ******************************** #########################
        boolean leftSubarrayIsSmaller = rightIdx - 1 - startIdx < endIdx - (rightIdx + 1);
        if (leftSubarrayIsSmaller) {
            quickSortHelper(array, startIdx, rightIdx - 1);
            quickSortHelper(array, rightIdx + 1, endIdx);
        } else {
            quickSortHelper(array, rightIdx + 1, endIdx); // [9]
            quickSortHelper(array, startIdx, rightIdx - 1); // [6, 5, 2, 3, 5]
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
