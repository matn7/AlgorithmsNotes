package problems.hard;

import java.util.*;

public class FindNodesDistanceK {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.right = new BinaryTree(6);
        tree.right.right.left = new BinaryTree(7);
        tree.right.right.right = new BinaryTree(8);

        FindNodesDistanceK findNodes = new FindNodesDistanceK();
        findNodes.findNodesDistanceK(tree, 3, 2);
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

    // O(n) time | O(n) space
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        Map<Integer, BinaryTree> nodesToParents = new HashMap<>();
        populateNodesToParents(tree, nodesToParents, null);
        BinaryTree targetNode = getNodeFromValue(target, tree, nodesToParents);
        return breadthFirstSearchForNodesDistanceK(targetNode, nodesToParents, k);
    }

    private void populateNodesToParents(BinaryTree node, Map<Integer, BinaryTree> nodesToParents,
                                        BinaryTree parent) {
        if (node != null) {
            nodesToParents.put(node.value, parent);
            populateNodesToParents(node.left, nodesToParents, node);
            populateNodesToParents(node.right, nodesToParents, node);
        }
    }

    private ArrayList<Integer> breadthFirstSearchForNodesDistanceK(BinaryTree targetNode,
            Map<Integer, BinaryTree> nodesToParents, int k) {
        Queue<TreeInfo> queue = new LinkedList<>();
        queue.add(new TreeInfo(targetNode, 0));
        Map<Integer, Boolean> seen = new HashMap<>();
        ArrayList<Integer> nodesDistanceK = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeInfo currentNodeInfo = queue.poll();
            if (currentNodeInfo.distance == k) {
                while (!queue.isEmpty()) {
                    int element = queue.poll().node.value;
                    if (element != targetNode.value) {
                        nodesDistanceK.add(element);
                    }
                }
                nodesDistanceK.add(currentNodeInfo.node.value);
                return nodesDistanceK;
            }
            List<BinaryTree> connectedNodes = new ArrayList<>();
            connectedNodes.add(currentNodeInfo.node.left);
            connectedNodes.add(currentNodeInfo.node.right);
            connectedNodes.add(nodesToParents.get(currentNodeInfo.node.value));

            for (BinaryTree node : connectedNodes) {
                if (node == null) {
                    continue;
                }

                if (seen.containsKey(node.value)) {
                    continue;
                }

                seen.put(node.value, Boolean.TRUE);
                queue.add(new TreeInfo(node, currentNodeInfo.distance + 1));
            }
        }
        return new ArrayList<>();
    }

    private BinaryTree getNodeFromValue(int value, BinaryTree tree, Map<Integer, BinaryTree> nodesToParents) {
        if (tree.value == value) {
            return tree;
        }
        BinaryTree nodeParent = nodesToParents.get(value);
        if (nodeParent.left != null && nodeParent.left.value == value) {
            return nodeParent.left;
        }

        return nodeParent.right;
    }

    static class TreeInfo {
        BinaryTree node;
        int distance;

        public TreeInfo(BinaryTree node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
