package october_2025;

public class MissingNumber {

    public static void main(String[] args) {
//        int[] nums = {9,6,4,2,3,5,7,0,1};
//        int[] nums = {0,1};
        int[] nums = {3,0,1};
        MissingNumber missingNumber = new MissingNumber();
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int missingNumber(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min != 0) {
            return 0;
        }
        int expected = 0;
        for (int i = 0; i <= max; i++) {
            expected += i;
        }
        if (expected == sum) {
            return max + 1;
        }
        return expected - sum;
    }

}
