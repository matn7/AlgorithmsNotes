package january_2024;


import java.util.Stack;

public class CloneTrees {

    public static void main(String[] args) {
        Node nodeA = new Node(1);
        nodeA.left = new Node(2);
        nodeA.right = new Node(3);
        nodeA.right.left = new Node(4);
        nodeA.right.right = new Node(5);

        Node nodeB = new Node(1);
        nodeB.left = new Node(2);
        nodeB.right = new Node(3);
        nodeB.right.left = nodeA.right.left;
        nodeB.right.right = new Node(5);

        Node node = nodeA.right.left;

        Node node1 = cloneTrees(nodeA, nodeB, node);
        System.out.println(node1);

        Node node2 = cloneTreesIterative(nodeA, nodeB, node);
        System.out.println(node2);
    }

    // O(n) time | O(n) space
    public static Node cloneTreesIterative(Node nodeA, Node nodeB, Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(nodeA, nodeB));
        while (!stack.isEmpty()) {
            NodeInfo pop = stack.pop();
            Node poppedA = pop.nodeA;
            Node poppedB = pop.nodeB;
            if (poppedA == node) {
                return poppedB;
            }
            if (poppedA.left != null && poppedB.left != null) {
                stack.push(new NodeInfo(poppedA.left, poppedB.left));
            }
            if (poppedA.right != null && poppedB.right != null) {
                stack.push(new NodeInfo(poppedA.right, poppedB.right));
            }
        }
        return null;
    }

    // O(n) time | O(n) space
    public static Node cloneTrees(Node nodeA, Node nodeB, Node node) {
        if (nodeA == null || nodeB == null) {
            return null;
        }

        if (nodeA == node) {
            return nodeB;
        }
        if (nodeA.left != null && nodeB.left != null) {
            Node found = cloneTrees(nodeA.left, nodeB.left, node);
            if (found != null) {
                return found;
            }
        }
        if (nodeA.right != null && nodeB.right != null) {
            Node found = cloneTrees(nodeA.right, nodeB.right, node);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    static class NodeInfo {
        Node nodeA;
        Node nodeB;

        public NodeInfo(Node nodeA, Node nodeB) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
