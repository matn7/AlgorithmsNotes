package august_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    // O(k * log(n)) time | O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[1] - b[1]); // [capital, profit]

        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {

            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                int[] current = minCapital.poll();
                int c = current[0];
                int p = current[1];
                maxProfit.add(p);
            }

            if (maxProfit.isEmpty()) {
                break;
            }

            w += maxProfit.poll();
        }
        return w;
    }

}
