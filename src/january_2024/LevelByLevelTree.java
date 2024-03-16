package january_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelByLevelTree {

    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');

        a.addNeighbor(b);
        a.addNeighbor(c);
        b.addNeighbor(g);
        c.addNeighbor(d);
        c.addNeighbor(e);
        c.addNeighbor(f);

        levelByLevelTrees(a);
    }

    // O(n) time | O(n) space
    public static void levelByLevelTrees(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();;
            while (currentSize > 0) {
                Node poll = queue.poll();
                System.out.print(poll.val);
                List<Node> neighbors = poll.neighbors;
                for (Node neighbor : neighbors) {
                    queue.add(neighbor);
                }
                currentSize--;
            }
            System.out.println();
        }
    }

    static class Node {
        char val;
        List<Node> neighbors;

        public Node(char val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
