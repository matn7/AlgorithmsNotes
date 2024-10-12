package udemy.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        int n = 8;
        int[] managers = {2, 2, 4, 6, -1, 4, 4, 5};
        int[] informtime = {0, 0, 4, 0, 7, 3, 6, 0};

        TimeNeededToInformAllEmployees timeNeeded = new TimeNeededToInformAllEmployees();
        timeNeeded.timeNeeded(n, managers, informtime, 4);
    }

    // O(n) time | O(n) space
    // O(v) time | O(v) space
    public int timeNeeded(int n, int[] managers, int[] informtime, int headId) {
        Map<Integer, Vertex> graphMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graphMap.put(i, new Vertex(i));
        }

        for (int i = 0; i < n; i++) {
            Vertex employee = graphMap.get(i);
            int employeeManager = managers[i];
            if (employeeManager != -1) {
                Vertex manager = graphMap.get(employeeManager);
                manager.addNeighbor(employee);
            }
            employee.informTime = informtime[i];
        }

        Vertex startVertex = graphMap.get(headId);
        Minutes numberOfMinutes = new Minutes(0);
        dfs(startVertex, 0, numberOfMinutes);
        return numberOfMinutes.numberOfMins;
    }

    private void dfs(Vertex vertex, int time, Minutes minutes) {
        if (vertex == null) {
            return;
        }
        int currTime = vertex.informTime + time;
        if (currTime > minutes.numberOfMins) {
            minutes.numberOfMins = currTime;
        }
        List<Vertex> neighbors = vertex.neighbors;
        for (Vertex neighbor : neighbors) {
            dfs(neighbor, currTime, minutes);
        }
    }

    class Minutes {
        int numberOfMins;

        public Minutes(int numberOfMins) {
            this.numberOfMins = numberOfMins;
        }
    }

    class Vertex {
        int id;
        int informTime;
        List<Vertex> neighbors = new ArrayList<>();
        public Vertex(int id) {
            this.id = id;
            this.informTime = 0;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Vertex neighbor) {
            this.neighbors.add(neighbor);
        }
    }

}
