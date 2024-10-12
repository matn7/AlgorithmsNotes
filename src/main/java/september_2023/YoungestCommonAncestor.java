package september_2023;

public class YoungestCommonAncestor {

    // O(d) time | O(1) space
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor,
            AncestralTree descendantOne,
            AncestralTree descendantTwo
    ) {
        
        // Write your code here.
        int oneDepth = getDepth(descendantOne, topAncestor);
        int twoDepth = getDepth(descendantTwo, topAncestor);

        if (oneDepth > twoDepth) {
            for (int i = 0; i < oneDepth - twoDepth; i++) {
                descendantOne = descendantOne.ancestor;
            }
        } else if (twoDepth > oneDepth) {
            for (int i = 0; i < twoDepth - oneDepth; i++) {
                descendantTwo = descendantTwo.ancestor;
            }
        }

        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        return descendantOne; // Replace this line
    }

    private static int getDepth(AncestralTree node, AncestralTree top) {
        AncestralTree current = node;
        int counter = 0;
        while (current != top) {
            current = current.ancestor;
            counter++;
        }
        return counter;
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
