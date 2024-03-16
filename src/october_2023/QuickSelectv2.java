package october_2023;

public class QuickSelectv2 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 2, 0, 1};

        int result = quickSelect(nums, 3);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static int quickSelect(int[] nums, int k) {
        int idx = nums.length - k;
        quickSort(nums, 0, nums.length - 1, idx);
        return nums[k];
    }

    private static void quickSort(int[] nums, int start, int end, int idx) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;

        while (s <= e) {
            if (nums[s] > nums[pivot] && nums[e] < nums[pivot]) {
                swap(nums, s ,e);
            }
            if (nums[s] <= nums[pivot]) {
                s++;
            }
            if (nums[e] >= nums[pivot]) {
                e--;
            }
        }
        swap(nums, pivot, e);
        if (idx == e) {
            return;
        }
        if (e - 1 - start > end - (e + 1)) {
            quickSort(nums, start, e - 1, idx);
            quickSort(nums, e + 1, end, idx);
        } else {
            quickSort(nums, e + 1, end, idx);
            quickSort(nums, start, e - 1, idx);
        }

        // start                      end
        // ===================*==========
        //                    e
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
