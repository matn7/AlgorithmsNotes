package october_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReconstructBst {

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 1, 5, 17, 19, 18};
        List<Integer> array = new ArrayList<>();
        for (int num : arr) {
            array.add(num);
        }

        Node node = reconstructBst(array);
        System.out.println();

    }

    // O(n^2) time | O(n) space
    public static Node reconstructBst(List<Integer> array) {
        return reconstructBstHelper(array);
    }

    public static Node reconstructBstHelper(List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        Integer current = array.remove(0);
        Node node = new Node(current);
        List<Integer> smaller = getElements(array, a -> a < current);
        List<Integer> larger = getElements(array, a -> a >= current);
        node.left = reconstructBstHelper(smaller);
        node.right = reconstructBstHelper(larger);
        return node;
    }

    private static List<Integer> getElements(List<Integer> array,Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : array) {
            if (predicate.test(num)) {
                result.add(num);
            }
        }
        return result;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
