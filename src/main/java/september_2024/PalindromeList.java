package september_2024;

import java.util.Stack;

public class PalindromeList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(1);
//        node.next.next = new Node(2);
//        node.next.next.next = new Node(1);

        PalindromeList palindromeList = new PalindromeList();
        boolean palindrome = palindromeList.isPalindrome(node);
        System.out.println(palindrome);
    }

    // O(n) time | O(1) space
    public boolean isPalindrome(Node node) {
        if (node == null) {
            return true;
        }
        Node slow = node;
        Node fast = node.next;
        if (fast == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow.next);

        while (node != null && newHead != null) {
            if (node.data != newHead.data) {
                return false;
            }
            node = node.next;
            newHead = newHead.next;
        }
        return true;
    }

    private Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
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

        public Node(int data) {
            this.data = data;
        }
    }

    // Book
    boolean isPalindrome2(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    boolean isEqual(Node one, Node two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    boolean isPalindrome3(Node head) {
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();

            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    class Result {
        public Node node;
        public boolean result;

        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    boolean isPalindrome4(Node head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    Result isPalindromeRecurse(Node head, int length) {
        if (head == null || length <= 0) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecurse(head.next, length - 2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.data == res.node.data);

        res.node = res.node.next;

        return res;
    }

    int lengthOfList(Node n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

}
