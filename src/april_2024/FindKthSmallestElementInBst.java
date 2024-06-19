package april_2024;

public class FindKthSmallestElementInBst {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.right = new Node(7);
        node.left.left = new Node(1);
        node.left.right = new Node(4);

        Node result = findKthSmallest(node, 4);
        System.out.println(result);

        FindKthSmallestElementInBst findKthSmallestElementInBst = new FindKthSmallestElementInBst();

        System.out.println(findKthSmallestElementInBst.kthSmallest(node, 4));
    }

    private int res;
    private int k;

    // O(n) time | O(n) space
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

    // O(n) time | O(n) space
    public static Node findKthSmallest(Node node, int k) {
        NodeInfo nodeInfo = new NodeInfo(0, null);
        inOrder(node, k, nodeInfo);
        return nodeInfo.visited;
    }

    private static void inOrder(Node node, int k, NodeInfo info) {
        if (node == null || info.numVisited >= k) {
            return;
        }

        inOrder(node.left, k, info);
        if (info.numVisited < k) {
            info.numVisited++;
            info.visited = node;
            inOrder(node.right, k, info);
        }
    }

    static class NodeInfo {
        int numVisited;
        Node visited;

        public NodeInfo(int numVisited, Node visited) {
            this.numVisited = numVisited;
            this.visited = visited;
        }
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
