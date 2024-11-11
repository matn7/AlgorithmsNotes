package october_2024;

import java.util.ArrayList;
import java.util.List;

public class MinFlips {

    public static void main(String[] args) {
        String s = "010";

        MinFlips minFlips = new MinFlips();
        int result = minFlips.minFlips(s);
        System.out.println(result);
    }

    public int minFlips(String s) {
        int leftIdx = 0;
        int flipCount = getFlipCount(s, leftIdx, true);
        int flipCount2 = getFlipCount(s, leftIdx, false);
        return Math.min(flipCount, flipCount2);
    }

    private static int getFlipCount(String s, int leftIdx, boolean evenOnes) {
        List<Integer> ones = new ArrayList<>();
        List<Integer> zeroes = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curr = c - '0';
            if (evenOnes) {
                if (i % 2 == 0) {
                    ones.add(curr);
                } else {
                    zeroes.add(curr);
                }
            } else {
                if (i % 2 == 0) {
                    zeroes.add(curr);
                } else {
                    ones.add(curr);
                }
            }
        }
        int flipCount = 0;
        for (Integer one : ones) {
            if (one == 0) {
                flipCount++;
            }
        }
        for (Integer zero : zeroes) {
            if (zero == 1) {
                flipCount++;
            }
        }
        return flipCount;
    }


}
