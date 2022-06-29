package educative.dynamicprogramming;

public class Knapsack {

    // O(n * c) time | O(n * c) space
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                profit2 = dp[i - 1][c];
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);

        return dp[n - 1][capacity];
    }

    private void printSelectedElements(int[][] dp, int[] weights, int[] profits, int capacity) {
        System.out.println("Selected weights:");
        int totalProfit = dp[weights.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0) {
            System.out.print(" " + weights[0]);
        }
        System.out.println("");
    }

//    // O(n * c) time | O(n * c) space
//    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
//        Integer[][] dp = new Integer[profits.length][capacity + 1];
//        return knapsackRecursive(dp, profits, weights, capacity, 0);
//    }
//
//    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
//        if (capacity <= 0 || currentIndex >= profits.length) {
//            return 0;
//        }
//
//        if (dp[currentIndex][capacity] != null) {
//            return dp[currentIndex][capacity];
//        }
//
//        int profit1 = 0;
//        if (weights[currentIndex] <= capacity) {
//            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
//                    capacity - weights[currentIndex], currentIndex + 1);
//        }
//
//        // recursive call after excluding the element at the currentIndex
//        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
//
//        dp[currentIndex][capacity] = Math.max(profit1, profit2);
//        return dp[currentIndex][capacity];
//    }

//    // O(2^n) time | O(n) space
//    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
//        return knapsackRecursive(profits, weights, capacity, 0);
//    }
//
//    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
//        if (capacity <= 0 || currentIndex >= profits.length) {
//            return 0;
//        }
//
//        int profit1 = 0;
//        if (weights[currentIndex] <= capacity) {
//            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
//                    capacity - weights[currentIndex], currentIndex + 1);
//        }
//
//        // recursive call after excluding the element at the currentIndex
//        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
//
//        return Math.max(profit1, profit2);
//    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

}

