package may_2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        PushDominoes pushDominoes = new PushDominoes();
        String result = pushDominoes.pushDominoes(dominoes);
        System.out.println(result);
    }

    public String pushDominoes(String dominoes) {
        char[] dom = dominoes.toCharArray();
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < dom.length; i++) {
            char d = dom[i];
            if (d != '.') {
                q.addLast(new int[] {i, d});
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.pollFirst();
            int i = poll[0];
            int d = poll[1];

            if (d == 'L') {
                if (i > 0 && dom[i - 1] == '.') {
                    q.addLast(new int[] {i - 1, 'L'});
                    dom[i - 1] = 'L';
                }
            } else if (d == 'R') {
                if (i + 1 < dom.length && dom[i + 1] == '.') {
                    if (i + 2 < dom.length && dom[i + 2] == 'L') {
                        q.pollFirst();
                    } else {
                        q.addLast(new int[] {i + 1, 'R'});
                        dom[i + 1] = 'R';
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : dom) {
            builder.append(c);
        }
        return builder.toString();
    }

}
