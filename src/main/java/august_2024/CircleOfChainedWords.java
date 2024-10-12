package august_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleOfChainedWords {

    public static void main(String[] args) {
        String[] words = {"eggs", "applp", "snack", "karat", "tuna"};

        boolean circle = circle(words);
        System.out.println(circle);
    }

    public static boolean circle(String[] words) {
        if (words.length == 0) {
            return false;
        }
        Map<Character, Node> graph = new HashMap<>();
        for (String word : words) {
            char firstChar = word.charAt(0);
            graph.put(firstChar, new Node(firstChar, word));
        }
        for (String word : words) {
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);
            Node firstNode = graph.get(firstChar);
            Node lastNode = graph.get(lastChar);
            firstNode.addNeighbor(lastNode);
        }
        Node startNode = graph.get(words[0].charAt(0));
        return isCircle(startNode);
    }

    private static boolean isCircle(Node node) {
        if (node == null) {
            return false;
        }
        if (node.visiting) {
            return true;
        }
        if (node.visited) {
            return false;
        }
        node.visiting = true;
        List<Node> neighbors = node.neighbors;
        boolean ret = false;
        for (Node neighbor : neighbors) {
            if (isCircle(neighbor)) {
                ret = true;
                break;
            }
        }
        node.visiting = false;
        node.visited = true;
        return ret;
    }

    static class Node {
        char id;
        String name;
        List<Node> neighbors;
        boolean visited;
        boolean visiting;

        public Node(char id, String name) {
            this.id = id;
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
