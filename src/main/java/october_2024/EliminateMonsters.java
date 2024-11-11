package october_2024;

import java.util.Arrays;

public class EliminateMonsters {

    public static void main(String[] args) {
        int[] dist = {1, 3, 4};
        int[] speed = {1, 1, 1};

        EliminateMonsters eliminateMonsters = new EliminateMonsters();
        int result = eliminateMonsters.eliminateMaximum(dist, speed);
        System.out.println(result);
    }

    // O(nlog(n)) time | O(n) space
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] minReach = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            minReach[i] = (int) Math.ceil(dist[i] * 1.0 / speed[i]);
        }
        Arrays.sort(minReach);
        int eliminated = 0;
        for (int minute = 0; minute < minReach.length; minute++) {
            if (minute >= minReach[minute]) {
                break;
            }
            eliminated++;
        }
        return eliminated;
    }

}
