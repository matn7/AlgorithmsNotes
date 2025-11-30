package november_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO2 {

    // O(n log(n)) time | O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < capital.length; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && w >= minCapital.peek()[0]) {
                maxProfit.add(minCapital.poll()[1]);
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll();
        }

        return w;
    }

}
