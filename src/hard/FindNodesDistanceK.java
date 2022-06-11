package hard;

import java.util.*;

public class FindNodesDistanceK {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.right.right.left = new BinaryTree(7);
        root.right.right.right = new BinaryTree(8);
//        root.left = new BinaryTree(2);
//        root.left.left = new BinaryTree(3);
//        root.left.left.left = new BinaryTree(4);
//        root.left.left.left.left = new BinaryTree(5);

        FindNodesDistanceK fndk = new FindNodesDistanceK();

//        traverseBreadthFirst(root);
        System.out.println();

//        fndk.findNodesDistanceK(root, 2, 3);
        fndk.findNodesDistanceK(root, 3, 2);

        System.out.println();
    }

//                      1
//                    /   \
//                   2     3
//                  / \     \
//                 4   5     6
//                          / \
//                         7   8

    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<BinaryTree> queue = new LinkedList<>();
        queue.addLast(tree);
        BinaryTree targetNode = findTargetNode(target, queue);

        Map<Integer, BinaryTree> nodeParentMap = new HashMap<>();
        populateParentNodesMap(tree, nodeParentMap);

        Map<Integer, Boolean> nodeVisitedMap = new HashMap<>();
        LinkedList<WithinDistanceNodes> queue2 = new LinkedList<>();
        WithinDistanceNodes firstNode = new WithinDistanceNodes(targetNode, 0);
        queue2.add(firstNode);
        nodeVisitedMap.put(targetNode.value, true);

        while (!queue2.isEmpty()) {
            WithinDistanceNodes current = queue2.pollFirst();
            System.out.println(current.tree.value + " : " + current.distance);

            if (current.distance == k && current.tree.value != target) {
                result.add(current.tree.value);
            }

            // visit parent
            BinaryTree currentParent = nodeParentMap.get(current.tree.value);
            if (currentParent != null && !nodeVisitedMap.containsKey(currentParent.value)) {
                queue2.addLast(new WithinDistanceNodes(currentParent, current.distance + 1));
                nodeVisitedMap.put(currentParent.value, true);
            }

            // visit left child
            if (current.tree.left != null && !nodeVisitedMap.containsKey(current.tree.left.value)) {
                queue2.addLast(new WithinDistanceNodes(current.tree.left, current.distance + 1));
                nodeVisitedMap.put(current.tree.left.value, true);
            }

            // visit right child
            if (current.tree.right != null && !nodeVisitedMap.containsKey(current.tree.right.value)) {
                queue2.addLast(new WithinDistanceNodes(current.tree.right, current.distance + 1));
                nodeVisitedMap.put(current.tree.right.value, true);
            }
        }

        return result;
    }

    private void populateParentNodesMap(BinaryTree root, Map<Integer, BinaryTree> nodeParentMap) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            nodeParentMap.put(root.left.value, root);
        }
        populateParentNodesMap(root.left, nodeParentMap);

        if (root.right != null) {
            nodeParentMap.put(root.right.value, root);
        }
        populateParentNodesMap(root.right, nodeParentMap);
    }


    private BinaryTree findTargetNode(int target, LinkedList<BinaryTree> queue) {
        BinaryTree targetNode = null;
        while (!queue.isEmpty()) {
            BinaryTree current = queue.pollFirst();
            if (current.value == target) {
                targetNode = current;
                break;
            }
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
        return targetNode;
    }

    class WithinDistanceNodes {
        public BinaryTree tree;
        public int distance;

        public WithinDistanceNodes(BinaryTree tree, int distance) {
            this.tree = tree;
            this.distance = distance;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
