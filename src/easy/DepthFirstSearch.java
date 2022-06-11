package easy;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    // OK - repeated 01/03/2022
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
        // A - B,C,D *
        // B - E,F
        // C -
        // D - G,H
        // E -
        // F - I,J
        // G - K
        // H -

        public Node(String name) {
            this.name = name;
        }
        // array = [A, B, E, F, I, J, C, D, G, K, H]
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
