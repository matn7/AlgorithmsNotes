package september_2024;

public class ListSum {

    public static void main(String[] args) {
        Node list1 = new Node(7);
        list1.next = new Node(1);
        list1.next.next = new Node(6);
        list1.next.next.next = new Node(5);

        Node list2 = new Node(5);
        list2.next = new Node(9);
        list2.next.next = new Node(8);

        ListSum listSum = new ListSum();
        Node node = listSum.listSumRev(list1, list2);
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
    }

    // O(n) time | O(n) space
    public  Node listSum(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Node temp = new Node(0);
        Node curr = temp;
        int carry = 0;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                list1 = new Node(0);
            }
            if (list2 == null) {
                list2 = new Node(0);
            }
            int sum = list1.data + list2.data + carry;
            curr.next = new Node(sum % 10);
            carry = sum / 10;
            list1 = list1.next;
            list2 = list2.next;
            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new Node(carry);
        }

        return temp.next;
    }

    // O(n) time | O(n) space
    public Node listSumRev(Node list1, Node list2) {
        Node list = listSum(list1, list2);
        return reverse(list);
    }

    private Node reverse(Node list) {
        Node prev = null;
        Node curr = list;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    // Book
    Node addLists(Node l1, Node l2) {
        return addLists(l1, l2, 0);
    }

    Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        Node result = new Node();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        result.data = value % 10;

        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

}
