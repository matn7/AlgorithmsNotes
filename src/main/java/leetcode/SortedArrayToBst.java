package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortedArrayToBst {


    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        SortedArrayToBst sortedArrayToBst = new SortedArrayToBst();
        TreeNode result = sortedArrayToBst.sortedArrayToBST(nums);
        System.out.println();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> array = new ArrayList<>();
        for (int n : nums) {
            array.add(n);
        }
        return sortedArrayToBSTHelperIter(array);
    }

    private TreeNode sortedArrayToBSTHelper(List<Integer> array) {
        int midIdx;
        if (array.size() == 0) {
            return null;
        }
        if (array.size() <= 1) {
            midIdx = 0;
        } else {
            midIdx = array.size() / 2;
        }

        TreeNode node = new TreeNode(array.get(midIdx));
        if (midIdx != 0) {
            node.left = sortedArrayToBSTHelper(array.subList(0, midIdx));
        }
        if (midIdx + 1 != array.size()) {
            node.right = sortedArrayToBSTHelper(array.subList(midIdx + 1, array.size()));
        }
        return node;
    }

    private TreeNode sortedArrayToBSTHelperIter(List<Integer> array) {
        Stack<Element> stack = new Stack<>();
        TreeNode node = new TreeNode(0);
        if (array.size() == 0) {
            return null;
        }
        stack.push(new Element(node, array));

        while (!stack.isEmpty()) {
            Element items = stack.pop();
            List<Integer> arr = items.array;
            TreeNode parentNode = items.node;
            int midIdx;
            if (arr.size() == 0) {
                continue;
            }
            if (arr.size() <= 1) {
                midIdx = 0;
            } else {
                midIdx = arr.size() / 2;
            }
            parentNode.val = arr.get(midIdx);
            if (midIdx != 0) {
                parentNode.left = new TreeNode(0);
                stack.push(new Element(parentNode.left, arr.subList(0, midIdx)));
            }
            if (midIdx + 1 != arr.size()) {
                parentNode.right = new TreeNode(0);
                stack.push(new Element(parentNode.right, arr.subList(midIdx + 1, arr.size())));
            }
        }
        return node;
    }

    static class Element {
        TreeNode node;
        List<Integer> array;

        public Element(TreeNode node, List<Integer> array) {
            this.node = node;
            this.array = array;
        }
    }

}
