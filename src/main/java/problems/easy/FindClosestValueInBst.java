package problems.easy;

public class FindClosestValueInBst {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.left.left.left = new BST(1);
        tree.right.left = new BST(13);
        tree.right.right = new BST(22);
        tree.right.left.right = new BST(14);

        findClosestValueInBst(tree, 12);
    }

    //              10
    //             /  \
    //            5    15
    //          /  \  /  \
    //         2   5 13   22
    //        /        \
    //       1         14

    // O(log(n)) time avg | O(1) space
    public static int findClosestValueInBstAlgo(BST tree, int target) {
        // Write your code here.
        BST currentNode = tree;
        int closest = 99999;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

//              10
//             /  \
//            5    15
//          /  \  /  \
//         2   5 13   22
//        /        \
//       1         14

    // O(log(n)) time avg | O(log(n)) space
    // O(n) time worst | O(n) space
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        return findClosestValueInBstHelper(tree, target, 99999);
    }

    private static int findClosestValueInBstHelper(BST tree, int target, int closest) {
        if (tree == null) {
            return closest;
        }
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value) {
            return findClosestValueInBstHelper(tree.left, target, closest);
        } else if (target > tree.value) {
            return findClosestValueInBstHelper(tree.right, target, closest);
        } else {
            return closest;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
