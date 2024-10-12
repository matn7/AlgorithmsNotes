package november_2023;

import java.util.*;

public class FindNodesDistanceK {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        node.right.right.left = new Node(7);
        node.right.right.right = new Node(8);

        int target = 3;
        int k = 2;

        findNodes(node, target, k);
    }

    // O(n) time | O(n) space
    public static List<Integer> findNodes(Node node, int target, int k) {
        Map<Integer, Node> parentsMap = new HashMap<>();
        getParentsMap(node, null, parentsMap);

        Node targetNode = getTargetNode(node, target, parentsMap);

        return findNodesHelper(node, targetNode, k, parentsMap);
    }

    private static List<Integer> findNodesHelper(Node node, Node targetNode, int k, Map<Integer, Node> parentsMap) {
        List<Integer> result = new ArrayList<>();

        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(targetNode, 0));
        Set<Integer> seen = new HashSet<>();

        while (!queue.isEmpty()) {
            NodeInfo currentInfo = queue.poll();
            Node currentNode = currentInfo.node;
            if (seen.contains(currentNode.value)) {
                continue;
            }
            seen.add(currentNode.value);
            int currentDistance = currentInfo.distance;
            if (currentDistance == k) {
                while (!queue.isEmpty()) {
                    int value = queue.poll().node.value;
                    if (value == targetNode.value) {
                        continue;
                    }
                    result.add(value);
                }
                result.add(currentNode.value);
                break;
            }
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
                queue.add(new NodeInfo(neighbor, currentDistance + 1));
            }

        }

        return result;
    }

    private static Node getTargetNode(Node node, int target, Map<Integer, Node> parentsMap) {
        Node parent = parentsMap.get(target);
        if (parent == null) {
            return node;
        }
        if (parent.left != null && parent.left.value == target) {
            return parent.left;
        }
        return parent.right;
    }

    private static void getParentsMap(Node node, Node parent, Map<Integer, Node> parentsMap) {
        if (node == null) {
            return;
        }
        parentsMap.put(node.value, parent);
        getParentsMap(node.left, node, parentsMap);
        getParentsMap(node.right, node, parentsMap);
    }

    static class NodeInfo {
        Node node;
        int distance;

        public NodeInfo(Node node, int distance) {
            this.node = node;
            this.distance = distance;
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
