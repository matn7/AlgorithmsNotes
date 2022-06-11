package hard;

import java.util.*;

public class MaxPathSum {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(-10);
        binaryTree.left.left = new BinaryTree(30);
        binaryTree.left.left.left = new BinaryTree(5);
        binaryTree.left.left.right = new BinaryTree(1);
        binaryTree.left.right = new BinaryTree(45);
        binaryTree.left.right.left = new BinaryTree(3);
        binaryTree.left.right.right = new BinaryTree(-3);
        binaryTree.right = new BinaryTree(-5);
        binaryTree.right.left = new BinaryTree(-20);
        binaryTree.right.left.left = new BinaryTree(100);
        binaryTree.right.left.right = new BinaryTree(2);
        binaryTree.right.right = new BinaryTree(-21);
        binaryTree.right.right.left = new BinaryTree(100);
        binaryTree.right.right.right = new BinaryTree(1);

        int result = maxPathSum(binaryTree);
        System.out.println("============");
        System.out.println(result);
    }

    public static int maxPathSum(BinaryTree tree) {
        if (isLeaf(tree)) {
            return tree.value;
        }
        List<TreePath> resultsLeft = new ArrayList<>();
        inOrder(tree.left, 0, resultsLeft);

        List<TreePath> resultsRight = new ArrayList<>();
        inOrder(tree.right, 0, resultsRight);

        TreePath currentLeftMax = getLocalMax(tree.left, resultsLeft);
//        TreePath entireLeft = getEntireSubtree(tree.left);
        TreePath currentRightMax = getLocalMax(tree.right, resultsRight);
//        TreePath entireRight = getEntireSubtree(tree.right);
        // get entire path left and right

        List<TreePath> treePathsLeft = longestPath(resultsLeft);
        List<TreePath> treePathsRight = longestPath(resultsRight);

        List<Integer> allValues = new ArrayList<>();
        if (treePathsLeft.size() >= 2) {
            Collections.sort(treePathsLeft, Collections.reverseOrder());
            allValues.add(treePathsLeft.get(0).value + treePathsLeft.get(1).value - tree.left.value);
        }
        if (treePathsRight.size() >= 2) {
            Collections.sort(treePathsRight, Collections.reverseOrder());
            allValues.add(treePathsRight.get(0).value + treePathsRight.get(1).value - tree.right.value);
        }

        int root = tree.value;


        allValues.add(currentLeftMax.value);
        allValues.add(currentRightMax.value);
        allValues.add(currentLeftMax.value + currentRightMax.value);
        allValues.add(currentLeftMax.value + currentRightMax.value + root);
        allValues.add(currentLeftMax.value + root);
        allValues.add(currentRightMax.value + root);

        allValues.add(currentLeftMax.value);
        allValues.add(currentRightMax.value);
        allValues.add(currentRightMax.value + root);
        allValues.add(currentRightMax.value + root);

        allValues.add(currentLeftMax.value);
        allValues.add(currentRightMax.value);
        allValues.add(currentLeftMax.value + root);
        allValues.add(currentLeftMax.value + root);

        allValues.add(currentLeftMax.value);
        allValues.add(currentRightMax.value);
        allValues.add(root);


//        allValues.add(entireLeft.value);
//        allValues.add(entireRight.value);
        allValues.add(root);

        int max = -9999;

        for (Integer element : allValues) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    public static TreePath getLocalMax(BinaryTree root, List<TreePath> results) {
        if (root == null) {
            return new TreePath(-9999);
        }
        if (isLeaf(root)) {
            return new TreePath(root.value);
        }
        TreePath maxMapPath = new TreePath(-9999);
        for (TreePath element : results) {
            if (element.compareTo(maxMapPath) > 0) {
                maxMapPath = element;
            }
        }
        return maxMapPath;
    }

    public static List<TreePath> longestPath(List<TreePath> results) {
        List<TreePath> resultsMaximum = new ArrayList<>();
        for (TreePath element : results) {
            if (!element.singleNode) {
                resultsMaximum.add(element);
            }
        }
        return resultsMaximum;
    }

    private static TreePath getEntireSubtree(BinaryTree root) {
        if (root == null) {
            return new TreePath(-9999);
        }
        int allSubtreeSum = breadthFirst(root);
        TreePath extraAllSubtree = new TreePath(allSubtreeSum);
        extraAllSubtree.singleSubTree = true;
        return extraAllSubtree;
    }

    public static void inOrder(BinaryTree root, int sum, List<TreePath> results) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            sum = sum + root.value;
            if (root.value > sum) {
                TreePath singleNode = new TreePath(root.value);
                singleNode.singleNode = true;
                results.add(singleNode);
            }
            results.add(new TreePath(sum));
        }

        sum = sum + root.value;
        inOrder(root.left, sum, results);
        inOrder(root.right, sum, results);
    }

    public static int breadthFirst(BinaryTree binaryTree) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(binaryTree);

        int sum = 0;

        while (!queue.isEmpty()) {
            BinaryTree poll = queue.poll();
            sum += poll.value;
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

        return sum;
    }

    private static boolean isLeaf(BinaryTree binaryTree) {
        return binaryTree.left == null && binaryTree.right == null;
    }

    static class TreePath implements Comparable<TreePath> {
        public int value;
        public boolean singleNode;
        public boolean singleSubTree;

        public TreePath(int value) {
            this.value = value;
            this.singleNode = false;
            this.singleSubTree = false;
        }

        @Override
        public int compareTo(TreePath o) {
            return value - o.value;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
