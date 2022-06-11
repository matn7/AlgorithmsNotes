package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchREPEAT {

    public static void main(String[] args) {
        Node tree = new Node("A");
        tree.addChild("B");
        tree.addChild("C");
        tree.addChild("D");

        tree.children.get(0).addChild("E");
        tree.children.get(0).addChild("F");
        tree.children.get(2).addChild("G");
        tree.children.get(2).addChild("H");
        tree.children.get(0).children.get(1).addChild("I");
        tree.children.get(0).children.get(1).addChild("J");
        tree.children.get(2).children.get(0).addChild("K");

        List<String> input = new ArrayList<>();
        List<String> strings = tree.breadthFirstSearch(input);
        System.out.println();
    }
    //                  A
    //               /  |  \
    //              B   C   D
    //             / \     / \
    //            E   F   G   H
    //               / \   \
    //              I   J   K

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        // O(V + E) time (V has how many children as edges) | O(V) space
        // OK - repeated 11/02/2022
        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> queue = new LinkedList<>();
            // ---------------------------------------
            //
            // ---------------------------------------
            queue.add(this);
            while (!queue.isEmpty()) {
                Node current = queue.poll(); // (K)
                array.add(current.name); // [A, B, C, D, E, F, G, H, I, J, K]
                for (Node child : current.children) { // []
                    queue.add(child);
                }
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
