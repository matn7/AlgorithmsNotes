package june_2025;

public class MissingNumber2 {

    public static void main(String[] args) {
//        int[] nums = {9,6,4,2,3,5,7,0,1};
        int[] nums = {0, 1};

        MissingNumber2 missingNumber2 = new MissingNumber2();
        int result = missingNumber2.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }
        if (min != 0) {
            return 0;
        }
        int theorySum = 0;
        for (int i = 0; i <= max; i++) {
            theorySum += i;
        }
        if (sum == theorySum) {
            return max + 1;
        }
        return theorySum - sum;
    }
}
