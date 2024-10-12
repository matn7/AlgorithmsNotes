package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup(head, 5);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        List<ListNode> arr = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            arr.add(curr);
            curr = curr.next;
        }
        int n = arr.size();

        int stop = 0;
        int step = k;

        ListNode temp = new ListNode(0);
        ListNode newNode = temp;
        int counter = 0;
        int i = step - 1;

        while (counter < n) {
            System.out.println(i);
            ListNode toAdd = arr.get(i);
            newNode.next = toAdd;
            newNode = newNode.next;
            if (i == stop) {
                stop = step;
                step += k;
                i = step;
                if (step > n) {
                    if (i - k >= n) {
                        newNode.next = null;
                        break;
                    }
                    ListNode last = arr.get(i - k);
                    newNode.next = last;
                    break;
                }
            }
            i--;
            counter++;
        }
        ListNode result = temp.next;
        return result;
    }

}

class ListNode {
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
