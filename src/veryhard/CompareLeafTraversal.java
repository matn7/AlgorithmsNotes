package veryhard;

import java.util.Stack;

public class CompareLeafTraversal {

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        tree1.left = new BinaryTree(2);
        tree1.right = new BinaryTree(3);
        tree1.left.left = new BinaryTree(4);
        tree1.left.right = new BinaryTree(5);
        tree1.right.right = new BinaryTree(6);
        tree1.left.right.left = new BinaryTree(7);
        tree1.left.right.right = new BinaryTree(8);

        BinaryTree tree2 = new BinaryTree(1);
        tree2.left = new BinaryTree(2);
        tree2.right = new BinaryTree(3);
        tree2.left.left = new BinaryTree(4);
        tree1.left.right = new BinaryTree(7);
        tree1.right.right = new BinaryTree(5);
        tree1.left.right.left = new BinaryTree(8);
        tree1.left.right.right = new BinaryTree(6);

        CompareLeafTraversal compare = new CompareLeafTraversal();
        compare.compareLeafTraversal(tree1, tree2);

    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n + m) time | O(max(h1, h2)) space
    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        TreeList tree1LeafNodesLinkedLists = connectLeafNodes(tree1, null, null);
        TreeList tree2LeafNodesLinkedLists = connectLeafNodes(tree2, null, null);

        BinaryTree list1CurrentNode = tree1LeafNodesLinkedLists.head;
        BinaryTree list2CurrentNode = tree2LeafNodesLinkedLists.head;

        while (list1CurrentNode != null && list2CurrentNode != null) {
            if (list1CurrentNode.value != list2CurrentNode.value) {
                return false;
            }

            list1CurrentNode = list1CurrentNode.right;
            list2CurrentNode = list2CurrentNode.right;
        }
        return list1CurrentNode == null && list2CurrentNode == null;
    }

    private TreeList connectLeafNodes(BinaryTree currentNode, BinaryTree head, BinaryTree previousNode) {
        if (currentNode == null) {
            return new TreeList(head, previousNode);
        }

        if (isLeafNode(currentNode)) {
            if (previousNode == null) {
                head = currentNode;
            } else {
                previousNode.right = currentNode;
            }
            previousNode = currentNode;
        }

        TreeList left = connectLeafNodes(currentNode.left, head, previousNode);

        return connectLeafNodes(currentNode.right, left.head, left.previousNode);
    }

    static class TreeList {
        BinaryTree head;
        BinaryTree previousNode;

        public TreeList(BinaryTree head, BinaryTree previousNode) {
            this.head = head;
            this.previousNode = previousNode;
        }
    }

    private boolean isLeafNode(BinaryTree node) {
        return node.left == null && node.right == null;
    }

    // O(n + m) time | O(h1 + h2) space
    public boolean compareLeafTraversal2(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        Stack<BinaryTree> tree1TraversalStack = new Stack<>();
        Stack<BinaryTree> tree2TraversalStack = new Stack<>();
        tree1TraversalStack.push(tree1);
        tree2TraversalStack.push(tree2);

        while (!tree1TraversalStack.isEmpty() && !tree2TraversalStack.isEmpty()) {
            BinaryTree tree1Leaf = getNextLeafNode(tree1TraversalStack);
            BinaryTree tree2Leaf = getNextLeafNode(tree2TraversalStack);
            if (tree1Leaf.value != tree2Leaf.value) {
                return false;
            }
        }
        return tree1TraversalStack.isEmpty() && tree2TraversalStack.isEmpty();
    }

    private BinaryTree getNextLeafNode(Stack<BinaryTree> traversalStack) {
        BinaryTree currentNode = traversalStack.pop();

        while (!isLeafNode2(currentNode)) {
            if (currentNode.right != null) {
                traversalStack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                traversalStack.push(currentNode.left);
            }

            currentNode = traversalStack.pop();
        }

        return currentNode;
    }

    private boolean isLeafNode2(BinaryTree node) {
        return node.left == null && node.right == null;
    }

}
