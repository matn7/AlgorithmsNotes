package problems.other;

import java.util.HashMap;
import java.util.Map;

public class SpiralTraversal {

    static int[][] matrix = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
    };

    public static void main(String[] args) {
        SpiralTraversal spiralTraversal = new SpiralTraversal(matrix);
        String result = spiralTraversal.spiralPrint();
        System.out.println();
    }

    public SpiralTraversal(int[][] matrix) {
        this.matrix = matrix;
    }

    public String spiralPrint() {
        int remaining = matrix.length * matrix[0].length;
        Direction current_direction = Direction.RIGHT;
        int[] current_position = {0, 0};
        StringBuilder result = new StringBuilder();
        while (remaining > 0) {
            remaining--;
            result.append(matrix[current_position[0]][current_position[1]]);
            matrix[current_position[0]][current_position[1]] = -1;
            int[] next_position = nextPosition(current_position, current_direction);
            if (!isValidPosition(next_position)) {
                current_direction = nextDirection(current_direction);
                current_position = nextPosition(current_position, current_direction);
            } else {
                current_position = nextPosition(current_position, current_direction);
            }
        }
        return result.toString();
    }

    private boolean isValidPosition(int[] pos) {
        return (pos[0] >= 0 && pos[0] < matrix.length - 1) &&  (pos[1] >= 0 && pos[0] < matrix[0].length - 1) &&
                (matrix[pos[0]][pos[1]] != -1);
    }

    private Direction nextDirection(Direction direction) {
        Map<Direction, Direction> direct = new HashMap<>();
        direct.put(Direction.RIGHT, Direction.DOWN);
        direct.put(Direction.DOWN, Direction.LEFT);
        direct.put(Direction.LEFT, Direction.UP);
        direct.put(Direction.UP, Direction.RIGHT);

        return direct.get(direction);
    }

    private int[] nextPosition(int[] position, Direction direction) {
        if (direction == Direction.RIGHT) {
            return new int[] {position[0], position[1] + 1};
        } else if (direction == Direction.DOWN) {
            return new int[] {position[0] + 1, position[1]};
        } else if (direction == Direction.LEFT) {
            return new int[] {position[0], position[1] - 1};
        } else if (direction == Direction.UP) {
            return  new int[] {position[0] - 1, position[1]};
        }
        return new int[] {-1, -1};
    }

}

enum Direction {
    RIGHT, LEFT, DOWN, UP
}
