package november_2025;

public class MinimumCostsForTicket {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        MinimumCostsForTicket minimumCostsForTicket = new MinimumCostsForTicket();
        int result = minimumCostsForTicket.mincostTickets(days, costs);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            int idx = 0;
            int j = i;
            for (int d : new int[] {1, 7, 30}) {
                while (j < n && days[j] < days[i] + d) { // 8 +

                    j++;
                }
                dp[i] = Math.min(dp[i], costs[idx] + dp[j]);
                System.out.println(dp[i]);
                idx++;
            }
        }

        return dp[0];
    }

}
