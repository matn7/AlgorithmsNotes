package april_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    // O(k*log(n)) time | O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<int[]> minCapital = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                int[] poll = minCapital.poll();
                maxProfit.add(poll[1]);
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll();
        }

        return w;
    }

}
