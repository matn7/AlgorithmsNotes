package july_2025;

public class TwoSumII2 {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        TwoSumII2 sum = new TwoSumII2();
        int[] result = sum.twoSum(numbers, target);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] {i + 1, j + 1};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[] {};
    }

}
