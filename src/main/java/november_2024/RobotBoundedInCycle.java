package november_2024;

import javax.swing.text.ChangedCharSetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RobotBoundedInCycle {

    public static void main(String[] args) {
//        String instructions = "GGLLGG";
//        String instructions = "GL";
        String instructions = "GLRLLGLL";

        RobotBoundedInCycle robot = new RobotBoundedInCycle();
        boolean robotBounded = robot.isRobotBounded(instructions);
        System.out.println(robotBounded);

    }

    public boolean isRobotBounded(String instructions) {
        Map<Character, int[]> directionMap = new HashMap<>();
        directionMap.put('N', new int[] {1, 0});
        directionMap.put('S', new int[] {-1, 0});
        directionMap.put('E', new int[] {0, 1});
        directionMap.put('W', new int[] {0, -1});

        char direction = 'N';
        int x = 0, y = 0;

        for (int i = 0; i < instructions.length(); i++) {
            char curr = instructions.charAt(i);
            if (curr == 'L') {
                switch (direction) {
                    case 'N' -> direction = 'W';
                    case 'W' -> direction = 'S';
                    case 'S' -> direction = 'E';
                    case 'E' -> direction = 'N';
                }
            } else if (curr == 'R') {
                switch (direction) {
                    case 'N' -> direction = 'E';
                    case 'E' -> direction = 'S';
                    case 'S' -> direction = 'W';
                    case 'W' -> direction = 'N';
                }
            } else {
                int[] coords = directionMap.get(direction);
                x += coords[0];
                y += coords[1];
            }
        }

        // Check if robot is at the origin or facing a different direction than North
        return (x == 0 && y == 0) || direction != 'N';
    }


}
