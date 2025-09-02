package august_2025;

import java.util.*;

public class OpenTheLock {

    // O(d^n + m) time | O(d^n) space
    // d - digits 0-9
    // n - num of wheels
    // m - num of deadends
    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));

        if (visit.contains("0000")) {
            return -1;
        }

        Queue<Element> q = new LinkedList<>();
        q.add(new Element("0000", 0));

        while (!q.isEmpty()) {
            Element element = q.poll();
            String lock = element.lock;
            int turns = element.turns;
            if (lock.equals(target)) {
                return turns;
            }
            for (String child : children(lock)) {
                if (!visit.contains(child)) {
                    visit.add(child);
                    q.add(new Element(child, turns + 1));
                }
            }
        }
        return -1;
    }


    private List<String> children(String lock) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' + 1) % 10) + '0');
            res.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' - 1 + 10) % 10) + '0');
            res.add(new String(arr));
        }
        return res;
    }

    static class Element {
        String lock;
        int turns;

        public Element(String lock, int turns) {
            this.lock = lock;
            this.turns = turns;
        }
    }

}
