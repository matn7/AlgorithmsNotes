package problems.other;

public class SortThreeUniqueNumber2 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 1, 1, 1, 1, 3, 3, 2, 1, 3, 2, 1, 3, 3, 3, 3, 1, 3, 3, 2, 3, 3, 3};
        SortThreeUniqueNumber2 sortThreeUniqueNumber2 = new SortThreeUniqueNumber2();
        sortThreeUniqueNumber2.sortThreeUniqueNumber(nums);
    }

    // O(n) time | O(1) space
    public int[] sortThreeUniqueNumber(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int index = 0;

        while (index <= last) {
            if (nums[index] == 1) {
                swap(nums, index, first);
                first++;
                index++;
            }
            if (nums[index] == 2) {
                index++;
            }
            if (nums[index] == 3) {
                swap(nums, index, last);
                last--;
            }
        }

        return nums;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
