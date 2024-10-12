package september_2023;

import javax.swing.*;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};

        quickSort(array);
    }

    // O(nlog(n)) time | O(log(n)) space - Best
    // O(nlog(n)) time | O(log(n)) space - Average
    // O(n^2) time | O(log(n)) space - Worst
    public static int[] quickSort(int[] array) {
        // Write your code here.
        quickSortHelper(0, array.length - 1, array);
        return array;
    }

    private static void quickSortHelper(int start, int end, int[] array) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (array[pivot] < array[s] && array[pivot] > array[e]) {
                swap(array, s, e);
            }
            if (array[pivot] >= array[s]) {
                s++;
            }
            if (array[pivot] <= array[e]) {
                e--;
            }
        }
        swap(array, pivot, e);

        //            e
        // ***********#********
        // start            end
        if (e - 1 - start > end - (e + 1)) {
            quickSortHelper(start, e - 1, array);
            quickSortHelper(e + 1, end, array);
        } else {
            quickSortHelper(e + 1, end, array);
            quickSortHelper(start, e - 1, array);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
