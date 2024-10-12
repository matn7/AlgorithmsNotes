package whiteboard;

public class ValidateThreeNodes {

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(5);
        tree.left = new BST(2);
        tree.right = new BST(7);
        tree.left.left = new BST(1);
        tree.left.right = new BST(4);
        tree.right.left = new BST(6);
        tree.right.right = new BST(8);
        tree.left.left.left = new BST(0);
        tree.left.right.left = new BST(3);

        ValidateThreeNodes validate = new ValidateThreeNodes();
        validate.validateThreeNodes(tree, tree.left, tree.left.right.left);
    }

    // O(d) time | O(1) space
    // #2: 27/06/2022
    // rand: 28/08/2022
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        if (isAncestor(nodeOne, nodeTwo)) {
            return isAncestor(nodeTwo, nodeThree);
        } else if (isAncestor(nodeThree, nodeTwo)) {
            return isAncestor(nodeTwo, nodeOne);
        } else {
            return false;
        }
    }

    private boolean isAncestor(BST topNode, BST bottomNode) {
        BST current = topNode;
        while (current != null) {
            if (current.value > bottomNode.value) {
                current = current.left;
            } else if (current.value < bottomNode.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

}
