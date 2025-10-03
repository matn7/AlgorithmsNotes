package september_2025;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGameIV {

    // O(n) time | O(n) space
    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);
        int farthest = 0;

        while (!q.isEmpty()) {
            int i = q.removeFirst();
            int start = Math.max(i + minJump, farthest + 1);

            for (int j = start; j < Math.min(i + maxJump + 1, s.length()); j++) {
                if (s.charAt(j) == '0') {
                    q.addLast(j);
                    if (j == s.length() - 1) {
                        return true;
                    }
                }
            }
            farthest = i + maxJump;
        }
        return false;
    }

}
