package june_2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[] {9, 9, 9};

        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(digits);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        digits[digits.length - 1]++;

        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i];
            int sum = num + carry;
            carry = sum / 10;
            res.add(sum % 10);
        }
        if (carry != 0) {
            res.add(carry);
        }
        Collections.reverse(res);

        return res.stream().mapToInt(a -> a).toArray();
    }

}
