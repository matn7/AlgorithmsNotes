package october_2024;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(digits);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] plusOne(int[] digits) {

        int carry = 1;
        int idx = digits.length - 1;

        while (idx >= 0) {
            int current = digits[idx];
            int sum = current + carry;
            int val = sum % 10;
            carry = sum / 10;
            digits[idx] = val;
            idx--;
        }
        if (carry > 0) {
            // we has to resive
            int[] resized = new int[digits.length + 1];
            resized[0] = carry;
            System.arraycopy(digits, 0, resized, 1, digits.length);
            return resized;
        }

        return digits;
    }

    // O(n) time | O(n) space
    public int[] plusOneV2(int[] digits) {

        List<Integer> res = new ArrayList<>();
        for (int d : digits) {
            res.add(d);
        }

        int carry = 1;
        int idx = digits.length - 1;

        while (idx >= 0) {
            int current = res.get(idx);
            int sum = current + carry;
            int val = sum % 10;
            carry = sum / 10;
            res.set(idx, val);
            idx--;
        }
        if (carry > 0) {
            res.add(0, carry);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}
