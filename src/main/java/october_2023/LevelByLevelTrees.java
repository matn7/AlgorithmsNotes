package october_2023;

import java.util.*;

public class LevelByLevelTrees {

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        a.addNeighbor(b);
        a.addNeighbor(c);

        b.addNeighbor(g);

        c.addNeighbor(d);
        c.addNeighbor(e);
        c.addNeighbor(f);

        levelByLevel(a);
    }

    // O(n) time | O(n) space
    public static void levelByLevel(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size != 0) {
                Node current = queue.poll();
                System.out.print(current.val);
                List<Node> neighbors = current.neighbors;
                queue.addAll(neighbors);
                size--;
            }
            System.out.println();
        }
    }

    static class Node {
        String val;
        List<Node> neighbors;

        public Node(String val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            this.neighbors.add(node);
        }
    }

}
