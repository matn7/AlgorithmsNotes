package may_2024;

import java.util.ArrayList;
import java.util.List;

public class SumOfSquares {

    public static void main(String[] args) {
        int num = 13;

        squareSums(num);
    }

    // O(n*sqrt(n)) time | O(n) space
    public static int squareSums(int n) {
        List<Integer> squares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            squares.add(i * i);
            i++;
        }
        List<Integer> minSums = new ArrayList<>();
        for (int j = 0; j < n + 1; j++) {
            minSums.add(n);
        }
        minSums.set(0, 0);

        for (int k = 0; k < n + 1; k++) {
            for (Integer s : squares) {
                if (k + s < minSums.size()) {
                    minSums.set(k + s, Math.min(minSums.get(k + s), minSums.get(k) + 1));
                }
            }
            System.out.println();
        }
        return minSums.get(minSums.size() - 1);
    }

}
