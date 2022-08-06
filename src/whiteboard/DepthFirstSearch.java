package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        // O(v + e) time | O(v) space
        // rand: 31/07/2022
        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            array.add(name);
            for (Node child : children) {
                child.depthFirstSearch(array);
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
