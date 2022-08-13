package whiteboard;

import java.util.*;

public class AirportsConnections {

    // O(a * (a + r) + a + r + alog(a)) time | O(a + r) space
    // rand: 08/08/2022
    public static int airportConnections(
            List<String> airports, List<List<String>> routes, String startingAirport) {
        // Write your code here.
        Map<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
        List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airportGraph, airports, startingAirport);
        markUnreachableConnections(airportGraph, unreachableAirportNodes);
        return getMinNumberOfNewConnections(airportGraph, unreachableAirportNodes);
    }

    // O(a + r) time | O(a + r) space
    private static Map<String, AirportNode> createAirportGraph(List<String> airports, List<List<String>> routes) {
        Map<String, AirportNode> airportGraph = new HashMap<>();
        for (String airport : airports) {
            airportGraph.put(airport, new AirportNode(airport));
        }
        for (List<String> route : routes) {
            String airport = route.get(0);
            String connection = route.get(1);
            airportGraph.get(airport).connections.add(connection);
        }
        return airportGraph;
    }

    // O(a + r) time | O(r) space
    private static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> airportGraph,
                                                                List<String> airports, String startingAirport) {
        Map<String, Boolean> visitedAirports = new HashMap<>();
        depthFirstTraverseAirport(airportGraph, startingAirport, visitedAirports);
        List<AirportNode> unreachableAirportNodes = new ArrayList<>();
        for (String airport : airports) {
            if (visitedAirports.containsKey(airport)) {
                continue;
            }
            AirportNode airportNode = airportGraph.get(airport);
            airportNode.isReachable = false;
            unreachableAirportNodes.add(airportNode);
        }
        return unreachableAirportNodes;
    }

    private static void depthFirstTraverseAirport(Map<String, AirportNode> airportGraph, String airport, Map<String, Boolean> visitedAirports) {
        if (visitedAirports.containsKey(airport)) {
            return;
        }
        visitedAirports.put(airport, Boolean.TRUE);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection : connections) {
            depthFirstTraverseAirport(airportGraph, connection, visitedAirports);
        }
    }

    // O(a * (a + r)) time | O(a) space
    private static void markUnreachableConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        for (AirportNode airportNode : unreachableAirportNodes) {
            String airport = airportNode.airport;
            List<String> unreachableConnections = new ArrayList<>();
            depthFirstUnreachableConnections(airportGraph, airport, unreachableConnections, new HashMap<>());
            airportNode.unreachableConnections.addAll(unreachableConnections);
        }
    }

    private static void depthFirstUnreachableConnections(Map<String, AirportNode> airportGraph, String airport,
                                                         List<String> unreachableConnections,
                                                         HashMap<String, Boolean> visitedAirports) {
        if (airportGraph.get(airport).isReachable) {
            return;
        }
        if (visitedAirports.containsKey(airport)) {
            return;
        }
        visitedAirports.put(airport, Boolean.TRUE);
        unreachableConnections.add(airport);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection : connections) {
            depthFirstUnreachableConnections(airportGraph, connection, unreachableConnections, visitedAirports);
        }
    }

    // O(a * log(a) + a + r) time | O(1) space
    private static int getMinNumberOfNewConnections(Map<String, AirportNode> airportGraph,
                                                    List<AirportNode> unreachableAirportNodes) {
        unreachableAirportNodes.sort(Comparator.comparingInt(a -> a.unreachableConnections.size()));
        Collections.reverse(unreachableAirportNodes);

        int numberOfNeConnections = 0;
        for (AirportNode airportNode : unreachableAirportNodes) {
            if (airportNode.isReachable) {
                continue;
            }
            numberOfNeConnections++;
            for (String connection : airportNode.unreachableConnections) {
                airportGraph.get(connection).isReachable = true;
            }
        }
        return numberOfNeConnections;
    }

    public static class AirportNode {
        String airport;
        List<String> connections;
        Boolean isReachable;
        List<String> unreachableConnections;

        public AirportNode(String airport) {
            this.airport = airport;
            this.connections = new ArrayList<>();
            this.isReachable = true;
            this.unreachableConnections = new ArrayList<>();
        }
    }

}
