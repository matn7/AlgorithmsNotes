package april_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfSquareNumber {

    public static void main(String[] args) {
        int c = 13;

        SumOfSquareNumber sumOfSquareNumber = new SumOfSquareNumber();
        for (int i = 0; i <= c; i++) {
            System.out.print(sumOfSquareNumber.numSquares(i) + " ");
        }
    }

    // O(n*sqrt(n)) time | O(n) space
    public int numSquares(int c) {
        List<Integer> squares = new ArrayList<>();

        int i = 1;
        while (i * i <= c) {
            squares.add(i * i);
            i++;
        }

        int[] dp = new int[c + 1];
        Arrays.fill(dp, c);
        dp[0] = 0;

        for (int k = 0; k <= dp.length; k++) {
            for (int square : squares) {
                if (k + square < dp.length) {
                    dp[k + square] = Math.min(dp[k] + 1, dp[k + square]);
                }
            }
        }

        return dp[c];
    }

}
