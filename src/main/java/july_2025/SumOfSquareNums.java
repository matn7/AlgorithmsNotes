package july_2025;

public class SumOfSquareNums {

    public static void main(String[] args) {
        int c = 5;

        SumOfSquareNums sumOfSquareNums = new SumOfSquareNums();
        boolean result = sumOfSquareNums.judgeSquareSum(c);
        System.out.println(result);
    }

    // O(log(n)) time | O(n) space
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);

        while (i <= j) {
            long sum = (long) i * i + (long) j * j;

            if (sum == c) {
                return true;
            } else if (sum > c){
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
