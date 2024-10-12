package september_2023;

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

        FindNodesDistanceK findNodesDistanceK = new FindNodesDistanceK();
        findNodesDistanceK.findNodesDistanceK(tree, 6, 1);
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
    public ArrayList<Integer> findNodesDistanceK(
            BinaryTree tree, int target, int k
    ) {
        // Write your code here.
        // Nodes parents
        Map<Integer, BinaryTree> nodesParents = new HashMap<>();
        populateNodesParent(tree, null, nodesParents);

        // Target Node
        BinaryTree targetNode = getTargetNode(nodesParents, tree, target);

        // Find nodes
        return findNodes(targetNode, nodesParents, k);
    }

    private ArrayList<Integer> findNodes(BinaryTree targetNode, Map<Integer, BinaryTree> nodesParents, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<BinaryTreeInfo> queue = new LinkedList<>();
        queue.add(new BinaryTreeInfo(targetNode, 0));
        Set<Integer> visitedNodes = new HashSet<>();

        while (!queue.isEmpty()) {
            BinaryTreeInfo currentInfo = queue.poll();
            int currentDistance = currentInfo.distance;
            BinaryTree currentNode = currentInfo.node;
            if (visitedNodes.contains(currentNode.value)) {
                continue;
            }
            visitedNodes.add(currentNode.value);
            if (currentDistance == k) {
                result.add(currentNode.value);
                while (!queue.isEmpty()) {
                    BinaryTreeInfo element = queue.poll();
                    if (element.node.value == targetNode.value) {
                        continue;
                    }
                    result.add(element.node.value);
                }
                break;
            }
            List<BinaryTree> neighbors = new ArrayList<>();
            if (currentNode.left != null) {
                neighbors.add(currentNode.left);
            }
            if (currentNode.right != null) {
                neighbors.add(currentNode.right);
            }
            if (nodesParents.get(currentNode.value) != null) {
                neighbors.add(nodesParents.get(currentNode.value));
            }
            for (BinaryTree neighbor : neighbors) {
                queue.add(new BinaryTreeInfo(neighbor, currentDistance + 1));
            }
        }

        //  --------------------------------------------------
        //      (3, 0)
        //  --------------------------------------------------
        return result;
    }

    private BinaryTree getTargetNode(Map<Integer, BinaryTree> nodesParents, BinaryTree root, int target) {
        BinaryTree targetNodeParent = nodesParents.get(target);
        if (targetNodeParent == null) {
            return root;
        }
        if (targetNodeParent.left != null && targetNodeParent.left.value == target) {
            return targetNodeParent.left;
        }
        return targetNodeParent.right;
    }

    private void populateNodesParent(BinaryTree node, BinaryTree parent, Map<Integer, BinaryTree> nodesParents) {
        if (node == null) {
            return;
        }
        nodesParents.put(node.value, parent);
        populateNodesParent(node.left, node, nodesParents);
        populateNodesParent(node.right, node, nodesParents);
    }

    static class BinaryTreeInfo {
        BinaryTree node;
        int distance;

        public BinaryTreeInfo(BinaryTree node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
