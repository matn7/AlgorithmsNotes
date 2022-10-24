package udemy.faang.datastructuresalgorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node current = this.root;
            while (current != null) {
                if (current.value <= value) {
                    if (current.right == null) {
                        current.right = newNode;
                        return this;
                    }
                    current = current.right;
                } else {
                    if (current.left == null) {
                        current.left = newNode;
                        return this;
                    }
                    current = current.left;
                }
            }
        }
        return null;
    }

    public Node lookup(int value) {
        if (this.root == null) {
            return null;
        }
        Node current = this.root;
        while (current != null) {
            if (current.value < value) {
                current = current.right;
            } else if (current.value > value) {
                current = current.left;
            } else {
                return current;
            }
        }
        return null;
    }

    public Node delete(int value) {
        return delete(value, this.root, null);
    }

    public Node delete(int value, Node root, Node prev) {
        Node current = root;
        if (current == null) {
            return null;
        }
        while (current != null) {
            if (current.value < value) {
                prev = current;
                current = current.right;
            } else if (current.value > value) {
                prev = current;
                current = current.left;
            } else {
                if (isLeafNode(current)) {
                    if (isLeafNode(this.root)) {
                        // case one element tree just set root to null
                        this.root = null;
                        return null;
                    }
                    if (prev.value < value) {
                        prev.right = null;
                    } else {
                        prev.left = null;
                    }
                    return current;
                } else if (isOneChildNode(current)) {
                    if (current.left != null) {
                        // what if parent is null ?
                        // parent should point to curr left
                        if (prev == null) {
                            // replace root with either left child or right child
                            Node leftMax = findMaxValue(current.left);
                            Node toDelete = delete(leftMax.value, current.left, current);
                            current.value = leftMax.value;
                            return toDelete;
                        }
                        if (prev.value <= current.value) {
                            prev.right = current.left;
                        } else {
                            prev.left = current.left;
                        }
                    } else {
                        if (prev == null) {
                            Node rightMin = findMinValue(current.right);
                            Node toDelete = delete(rightMin.value, current.right, current);
                            current.value = rightMin.value;
                            return toDelete;
                        }
                        if (prev.value <= current.value) {
                            prev.right = current.right;
                        } else {
                            prev.left = current.right;
                        }
                    }
                    return current;
                } else if (isTwoChildNode(current)) {
                    Node rightMin = findMinValue(current.right);
                    Node toDelete = delete(rightMin.value, current.right, current);
                    current.value = rightMin.value;
                    return toDelete;
                }
            }
        }
        return null;
    }

    private boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    private boolean isOneChildNode(Node node) {
        return (node.left == null && node.right != null) || (node.left != null && node.right == null);
    }

    private boolean isTwoChildNode(Node node) {
        return node.left != null && node.right != null;
    }

    private Node findMaxValue(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    private Node findMinValue(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void traverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        traverse(node.left);
        traverse(node.right);
    }

    public List<Integer> breadthFirstSearch() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.value + " -> ");
            list.add(curr.value);
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return list;
    }

    public void breadthFirstSearchR(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return;
        }
        Node currentNode = queue.poll();
        list.add(currentNode.value);
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
        breadthFirstSearchR(queue, list);
    }

    public List<Integer> dfsInOrder() {
        List<Integer> list = new ArrayList<>();
        traverseInOrder(this.root, list);
        return list;
    }

    private void traverseInOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traverseInOrder(node.left, list);
        list.add(node.value);
        traverseInOrder(node.right, list);
    }

    public List<Integer> dfsPostOrder() {
        List<Integer> list = new ArrayList<>();
        traversePostOrder(this.root, list);
        return list;
    }

    private void traversePostOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.left, list);
        traversePostOrder(node.right, list);
        list.add(node.value);
    }

    public List<Integer> dfsPreOrder() {
        List<Integer> list = new ArrayList<>();
        traversePreOrder(this.root, list);
        return list;
    }

    private void traversePreOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.value);
        traversePreOrder(node.left, list);
        traversePreOrder(node.right, list);
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

//        tree.traverse(tree.root);
//        tree.delete(170);
//        tree.delete(20);
//        tree.delete(4);
//        tree.delete(9);
//        tree.delete(6);
//        tree.delete(15);
//        tree.delete(1);
//        System.out.println(tree.lookup(99));
        tree.breadthFirstSearch();
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        tree.breadthFirstSearchR(queue, result);
        System.out.println();
        List<Integer> inOrder = tree.dfsInOrder();
        List<Integer> preOrder = tree.dfsPreOrder();
        List<Integer> postOrder = tree.dfsPostOrder();

        System.out.println();
    }
}

class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
    }
}
