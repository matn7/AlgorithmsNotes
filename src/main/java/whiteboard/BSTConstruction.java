package whiteboard;

public class BSTConstruction {

    public static void main(String[] args) {
        BST bst = new BST(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(3);

        bst.remove(1);

        System.out.println();
    }

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
            BST currNode = this;
            while (currNode != null) {
                int currVal = currNode.value;
                if (currVal <= value) {
                    if (currNode.right == null) {
                        currNode.right = new BST(value);
                        break;
                    } else {
                        currNode = currNode.right;
                    }
                } else if (currVal > value) {
                    if (currNode.left == null) {
                        currNode.left = new BST(value);
                        break;
                    } else {
                        currNode = currNode.left;
                    }
                }
            }
            return this;
        }

        // O(log(n)) time | O(1) space
        public boolean contains(int value) {
            // Write your code here.
            BST currNode = this;
            while (currNode != null) {
                int currVal = currNode.value;
                if (currVal < value) {
                    currNode = currNode.right;
                } else if (currVal > value) {
                    currNode = currNode.left;
                } else {
                    return true;
                }
            }
            return false;
        }

        // O(log(n)) time | O(1) space
        public BST remove(int value) {
            return removeHelper(value, null);
        }

        public BST removeHelper(int value, BST prevNode) {
            // Write your code here.
            // Do not edit the return statement of this method.
            BST currNode = this;
            while (currNode != null) {
                int currValue = currNode.value;
                if (currValue < value) {
                    prevNode = currNode;
                    currNode = currNode.right;
                } else if (currValue > value) {
                    prevNode = currNode;
                    currNode = currNode.left;
                } else {
                    if (isLeaf(currNode) && prevNode != null) {
                        if (prevNode.left != null && prevNode.left.value == value) {
                            prevNode.left = null;
                        } else {
                            prevNode.right = null;
                        }
                        break;
                    } else if (isOneParentNode(currNode)) {
                        if (prevNode != null) {
                            if (currNode.value >= prevNode.value) {
                                if (currNode.left != null) {
                                    prevNode.right = currNode.left;
                                } else {
                                    prevNode.right = currNode.right;
                                }
                            } else {
                                if (currNode.left != null) {
                                    prevNode.left = currNode.left;
                                } else {
                                    prevNode.left = currNode.right;
                                }
                            }
                        } else {
                            if (currNode.left != null) {
                                currNode.value = currNode.left.value;
                                if (currNode.left.left != null) {
                                    currNode.left = currNode.left.left;
                                } else {
                                    currNode.left = null;
                                }
                            } else {
                                currNode.value = currNode.right.value;
                                if (currNode.right.right != null) {
                                    currNode.right = currNode.right.right;
                                } else {
                                    currNode.right = null;
                                }
                            }
                        }
                        break;
                    } else if (isTwoChildNode(currNode)) {
                        BST rightMin = getMinAndRemove(currNode.right);
                        currNode.value = rightMin.value;
                        currNode.right.removeHelper(currNode.value, currNode);
                        break;
                    } else {
                        // Node not found
                        break;
                    }
                }
            }
            return this;
        }

        private BST getMinAndRemove(BST tree) {
            while (tree != null && tree.left != null) {
                tree = tree.left;
            }
            return tree;
        }

        private boolean isLeaf(BST currNode) {
            return currNode.left == null && currNode.right == null;
        }

        private boolean isOneParentNode(BST currNode) {
            return (currNode.left == null && currNode.right != null)
                    || (currNode.left != null && currNode.right == null);
        }

        private boolean isTwoChildNode(BST currNode) {
            return currNode.left != null && currNode.right != null;
        }

    }

}
