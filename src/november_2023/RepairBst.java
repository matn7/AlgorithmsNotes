package november_2023;

public class RepairBst {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(7);
        tree.right = new Node(20);
        tree.left.left = new Node(3);
        tree.left.right = new Node(12);
        tree.right.left = new Node(8);
        tree.right.right = new Node(22);
        tree.left.left.left = new Node(2);
        tree.right.left.right = new Node(14);

        RepairBst repairBst = new RepairBst();
        Node result = repairBst.repairBst(tree);
        System.out.println(result);
    }

    Node nodeOne = null;
    Node nodeTwo = null;
    Node previousNode = null;

    // O(n) time | O(h) space
    public Node repairBst(Node tree) {
        inOrderTraversal(tree);
        swap(nodeOne, nodeTwo);
        return tree;
    }

    private void swap(Node nodeOne, Node nodeTwo) {
        int temp = nodeOne.value;
        nodeOne.value = nodeTwo.value;
        nodeTwo.value = temp;
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (previousNode != null && previousNode.value > node.value) {
            if (nodeOne == null) {
                nodeOne = previousNode;
            }
            nodeTwo = node;
        }
        previousNode = node;
        inOrderTraversal(node.right);
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
