package coderpro;

public class IntersectionOfTwoLinkedList {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(6);
        head2.next =  head1.next.next;

        IntersectionOfTwoLinkedList intersectionOfTwoLinkedList = new IntersectionOfTwoLinkedList();
        intersectionOfTwoLinkedList.intersection(head1, head2);
    }

    // O(m + n) time | O(1) space
    public ListNode intersection(ListNode a, ListNode b) {
        int lenA = length(a);
        int lenB = length(b);

        ListNode currA = a;
        ListNode currB = b;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB.next;
            }
        }

        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }

    private int length(ListNode n) {
        int len = 0;
        ListNode curr = n;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    public ListNode intersect(ListNode l1, ListNode l2) {
        int len1 = 0;
        int len2 = 0;
        ListNode curr1 = l1;
        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }

        ListNode curr2 = l2;
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }

        curr1 = l1;
        curr2 = l2;

        if (len1 > len2) {
            curr1 = moveList(len1, len2, curr1, curr2);
            return curr1;
        }
        curr2 = moveList(len2, len1, curr2, curr1);
        return curr2;
    }

    private ListNode moveList(int longerLen, int smallerLen, ListNode longerList, ListNode smallerList) {
        while (longerLen > smallerLen) {
            longerList = longerList.next;
            longerLen--;
        }
        while (longerList != smallerList) {
            longerList = longerList.next;
            smallerList = smallerList.next;
        }
        return longerList;
    }

}
