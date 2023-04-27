package star;

public class RearrangeLinkedList {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(0);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);

        RearrangeLinkedList rearrangeLinkedList = new RearrangeLinkedList();
        rearrangeLinkedList.rearrangeLinkedList(head, 3);
    }

    // O(n) time | O(n) space
    public Node rearrangeLinkedList(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node smallerHead = null;
        Node smallerTail = null;
        Node equalHead = null;
        Node equalTail = null;
        Node greaterHead = null;
        Node greaterTail = null;

        Node curr = head;
        while (curr != null) {
            if (curr.val < k) {
                NodeInfo nodeInfo = expandList(smallerHead, smallerTail, curr);
                smallerHead = nodeInfo.head;
                smallerTail = nodeInfo.tail;
            } else if (curr.val > k) {
                NodeInfo nodeInfo = expandList(greaterHead, greaterTail, curr);
                greaterHead = nodeInfo.head;
                greaterTail = nodeInfo.tail;
            } else {
                NodeInfo nodeInfo = expandList(equalHead, equalTail, curr);
                equalHead = nodeInfo.head;
                equalTail = nodeInfo.tail;
            }
            curr = curr.next;
        }

        NodeInfo current = merge(smallerHead, smallerTail, equalHead, equalTail);
        NodeInfo finalResult = merge(current.head, current.tail, greaterHead, greaterTail);
        return finalResult.head;
    }

    private NodeInfo merge(Node h1, Node t1, Node h2, Node t2) {
        if (h1 == null) {
            return new NodeInfo(h2, t2);
        }
        if (h2 == null) {
            return new NodeInfo(h1, t1);
        }
        t1.next = h2;
        return new NodeInfo(h1, t2);
    }


    private NodeInfo expandList(Node head, Node tail, Node node) {
        if (head == null) {
            head = new Node(node.val);
            tail = head;
        } else {
            Node newNode = new Node(node.val);
            tail.next = newNode;
            tail = newNode;
        }
        return new NodeInfo(head, tail);
    }

    static class NodeInfo {
        Node head;
        Node tail;

        public NodeInfo(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
