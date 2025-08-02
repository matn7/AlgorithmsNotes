package july_2025;

public class MyHashMap {

    ListNode[] map;

    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new ListNode(-1, -1);
        }
    }

    public void put(int key, int value) {
        ListNode curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next.val = value;
                return;
            }
            curr = curr.next;
        }
        curr.next = new ListNode(key, value);
    }

    private int hash(int key) {
        return key % map.length;
    }

    public int get(int key) {
        ListNode curr = map[hash(key)].next;
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        ListNode curr = map[hash(key)];
        while (curr != null && curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    static class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
