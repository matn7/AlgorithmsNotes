package january_2026;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    // O(klog(n)) time | O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < capital.length; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfits.add(minCapital.poll()[1]);
            }
            if (maxProfits.isEmpty()) {
                break;
            }
            w += maxProfits.poll();
        }

        return w;
    }


}
