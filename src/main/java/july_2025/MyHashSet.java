package july_2025;

class TreeNode {
    int key;
    TreeNode left, right;

    TreeNode(int key) {
        this.key = key;
    }
}

class BST {
    private TreeNode root;

    private TreeNode insert(TreeNode node, int key) {
        if (node == null) return new TreeNode(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null) return null;
        if (key < node.key) node.left = delete(node.left, key);
        else if (key > node.key) node.right = delete(node.right, key);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode temp = minValueNode(node.right);
            node.key = temp.key;
            node.right = delete(node.right, temp.key);
        }
        return node;
    }

    private TreeNode minValueNode(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private boolean search(TreeNode node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

    public void add(int key) {
        root = insert(root, key);
    }

    public void remove(int key) {
        root = delete(root, key);
    }

    public boolean contains(int key) {
        return search(root, key);
    }
}

public class MyHashSet {
    private final int size = 10000;
    private BST[] buckets;

    public MyHashSet() {
        buckets = new BST[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new BST();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int idx = hash(key);
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = hash(key);
        buckets[idx].remove(key);
    }

    public boolean contains(int key) {
        int idx = hash(key);
        return buckets[idx].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */