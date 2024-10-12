package august_2024;

import java.net.Inet4Address;
import java.util.*;

public class FindNodesDistanceKV2 {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        node.right.right.left = new Node(7);
        node.right.right.right = new Node(8);

        List<Integer> nodes = nodesDistanceK(node, 3, 3);
        System.out.println(nodes);

    }

    // O(n) time | O(n) space
    public static List<Integer> nodesDistanceK(Node node, int target, int k) {
        if (k < 0) {
            throw new RuntimeException("Distance must be a positive number.");
        }

        // 1. Get nodes parents
        Map<Integer, Node> parentsMap = new HashMap<>();
        populateParentsMap(node, null, parentsMap);
        // 2. Get target node
        Node targetNode = getTargetNode(target, parentsMap, node);
        // 3. Find nodes at distance
        return findNodes(targetNode, parentsMap, k);
    }

    private static List<Integer> findNodes(Node targetNode, Map<Integer, Node> parentsMap, int k) {
        List<Integer> result = new ArrayList<>();

        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(0, targetNode));
        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            NodeInfo info = queue.poll();
            Node currentNode = info.node;
            int currentDistance = info.distance;

            if (currentDistance == k) {
                result.add(currentNode.value);
                while (!queue.isEmpty()) {
                    NodeInfo polled = queue.poll();
                    result.add(polled.node.value);
                }
                break;
            }
            seen.add(currentNode.value);
            List<Node> neighbors = new ArrayList<>();
            if (currentNode.left != null) {
                neighbors.add(currentNode.left);
            }
            if (currentNode.right != null) {
                neighbors.add(currentNode.right);
            }
            Node parent = parentsMap.get(currentNode.value);
            if (parent != null) {
                neighbors.add(parent);
            }

            for (Node neighbor : neighbors) {
                if (seen.contains(neighbor.value)) {
                    continue;
                }
                queue.add(new NodeInfo(currentDistance + 1, neighbor));
            }
        }


        return result;
    }

    private static Node getTargetNode(int target, Map<Integer, Node> parentsMap, Node node) {
        Node parentNode = parentsMap.get(target);
        if (parentNode == null) {
            return node;
        }
        if (parentNode.left != null && parentNode.left.value == target) {
            return parentNode.left;
        }
        return parentNode.right;
    }

    private static void populateParentsMap(Node node, Node parent, Map<Integer, Node> parentsMap) {
        if (node == null) {
            return;
        }
        parentsMap.put(node.value, parent);
        populateParentsMap(node.left, node, parentsMap);
        populateParentsMap(node.right, node, parentsMap);
    }

    static class NodeInfo {
        int distance;
        Node node;

        public NodeInfo(int distance, Node node) {
            this.distance = distance;
            this.node = node;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
