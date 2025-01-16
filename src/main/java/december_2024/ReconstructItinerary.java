package december_2024;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        // tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> itinerary = reconstructItinerary.findItinerary(tickets);
        System.out.println(itinerary);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> adj = new HashMap<>();
        tickets.sort((o1, o2) -> {
            if (o1.get(0).compareTo(o2.get(0)) == 0) {
                return o1.get(1).compareTo(o2.get(1));
            }
            return o1.get(0).compareTo(o2.get(0));
        });

        for (List<String> ticket : tickets) {
            adj.put(ticket.get(0), new ArrayList<>());
        }

        List<String> res = new ArrayList<>();
        res.add("JFK");

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.get(src).add(dst);
        }
        dfs("JFK", res, tickets, adj);
        return res;
    }

    private boolean dfs(String src, List<String> res, List<List<String>> tickets, Map<String, List<String>> adj) {
        if (res.size() == tickets.size() + 1) {
            return true;
        }
        if (!adj.containsKey(src)) {
            return false;
        }

        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = adj.get(src).remove(i);
            res.add(v);
            if (dfs(v, res, tickets, adj)) {
                return true;
            }
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }

}
