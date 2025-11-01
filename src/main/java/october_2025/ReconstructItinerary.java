package october_2025;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK","SFO"),Arrays.asList("JFK","ATL"),
                Arrays.asList("SFO","ATL"),Arrays.asList("ATL","JFK"),Arrays.asList("ATL","SFO"));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> result = reconstructItinerary.findItinerary(tickets);
        System.out.println(result);
    }

    // O(v + e) time | o(v + e) space
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(a -> a.get(1)));
        Map<String, List<String>> adj = new HashMap<>();
        int count = tickets.size() + 1;

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            adj.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");

        String start = "JFK";
        if (backtrack(adj, start, count, result)) {
            return result;
        }
        return new ArrayList<>();
    }

    private boolean backtrack(Map<String, List<String>> adj, String node, int count, List<String> result) {
        if (result.size() == count) {
            return true;
        }
        if (!adj.containsKey(node)) {
            return false;
        }
        List<String> neighbors = adj.get(node);
        for (int i = 0; i < neighbors.size(); i++) {
            String nei = neighbors.get(i);
            adj.get(node).remove(i);
            result.add(nei);
            if (backtrack(adj, nei, count, result)) {
                return true;
            }

            adj.get(node).add(i, nei);
            result.remove(result.size() - 1);
        }
        return false;
    }

}
