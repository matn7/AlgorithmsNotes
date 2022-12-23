package udemy.leetcode;

public class CountEvenDigitsNumbers {

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        CountEvenDigitsNumbers countEvenDigitsNumbers = new CountEvenDigitsNumbers();
        int digits = countEvenDigitsNumbers.findNumbers(nums);
        System.out.println(digits);
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int n = 0;
            while (num > 0) {
                n++;
                num = num / 10;
            }
            if (n % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
