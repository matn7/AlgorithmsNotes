package january_2024;

public class QuickSelect {

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 3, 4, 1, 5, 6, 9, 0};
        int k = 3;

        int result = quickSelect(arr, k);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public static int quickSelect(int[] arr, int k) {
        k = arr.length - k;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == k) {
                return arr[k];
            } else if (pivotIndex > k) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
