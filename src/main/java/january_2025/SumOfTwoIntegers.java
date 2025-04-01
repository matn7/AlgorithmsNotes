package january_2025;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b << 1);
            a ^= b;
            b = carry;
        }
        return a;
    }

}
