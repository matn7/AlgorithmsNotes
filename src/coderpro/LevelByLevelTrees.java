package coderpro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelByLevelTrees {

    public static void main(String[] args) {
        TreeNodeList nodeA = new TreeNodeList('a');
        TreeNodeList nodeB = new TreeNodeList('b');
        TreeNodeList nodeC = new TreeNodeList('c');
        TreeNodeList nodeD = new TreeNodeList('d');
        TreeNodeList nodeE = new TreeNodeList('e');
        TreeNodeList nodeF = new TreeNodeList('f');
        TreeNodeList nodeG = new TreeNodeList('g');
        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeG);
        nodeC.addNeighbor(nodeD);
        nodeC.addNeighbor(nodeE);
        nodeC.addNeighbor(nodeF);

        LevelByLevelTrees levelByLevelTrees = new LevelByLevelTrees();
        List<TreeNodeList> result = levelByLevelTrees.levelTraversal(nodeA);

        for (TreeNodeList node : result) {
            System.out.print(node.value + " ");
        }
        System.out.println();
        System.out.println("==========");
        levelByLevelTrees.levelPrint(nodeA);

    }

    // O(n) time | O(n) space
    public void levelPrint(TreeNodeList node) {
        Queue<TreeNodeList> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int num = q.size();
            while (num > 0) {
                TreeNodeList n = q.poll();
                System.out.print(n.value);
                List<TreeNodeList> neighbors = n.neighbors;
                q.addAll(neighbors);
                num--;
            }
            System.out.println();
        }
    }

    // O(n) time | O(n) space
    public List<TreeNodeList> levelTraversal(TreeNodeList node) {
        List<TreeNodeList> result = new ArrayList<>();
        Queue<TreeNodeList> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNodeList current = queue.poll();
                result.add(current);
                System.out.print(current.value);
                List<TreeNodeList> neighbors = current.neighbors;
                for (TreeNodeList neighbor : neighbors) {
                    queue.add(neighbor);
                }
                size--;
            }
            System.out.println();
        }
        return result;
    }

}

class TreeNodeList {
    Character value;
    List<TreeNodeList> neighbors;

    public TreeNodeList(Character value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(TreeNodeList node) {
        this.neighbors.add(node);
    }
}
