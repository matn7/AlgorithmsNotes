package february_2025;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(numbers, target);
        System.out.println(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        int L = 0;
        int R = numbers.length - 1;
        int sum;
        while (L < R) {
            sum = numbers[L] + numbers[R];
            if (sum < target) {
                L++;
            } else if (sum > target) {
                R--;
            } else {
                return new int[] {L + 1, R + 1};
            }
        }
        return new int[] {};
    }

}
