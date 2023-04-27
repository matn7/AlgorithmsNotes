package whiteboard;

import java.util.*;

public class FindNodesDistanceK {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class BinaryTreeInfo {
        int distance;
        BinaryTree node;

        public BinaryTreeInfo(int distance, BinaryTree node) {
            this.distance = distance;
            this.node = node;
        }
    }

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
        findNodesDistanceK.findNodesDistanceK(tree, 3, 2);
    }

    // ********
    // * STAR *
    // ********

    // Remember cases:
    // Do not add null as parent
    // Check targetNode to be a root of tree
    // Keep track of visited nodes

    // O(n) time | O(n) space
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        Map<Integer, BinaryTree> parentsMap = new HashMap<>();
        populateParentsMap(tree, null, parentsMap);
        BinaryTree targetNode = getTargetNode(parentsMap, target, tree);
        return findNodes(targetNode, parentsMap, k);
    }

    private void populateParentsMap(BinaryTree node, BinaryTree parent, Map<Integer, BinaryTree> parentsMap) {
        if (node == null) {
            return;
        }
        parentsMap.put(node.value, parent);
        populateParentsMap(node.left, node, parentsMap);
        populateParentsMap(node.right, node, parentsMap);
    }

    private BinaryTree getTargetNode(Map<Integer, BinaryTree> parentsMap, int target, BinaryTree tree) {
        BinaryTree parent = parentsMap.get(target);
        if (parent == null) {
            return tree;
        }
        if (parent.left != null && parent.left.value == target) {
            return parent.left;
        }
        return parent.right;
    }

    private ArrayList<Integer> findNodes(BinaryTree targetNode, Map<Integer, BinaryTree> parentsMap, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<BinaryTreeInfo> queue = new LinkedList<>();
        queue.add(new BinaryTreeInfo(0, targetNode));
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            BinaryTreeInfo current = queue.poll();
            int currDist = current.distance;
            BinaryTree currNode = current.node;
            if (currDist == k) {
                // populate result array
                result.add(currNode.value);
                while (!queue.isEmpty()) {
                    BinaryTreeInfo poll = queue.poll();
                    result.add(poll.node.value);
                }
                break;
            }
            visited.add(currNode.value);
            List<BinaryTree> neighbors = new ArrayList<>();
            if (currNode.left != null) {
                neighbors.add(currNode.left);
            }
            if (currNode.right != null) {
                neighbors.add(currNode.right);
            }
            if (parentsMap.containsKey(currNode.value) && parentsMap.get(currNode.value) != null) {
                neighbors.add(parentsMap.get(currNode.value));
            }
            for (BinaryTree neighbor : neighbors) {
                if (visited.contains(neighbor.value)) {
                    continue;
                }
                queue.add(new BinaryTreeInfo(currDist + 1, neighbor));
            }
        }

        return result;
    }


}
