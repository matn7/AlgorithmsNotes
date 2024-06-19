package march_2024;

import java.util.HashMap;
import java.util.Map;

public class Robot {

    public static void main(String[] args) {
        boolean result = returnToOrigin("UDLR");
        System.out.println(result);

    }

    // O(n) time | O(1) space
    public static boolean returnToOrigin(String moves) {

        Map<Character, int[]> directions = new HashMap<>();
        // UP
        // ^
        // |
        // |
        // |
        // |
        // |
        // +-----------------------------> x R
        //  y
        // (x, y)
        directions.put('U', new int[]{0,1});
        directions.put('R', new int[]{1,0});
        directions.put('D', new int[]{0,-1});
        directions.put('L', new int[]{-1,0});
        int[] origin = new int[] {0, 0};

        for (char c : moves.toCharArray()) {
            origin[0] = origin[0] + directions.get(c)[0];
            origin[1] = origin[1] + directions.get(c)[1];
        }
        return origin[0] == 0 && origin[1] == 0;
    }

}
