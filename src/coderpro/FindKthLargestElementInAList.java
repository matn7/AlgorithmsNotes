package coderpro;

public class FindKthLargestElementInAList {

    public static void main(String[] args) {
        int[] arr = {4, 4, 1, 1, 1, 3, 5, 2, 4, 6, 8, 1, 3};
        int k = 3;
        FindKthLargestElementInAList find = new FindKthLargestElementInAList();
        find.findKthLargest(arr, k);
    }

    public int findKthLargest(int[] arr, int k) {
        quickSelectHelper(arr, 0, arr.length - 1, k);
        return -1;
    }

    private void quickSelectHelper(int[] arr, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (arr[s] >= arr[pivot] && arr[e] <= arr[pivot]) {
                swap(arr, s, e);
            }
            if (arr[s] <= arr[pivot]) {
                s++;
            }
            if (arr[e] >= arr[pivot]) {
                e--;
            }
        }
        swap(arr, pivot, e);
        if (e == arr.length - k) {
            System.out.println();
            return;
        }

        if (end - (e + 1) > e - 1 - start) {
            quickSelectHelper(arr, e + 1, end, k);
            quickSelectHelper(arr, start, e - 1, k);
        } else {
            quickSelectHelper(arr, start, e - 1, k);
            quickSelectHelper(arr, e + 1, end, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
