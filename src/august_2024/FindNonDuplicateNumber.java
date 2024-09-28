package august_2024;

public class FindNonDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 3, 2};

        int result = nonDuplicate(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int nonDuplicate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }

}
