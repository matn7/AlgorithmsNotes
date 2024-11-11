package november_2024;

import java.util.Stack;

public class MinSwaps {

    public static void main(String[] args) {
        String s = "][][";

        MinSwaps minSwaps = new MinSwaps();
        int result = minSwaps.minSwaps(s);
        System.out.println(result);
    }

    public int minSwaps(String s) {

        int extraClose = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == ']') {
                extraClose++;
            } else if (c == '[') {
                extraClose--;
            }
            max = Math.max(max, extraClose);
        }
        return (max + 1) / 2;
    }

}
