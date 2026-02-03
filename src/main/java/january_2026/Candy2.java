package january_2026;

import java.util.Arrays;

public class Candy2 {

    public static void main(String[] args) {
        int[] ratings = {1, 2, 3, 4, 3, 1};

        Candy2 candy2 = new Candy2();
        int candy = candy2.candy(ratings);
        System.out.println(candy);
    }

    // O(n) time | O(n) space
    public int candy(int[] ratings) {
        int[] dp = new int[ratings.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int num : dp) {
            sum += num;
        }
        return sum;
    }

}
