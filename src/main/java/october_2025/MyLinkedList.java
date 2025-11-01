package october_2025;

public class MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        // ["MyLinkedList",
        // "addAtHead" [7], x
        // "addAtHead" [2], x
        // "addAtHead" [1], x
        // "addAtIndex" [3,0], x
        // "deleteAtIndex" [2], x
        // "addAtHead" [6], x
        // "addAtTail" [4], x
        // "get" [4], -> 4
        // "addAtHead" [4],
        // "addAtIndex" [5,0],
        // "addAtHead" [6]]

        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);

        System.out.println();

        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList.get(4));


//        myLinkedList.addAtHead(1);
//        myLinkedList.deleteAtIndex(0);

//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//
//        myLinkedList.addAtIndex(1, 2);
//
//        System.out.println(myLinkedList.get(1));
//        myLinkedList.deleteAtIndex(1);
//        System.out.println(myLinkedList.get(1));
    }

    ListNode head;
    ListNode tail;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        ListNode next = head.next;
        head.next = newNode;
        next.prev = newNode;
        newNode.prev = head;
        newNode.next = next;
        size++;

    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode prev = tail.prev;
        tail.prev = newNode;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode curr = head;
        ListNode newNode = new ListNode(val);
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode next = curr.next;
        curr.next = newNode;
        next.prev = newNode;
        newNode.next = next;
        newNode.prev = curr;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        ListNode next =  curr.next.next;
        curr.next = next;
        next.prev = curr;
        size--;
    }

    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
