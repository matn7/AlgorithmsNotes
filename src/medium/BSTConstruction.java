package medium;

public class BSTConstruction {

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(12);
        bst.insert(13);
//        bst.insert(5);
//        bst.insert(15);
//        bst.insert(2);
//        bst.insert(5);
//        bst.insert(1);
//        bst.insert(13);
//        bst.insert(22);
//        bst.insert(14);
//        bst.insert(12);

        inOrder(bst);
        System.out.println();

        bst.remove(10, null);
        inOrder(bst);
        System.out.println();
    }

    public static void inOrder(BST root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    // OK - repeated 21/02/2022
    // Average: O(log(n)) time | O(log(n)) space (O(1) if implement iteratively)
    // Worst: O(n) time | O(n) space
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // left < root
        // right >= root
        // Average: O(log(n)) time | O(1) space
        // Worst: O(n) time | O(1) space
        // rec(12)
        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST currentNode = this;
            while (true) {
                if (value < currentNode.value) {
                    // left
                    if (currentNode.left == null) {
                        currentNode.left = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    // right
                    if (currentNode.right == null) {
                        currentNode.right = new BST(value);
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        // Average: O(log(n)) time | O(1) space
        // Worst: O(n) time | O(1) space
        public boolean contains(int value) {
            // Write your code here.
            BST currentNode = this;
            // rec(14)
            while (currentNode != null) {
                if (value < currentNode.value) {
                    // left
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        // Average: O(log(n)) time | O(1) space
        // Worst: O(n) time | O(1) space
        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            // rec(10,null)
            return remove(value, null);
        }

        // value = 10
        //               12
        //             /    \
        //            5      15
        //           / \    /   \
        //          2   5  13 p  22
        //         /      /  \
        //        1      N c 14 c
        // rec(12, (12))
        public BST remove(int value, BST parentNode) {
            BST currentNode = this; // 15
            while (currentNode != null) {
                if (value < currentNode.value) { // 12 < 12
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    // found node
                    if (currentNode.left != null && currentNode.right != null) { // case 2 child parent node
                        currentNode.value = currentNode.right.getMinValue(); // (15).getMinValue() = 12
                        // currentNode.value = smallest value of right subtree
                        currentNode.right.remove(currentNode.value, currentNode); // (15).remove(12, (12))
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null){
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            currentNode = null;
                        }
                    }
                    // we're gonna come back to the root node case
                    else if (parentNode.left == currentNode) {
                        if (currentNode.left != null) {
                            parentNode.left = currentNode.left;
                        } else {
                            parentNode.left = currentNode.right;
                        }
                    }
                    else if (parentNode.right == currentNode) {
                        if (currentNode.left != null) {
                            parentNode.right = currentNode.left;
                        } else {
                            parentNode.right = currentNode.right;
                        }
                    }
                    break;
                }
            }
            return this;
        }


        private int getMinValue() {
            BST currentNode = this; // 15
            while (currentNode.left != null) {
                currentNode = currentNode.left; // 12
            }
            return currentNode.value; // 12
        }
    }
}




















