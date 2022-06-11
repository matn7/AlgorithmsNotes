package hard;

import java.util.*;

public class FindNodesDistanceKREPEAT {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.right = new BinaryTree(6);
        tree.right.right.left = new BinaryTree(7);
        tree.right.right.right = new BinaryTree(8);

        FindNodesDistanceKREPEAT findNodes = new FindNodesDistanceKREPEAT();
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

//    // O(n) time | O(n) space
//    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
//        // Write your code here.
//        ArrayList<Integer> nodesDistanceK = new ArrayList<>();
//        findDistanceFromNodeToTarget(tree, target, k, nodesDistanceK);
//        return nodesDistanceK;
//    }
//
//    private int findDistanceFromNodeToTarget(BinaryTree node, int target, int k, ArrayList<Integer> nodesDistanceK) {
//        if (node == null) {
//            return -1;
//        }
//
//        if (node.value == target) {
//            addSubtreeNodesAtDistanceK(node, 0, k, nodesDistanceK);
//            return 1;
//        }
//
//        int leftDistance = findDistanceFromNodeToTarget(node.left, target, k, nodesDistanceK);
//        int rightDistance = findDistanceFromNodeToTarget(node.right, target, k, nodesDistanceK);
//
//        if (leftDistance == k || rightDistance == k) {
//            nodesDistanceK.add(node.value);
//        }
//
//        if (leftDistance != -1) {
//            addSubtreeNodesAtDistanceK(node.right, leftDistance + 1, k, nodesDistanceK);
//            return leftDistance + 1;
//        }
//
//        if (rightDistance != -1) {
//            addSubtreeNodesAtDistanceK(node.left, rightDistance + 1, k, nodesDistanceK);
//            return rightDistance + 1;
//        }
//
//        return -1;
//    }
//
//    private void addSubtreeNodesAtDistanceK(BinaryTree node, int distance, int k, ArrayList<Integer> nodesDistanceK) {
//        if (node == null) {
//            return;
//        }
//
//        if (distance == k) {
//            nodesDistanceK.add(node.value);
//        } else {
//            addSubtreeNodesAtDistanceK(node.left, distance + 1, k, nodesDistanceK);
//            addSubtreeNodesAtDistanceK(node.right, distance + 1, k, nodesDistanceK);
//        }
//    }

//                      1
//                    /   \
//                   2     3
//                  / \     \
//                 4   5     6
//                          / \
//                         7   8

    // O(n) time | O(n) space
    // OK - repeated 29/01/2022
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        Map<Integer, BinaryTree> nodesToParents = new HashMap<>();
        populateNodesToParents(tree, nodesToParents, null);
        BinaryTree targetNode = getNodeFromValue(target, tree, nodesToParents); // (3)

        // rec((3), {}, 2)
        return breadthFirstSearchForNodesDistanceK(targetNode, nodesToParents, k);
    }

    // rec(1, null)
    private void populateNodesToParents(BinaryTree node, Map<Integer, BinaryTree> nodesToParents,
                                        BinaryTree parent) {
        // {1: null, 2: (1), 4: (2), 5: (2), 3: (1), 6: (3), 7: (6), 8: (6)}
        if (node != null) {
            nodesToParents.put(node.value, parent);
            populateNodesToParents(node.left, nodesToParents, node); // rec(7, 6)
            populateNodesToParents(node.right, nodesToParents, node); // rec(8, 6)
        }
    }

    // rec((3), {}, 2)
    private ArrayList<Integer> breadthFirstSearchForNodesDistanceK(BinaryTree targetNode,
            Map<Integer, BinaryTree> nodesToParents, int k) {
        // nodesToParents {1: null, 2: (1), 4: (2), 5: (2), 3: (1), 6: (3), 7: (6), 8: (6)}
        Queue<TreeInfo> queue = new LinkedList<>();
        // -------------------------------------
        // ((2), 2)
        // -------------------------------------
        queue.add(new TreeInfo(targetNode, 0));
        // {}
        Map<Integer, Boolean> seen = new HashMap<>();
        ArrayList<Integer> nodesDistanceK = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeInfo currentNodeInfo = queue.poll(); // ((7), 2)
            if (currentNodeInfo.distance == k) { // 2 == 2
                while (!queue.isEmpty()) {
                    int element = queue.poll().node.value; // 2
                    if (element != targetNode.value) { // 2 != 3
                        nodesDistanceK.add(element);
                    }
                }
                nodesDistanceK.add(currentNodeInfo.node.value);
                // [8, 2, 7]
                return nodesDistanceK;
            }
            List<BinaryTree> connectedNodes = new ArrayList<>();
            connectedNodes.add(currentNodeInfo.node.left); // (3)
            connectedNodes.add(currentNodeInfo.node.right); // (2)
            connectedNodes.add(nodesToParents.get(currentNodeInfo.node.value)); // null

            // [(3), (2), null]
            for (BinaryTree node : connectedNodes) {
                if (node == null) {
                    continue;
                }
                // {6: TRUE, 1: TRUE, 7: TRUE, 8: TRUE, 3: TRUE, 2: TRUE}
                if (seen.containsKey(node.value)) {
                    continue;
                }

                seen.put(node.value, Boolean.TRUE);
                queue.add(new TreeInfo(node, currentNodeInfo.distance + 1));
            }
        }
        return new ArrayList<>();
    }

    // rec(3, (1), {})
    private BinaryTree getNodeFromValue(int value, BinaryTree tree, Map<Integer, BinaryTree> nodesToParents) {
        if (tree.value == value) {
            return tree;
        }
        // nodesToParents {1: null, 2: (1), 4: (2), 5: (2), 3: (1), 6: (3), 7: (6), 8: (6)}
        BinaryTree nodeParent = nodesToParents.get(value); // (1)
        if (nodeParent.left != null && nodeParent.left.value == value) {
            return nodeParent.left;
        }

        return nodeParent.right; // (3)
    }

    static class TreeInfo {
        BinaryTree node;
        int distance;

        public TreeInfo(BinaryTree node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }


//    // O(n) time | O(n) space
//    public ArrayList<Integer> findNodesDistanceK2(BinaryTree tree, int target, int k) {
//        // Write your code here.
//        Map<Integer, BinaryTree> parents = new HashMap<>();
//        List<BinaryTree> targetNode = new ArrayList<>();
//
//        depthFirst(tree, targetNode, target, parents);
//        if (targetNode.isEmpty()) {
//            return new ArrayList<>();
//        }
//        ArrayList<Integer> integers = breadthFirst(targetNode.get(0), parents, k);
//        return integers;
//    }
//
//    public void depthFirst(BinaryTree tree, List<BinaryTree> targetNode, int target, Map<Integer, BinaryTree> parents) {
//        if (tree == null) {
//            return;
//        }
//        if (tree.value == target) {
//            targetNode.add(tree);
//        }
//        if (tree.left != null) {
//            parents.put(tree.left.value, tree);
//        }
//        depthFirst(tree.left, targetNode, target, parents);
//        if (tree.right != null) {
//            parents.put(tree.right.value, tree);
//        }
//        depthFirst(tree.right, targetNode, target, parents);
//
//    }
//
//    public ArrayList<Integer> breadthFirst(BinaryTree tree, Map<Integer, BinaryTree> parents, int k) {
//        // Node ---> Parent
//        Queue<TreeInfo> queue = new LinkedList<>();
//        queue.add(new TreeInfo(tree, 0));
//        ArrayList<Integer> result = new ArrayList<>();
//        Map<Integer, Boolean> visitedNodes = new HashMap<>();
//
//        while (!queue.isEmpty()) {
//            TreeInfo poll = queue.poll();
//
//            if (visitedNodes.containsKey(poll.node.value)) {
//                continue;
//            }
//
//            visitedNodes.put(poll.node.value, Boolean.TRUE);
//
//            System.out.print(poll.node.value + " ");
//            if (poll.distance == k) {
//                result.add(poll.node.value);
//                while (!queue.isEmpty()) {
//                    BinaryTree node = queue.poll().node;
//                    if (node != tree) {
//                        result.add(node.value);
//                    }
//                }
//                break;
//            }
//
//            // check parent
//            if (parents.get(poll.node.value) != null) {
//                queue.add(new TreeInfo(parents.get(poll.node.value), poll.distance + 1));
//            }
//
//            // check left
//            if (poll.node.left != null) {
//                queue.add(new TreeInfo(poll.node.left, poll.distance + 1));
//            }
//            // check right
//            if (poll.node.right != null) {
//                queue.add(new TreeInfo(poll.node.right, poll.distance + 1));
//            }
//        }
//        return result;
//    }
}
