package november_2024;

import java.util.*;

public class ReconstructItinerary2 {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        ReconstructItinerary2 reconstructItinerary = new ReconstructItinerary2();
        List<String> itinerary = reconstructItinerary.findItinerary(tickets);
        System.out.println(itinerary);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Create the adjacency list
        Map<String, List<String>> adj = new HashMap<>();

        // Step 2: Sort tickets in reverse lexicographical order
        tickets.sort((a, b) -> b.get(0).compareTo(a.get(0)));  // sort by source and destination in reverse order

        // Step 3: Build the adjacency list
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dest = ticket.get(1);
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dest);
        }

        // Step 4: Result list to store the itinerary
        List<String> res = new ArrayList<>();

        // Step 5: Helper DFS function
        dfs("JFK", adj, res);

        // Step 6: Reverse the result to get the correct order
        Collections.reverse(res);

        return res;
    }

    // DFS function to explore the itinerary
    private void dfs(String src, Map<String, List<String>> adj, List<String> res) {
        // While there are destinations from the current city
        if (adj.containsKey(src)) {
            List<String> neighbors = adj.get(src);
            // Visit each destination in reverse lexicographical order
            while (!neighbors.isEmpty()) {
                String nextDest = neighbors.remove(neighbors.size() - 1);
                dfs(nextDest, adj, res);
            }
        }
        // Add the current source to the result list (backtracking step)
        res.add(src);
    }
}
