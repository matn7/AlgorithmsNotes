package august_2024;

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
        List<Integer> nodes = findNodes(node, target, k);
        System.out.println(nodes);
    }


    // O(n) time | O(n) space
    public static List<Integer> findNodes(Node node, int target, int k) {
        Map<Integer, Node> parentsMap = new HashMap<>();
        generateParentsMap(node, null, parentsMap);

        Node targetNode = findTargetNode(parentsMap, target, node);

        return findNodesHelper(targetNode, k, parentsMap);
    }

    private static List<Integer> findNodesHelper(Node targetNode, int k, Map<Integer, Node> parentsMap) {
        List<Integer> result = new ArrayList<>();
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(0, targetNode));
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            NodeInfo info = queue.poll();
            Node current = info.node;
            int distance = info.distance;
            visited.add(current.value);
            if (distance == k) {
                while (!queue.isEmpty()) {
                    int pulled = queue.poll().node.value;
                    result.add(pulled);
                }
                result.add(current.value);
                break;
            }
            List<NodeInfo> neighbors = new ArrayList<>();
            if (current.left != null) {
                neighbors.add(new NodeInfo(distance + 1, current.left));
            }
            if (current.right != null) {
                neighbors.add(new NodeInfo(distance + 1, current.right));
            }
            Node parent = parentsMap.get(current.value);
            if (parent != null) {
                neighbors.add(new NodeInfo(distance + 1, parent));
            }
            for (NodeInfo neighbor : neighbors) {
                if (visited.contains(neighbor.node.value)) {
                    continue;
                }
                queue.add(neighbor);
            }
        }

        return result;
    }

    private static Node findTargetNode(Map<Integer, Node> parentsMap, int target, Node node) {
        Node parent = parentsMap.get(target);
        if (parent == null) {
            return node;
        }
        if (parent.left != null && parent.left.value == target) {
            return parent.left;
        }
        return parent.right;
    }

    private static void generateParentsMap(Node node, Node parent, Map<Integer, Node> parentsMap) {
        if (node == null) {
            return;
        }
        parentsMap.put(node.value, parent);
        generateParentsMap(node.left, node, parentsMap);
        generateParentsMap(node.right, node, parentsMap);
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
