package july_2025;

public class SumTwoIntegers {

    public static void main(String[] args) {
        SumTwoIntegers sumTwoIntegers = new SumTwoIntegers();
        int result = sumTwoIntegers.getSum(1, 2);
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
