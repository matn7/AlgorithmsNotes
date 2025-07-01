package june_2025;

import java.util.*;

public class FindItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));

        FindItinerary findItinerary = new FindItinerary();
        List<String> result = findItinerary.findItinerary(tickets);
        System.out.println(result);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        tickets.sort(Comparator.comparing(a -> a.get(1)));

        for (List<String> ticket : tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if (!adj.containsKey(source)) {
                adj.put(source, new ArrayList<>());
            }
            if (!adj.containsKey(destination)) {
                adj.put(destination, new ArrayList<>());
            }
            adj.get(source).add(destination);
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");

        if (dfs("JFK", adj, tickets.size() + 1,  result)) {
            return result;
        }

        return new ArrayList<>();
    }

    private boolean dfs(String source, Map<String, List<String>> adj, int targetLen, List<String> result) {
        if (result.size() == targetLen) {
            return true;
        }
        if (!adj.containsKey(source)) {
            return false;
        }
        List<String> temp = new ArrayList<>(adj.get(source));
        for (int i = 0; i < temp.size(); i++) {
            String vertex = temp.get(i);
            adj.get(source).remove(i);
            result.add(vertex);
            if (dfs(vertex, adj, targetLen, result)) {
                return true;
            }
            adj.get(source).add(i, vertex);
            result.remove(result.size() - 1);
        }
        return false;
    }

}
