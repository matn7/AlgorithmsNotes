package september_2024;

public class ThreeNumSort {

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, -1, -1, 0, 1, 1};

        int[] result = threeNumSort(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] threeNumSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int low = 0;
        int high = arr.length - 1;
        int idx = 0;

        //                 i
        // [-1, 0, 0,  0, -1, 1, 1, 1]
        //      l          h

        while (idx <= high) {
            int num = arr[idx];
            if (num == -1) {
                swap(arr, idx, low);
                low++;
                idx++;
            } else if (num == 1) {
                swap(arr, idx, high);
                high--;
            } else {
                idx++;
            }
        }
        return arr;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
