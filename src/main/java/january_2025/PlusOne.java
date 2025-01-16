package january_2025;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(new int[]{9, 8, 9});
        System.out.println(ints);
    }

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int sum = 1;

        List<Integer> result = new ArrayList<>();

        for (int i = digits.length - 1; i >= 0; i--) {
            int curr = sum + digits[i] + carry;
            int number = curr % 10;
            carry = curr / 10;
            result.add(number);
            sum = 0;
        }
        if (carry != 0) {
            result.add(carry);
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(result.size() - 1 - i);
        }
        return res;
    }

}
