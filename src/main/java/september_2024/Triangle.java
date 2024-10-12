package september_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        Triangle triangle1 = new Triangle();
//        triangle1.minimumTotal(triangle);

        triangle1.minimumTotal2(triangle);
    }

    // O(n^2) time | O(n) space
    public int minimumTotal2(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for (int row = triangle.size() - 1; row >= 0; row--) {
            List<Integer> rows = triangle.get(row);
            for (int i = 0; i < rows.size(); i++) {
                int n = rows.get(i);
                dp[i]  = n + Math.min(dp[i], dp[i + 1]);
            }
        }
        return dp[0];
    }

    // O(n*m) time | O(n*m) space
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] input = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int row = 0; row < triangle.size(); row++) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                input[row][col] = triangle.get(row).get(col);
            }
        }

        int[][] cache = new int[input.length][input[0].length];
        for (int row = 0; row < cache.length; row++) {
            Arrays.fill(cache[row], Integer.MAX_VALUE);
        }
        cache[0][0] = input[0][0];
        int c = 1;
        for (int row = 1; row < input.length; row++) {
            cache[row][0] = Math.min(cache[row][0], cache[row - 1][0] + input[row][0]);
            cache[row][c] = Math.min(cache[row][c], cache[row - 1][c - 1] + input[row][c]);
            c++;
        }

        for (int row = 2; row < input.length; row++) {
            for (int col = 1; col < row; col++) {
                cache[row][col] = Math.min(cache[row][col],
                        Math.min(input[row][col] + cache[row - 1][col - 1], input[row][col] + cache[row - 1][col]));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int col = 0; col < cache[0].length; col++) {
            min = Math.min(min, cache[cache.length - 1][col]);
        }

        return min;
    }

}
