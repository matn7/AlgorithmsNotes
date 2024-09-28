package problems.other;

import java.util.ArrayList;
import java.util.List;

public class FindCousins2 {

    public static void main(String[] args) {
        TreeNodeParent node1 = new TreeNodeParent(1);
        TreeNodeParent node2 = new TreeNodeParent(2);
        TreeNodeParent node3 = new TreeNodeParent(3);
        TreeNodeParent node4 = new TreeNodeParent(4);
        TreeNodeParent node5 = new TreeNodeParent(5);
        TreeNodeParent node6 = new TreeNodeParent(6);

        // node1
        node1.left = node2;
        node1.right = node3;

        // node2
        node2.left = node4;
        node2.right = node6;
        node2.parent = node1;

        // node3
        node3.right = node5;
        node3.parent = node1;

        // node4
        node4.parent = node2;

        // node6
        node6.parent = node2;

        // node5
        node5.parent = node3;

        FindCousins2 findCousins2 = new FindCousins2();
        findCousins2.findCousins(node1, node5);

    }

    public List<TreeNodeParent> findCousins(TreeNodeParent node, TreeNodeParent cousin) {
        int depth = getDepth(cousin);
        List<TreeNodeParent> cousins = new ArrayList<>();
        findCousinsHelper(node, cousin, 0, depth, cousins);
        return cousins;
    }

    private void findCousinsHelper(TreeNodeParent currNode, TreeNodeParent cousin, int currDepth, int depth,
                                   List<TreeNodeParent> cousins) {
        if (currNode == cousin.parent) {
            return;
        }
        if (currDepth == depth) {
            cousins.add(currNode);
            return;
        }
        findCousinsHelper(currNode.left, cousin, currDepth + 1, depth, cousins);
        findCousinsHelper(currNode.right, cousin, currDepth + 1, depth, cousins);
    }

    private int getDepth(TreeNodeParent node) {
        int depth = 0;
        TreeNodeParent curr = node;
        while (curr.parent != null) {
            curr = curr.parent;
            depth++;
        }
        return depth;
    }

}
