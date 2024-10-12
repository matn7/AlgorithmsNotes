package september_2023;

public class MinimumWaitingTime {

    public static void main(String[] args) {
        int[] queries = {3, 2, 1, 2, 6};

        MinimumWaitingTime minimumWaitingTime = new MinimumWaitingTime();
        minimumWaitingTime.minimumWaitingTime(queries);
    }

    // O(nlog(n)) time | O(n) space
    public int minimumWaitingTime(int[] queries) {
        // Write your code here.
        // [3, 2, 1, 2, 6]
        // [1, 2, 2, 3, 6]
        // time = 2
        // 1 + 2 +
        quickSort(queries);
        int sum = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int left = queries.length - (i + 1);
            sum += duration * left;
        }
        return sum;
    }

    private void quickSort(int[] queries) {
        quickSortHelper(queries, 0, queries.length - 1);
    }

    private void quickSortHelper(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;
        while (s <= e) {
            if (arr[s] > arr[pivot] && arr[e] < arr[pivot]) {
                swap(arr, s, e);
                s++;
                e--;
            }
            if (arr[s] <= arr[pivot]) {
                s++;
            }
            if (arr[e] >= arr[pivot]) {
                e--;
            }
        }

        swap(arr, pivot, e);

        // S               p          E
        // *************** # **********
        if (end - (e + 1) > e - 1 - start) {
            quickSortHelper(arr, e + 1, end);
            quickSortHelper(arr, start, e - 1);
        } else {
            quickSortHelper(arr, start, e - 1);
            quickSortHelper(arr, e + 1, end);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
