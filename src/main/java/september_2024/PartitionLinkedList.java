package september_2024;

public class PartitionLinkedList {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        PartitionLinkedList partitionLinkedList = new PartitionLinkedList();
        Node partition = partitionLinkedList.partition(head, 5);
        while (partition != null) {
            System.out.print(partition.data + " -> ");
            partition = partition.next;
        }
    }

    // O(n) time | O(1) space
    public Node partition(Node head, int x) {
        Node smaller = new Node(0);
        Node smallTemp = smaller;
        Node larger = new Node(0);
        Node largerTemp = larger;
        Node current = head;

        while (current != null) {
            if (current.data < x) {
                smaller.next = current;
                smaller = smaller.next;
            } else {
                larger.next = current;
                larger = larger.next;
            }
            current = current.next;
        }
        larger.next = null;
        smaller.next = largerTemp.next;
        return smallTemp.next;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // Book
    Node partition2(Node node, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        // partition list
        while (node != null) {
            Node next = node.next;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    Node partition3(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

}
