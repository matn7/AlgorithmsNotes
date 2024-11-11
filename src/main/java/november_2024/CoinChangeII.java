package november_2024;

public class CoinChangeII {


    public static void main(String[] args) {
        CoinChangeII coinChangeII = new CoinChangeII();
        int amount = 5;
        int[] coins = {1, 2, 5};
        int change = coinChangeII.change(amount, coins);
        System.out.println(change);
    }

    public int change(int amount, int[] coins) {

        int[][] matrix = new int[coins.length + 1][amount + 1];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r][0] = 1;
        }
        for (int c = 0; c < matrix[0].length; c++) {
            matrix[matrix.length - 1][c] = 0;
        }

        for (int r = matrix.length - 2; r >= 0; r--) {
            int coin = coins[r];
            for (int c = 1; c < matrix[r].length; c++) {
                int sum = c - coin;
                if (sum < 0) {
                    sum = 0;
                } else {
                    sum = matrix[r][sum];
                }
                matrix[r][c] = sum + matrix[r + 1][c];
            }
        }

        return matrix[0][matrix[0].length - 1];
    }

}
