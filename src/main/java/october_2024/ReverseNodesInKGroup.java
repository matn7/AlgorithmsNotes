package october_2024;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode listNode = reverseNodesInKGroup.reverseKGroup(head, 2);
        System.out.println(listNode);
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            // reverse group
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // O(n) time | O(1) space
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode d1 = dummy;
        ListNode newTail = head;
        ListNode newHead = head;
        ListNode curr = head;
        dummy.next = curr;

        while (curr != null) {
            System.out.println();
            int count = k;
            while (count > 0 && curr != null) {
                count--;
                curr = curr.next;
            }
            if (curr == null) {
                if (newHead == head) {
                    return reverse(newHead, null).newHead;
                }
                if (count == 0) {
                    newTail.next = reverse(newHead, null).newHead;
                }
                break;
            }
            ListNode next = curr;
            ListNodeInfo rev = reverse(newHead, next);
            rev.newTail.next = next;
            d1.next = rev.newHead;
            d1 = rev.newTail;
            newHead = next;
            newTail = rev.newTail;
            System.out.println();
        }

        return dummy.next;
    }

    private ListNodeInfo reverse(ListNode node, ListNode next) {
        ListNode curr = node;
        ListNode prev = null;

        while (curr != next) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return new ListNodeInfo(prev, node);
    }

    static class ListNodeInfo {
        ListNode newHead;
        ListNode newTail;

        public ListNodeInfo(ListNode newHead, ListNode newTail) {
            this.newHead = newHead;
            this.newTail = newTail;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
