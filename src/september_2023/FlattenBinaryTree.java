package september_2023;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        root.right.left = new BinaryTree(6);

        BinaryTree binaryTree = flattenBinaryTree(root);
        BinaryTree curr = binaryTree;
        while (curr != null) {
            System.out.print(curr.value + " <-> ");
            curr = curr.right;
        }
    }

    // O(n) time | O(n) space
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        List<BinaryTree> elements = new ArrayList<>();
        inOrder(root, elements);
        int currentIdx = 0;
        BinaryTree current = elements.get(currentIdx);
        // 4 <> 2   7   5   8   1   6   3
        //      c    n
        BinaryTree temp = current;

        for (int i = 1; i < elements.size(); i++) {
            BinaryTree next = elements.get(i);
            current.right = next;
            next.left = current;
            current = current.right;
        }
        return temp;
    }

    private static void inOrder(BinaryTree node, List<BinaryTree> elements) {
        if (node == null) {
            return;
        }
        inOrder(node.left, elements);
        elements.add(node);
        inOrder(node.right, elements);
    }


    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
