package october_2023;

import java.util.ArrayList;
import java.util.List;

public class SalaryRange {

    public static void main(String[] args) {
        Node node = new Node(2000);
        node.left = new Node(1000);
        node.right = new Node(4000);
        node.right.left = new Node(3000);
        node.right.left.left = new Node(2500);

        System.out.println(findSalaries(node, 1800));
    }

    // O(n) time | O(n) space
    public static int findSalaries(Node node, int min) {
        if (node == null) {
            return 0;
        }
        int right = findSalaries(node.right, min);
        if (node.salary < min) {
            return right;
        } else {
            int left = findSalaries(node.left, min);
            return 1 + left + right;
        }
    }

    static class Node {
        int salary;
        Node left;
        Node right;

        public Node(int salary) {
            this.salary = salary;
        }
    }

}
