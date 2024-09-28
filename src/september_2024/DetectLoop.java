package september_2024;

public class DetectLoop {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
//        node.next.next.next.next = node.next.next;
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = node.next.next;

        DetectLoop detectLoop = new DetectLoop();
        Node loop = detectLoop.loop(node);
        System.out.println(loop.value);
    }

    public Node loop(Node node) {
        if (node == null) {
            return null;
        }
        Node slow = node;
        Node fast = node.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = node;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    // Book
    Node findBeginning(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
