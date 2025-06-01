package may_2025;

public class SumOfSquareNums2 {

    public static void main(String[] args) {
        SumOfSquareNums2 sumOfSquareNums2 = new SumOfSquareNums2();
        boolean result = sumOfSquareNums2.judgeSquareSum(5);
        System.out.println(result);
    }

    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);

        while (i <= j) {
            long sum = (long) i * i + (long) j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

}
