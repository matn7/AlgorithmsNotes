package august_2024;

public class NumOfEmployeesV2 {

    public static void main(String[] args) {
        Node node = new Node(2000);
        node.left = new Node(1000);
        node.right = new Node(4000);
        node.right.left = new Node(3000);
        node.right.left.left = new Node(2500);

        int employees = findEmployees(node, 2050);
        System.out.println(employees);
    }

    // O(n) time | O(n) space
    public static int numEmployees(Node node, int min) {
        if (node == null) {
            return 0;
        }
        return findEmployees(node, min);
    }

    private static int findEmployees(Node node, int min) {
        if (node == null) {
            return 0;
        }
        int right = findEmployees(node.right, min);
        if (node.salary < min) {
            return right;
        }
        int left = findEmployees(node.left, min);
        return 1 + left + right;
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
