package coderpro;

public class QuickSelect2 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 2, 0, 1};
        QuickSelect2 quickSelect2 = new QuickSelect2();
        quickSelect2.quickSelect(nums, 3);
    }

    // O(n) time | O(log(n)) space
    public int quickSelect(int[] nums, int k) {

        sort(nums, 0, nums.length - 1, k);
        // 9 no quick select

        int num = nums[k];
        return num;

    }

    private void sort(int[] nums, int first, int last, int k) {
        System.out.println("#");
        if (first >= last) {
            return;
        }
        int pivot = first;
        int start = first + 1;
        int end = last;

        // f              l
        // 0, 3, 1, 2, 4, 5
        // p           e  s
        while (start <= end) {
            if (nums[start] >= nums[pivot] && nums[end] <= nums[pivot]) {
                swap(nums, start, end);
                start++;
                end--;
            }
            if (nums[start] <= nums[pivot]) {
                start++;
            }
            if (nums[end] >= nums[pivot]) {
                end--;
            }
        }
        swap(nums, pivot, end);
        if (end == k) {
            return;
        }
        if (end - first > last + 1 - end) {
            sort(nums, first, end - 1, k);
            sort(nums, end + 1, last, k);
        } else {
            sort(nums, end + 1, last, k);
            sort(nums, first, end - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
