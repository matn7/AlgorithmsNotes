package august_2024;

public class NumEmployeesV3 {

    public static void main(String[] args) {
        Node node = new Node(2000);
        node.left = new Node(1000);
        node.right = new Node(4000);
        node.right.left = new Node(3000);
        node.right.left.left = new Node(2500);

        int result = numEmployees(node, 2050);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int numEmployees(Node node, int min) {
        if (node == null) {
            return 0;
        }
        int right = numEmployees(node.right, min);
        if (node.value < min) {
            return right;
        }
        int left = numEmployees(node.left, min);
        return 1 + left + right;

    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
