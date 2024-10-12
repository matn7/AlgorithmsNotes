package october_2023;

public class InorderSuccessor {

    public static void main(String[] args) {
        Node root = new Node(4);
        Node one = new Node(2);
        Node two = new Node(8);
        Node three = new Node(1);
        Node four = new Node(5);
        Node five = new Node(9);
        Node six = new Node(7);
        Node seven = new Node(7);

        root.left = one;
        root.right = two;
        one.parent = root;
        two.parent = root;

        one.left = three;
        three.parent = one;

        two.left = four;
        two.right = five;
        four.parent = two;
        five.parent = two;

        four.right = six;
        six.parent = four;

        six.right = seven;
        seven.parent = six;

//        inOrder(root);

        System.out.println(inOrderSuccessor(seven).value);
        System.out.println(inOrderSuccessor(two).value);
        System.out.println(inOrderSuccessor(root).value);
        System.out.println(inOrderSuccessor(three).value);
        System.out.println(inOrderSuccessor(five));

    }

    // O(n) time | O(n) space
    public static Node inOrderSuccessor(Node node) {
        // [1, 2, 4, 5, 7, 7, 8, 9]
        //                    *
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findMinNode(node.right);
        }

        Node curr = node;
        Node parent = curr.parent; // 7
        while (parent != null && curr != parent.left) {
            curr = curr.parent;
            parent = parent.parent;
        }

        return parent;
    }

    private static Node findMinNode(Node node) {
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
