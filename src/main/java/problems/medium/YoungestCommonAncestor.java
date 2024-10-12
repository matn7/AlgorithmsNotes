package problems.medium;

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

        AncestralTree result = getYoungestCommonAncestor(root, nodeE, nodeI);
        System.out.println();
    }


    // O(d) time (depth of lowest descendant) | O(1) space
    // OK - repeated 15/02/2022
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        // rec(
        int depthOne = getDescendantDepth(descendantOne, topAncestor); // 2
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor); // 3
        if (depthOne > depthTwo) {
            return backtrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backtrackAncestralTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    private static AncestralTree backtrackAncestralTree(AncestralTree lowerDescendant,
                                                        AncestralTree higherDescendant, int diff) {
        while (diff > 0) {
            lowerDescendant = lowerDescendant.ancestor;
            diff--;
        }
        while (lowerDescendant != higherDescendant) {
            lowerDescendant = lowerDescendant.ancestor;
            higherDescendant = higherDescendant.ancestor;
        }
        return lowerDescendant;
    }

    private static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;
        while (descendant != topAncestor) {
            depth++;
            descendant = descendant.ancestor;
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
