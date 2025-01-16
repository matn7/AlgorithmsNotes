package december_2024;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0, 1};
        MissingNumber missingNumber = new MissingNumber();
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            res += (i - nums[i]);
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int max = nums.length;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
        }
        int correctSum = 0;
        for (int i = 0; i <= max; i++) {
            correctSum += i;
        }
        return correctSum - currSum;
    }

}
