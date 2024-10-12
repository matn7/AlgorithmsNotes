package february_2024;

public class RepairBst {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(7);
        tree.right = new BST(20);
        tree.left.left = new BST(3);
        tree.left.right = new BST(12);
        tree.left.left.left = new BST(2);
        tree.right.left = new BST(8);
        tree.right.right = new BST(22);
        tree.right.left.right = new BST(14);

        RepairBst repairBst = new RepairBst();
        BST bst = repairBst.repairBst(tree);
        System.out.println(bst);
    }

    BST nodeOne = null;
    BST nodeTwo = null;
    BST prevNode = null;

    // O(n) time | O(n) space
    public BST repairBst(BST tree) {
        inOrderTraversal(tree);
        swap();
        return tree;
    }

    private void inOrderTraversal(BST node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        if (prevNode != null && prevNode.value > node.value) {
            if (nodeOne == null) {
                nodeOne = prevNode;
            }
            nodeTwo = node;
        }
        prevNode = node;
        inOrderTraversal(node.right);
    }

    private void swap() {
        int temp = nodeOne.value;
        nodeOne.value = nodeTwo.value;
        nodeTwo.value = temp;
    }

    static class BST {
        int value;
        BST left;
        BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
