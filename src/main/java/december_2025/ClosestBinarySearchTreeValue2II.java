package december_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValue2II {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        double target = 3.714286;
        int k = 2;

        ClosestBinarySearchTreeValue2II closestBinarySearchTreeValue2II = new ClosestBinarySearchTreeValue2II();
        List<Integer> result = closestBinarySearchTreeValue2II.closestKValues(root, target, k);
        System.out.println(result);
    }

    // O(nlog(k)) time | O(k) space
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));
        preOrder(root, target, maxHeap, k);

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().val);
        }

        return result;
    }

    private void preOrder(TreeNode node, double target, PriorityQueue<Node> maxHeap, int k) {
        if (node == null) {
            return;
        }
        double dist = Math.abs(node.val - target);
        if (maxHeap.isEmpty() || maxHeap.size() < k) {
            maxHeap.add(new Node(node.val, dist));
        } else {
            Node currMax = maxHeap.peek();
            if (currMax.distance > dist) {
                maxHeap.poll();
                maxHeap.add(new Node(node.val, dist));
            }
        }
        preOrder(node.left, target, maxHeap, k);
        preOrder(node.right, target, maxHeap, k);
    }

    static class Node {
        int val;
        double distance;

        public Node(int val, double distance) {
            this.val = val;
            this.distance = distance;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
