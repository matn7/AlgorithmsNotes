package problems.other;

public class InOrderSuccessor2 {

    public static void main(String[] args) {
        TreeNodeParent tree = new TreeNodeParent(4);

        TreeNodeParent node2 = new TreeNodeParent(2);
        TreeNodeParent node1 = new TreeNodeParent(1);
        TreeNodeParent node8 = new TreeNodeParent(8);
        TreeNodeParent node5 = new TreeNodeParent(5);
        TreeNodeParent node7 = new TreeNodeParent(7);
        TreeNodeParent node9 = new TreeNodeParent(9);
        TreeNodeParent node11 = new TreeNodeParent(11);
        TreeNodeParent node12 = new TreeNodeParent(12);
        TreeNodeParent node13 = new TreeNodeParent(13);

        tree.left = node2;
        tree.right = node8;
        node2.parent = tree;
        node2.left = node1;
        node1.parent = node2;
        node8.parent = tree;
        node8.left = node5;
        node8.right = node9;
        node5.parent = node8;
        node5.right = node7;
        node7.parent = node5;
        node9.parent = node8;
        node7.right = node11;
        node11.parent = node7;
        node11.right = node12;
        node12.parent = node11;
        node12.right = node13;
        node13.parent = node12;

        InOrderSuccessor2 inOrderSuccessor2 = new InOrderSuccessor2();
        TreeNodeParent result = inOrderSuccessor2.inOrderSuccessor(tree, node13);
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public TreeNodeParent inOrderSuccessor(TreeNodeParent tree, TreeNodeParent node) {
        if (tree == null || node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        }

        if (node.parent == null) {
            return null;
        }
        if (node.parent.right == node) {
            TreeNodeParent curr = node.parent;
            while (curr.parent != null && curr.parent.left != curr) {
                curr = curr.parent;
            }
            if (curr.parent == null) {
                return null;
            }
            return curr.parent;
        }
        if (node.parent.left == node) {
            return node.parent;
        }

        return null;
    }

    private TreeNodeParent getLeftMost(TreeNodeParent node) {
        TreeNodeParent curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

}


