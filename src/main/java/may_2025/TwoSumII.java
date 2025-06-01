package may_2025;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;

        TwoSumII twoSumII = new TwoSumII();
        int[] result = twoSumII.twoSum(numbers, target);
        System.out.println(result[0] + " : " + result[1]);
    }

    // O(n) time | O(1) space
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (target > sum) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {};
    }


}
