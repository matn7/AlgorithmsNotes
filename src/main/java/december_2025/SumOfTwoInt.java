package december_2025;

public class SumOfTwoInt {

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
