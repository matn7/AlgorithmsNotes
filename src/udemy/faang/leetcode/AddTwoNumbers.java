package udemy.faang.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newList = new ListNode(0);
        ListNode first = l1;
        ListNode second = l2;
        int carryover = 0;
        ListNode current = newList;
        while (first != null && second != null) {
            int sum = first.val + second.val + carryover;
            int listValue = sum % 10;
            carryover = sum / 10;
            current.next = new ListNode(listValue);
            current = current.next;
            first = first.next;
            second = second.next;
        }
        while (first != null) {
            int sum = first.val + carryover;
            int listValue = sum % 10;
            carryover = sum / 10;
            current.next = new ListNode(listValue);
            current = current.next;
            first = first.next;
        }

        while (second != null) {
            int sum = second.val + carryover;
            int listValue = sum % 10;
            carryover = sum / 10;
            current.next = new ListNode(listValue);
            current = current.next;
            second = second.next;
        }

        if (carryover > 0) {
            current.next = new ListNode(carryover);
        }

        return newList.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
