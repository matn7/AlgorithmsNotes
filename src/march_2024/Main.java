package march_2024;

public class Main {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();

        lruCache.initialize(4);

        lruCache.put(1, 100);
        lruCache.put(2, 200);
        int result = lruCache.get(1);

        lruCache.put(3, 300);
        lruCache.get(2);
        lruCache.put(4,400);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.put(3,3000);
        int result1 = lruCache.get(1000);
        System.out.println();

    }

}
