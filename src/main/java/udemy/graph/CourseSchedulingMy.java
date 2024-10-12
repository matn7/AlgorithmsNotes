package udemy.graph;

import java.util.*;

public class CourseSchedulingMy {

    public static void main(String[] args) {
        List<String> courses = new ArrayList<>(Arrays.asList("CS101", "CS102", "CS103", "CS104", "CS105",
                "CS106", "CS107"));
        Map<String, List<String>> prereqs = new HashMap<>();
        prereqs.put("CS101", new ArrayList<>(Arrays.asList("CS102", "CS103", "CS105")));
        prereqs.put("CS104", new ArrayList<>(Arrays.asList("CS105")));
        prereqs.put("CS105", new ArrayList<>(Arrays.asList("CS107")));

        courseScheduling(courses, prereqs);

    }

    public static List<String> courseScheduling(List<String> courses, Map<String, List<String>> prereqs) {
        Map<String, Node> graphMap = new HashMap<>();
        for (String course : courses) {
            graphMap.put(course, new Node(course));
        }
        
        for (Map.Entry<String, List<String>> prereq : prereqs.entrySet()) {
            String nodeKey = prereq.getKey();
            List<String> nodePrereqs = prereq.getValue();
            Node currentNode = graphMap.get(nodeKey);
            for (String pre : nodePrereqs) {
                Node prereqNode = graphMap.get(pre);
                currentNode.addNeighbor(prereqNode);
                prereqNode.degree += 1;
            }
        }

        List<String> result = new ArrayList<>();
        List<Node> zeroInDegList = new ArrayList<>();
        for (Map.Entry<String, Node> graphNode : graphMap.entrySet()) {
            Node currentNode = graphNode.getValue();
            if (currentNode.degree == 0) {
                zeroInDegList.add(currentNode);
            }
        }

        while (!zeroInDegList.isEmpty()) {
            Node currentNode = zeroInDegList.remove(0);
            result.add(currentNode.id);
            Set<Node> neighbors = currentNode.neighbors;
            for (Node neighbor : neighbors) {
//                currentNode.neighbors.remove(neighbor);
                neighbor.degree -= 1;
                if (neighbor.degree == 0) {
                    zeroInDegList.add(neighbor);
                }
            }
        }

        return result;
    }

    public static class Node {
        String id;
        int degree;
        Set<Node> neighbors;

        public Node(String id) {
            this.id = id;
            this.degree = 0;
            this.neighbors = new HashSet<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
