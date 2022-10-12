package hard;

public class ValidateThreeNodes {

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

        ValidateThreeNodes validateThreeNodes = new ValidateThreeNodes();
        boolean result = validateThreeNodes.validateThreeNodes(tree, tree.left, tree.left.right.left);
        System.out.println(result);
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(h) time | O(h) space
    // OK - repeated 28/01/2022
    // (5, 2, 3)
//    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
//        // Write your code here.
//        if (isDescendant(nodeTwo, nodeOne)) { // 2, 5
//            return isDescendant(nodeThree, nodeTwo);
//        }
//        if (isDescendant(nodeTwo, nodeThree)) { // 2, 3    ---> from node 2 we can go to node 3
//            return isDescendant(nodeOne, nodeTwo); // 5, 2 ---> from node 5 check whether we can go to node 2
//            // is nodeTwo is descendant of nodeOne
//            // is nodeOne is ancestor of nodeTwo
//        }
//        return false;
//    }
//
//    private boolean isDescendant(BST node, BST target) {
//        if (node == null) {
//            return false;
//        }
//        if (node == target) { // 2 == 2
//            return true;
//        }
//
//        if (target.value < node.value) { // 2 < 5
//            return isDescendant(node.left, target);
//        } else {
//            return isDescendant(node.right, target);
//        }
//    }

    // O(h) time | O(1) space
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        // Write your code here.
        if (isDescendant(nodeTwo, nodeOne)) { // 2, 5
            return isDescendant(nodeThree, nodeTwo);
        }
        if (isDescendant(nodeTwo, nodeThree)) { // 2, 3
            return isDescendant(nodeOne, nodeTwo); // 5, 2
        }
        return false;
    }

    private boolean isDescendant(BST node, BST target) { // 5, 2
        while (node != null && node != target) {
            if (node.value > target.value) { // 5 > 2
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node == target; // 2 == 2
    }

//    // O(d) time | O(1) space
//    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
//        BST searchOne = nodeOne;
//        BST searchTwo = nodeTwo;
//
//        while (true) {
//            boolean foundThreeFromOne = searchOne == nodeThree;
//            boolean foundOneFromThree = searchTwo == nodeOne;
//            boolean foundNodeTwo = searchOne == nodeTwo || searchTwo == nodeTwo;
//            boolean finishedSearching = searchOne == null && searchTwo == null;
//            if (foundThreeFromOne || foundOneFromThree || foundNodeTwo || finishedSearching) {
//                break;
//            }
//
//            if (searchOne != null) {
//                if (searchOne.value > nodeTwo.value) {
//                    searchOne = searchOne.left;
//                } else {
//                    searchOne = searchOne.right;
//                }
//            }
//
//            if (searchTwo != null) {
//                if (searchTwo.value > nodeTwo.value) {
//                    searchTwo = searchTwo.left;
//                } else {
//                    searchTwo = searchTwo.right;
//                }
//            }
//        }
//
//        boolean foundNodeFromOther = searchOne == nodeThree || searchTwo == nodeOne;
//        boolean foundNodeTwo = searchOne == nodeTwo || searchTwo == nodeTwo;
//        if (!foundNodeTwo || foundNodeFromOther) {
//            return false;
//        }
//
//        if (searchOne == nodeTwo) {
//            return searchForTarget(nodeTwo, nodeThree);
//        } else {
//            return searchForTarget(nodeTwo, nodeOne);
//        }
//    }
//
//    private boolean searchForTarget(BST node, BST target) {
//        while (node != null && node != target) {
//            if (node.value > target.value) {
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//        return node == target;
//    }

}
