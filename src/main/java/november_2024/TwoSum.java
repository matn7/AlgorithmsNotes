package november_2024;

public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;

        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(numbers, target);
        System.out.println();
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int a = numbers[start];
            int b = numbers[end];
            int sum = a + b;
            if (sum == target) {
                return new int[] {start, end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return null;
    }

}
