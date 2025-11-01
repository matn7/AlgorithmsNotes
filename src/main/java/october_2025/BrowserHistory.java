package october_2025;

public class BrowserHistory {

    public static void main(String[] args) {
        // ["BrowserHistory", leetcode.com - null
        // "visit", google.com - null
        // "visit", facebook.com - null
        // "visit", youtube.com - null
        // "back", 1 - facebook.com         OK
        // "back", 1 - google.com           OK
        // "forward", 1 - facebook.com      OK
        // "visit", linkedin.com - null
        // "forward", 2 - linkedin.com      OK
        // "back", 2 - google.com           OK
        // "back" 7 - leetcode.com
        // ]
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    ListNode head;
    ListNode tail;
    ListNode curr;

    public BrowserHistory(String homepage) {
        head = new ListNode("head");
        tail = new ListNode("tail");
        head.next = tail;
        tail.prev = head;
        ListNode newNode = new ListNode(homepage);
        head.next = newNode;
        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = head;
        curr = newNode;
    }

    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        newNode.next = tail;
        tail.prev = newNode;
        curr = curr.next;
    }

    public String back(int steps) {
        while (steps > 0) {
            if (curr.prev == head) {
                break;
            }
            curr = curr.prev;
            steps--;
        }
        return curr.val;
    }

    public String forward(int steps) {
        while (steps > 0) {
            if (curr.next == tail) {
                break;
            }
            curr = curr.next;
            steps--;
        }
        return curr.val;
    }

    static class ListNode {
        String val;
        ListNode next;
        ListNode prev;

        public ListNode(String val) {
            this.val = val;
        }
    }

}
