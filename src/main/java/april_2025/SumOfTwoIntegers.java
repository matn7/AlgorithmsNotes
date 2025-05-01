package april_2025;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        int result = sumOfTwoIntegers.getSum(9, 11);
        System.out.println(result);
    }

    // O(1) time | O(1) space
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }

}
