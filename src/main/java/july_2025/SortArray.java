package july_2025;

public class SortArray {

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        SortArray sortArray = new SortArray();
        int[] result = sortArray.sortArray(nums);
        System.out.println(result);
    }

    // O(n log(n)) time | O(n) space
    public int[] sortArray(int[] nums) {
        return mergeSort(nums);
    }

    private int[] mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        int[] right = new int[nums.length - mid];
        int idx = 0;
        for (int i = mid; i < nums.length; i++) {
            right[idx] = nums[i];
            idx++;
        }
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            result[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length) {
            result[k] = right[j];
            k++;
            j++;
        }
        return result;
    }

    // O(n log(n)) time | O(n) space | O(n^2) time in worst case
    private void quickSort(int start, int end, int[] nums) {
        if (start > end) {
            return;
        }
        int pivot = start;
        int s = start + 1;
        int e = end;
        while (s <= e) {
            if (nums[s] >= nums[pivot] && nums[e] <= nums[pivot]) {
                swap(s, e, nums);
            }
            if (nums[s] <= nums[pivot]) {
                s++;
            }
            if (nums[e] >= nums[pivot]) {
                e--;
            }
        }
        swap(e, pivot, nums);
        // *----------------------+*+--------*
        // start              (e-1) (e+1)    end
        if (e - 1 - start > end - (e + 1)) {
            quickSort(start, e - 1, nums);
            quickSort(e + 1, end, nums);
        } else {
            quickSort(e + 1, end, nums);
            quickSort(start, e - 1, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
