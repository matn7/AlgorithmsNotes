package april_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.left.left = new Node(8);
        node.right.left = new Node(3);
        node.right.right = new Node(7);
        node.right.right.left = new Node(1);
        node.right.right.right = new Node(2);

        List<List<Integer>> result = levelOrder(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<List<Integer>> levelOrder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> levelElements = new ArrayList<>();
            while (count > 0) {
                Node frontElement = queue.poll();
                if (frontElement.left != null) {
                    queue.add(frontElement.left);
                }
                if (frontElement.right != null) {
                    queue.add(frontElement.right);
                }
                levelElements.add(frontElement.value);
                count--;
            }
            result.add(levelElements);
        }

        return result;
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
