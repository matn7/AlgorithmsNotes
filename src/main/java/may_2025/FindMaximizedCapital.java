package may_2025;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaximizedCapital {

    // O(k*log(n)) time | O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<int[]> minCapital = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                int p = minCapital.poll()[1];
                maxProfits.add(p);
            }
            if (maxProfits.isEmpty()) {
                return 0;
            }
            w += maxProfits.poll();
        }
        return w;
    }

}
