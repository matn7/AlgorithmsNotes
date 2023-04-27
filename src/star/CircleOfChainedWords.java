package star;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleOfChainedWords {

    public static void main(String[] args) {
        String[] words = {"eggs", "apple", "snack", "karat", "tuna"};

        CircleOfChainedWords circleOfChainedWords = new CircleOfChainedWords();
        circleOfChainedWords.chainedWords(words);

    }

    // O(n) time | O(n) space
    public boolean chainedWords(String[] words) {

        Map<Character, Node> graphMap = prepareGraphMap(words);

        for (Map.Entry<Character, Node> elem : graphMap.entrySet()) {
            CycleInfo cycleInfo = new CycleInfo();
            Node node = elem.getValue();
            dfs(node, cycleInfo);
            if (cycleInfo.isCycle) {
                return true;
            }
        }
        return false;
    }

    private void dfs(Node node, CycleInfo cycleInfo) {
        if (node.visited) {
            cycleInfo.isCycle = false;
            return;
        }
        if (node.visiting) {
            cycleInfo.isCycle = true;
            return;
        }
        node.visiting = true;

        // logic
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            dfs(neighbor, cycleInfo);
        }

        node.visiting = false;
        node.visited = true;
    }

    private Map<Character, Node> prepareGraphMap(String[] words) {
        Map<Character, Node> nodesGraph = new HashMap<>();
        for (String word : words) {
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            nodesGraph.put(first, new Node(first, last));
        }
        for (String word : words) {
            char first = word.charAt(0);
            Node currNode = nodesGraph.get(first);
            char last = word.charAt(word.length() - 1);
            Node neighborNode = nodesGraph.get(last);
            currNode.addNode(neighborNode);
        }
        return nodesGraph;
    }

    static class CycleInfo {
        boolean isCycle;
    }

    static class Node {
        char first;
        char last;
        boolean visited;
        boolean visiting;
        List<Node> neighbors;

        public Node(char first, char last) {
            this.first = first;
            this.last = last;
            this.neighbors = new ArrayList<>();
        }

        public void addNode(Node n) {
            this.neighbors.add(n);
        }
    }

}
