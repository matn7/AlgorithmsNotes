package problems.veryhard;

import java.util.*;

public class AirportConnections {

    public static void main(String[] args) {
        List<String> airports = new ArrayList<>(Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND",
                "ICN", "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"));
        String[][] routesStr = {
                {"DSM", "ORD"},
                {"ORD", "BGI"},
                {"BGI", "LGA"},
                {"SIN", "CDG"},
                {"CDG", "SIN"},
                {"CDG", "BUD"},
                {"DEL", "DOH"},
                {"DEL", "CDG"},
                {"TLV", "DEL"},
                {"EWR", "HND"},
                {"HND", "ICN"},
                {"HND", "JFK"},
                {"ICN", "JFK"},
                {"JFK", "LGA"},
                {"EYW", "LHR"},
                {"LHR", "SFO"},
                {"SFO", "SAN"},
                {"SFO", "DSM"},
                {"SAN", "EYW"}
        };

        List<List<String>> routes = new ArrayList<>();
        for (String[] element : routesStr) {
            routes.add(Arrays.asList(element[0], element[1]));
        }

        String startingAirport = "LGA";

        int result = airportConnections(airports, routes, startingAirport);
        System.out.println(result);
    }

    // O(a * (a + r) + a + r + alog(a)) time | O(a + r) space
    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
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

    // O(a + r) time | O(a) space
    private static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> airportGraph, List<String> airports,
                                                   String startingAirport) {
        Map<String, Boolean> visitedAirports = new HashMap<>();

        depthFirstTraverseAirports(airportGraph, startingAirport, visitedAirports);

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

    private static void depthFirstTraverseAirports(Map<String, AirportNode> airportGraph, String airport,
                                                   Map<String, Boolean> visitedAirports) {
        if (visitedAirports.containsKey(airport)) {
            return;
        }
        visitedAirports.put(airport, Boolean.TRUE);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection : connections) {
            depthFirstTraverseAirports(airportGraph, connection, visitedAirports);
        }
    }

    // O(a * (a + r)) time | O(a) space
    private static void markUnreachableConnections(Map<String, AirportNode> airportGraph,
                                                   List<AirportNode> unreachableAirportNodes) {
        Map<String, Boolean> visitedAirports = new HashMap<>();
        for (AirportNode airportNode : unreachableAirportNodes) {
            String airport = airportNode.airport;
            List<String> unreachableConnections = new ArrayList<>();
            depthFirstAddUnreachableConnections(airportGraph, airport, unreachableConnections, visitedAirports);
            airportNode.unreachableConnections.addAll(unreachableConnections);
        }
    }

    private static void depthFirstAddUnreachableConnections(Map<String, AirportNode> airportGraph, String airport,
            List<String> unreachableConnections, Map<String, Boolean> visitedAirports) {
        if (airportGraph.get(airport).isReachable) {
            return; // we only care about unreachable connections
        }
        if (visitedAirports.containsKey(airport)) {
            return;
        }
        visitedAirports.put(airport, Boolean.TRUE);
        unreachableConnections.add(airport);
        List<String> connections = airportGraph.get(airport).connections;
        for (String connection : connections) {
            depthFirstAddUnreachableConnections(airportGraph, connection, unreachableConnections, visitedAirports);
        }
    }

    // O(alog(a) + a + r) time | O(1) space
    private static int getMinNumberOfNewConnections(Map<String, AirportNode> airportGraph,
                                                    List<AirportNode> unreachableAirportNodes) {
        Collections.sort(unreachableAirportNodes, Comparator.comparingInt(a -> a.unreachableConnections.size()));
        Collections.reverse(unreachableAirportNodes); //

        int numberOfNewConnections = 0;
        for (AirportNode airportNode : unreachableAirportNodes) {
            if (airportNode.isReachable) {
                continue;
            }
            numberOfNewConnections += 1;
            for (String connection : airportNode.unreachableConnections) {
                airportGraph.get(connection).isReachable = true;
            }
        }

        return numberOfNewConnections;
    }

    static class AirportNode {
        String airport;
        List<String> connections = new ArrayList<>();
        Boolean isReachable = true;
        List<String> unreachableConnections = new ArrayList<>();

        public AirportNode(String airport) {
            this.airport = airport;
        }
    }

}


















