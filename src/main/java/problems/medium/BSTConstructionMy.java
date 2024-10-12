package problems.medium;

public class BSTConstructionMy {

    public static void main(String[] args) {
        BST bst = new BST(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
//        bst.insert(5);
//        bst.insert(15);
//        bst.insert(2);
//        bst.insert(5);
//        bst.insert(13);
//        bst.insert(22);
//        bst.insert(1);
//        bst.insert(14);
//        bst.insert(12);

        inOrder(bst);
        System.out.println();

        bst.remove(1);

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

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST current = this;
            while (current != null) {
                if (current.value > value) {
                    if (current.left == null) {
                        current.left = new BST(value);
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new BST(value);
                        break;
                    }
                    current = current.right;
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            BST current = this;
            while (current != null) {
                if (current.value > value) {
                    // look left
                    if (current.left == null) {
                        return false;
                    }
                    current = current.left;
                } else if (current.value < value) {
                    if (current.right == null) {
                        return false;
                    }
                    current = current.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST previous = null;
            BST current = this;
            while (current != null) {
                if (current.value > value) {
                    // look left
                    previous = current;
                    current = current.left;
                } else if (current.value < value) {
                    // look right
                    previous = current;
                    current = current.right;
                } else {
                    // found node
                    // leaf node
                    if (isLeaf(current)) {
                        if (previous == null) {
                            // remove node itself
                            return null;
                        } else {
                            if (current.value < previous.value) {
                                previous.left = null;
                            } else {
                                previous.right = null;
                            }
                        }
                        break;
                    }
                    // one child node
                    else if (isOneChildNode(current)) {
                        // check whether we have left or right child
                        if (previous == null) {
                            // remove root
                            if (current.left != null) {
                                current.value = current.left.value;
                                current.left = current.left.left;
                            } else {
                                current.value = current.right.value;
                                current.right = current.right.right;
                            }
                        } else {
                            if (current.left != null) {
                                // current has child on left
                                if (previous.value > current.value) {
                                    // node on left -> previous.left
                                    previous.left = current.left;
                                } else {
                                    // node on right -> previous.right
                                    previous.right = current.left;
                                }
                            } else {
                                // current has child on right
                                if (previous.value > current.value) {
                                    // node on left -> previous.left
                                    previous.left = current.right;
                                } else {
                                    // node on right -> previous.right
                                    previous.right = current.right;
                                }
                            }
                        }
                        break;
                    }
                    // two child nodes
                    else if (isTwoChildNode(current)) {
                        // find min value from right
                        int minRight = findAndRemoveMin(current, current.right);
                        current.value = minRight;
                        break;
                    }
                }
            }
            return this;
        }

        private boolean isLeaf(BST node) {
            return node.left == null && node.right == null;
        }

        private boolean isOneChildNode(BST node) {
            return (node.left == null && node.right != null) || (node.left != null && node.right == null);
        }

        private boolean isTwoChildNode(BST node) {
            return node.left != null && node.right != null;
        }

        private int findAndRemoveMin(BST previous, BST bst) {
            BST current = bst;
            int valueToReturn = -1;
            boolean atLeasOnce = false;
            while (current != null) {
                if (current.left == null) {
                    valueToReturn = current.value;
                    break;
                }
                atLeasOnce = true;
                previous = current;
                current = current.left;
            }
            if (atLeasOnce) {
                previous.left = null;
            } else {
                previous.right = null;
            }

            return valueToReturn;
        }
    }

}
