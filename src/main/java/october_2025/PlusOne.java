package october_2025;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};

        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(digits);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] plusOne(int[] digits) {
        int r = digits.length - 1;
        digits[r]++;

        int carry = digits[r] / 10;
        while (carry > 0 && r > 0) {
            digits[r] = digits[r] % 10;
            r--;
            digits[r] += carry;
            carry = digits[r] / 10;
        }
        if (carry > 0) {
            digits[r] = digits[r] % 10;
            int[] result = new int[digits.length + 1];
            int idx = result.length - 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                result[idx] = digits[i];
                idx--;
            }
            result[0] = carry;
            return result;
        }
        return digits;
    }

}
