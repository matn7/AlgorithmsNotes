package may_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(6);
        node.right = new Node(1);
        node.left.left = new Node(9);
        node.left.right = new Node(2);
        node.right.right = new Node(4);
        node.left.left.right = new Node(5);
        node.left.left.right.left = new Node(8);

        List<List<Integer>> result = levelOrderTraversal(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<List<Integer>> levelOrderTraversal(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node frontElement = queue.poll();
                sublist.add(frontElement.value);
                if (frontElement.left != null) {
                    queue.add(frontElement.left);
                }
                if (frontElement.right != null) {
                    queue.add(frontElement.right);
                }
            }
            result.add(sublist);
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
