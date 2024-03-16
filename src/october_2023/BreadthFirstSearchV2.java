package october_2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchV2 {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        // O(v + e) time | O(v) space
        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                array.add(current.name);
                List<Node> childrens = current.children;
                queue.addAll(childrens);
            }
            return array;
        }
    }

}
