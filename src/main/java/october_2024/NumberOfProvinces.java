package october_2024;

import java.util.*;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0}, {0,1,0}, {0,0,1}};

        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int circleNum = numberOfProvinces.findCircleNum(isConnected);
        System.out.println(circleNum);
    }


    // leetcode 547

    // O(v + e) time | O(v) space
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            graph.put(i, new Node(i));
        }

        for (int i = 0; i < isConnected.length; i++) {
            int[] connect = isConnected[i];
            Node currNode = graph.get(i);
            for (int j = 0; j < connect.length; j++) {
                if (j == i) {
                    continue;
                }
                Node neighborNode = graph.get(j);
                if (connect[j] == 1) {
                    currNode.addNeighbor(neighborNode);
                    if (currNode.prev != null) {
                        neighborNode.prev = currNode;
                    }
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                count++;
                Node node = graph.get(i);
                dfs(node, visited);
            }
        }

        return count;
    }

    private void dfs(Node node, Set<Integer> visited) {
        if (visited.contains(node.idx)) {
            return;
        }
        visited.add(node.idx);
        Node prev = node.prev;
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (prev != neighbor) {
                dfs(neighbor, visited);
            }
        }
    }

    static class Node {
        int idx;
        Node prev;
        List<Node> neighbors;

        public Node(int idx) {
            this.idx = idx;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
