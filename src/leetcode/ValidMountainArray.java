package leetcode;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1};
    }

    public boolean validMountainArray(int[] arr) {
        Direction direction = Direction.START; // start
        for (int i = 1; i < arr.length; i++) {
            if (direction == Direction.START) {
                if (arr[i] > arr[i - 1]) {
                    direction = Direction.UP; // up
                } else {
                    return false;
                }
            }
            if (direction == Direction.UP) {
                if (arr[i] > arr[i - 1]) {
                    continue;
                }
                if (arr[i] == arr[i - 1]) {
                    return false;
                }
                if (arr[i] < arr[i - 1]) {
                    direction = Direction.DOWN; // down
                }
            }
            if (direction == Direction.DOWN) {
                if (arr[i] < arr[i - 1]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return direction == Direction.DOWN;
    }

    enum Direction {
        START, UP, DOWN
    }
}