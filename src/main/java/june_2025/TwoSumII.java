package june_2025;

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
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int num1 = numbers[i];
            int num2 = numbers[j];
            int sum = num1 + num2;

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[] {i, j};
            }
        }
        return new int[] {};
    }


}
