package november_2024;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> itinerary = reconstructItinerary.findItinerary(tickets);
        System.out.println(itinerary);
    }

    // O(E^2) time | O(E) space
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();

        Collections.sort(tickets, Comparator.comparing((List<String> a) -> a.get(0))
                .thenComparing(a -> a.get(1)));
        for (List<String> ticket : tickets) {
            adj.put(ticket.get(0), new ArrayList<>());
        }

        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs("JFK", tickets, res, adj);
        return res;
    }

    private boolean dfs(String src, List<List<String>> tickets, List<String> res, Map<String, List<String>> adj) {
        if (res.size() == tickets.size() + 1) {
            return true;
        }
        if (!adj.containsKey(src)) {
            return false;
        }

        List<String> neighbors = adj.get(src);
        List<String> temp = new ArrayList<>(neighbors);
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);

            if (dfs(v, tickets, res, adj)) {
                return true;
            }

            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }

}
