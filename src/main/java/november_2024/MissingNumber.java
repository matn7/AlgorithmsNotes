package november_2024;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
//        int[] nums = {0, 1};

        MissingNumber missingNumber = new MissingNumber();
        int result = missingNumber.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i <= nums.length; i++) {
            num ^= i;
        }
        for (int n : nums) {
            num ^= n;
        }
        return num;
    }

    public int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            res += (i - nums[i]);
        }
        return res;
    }


}
