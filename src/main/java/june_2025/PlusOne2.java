package june_2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne2 {

    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};
//        int[] digits = {9};

        PlusOne2 plusOne2 = new PlusOne2();
        int[] result = plusOne2.plusOne(digits);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] plusOne(int[] digits) {
        // 9999 -> 10000
        // 4 9 9 10
        List<Integer> result = new ArrayList<>();
        digits[digits.length - 1]++;

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
           int digit = digits[i];
           int sum = digit + carry;
           result.add(sum % 10);
           carry = sum / 10;
        }
        if (carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }

}
