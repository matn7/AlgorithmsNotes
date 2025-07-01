package june_2025;

import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        IPO ipo = new IPO();
        int maximizedCapital = ipo.findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
    }

    // O(n log(n)) time | O(n) space
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        for (int i = 0; i < capital.length; i++) {
            minCapital.add(i);
        }

        for (int i = 0; i < k; i++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.add(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += profits[maxProfit.poll()];
        }
        return w;
    }

}
