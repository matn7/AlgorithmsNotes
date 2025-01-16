package january_2025;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SJC"));
        tickets.add(List.of("LHR", "SFO"));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> result = reconstructItinerary.findItinerary(tickets);
        System.out.println(result);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.put(ticket.get(0), new ArrayList<>());
        }
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        result.add("JFK");
        if (dfs("JFK", adj, result, tickets.size() + 1)) {
            return result;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String source, Map<String, List<String>> adj, List<String> res, int targetLen) {
        if (res.size() == targetLen) {
            return true;
        }
        if (!adj.containsKey(source)) {
            return false;
        }
        List<String> neighbors = adj.get(source);
        for (int i = 0; i < neighbors.size(); i++) {
            String v = adj.get(source).remove(i);
            res.add(v);
            if (dfs(v, adj, res, targetLen)) {
                return true;
            }
            adj.get(source).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }



}
