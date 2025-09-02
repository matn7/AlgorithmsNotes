package august_2025;

import java.util.*;

public class ReconstructItinerary {

    // O(E log(E)) time | O(E) space
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

    // O(V + E) time | O(V + E) space
    public List<String> findItinerary2(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.put(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");

        if (dfs2("JFK", adj, tickets.size() + 1, res)) {
            return res;
        }

        return new ArrayList<>();
    }

    private boolean dfs2(String source, Map<String, List<String>> adj, int targetLen, List<String> res) {
        if (res.size() == targetLen) {
            return true;
        }

        if (!adj.containsKey(source)) {
            return false;
        }

        List<String> neighbors = adj.get(source);
        for (int i = 0; i < neighbors.size(); i++) {
            String nei = neighbors.get(i);
            adj.get(source).remove(i);
            res.add(nei);
            if (dfs2(nei, adj, targetLen, res)) {
                return true;
            }
            adj.get(source).add(i, nei);
            res.remove(nei);
        }
        return false;
    }

}
