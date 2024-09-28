package august_2024;

public class FindNonSuplicateNumberV2 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 3, 2};

        int number = findNumber(nums);
        System.out.println(number);
    }

    // O(n) time | O(1) space
    public static int findNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

}
