package may_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(6);
        node.left.left.right = new Node(7);
        node.left.left.right.left = new Node(8);

        RightSideView rightSideView = new RightSideView();
        List<Integer> result = rightSideView.rightViewDFS(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> rightViewBFS(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node frontElement = queue.poll();
                if (frontElement.left != null) {
                    queue.add(frontElement.left);
                }
                if (frontElement.right != null) {
                    queue.add(frontElement.right);
                }
                if (i == size - 1) {
                    result.add(frontElement.value);
                }
            }
        }

        return result;
    }

    Integer seenLevel = 0;

    // O(n) time | O(n) space
    public List<Integer> rightViewDFS(Node node) {
        List<Integer> result = new ArrayList<>();
        dfs(node, 0, result);
        return result;
    }

    private void dfs(Node node, int currentLevel, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (currentLevel >= seenLevel) {
            result.add(node.value);
            seenLevel++;
        }
        currentLevel++;
        dfs(node.right, currentLevel, result);
        dfs(node.left, currentLevel, result);
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
