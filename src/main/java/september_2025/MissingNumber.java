package september_2025;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min != 0) {
            return 0;
        }
        int expectedSum = 0;
        for (int i = min; i <= max; i++) {
            expectedSum += i;
        }
        int diff = expectedSum - sum;
        return diff == 0 ? max + 1 : diff;
    }

}
