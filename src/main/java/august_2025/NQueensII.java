package august_2025;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {

    public static void main(String[] args) {
        int n = 4;
        NQueensII nQueensII = new NQueensII();
        int result = nQueensII.totalNQueens(n);
        System.out.println(result);
    }

    // O(n!) time | O(n) space
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        return dfs(n, 0, cols, posDiag, negDiag);
    }

    private int dfs(int n, int r, Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (r == n) {
            return 1;
        }

        int res = 0;
        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            res += dfs(n, r + 1, cols, posDiag, negDiag);

            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
        return res;
    }

}
