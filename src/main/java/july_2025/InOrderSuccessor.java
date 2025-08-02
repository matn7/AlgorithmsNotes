package july_2025;

public class InOrderSuccessor {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        TreeNode node17 = new TreeNode(17);
        TreeNode node7 = new TreeNode(7);

        node4.left = node2;
        node4.right = node8;

        node2.left = node1;
        node2.parent = node4;

        node8.left = node5;
        node8.right = node9;
        node8.parent = node4;

        node1.parent = node2;

        node5.parent = node8;
        node5.right = node17;

        node9.parent = node8;

        node17.parent = node5;
        node17.right = node7;

        node7.parent = node17;

        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();

        System.out.println(inOrderSuccessor.inOrderSuccessor(node1).val); // 2
        System.out.println(inOrderSuccessor.inOrderSuccessor(node2).val); // 4
        System.out.println(inOrderSuccessor.inOrderSuccessor(node4).val); // 5
        System.out.println(inOrderSuccessor.inOrderSuccessor(node5).val); // 17
        System.out.println(inOrderSuccessor.inOrderSuccessor(node17).val); // 7
        System.out.println(inOrderSuccessor.inOrderSuccessor(node7).val); // 8
        System.out.println(inOrderSuccessor.inOrderSuccessor(node8).val); // 9
        System.out.println(inOrderSuccessor.inOrderSuccessor(node9)); // null

    }

    // Intuition:
    // - dfs or bfs, inorder dfs
    // inorder left, node, right
    // - add to array = [1, 2, 4, 5, 17, 7, 8, 9]
    // Approach:
    // - identify case: 1 -> 2 (parent.left = curr)
    // - identify case: 4 -> 5 (min from right child) - if node has right child find min(node.right)
    // - identify case: 7 -> 8 (parent.left = curr)
    // - identify case: 9 -> null
    // Complexity:
    // Code:

    //          4
    //        /   \
    //     p 2     8 p
    //      /     /  \
    //   c 1   c 5    9
    //            \
    //             17
    //              \
    //               7


    // O(n) time | O(n) space
    public TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findLeftMost(node.right);
        }
        TreeNode parent = node.parent;
        TreeNode curr = node;
        while (parent != null && parent.left != curr) { // check parent null
            parent = parent.parent;
            curr = curr.parent;
        }
        return parent;
    }

    private TreeNode findLeftMost(TreeNode node) {
        TreeNode curr = node;
        while (curr.left!= null) {
            curr = curr.left;
        }
        return curr;
    }

    static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
