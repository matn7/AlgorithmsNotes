package july_2024;

public class RepairBstV2 {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(7);
        tree.right = new BST(20);
        tree.left.left = new BST(3);
        tree.left.right = new BST(12);
        tree.right.left = new BST(8);
        tree.right.right = new BST(22);
        tree.left.left.left = new BST(2);
        tree.right.left.right = new BST(14);

        RepairBstV2 repairBstV2 = new RepairBstV2();
        repairBstV2.repairBst(tree);

        System.out.println(repairBstV2);
    }

    BST nodeOne = null;
    BST nodeTwo = null;
    BST previousNode = null;

    public BST repairBst(BST tree) {
        inOrderTraversal(tree);
        swap(nodeOne, nodeTwo);
        return tree;
    }

    private void inOrderTraversal(BST node) {
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

    private void swap(BST nodeOne, BST nodeTwo) {
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
