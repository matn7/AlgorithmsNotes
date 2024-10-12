package may_2024;

public class CountGreaterThan {

    public static void main(String[] args) {
        Node node = new Node(2000);
        node.left = new Node(1000);
        node.right = new Node(4000);
        node.right.left = new Node(3000);
        node.right.left.left = new Node(2500);

        int result = countGreaterThan(node, 2200);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int countGreaterThan(Node node, int min) {
        if (node == null) {
            return 0;
        }
        int right = countGreaterThan(node.right, min);
        if (node.value < min) {
            return right;
        }
        int left = countGreaterThan(node.left, min);
        return left + right + 1;
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


