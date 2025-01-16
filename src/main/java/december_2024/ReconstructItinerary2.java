package december_2024;

import java.util.*;

public class ReconstructItinerary2 {

    public static void main(String[] args) {
        // tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        ReconstructItinerary2 reconstructItinerary = new ReconstructItinerary2();
        List<String> itinerary = reconstructItinerary.findItinerary(tickets);
        System.out.println(itinerary);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            adj.put(ticket.get(0), new ArrayList<>());
        }
        tickets.sort(Comparator.comparing(a -> a.get(1)));

        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        if (dfs("JFK", res, adj, tickets.size() + 1)) {
            return res;
        }
        return new ArrayList<>();
    }

    private boolean dfs(String src, List<String> res, Map<String, List<String>> adj, int target) {
        if (res.size() == target) {
            return true;
        }
        if (!adj.containsKey(src)) {
            return false;
        }
        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = adj.get(src).remove(i);
            res.add(v);
            if (dfs(v, res, adj, target)) {
                return true;
            }
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }


}
