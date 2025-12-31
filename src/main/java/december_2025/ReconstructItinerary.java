package december_2025;

import java.util.*;

public class ReconstructItinerary {

    // O(e * log(e)) time | O(e) space
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).add(dst);
        }
        List<String> res = new ArrayList<>();

        dfs(adj, "JFK", res);

        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String src, List<String> res) {
        PriorityQueue<String> queue = adj.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, res);
        }
        res.add(src);
    }


    // O(v * e) time | O(v * e) space
    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");

        if (dfs2("JFK", res, adj, tickets.size() + 1)) {
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs2(String src, List<String> res, Map<String, List<String>> adj, int targetLen) {
        if (res.size() == targetLen) {
            return true;
        }
        if (!adj.containsKey(src)) {
            return false;
        }
        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            if (dfs2(v, res, adj, targetLen)) {
                return true;
            }
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }

}
