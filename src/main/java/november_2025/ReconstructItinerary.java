package november_2025;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> result = reconstructItinerary.findItinerary2(tickets);
        // [JFK, SFO, ATL, JFK, ATL, SFO]
        // [JFK, ATL, JFK, SFO, ATL, SFO]
        System.out.println(result);

    }

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

    private void dfs(Map<String, PriorityQueue<String>> adj, String node, List<String> res) {
        PriorityQueue<String> queue = adj.get(node);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, res);
        }
        res.add(node);
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

        int size = tickets.size() + 1;
        if (dfs2("JFK", adj, res, size)) {
            return res;
        }
        return new ArrayList<>();
    }

    private boolean dfs2(String node, Map<String, List<String>> adj, List<String> res, int size) {
        if (res.size() == size) {
            return true;
        }
        if (!adj.containsKey(node)) {
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(node));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(node).remove(i);
            res.add(v);

            if (dfs2(v, adj, res, size)) {
                return true;
            }

            adj.get(node).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }

}
