package august_2024;

public class SortingThreeUniqueNumbersV2 {

    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 1, 3, 2, 1};

        sort(nums);
        System.out.println(nums);
    }

    public static int[] sort(int[] nums) {

        //  0  1  2  3  4  5  6
        // [3, 3, 2, 1, 3, 2, 1]
        //  s                 e
        //  i
        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (index <= end) {
            if (nums[index] == 1) {
                swap(nums, index, start);
                start++;
                index++;
            } else if (nums[index] == 3) {
                swap(nums, index, end);
                end--;
            } else {
                index++;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
