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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.right = new BinaryTree(3);
//        tree.left.left = new BinaryTree(4);
//        tree.left.right = new BinaryTree(5);
//        tree.right.right = new BinaryTree(6);
//        tree.right.right.left = new BinaryTree(7);
//        tree.right.right.right = new BinaryTree(8);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(3);
        tree.left.left.left = new BinaryTree(4);
        tree.left.left.left.left = new BinaryTree(5);

        FindNodesDistanceK findNodesDistanceK = new FindNodesDistanceK();
//        findNodesDistanceK.findNodesDistanceK(tree, 3, 2);
        findNodesDistanceK.findNodesDistanceK(tree, 2, 3);
    }

    static class Node {
        public BinaryTree treeNode;
        int distance;

        public Node(BinaryTree treeNode, int distance) {
            this.treeNode = treeNode;
            this.distance = distance;
        }
    }

    // O(n) time | O(n) space
    // #2: 15/06/2022
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, BinaryTree> parentsMap = new HashMap<>();

        populateParentsMap(tree, null, parentsMap);

        BinaryTree targetNode = getTargetNode(target, tree, parentsMap);

        Queue<Node> queue = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();
        queue.add(new Node(targetNode, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            visited.add(currentNode.treeNode.value);
            int distance = currentNode.distance;

            if (distance == k) {
                for (Node element : queue) {
                    if (element.treeNode.value != target) {
                        result.add(element.treeNode.value);
                    }
                }
                result.add(currentNode.treeNode.value);
                break;
            }

            List<BinaryTree> neighbors = new ArrayList<>();
            neighbors.add(parentsMap.get(currentNode.treeNode.value));
            neighbors.add(currentNode.treeNode.left);
            neighbors.add(currentNode.treeNode.right);

            for (BinaryTree neighbor : neighbors) {
                if (neighbor == null || visited.contains(neighbor.value)) {
                    continue;
                }

                queue.add(new Node(neighbor, distance + 1));
            }
        }


        return result;
    }

    private BinaryTree getTargetNode(int target, BinaryTree tree, Map<Integer, BinaryTree> parentsMap) {
        if (tree.value == target) {
            return tree;
        }
        BinaryTree parent = parentsMap.get(target);
        if (parent.left != null && parent.left.value == target) {
            return parent.left;
        }
        return parent.right;
    }

    private Map<Integer, BinaryTree> populateParentsMap(BinaryTree node, BinaryTree parent,
                                                           Map<Integer, BinaryTree> parentsMap ) {
        parentsMap.put(node.value, parent);
        if (node.left != null) {
            populateParentsMap(node.left, node, parentsMap);
        }
        if (node.right != null) {
            populateParentsMap(node.right, node, parentsMap);
        }
        return parentsMap;
    }

}
