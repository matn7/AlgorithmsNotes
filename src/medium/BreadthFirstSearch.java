package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

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

        tree.breadthFirstSearch(new ArrayList<>());
    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);

            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                array.add(poll.name);
                for (Node child : poll.children) {
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
