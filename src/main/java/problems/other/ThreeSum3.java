package problems.other;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum3 {

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -4, -3};
        ThreeSum3 threeSum3 = new ThreeSum3();
        threeSum3.threeSum(array);
    }

    public List<Integer[]> threeSum(int[] array) {
        quickSort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int p = 0; p < array.length - 2; p++) {
            int pVal = array[p];
            int l = p + 1;
            int r = array.length - 1;
            while (l < r) {
                int lVal = array[l];
                int rVal = array[r];
                int sum = pVal + lVal + rVal;
                if (sum == 0) {
                    result.add(new Integer[]{pVal, lVal, rVal});
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }


    private void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (array[s] >= array[pivot] && array[e] <= array[pivot]) {
                swap(array, s, e);
            }
            if (array[s] <= array[pivot]) {
                s++;
            }
            if (array[e] >= array[pivot]) {
                e--;
            }
        }
        swap(array, pivot, e);

        if (end - (e + 1) > e - 1 - start) {
            quickSortHelper(array, e + 1, end);
            quickSortHelper(array, start, e - 1);
        } else {
            quickSortHelper(array, start, e - 1);
            quickSortHelper(array, e + 1, e);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
