package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheProgram {

    static class LRUCache {
        int maxSize;
        Map<String, DoublyLinkedListNode> cache = new HashMap<>();
        int currentSize = 0;
        DoublyLinkedList listOfMostRecent = new DoublyLinkedList();

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        // O(1) time | O(1) space
        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if (!cache.containsKey(key)) {
                if (currentSize == maxSize) {
                    evictLeastRecent();
                } else {
                    currentSize++;
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
            return cache.get(key).value;
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
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head = null;
        public DoublyLinkedListNode tail = null;

        // O(1) time | O(1) space
        public void setHeadTo(DoublyLinkedListNode node) {
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

    static class DoublyLinkedListNode {
        public String key;
        public LRUResult value;
        public DoublyLinkedListNode prev;
        public DoublyLinkedListNode next;

        public DoublyLinkedListNode(String key, LRUResult value) {
            this.key = key;
            this.value = value;
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
