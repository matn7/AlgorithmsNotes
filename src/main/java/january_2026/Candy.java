package january_2026;

import java.util.Arrays;

public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1, 2, 3, 4, 3, 1};

        Candy candy = new Candy();
        int result = candy.candy(ratings);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = 1 + dp[i - 1];
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], 1 + dp[i + 1]);
            }
        }
        int sum = 0;
        for (int num : dp) {
            sum += num;
        }

        return sum;
    }

}
