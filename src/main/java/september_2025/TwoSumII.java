package september_2025;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(numbers, target);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int num1 = numbers[l];
            int num2 = numbers[r];
            int sum = num1 + num2;
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[] {-1, -1};
    }

}
