package december_2025;

import java.util.ArrayDeque;

public class ProductOfNumbers {

    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }

    Node head;
    Node tail;
    Node curr;

    public ProductOfNumbers() {
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;
        curr = head;
    }

    // O(1) time
    public void add(int num) {
        Node newNode = new Node(num);
        curr.next = newNode;
        newNode.next = tail;
        newNode.prev = curr;
        tail.prev = newNode;
        curr = curr.next;
    }

    // O(k) time
    public int getProduct(int k) {
        int prod = 1;
        Node lastNode = tail.prev;

        while (k > 0) {
            prod *= lastNode.val;
            lastNode = lastNode.prev;
            k--;
        }
        return prod;
    }

    static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

}
