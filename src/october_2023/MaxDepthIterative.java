package october_2023;

import java.util.Map;
import java.util.Stack;

public class MaxDepthIterative {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);

        maxDepthIterative(node);

    }

    // O(n) time | O(n) space
    public static int maxDepthIterative(Node node) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(1, node));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            NodeInfo top = stack.pop();
            Node currNode = top.node;
            int currDepth = top.depth;
            maxDepth = Math.max(maxDepth, currDepth);

            if (currNode.left != null) {
                stack.push(new NodeInfo(currDepth + 1, currNode.left));
            }

            if (currNode.right != null) {
                stack.push(new NodeInfo(currDepth + 1, currNode.right));
            }
        }

        return maxDepth;
    }

    static class NodeInfo {
        int depth;
        Node node;

        public NodeInfo(int depth, Node node) {
            this.depth = depth;
            this.node = node;
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
