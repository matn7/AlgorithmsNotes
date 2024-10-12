package july_2024;

public class FindKthSmallest {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);

        int k = 4;

        FindKthSmallest findKthSmallest = new FindKthSmallest();
        int result = findKthSmallest.kthSmallest(root, k);
        System.out.println(result);
    }

    private int res;
    private int k;

    public int kthSmallest(Node root, int k) {
        this.k = k;
        solution(root);
        return res;
    }

    private void solution(Node root) {
        if (root == null) {
            return;
        }
        solution(root.left);
        k--;
        if (k == 0) {
            res = root.value;
            return;
        }
        solution(root.right);
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
