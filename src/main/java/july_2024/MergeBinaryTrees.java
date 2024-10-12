package july_2024;


import java.util.Stack;

public class MergeBinaryTrees {

    public static void main(String[] args) {
        Node tree1 = new Node(1);
        tree1.left = new Node(3);
        tree1.right = new Node(2);
        tree1.left.left = new Node(7);
        tree1.left.right = new Node(4);

        Node tree2 = new Node(1);
        tree2.left = new Node(5);
        tree2.right = new Node(9);
        tree2.left.left = new Node(2);
        tree2.right.left = new Node(7);
        tree2.right.right = new Node(6);

        Node node = mergeBinaryTrees(tree1, tree2);
        System.out.println(node);

    }

    public static Node mergeBinaryTrees(Node tree1, Node tree2) {
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(tree1);
        stack2.push(tree2);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            Node node1 = stack1.pop();
            Node node2 = stack2.pop();
            if (node2 == null) {
                continue;
            }
            node1.val = node1.val + node2.val;
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
        }
        return tree1;
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
