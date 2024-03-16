package september_2023;

public class BSTConstruction {

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(2);
//        bst.insert(5);
        bst.insert(1);
        bst.insert(13);
        bst.insert(14);
        bst.insert(22);

        System.out.println(bst.contains(1));

        bst.remove(14);
        bst.remove(13);
        bst.remove(22);
        bst.remove(15);
        bst.remove(10);

    }

    //          10
    //         /   \
    //        5     15
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // O(log(n)) time | O(1) space
        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST curr = this;
            // 14
            // 12
            while (true) {
                if (curr.value <= value) {
                    if (curr.right == null) {
                        curr.right = new BST(value);
                        break;
                    }
                    curr = curr.right;
                } else {
                    if (curr.left == null) {
                        curr.left = new BST(value);
                        break;
                    }
                    curr = curr.left;
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            BST curr = this;
            while (curr != null) {
                if (curr.value == value) {
                    return true;
                } else if (curr.value < value) { // 12 < 14
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            return removeHelper(value, null);
        }

        private BST removeHelper(int value, BST prevNode) {
            BST prev = prevNode;
            BST curr = this;
            while (curr != null) {
                if (curr.value < value) {
                    prev = curr;
                    curr = curr.right;
                } else if (curr.value > value) {
                    prev = curr;
                    curr = curr.left;
                } else {
                    // 3 cases
                    //      10 c
                    //     /  \
                    //    5    15
                    //   / \   /  \
                    //  2  5  13  22
                    // /        \
                    // 1        14
                    // leaf node
                    if (isLeaf(curr)) {
                        if (prev == null) {
                            curr = null;
                            return null;
                        }
                        if (prev.left == curr) { // prev != null
                            prev.left = null;

                        } else {
                            prev.right = null;
                        }
                    } else if (isOneParentNode(curr)) {
                        if (prev != null) {
                            if (curr.value >= prev.value) {
                                if (curr.left != null) {
                                    prev.right = curr.left;
                                } else {
                                    prev.right = curr.right;
                                }
                            } else {
                                if (curr.left != null) {
                                    prev.left = curr.left;
                                } else {
                                    prev.left = curr.right;
                                }
                            }
                        } else {
                            if (curr.left != null) {
                                curr.value = curr.left.value;
                                if (curr.left.left != null) {
                                    curr.left = curr.left.left;
                                } else {
                                    curr.left = null;
                                }
                            } else {
                                curr.value = curr.right.value;
                                if (curr.right.right != null) {
                                    curr.right = curr.right.right;
                                } else {
                                    curr.right = null;
                                }
                            }
                        }
                    } else {
                        BST rightMin = getMin(curr.right);
                        curr.value = rightMin.value;
                        curr.right.removeHelper(rightMin.value, curr);
                    }
                    break;
                }
            }
            return this;
        }

        private BST getMin(BST node) {
            BST curr = node;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        public void inOrder(BST node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }

        private boolean isLeaf(BST node) {
            return node.left == null && node.right == null;
        }

        private boolean isOneParentNode(BST node) {
            return (node.left == null && node.right != null) || (node.left != null && node.right == null);
        }

        private boolean isTwoParentNode(BST node) {
            return node.left != null && node.right != null;
        }
    }

}
