package november_2023;

public class YoungestCommonAncestor {

    public static void main(String[] args) {
        AncestorTree A = new AncestorTree('A', null);
        AncestorTree B = new AncestorTree('B', A);
        AncestorTree C = new AncestorTree('C', A);
        AncestorTree D = new AncestorTree('D', B);
        AncestorTree E = new AncestorTree('E', B);
        AncestorTree F = new AncestorTree('F', C);
        AncestorTree G = new AncestorTree('G', C);
        AncestorTree H = new AncestorTree('H', D);
        AncestorTree I = new AncestorTree('I', D);

        youngestCommonAncestor(A, E, I);
    }

    // O(n) time | O(1) space
    public static AncestorTree youngestCommonAncestor(AncestorTree root, AncestorTree node1, AncestorTree node2) {
        int node1Depth = getDepth(root, node1);
        int node2Depth = getDepth(root, node2);

        if (node1Depth > node2Depth) {
            while (node1Depth > node2Depth) {
                node1 = node1.parent;
                node1Depth--;
            }
        } else {
            while (node2Depth > node1Depth) {
                node2 = node2.parent;
                node2Depth--;
            }
        }

        while (node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        return node1;
    }

    private static int getDepth(AncestorTree root, AncestorTree node) {
        int depth = 0;
        while (node != root) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    static class AncestorTree {
        char id;
        AncestorTree parent;

        public AncestorTree(char id, AncestorTree parent) {
            this.id = id;
            this.parent = parent;
        }
    }

}
