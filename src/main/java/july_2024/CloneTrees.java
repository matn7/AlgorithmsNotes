package july_2024;


public class CloneTrees {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.right.left = new Node(4);
        a.right.right = new Node(5);

        Node b = new Node(1);
        b.left = new Node(2);
        b.right = new Node(3);
        b.right.left = new Node(4);
        b.right.right = new Node(5);

        Node node = a.right.left;

        Node node1 = findNode(a, b, node);
        System.out.println(node1 == b.right.left);
    }

    public static Node findNode(Node a, Node b, Node n) {
        if (a == n) {
            return b;
        }
        if (a.left != null && b.left != null) {
            Node found = findNode(a.left, b.left, n);
            if (found != null) {
                return found;
            }
        }
        if (a.right != null && b.right != null) {
            Node found = findNode(a.right, b.right, n);
            if (found != null) {
                return found;
            }
        }
        return null;
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
