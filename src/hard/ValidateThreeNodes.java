package hard;

import java.util.LinkedList;

public class ValidateThreeNodes {

    static BST root;

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

        root = tree;
//        BST tree = new BST(3);
//        tree.left = new BST(2);
//        tree.left.left = new BST(1);

        //          5
        //        /   \
        //       2     7
        //     /  \   /  \
        //    1    4 6    8
        //  /     /
        // 0     3

        inOrder(tree);

        ValidateThreeNodes validateThreeNodes = new ValidateThreeNodes();

        System.out.println();
        boolean result = validateThreeNodes.validateThreeNodes(tree.left.left, tree.left, tree);
        System.out.println(result);
        System.out.println(validateThreeNodes.isBST(tree));
    }

    private boolean isBST(BST tree) {
        LinkedList<BST> queue = new LinkedList<>();
        queue.addFirst(tree);

        while (!queue.isEmpty()) {
            BST element = queue.pollFirst();
            if (element.left != null) {
                if (element.left.value >= element.value) {
                    return false;
                }
                queue.addLast(element.left);
            }
            if (element.right != null) {
                if (element.right.value < element.value) {
                    return false;
                }
                queue.addLast(element.right);
            }
        }
        return true;
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        // Determine whether root is nodeOne or nodeThree
        BST current = nodeOne;
        boolean nodeOneIsCloserToRoot = false;
        BST firstCheckNode = null;
        BST secondCheckNode = null;

        // assume nodeOne is ancestor of nodeThree
        while (current != null) {
            if (current.value > nodeThree.value) {
                // left
                current = current.left;
            } else if (current.value < nodeThree.value) {
                // right
                current = current.right;
            } else {
                // proof assumed
                nodeOneIsCloserToRoot = true;
                break;
            }
        }

        if (nodeOneIsCloserToRoot) {
            firstCheckNode = nodeOne;
            secondCheckNode = nodeThree;
        } else {
            firstCheckNode = nodeThree;
            secondCheckNode = nodeOne;
        }

        boolean firstCheck = false;
        boolean secondCheck = false;

        // check firstCheckNode is parent of nodeTwo
        while (firstCheckNode != null) {
            if (firstCheckNode.value > nodeTwo.value) {
                // left
                firstCheckNode = firstCheckNode.left;
            } else if (firstCheckNode.value < nodeTwo.value) {
                // right
                firstCheckNode = firstCheckNode.right;
            } else {
                // are equals
                nodeTwo = firstCheckNode;
                firstCheck = true;
                break;
            }
        }

        // check nodeTwo is parent of secondCheckNode
        while (nodeTwo != null) {
            if (nodeTwo.value > secondCheckNode.value) {
                // left
                nodeTwo = nodeTwo.left;
            } else if (nodeTwo.value < secondCheckNode.value) {
                // right
                nodeTwo = nodeTwo.right;
            } else {
                // are equals
                secondCheck = true;
                break;
            }
        }

        return firstCheck && secondCheck;
    }

    public static void inOrder(BST tree) {
        if (tree == null) {
            return;
        }

        inOrder(tree.left);
        System.out.print(tree.value + " ");
        inOrder(tree.right);
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

}
