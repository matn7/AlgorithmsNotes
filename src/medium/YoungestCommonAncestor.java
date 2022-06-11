package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YoungestCommonAncestor {

    public static void main(String[] args) {
        AncestralTree root = new AncestralTree('A');
        AncestralTree nodeB = new AncestralTree('B');
        nodeB.ancestor = root;
        AncestralTree nodeC = new AncestralTree('C');
        nodeC.ancestor = root;
        AncestralTree nodeD = new AncestralTree('D');
        nodeD.ancestor = nodeB;
        AncestralTree nodeE = new AncestralTree('E');
        nodeE.ancestor = nodeB;
        AncestralTree nodeF = new AncestralTree('F');
        nodeF.ancestor = nodeC;
        AncestralTree nodeG = new AncestralTree('G');
        nodeG.ancestor = nodeC;
        AncestralTree nodeH = new AncestralTree('H');
        nodeH.ancestor = nodeD;
        AncestralTree nodeI = new AncestralTree('I');
        nodeI.ancestor = nodeD;

        getYoungestCommonAncestor(root, nodeE, nodeI);
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.

        List<AncestralTree> pathOne = breadthFirst(descendantOne);
        List<AncestralTree> pathTwo = breadthFirst(descendantTwo);

        for (AncestralTree element : pathTwo) {
            if (pathOne.contains(element)) {
                System.out.println();
                return element;
            }
        }

        return topAncestor; // Replace this line
    }

    public static List<AncestralTree> breadthFirst(AncestralTree node) {
        Queue<AncestralTree> queue = new LinkedList<>();
        queue.add(node);

        List<AncestralTree> path = new ArrayList<>();

        while (!queue.isEmpty()) {
            AncestralTree poll = queue.poll();

            System.out.println(poll.name);
            path.add(poll);

            if (poll.ancestor != null) {
                queue.add(poll.ancestor);
            }
        }

        return path;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
