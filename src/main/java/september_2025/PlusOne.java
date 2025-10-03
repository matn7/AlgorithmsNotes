package september_2025;

public class PlusOne {

    public static void main(String[] args) {
//        int[] digits = {9, 9, 9, 9};

//        int[] digits = {1, 2, 3};
//        int[] digits = {4,3,2,1};

        int[] digits = {9};

        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(digits);
        System.out.println(ints);
    }

    // O(n) time | O(n) space
    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        digits[idx]++;

        // [10, 0, 0, 0]
        //  *
        // c = 1
        int carry = digits[idx] / 10; // 10 / 10 = 1
        while (carry > 0 && idx > 0) {
            digits[idx] = digits[idx] % 10; // 0
            idx--;
            digits[idx] += carry;
            carry = digits[idx] / 10;
        }
        if (carry > 0) {
            digits[idx] = digits[idx] % 10;
            int[] newRes = new int[digits.length + 1];
            for (int i = digits.length - 1; i >= 1; i--) {
                newRes[i] = digits[i - 1];
            }
            newRes[0] = carry;
            return newRes;
        }

        return digits;
    }

}
