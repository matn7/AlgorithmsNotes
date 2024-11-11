package november_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> result = pascalTriangle.generate(5);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> temp = new ArrayList<>(result.get(result.size() - 1));
            temp.add(0, 0);
            temp.add(0);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < result.get(result.size() - 1).size() + 1; j++) {
                row.add(temp.get(j) + temp.get(j + 1));
            }
            result.add(row);
        }
        return result;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = Arrays.asList(1);
        result.add(oneRes);
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        if (numRows == 2) {
            return result;
        }
        int[][] dp = new int[numRows][numRows];
        for (int r = 0; r < numRows; r++) {
            dp[r][0] = 1;
            dp[r][r] = 1;
        }
        for (int r = 2; r < numRows; r++) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            for (int c = 1; c < r; c++) {
                dp[r][c] = dp[r-1][c-1] + dp[r-1][c];
                res.add(dp[r][c]);
            }
            res.add(1);
            result.add(res);
        }
        return result;
    }

}
