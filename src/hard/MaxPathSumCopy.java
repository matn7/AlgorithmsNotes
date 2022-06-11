package hard;

import java.util.*;

public class MaxPathSumCopy {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
//        binaryTree.left = new BinaryTree(-1);

//        binaryTree.left = new BinaryTree(2);
//        binaryTree.right = new BinaryTree(3);
//        binaryTree.left.left = new BinaryTree(4);
////        binaryTree.left.left.left = new BinaryTree(18);
////        binaryTree.left.left.right = new BinaryTree(99);
//        binaryTree.left.right = new BinaryTree(5);
////        binaryTree.left.right.right = new BinaryTree(30);
//        binaryTree.right.left = new BinaryTree(6);
//        binaryTree.right.right = new BinaryTree(7);
////        binaryTree.right.right.left = new BinaryTree(17);

//        binaryTree.left = new BinaryTree(2);
//        binaryTree.right = new BinaryTree(-1);

//        binaryTree.left = new BinaryTree(-5);
//        binaryTree.left.left = new BinaryTree(6);
//        binaryTree.right = new BinaryTree(3);

//        binaryTree.left = new BinaryTree(-1);
//        binaryTree.left.left = new BinaryTree(2);
//        binaryTree.left.right = new BinaryTree(3);

//        binaryTree.left = new BinaryTree(-1);

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
        List<TreePath> leftMaxArray = getLocalMax(tree.left);
        TreePath entireLeft = getEntireSubtree(tree.left);

        List<TreePath> leftResultsMaximum = new ArrayList<>();
        for (TreePath element : leftMaxArray) {
            if (!element.singleNode) {
                leftResultsMaximum.add(element);
            }
        }

        List<TreePath> rightMaxArray = getLocalMax(tree.right);

        List<TreePath> rightResultsMaximum = new ArrayList<>();
        for (TreePath element : rightMaxArray) {
            if (!element.singleNode) {
                rightResultsMaximum.add(element);
            }
        }

        TreePath entireRight = getEntireSubtree(tree.right);
        int root = tree.value;

        List<Integer> allValues = new ArrayList<>();
//        if (!currentLeftMax.singleNode && !currentRightMax.singleNode) {
//            allValues.add(currentLeftMax.value);
//            allValues.add(currentRightMax.value);
//            allValues.add(currentLeftMax.value + currentRightMax.value);
//            allValues.add(currentLeftMax.value + currentRightMax.value + root);
//            allValues.add(currentLeftMax.value + root);
//            allValues.add(currentRightMax.value + root);
//            allValues.add(root);
//        } else if (currentLeftMax.singleNode && !currentRightMax.singleNode) {
//            allValues.add(currentLeftMax.value);
//            allValues.add(currentRightMax.value);
//            allValues.add(currentRightMax.value + root);
//            allValues.add(currentRightMax.value + root);
//        } else if (!currentLeftMax.singleNode) {
//            allValues.add(currentLeftMax.value);
//            allValues.add(currentRightMax.value);
//            allValues.add(currentLeftMax.value + root);
//            allValues.add(currentLeftMax.value + root);
//        } else {
//            allValues.add(currentLeftMax.value);
//            allValues.add(currentRightMax.value);
//            allValues.add(root);
//        }

        allValues.add(entireLeft.value);
        allValues.add(entireRight.value);

        int max = -9999;

        for (Integer element : allValues) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    public static List<TreePath> getLocalMax(BinaryTree root) {
        List<TreePath> results = new ArrayList<>();
        if (root == null) {
            results.add(new TreePath(-9999));
            return results;
        }
        if (isLeaf(root)) {
            results.add(new TreePath(root.value));
            return results;
        }
        inOrder(root, 0, results);
        return results;
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

            System.out.println(sum);

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
