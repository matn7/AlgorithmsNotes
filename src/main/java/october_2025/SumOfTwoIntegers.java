package october_2025;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        int result = sumOfTwoIntegers.getSum(a, b);
        System.out.println(result);
    }

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
