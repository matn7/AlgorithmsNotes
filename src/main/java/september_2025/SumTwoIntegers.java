package september_2025;

public class SumTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

}
