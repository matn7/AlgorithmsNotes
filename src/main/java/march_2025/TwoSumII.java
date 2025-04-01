package march_2025;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 7, 10, 11};
        int target = 9;

        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(numbers, target);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {-1, -1};
    }

}
