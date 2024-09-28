package problems.other;

import java.util.ArrayList;
import java.util.List;

public class SumOfSquares {

    public static void main(String[] args) {
        int num = 13;

        SumOfSquares sumOfSquares = new SumOfSquares();
        int result = sumOfSquares.square_sums(num);
        System.out.println(result);
    }

    // O(n * sqrt(n)) time | O(n) space
    public int square_sums(int n) {
        List<Integer> squares = new ArrayList<>();

        int i = 1;
        while (i * i <= n) {
            squares.add(i*i);
            i++;
        }

        List<Integer> min_sums = new ArrayList<>();
        for (int j = 0; j < n+1; j++) {
            min_sums.add(n);
        }
        min_sums.set(0, 0);

        for (int k = 0; k < n + 1; k++) {
            for (Integer s : squares) {
                if (k + s < min_sums.size()) {
                    min_sums.set(k + s, Math.min(min_sums.get(k + s), min_sums.get(k) + 1));
                }
            }
        }

        return min_sums.get(min_sums.size() - 1);
    }

}
