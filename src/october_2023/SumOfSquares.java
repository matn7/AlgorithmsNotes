package october_2023;

import java.util.ArrayList;
import java.util.List;

public class SumOfSquares {

    public static void main(String[] args) {
        square_sums(13);
    }

    // O(n) time | O(n) space
    public static int square_sums(int n) {
        List<Integer> squares = new ArrayList<>();
        int i = 1;
        while (i * i <= n) {
            squares.add(i * i);
            i++;
        }
        List<Integer> min_sums = new ArrayList<>();
        for (int j = 0; j < n + 1; j++) {
            min_sums.add(n);
        }
        min_sums.set(0, 0);

        for (int k = 0; k < n + 1; k++) {
            for (Integer s : squares) {
                min_sums.set(k + s,
                        Math.min(min_sums.get(k + 1), min_sums.get(k) + 1));
            }
        }
        return min_sums.get(min_sums.size() - 1);
    }

}
