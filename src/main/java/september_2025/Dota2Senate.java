package september_2025;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Deque<Integer> rQueue = new LinkedList<>();
        Deque<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.addLast(i);
            } else {
                dQueue.addLast(i);
            }
        }

        int offset = senate.length();
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIdx = rQueue.removeFirst();
            int dIdx = dQueue.removeFirst();

            if (rIdx < dIdx) {
                rQueue.addLast(rIdx + offset);
            } else {
                dQueue.addLast(dIdx + offset);
            }
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
