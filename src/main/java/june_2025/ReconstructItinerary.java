package june_2025;

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
        List<String> itinerary = reconstructItinerary.findItinerary(tickets);
        System.out.println(itinerary);

    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, Comparator.comparing(a -> a.get(1)));

        Map<String, List<String>> adj = new HashMap<>();
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
        if (backtrack(adj, "JFK", result, tickets.size() + 1)) {
            return result;
        }
        return new ArrayList<>();
    }

    private boolean backtrack(Map<String, List<String>> adj, String source, List<String> result, int totalTickets) {
        if (result.size() == totalTickets) {
            return true;
        }

        if (!adj.containsKey(source)) {
            return false;
        }

        List<String> neighbors = new ArrayList<>(adj.get(source));

        for (int i = 0; i < neighbors.size(); i++) {
            String ticket = neighbors.get(i);
            adj.get(source).remove(i);
            result.add(ticket);
            if (backtrack(adj, ticket, result, totalTickets)) {
                return true;
            }
            adj.get(source).add(i, ticket);
            result.remove(result.size() - 1);
        }
        return false;
    }

}
