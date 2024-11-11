package october_2024;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {

    public static void main(String[] args) {
        String s = "01101110";
        int minJump = 2;
        int maxJump = 3;

        JumpGameVII jumpGameVII = new JumpGameVII();
        boolean result = jumpGameVII.canReach(s, minJump, maxJump);
        System.out.println(result);
    }

    // leetcode 1871

    // O(n) time | O(n) space
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(0) == '1' || s.charAt(s.length() - 1) == '1') {
            return false;
        }
        int furthest = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        // 0 1 2 3 4 5
        // 0 1 1 0 1 0
        //     * *
        //     +
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int start = Math.max(i + minJump, furthest + 1);
            for (int j = start; j < Math.min(i + maxJump + 1, s.length()); j++) {
                if (s.charAt(j) == '0') {
                    queue.add(j);
                    if (j == s.length() - 1) {
                        return true;
                    }
                }
            }
            furthest = i + maxJump;
        }

        return false;
    }



}
