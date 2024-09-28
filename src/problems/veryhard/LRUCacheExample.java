package problems.veryhard;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(100);
        lruCache.getValueFromKey("a");
        lruCache.insertKeyValuePair("a", 1);
        lruCache.getValueFromKey("a");
        lruCache.insertKeyValuePair("a", 9001);
        lruCache.getValueFromKey("a");
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 2);
        lruCache.getValueFromKey("a");
        lruCache.getValueFromKey("b");
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getValueFromKey("a"));
        System.out.println(lruCache.getValueFromKey("b"));
        System.out.println(lruCache.getValueFromKey("c"));
    }

    // OK - repeated 19/02/2022
    // O(1) time | O(1) space
    static class LRUCache {
        int maxSize;
        Map<String, DoublyLinkedListNode> cache = new HashMap<>();
        int currentSize = 0;
        DoublyLinkedList listOfMostRecent = new DoublyLinkedList();

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        //                                                                      LR
        // cache = {"a": ("a", (true, 2)), "b": ("b", (true, 2)), "d": ("d", (true, 18))}

        // O(1) time | O(1) space
        // rec("d", 18)
        // rec("c", 3)
        // rec("a", 2)
        // rec("b", 2)
        // rec("a", 9001)
        // rec("a", 1)
        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if (!cache.containsKey(key)) {
                if (currentSize == maxSize) { // 3 == 3
                    evictLeastRecent();
                } else {
                    currentSize++; // 3
                }
                cache.put(key, new DoublyLinkedListNode(key, new LRUResult(true, value)));
            } else {
                replaceKey(key, value);
            }
            updateMostRecent(cache.get(key));
        }

        private void updateMostRecent(DoublyLinkedListNode node) {
            listOfMostRecent.setHeadTo(node);
        }

        private void evictLeastRecent() {
            String keyToRemove = listOfMostRecent.tail.key;
            listOfMostRecent.removeTail();
            cache.remove(keyToRemove);
        }

        private void replaceKey(String key, int value) {
            if (!cache.containsKey(key)) {
                throw new RuntimeException("The provided key isn't in the cache!");
            }
            cache.get(key).value = new LRUResult(true, value);
        }

        // O(1) time | O(1) space
        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            if (!cache.containsKey(key)) {
                return null;
            }
            updateMostRecent(cache.get(key));
            return cache.get(key).value; // (true, 2)
        }

        // O(1) time | O(1) space
        public String getMostRecentKey() {
            // Write your code here.
            return listOfMostRecent.head.key;
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head = null;
        public DoublyLinkedListNode tail = null;

        // O(1) time | O(1) space
        public void setHeadTo(DoublyLinkedListNode node) {
            // Write your code here.
            if (head == node) {
                return;
            } else if (head == null) {
                head = node;
                tail = node;
            } else if (head == tail) {
                tail.prev = node;
                head = node;
                head.next = tail;
            } else {
                if (tail == node) {
                    removeTail();
                }
                node.removeBindings();
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        public void removeTail() {
            if (tail == null) {
                return;
            }
            if (tail == head) {
                head = null;
                tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Do not edit the class below.
    static class DoublyLinkedListNode {
        public String key;
        public LRUResult value;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode next;

        public DoublyLinkedListNode(String key, LRUResult value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public void removeBindings() {
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev = prev;
            }
            prev = null;
            next = null;
        }
    }
}
