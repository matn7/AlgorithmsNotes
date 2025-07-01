package june_2025;

public class SumOfTwoIntegers2 {

    // O(1) time | O(1) space
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

}
