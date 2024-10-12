package whiteboard;

public class YoungestCommonAncestor {

    // O(d) time | O(1) space - d is depth of tree, equal to n in worst case
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int depthOne = getDepth(descendantOne, topAncestor);
        int depthTwo = getDepth(descendantTwo, topAncestor);

        if (depthOne > depthTwo) {
            while (depthOne != depthTwo) {
                descendantOne = descendantOne.ancestor;
                depthOne--;
            }
        } else if (depthTwo > depthOne) {
            while (depthTwo != depthOne) {
                descendantTwo = descendantTwo.ancestor;
                depthTwo--;
            }
        }

        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        return descendantOne; // Replace this line
    }

    private static int getDepth(AncestralTree descendant, AncestralTree ancestor) {
        int depth = 0;
        while (descendant != ancestor) {
            descendant = descendant.ancestor;
            depth++;
        }
        return depth;
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
