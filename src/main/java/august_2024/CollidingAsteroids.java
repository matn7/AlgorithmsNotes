package august_2024;

import java.util.Stack;

public class CollidingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {100, 5, -3, 5, -8, 6, 7, -4, -7, -90};

        collidingAsteroids(asteroids);
    }

    // O(n) time | O(n) space
    public static Stack<Integer> collidingAsteroids(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            int absValue = Math.abs(asteroid);
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    break;
                }
                Integer peek = stack.peek();
                if (peek < 0 && asteroid < 0) {
                    stack.push(asteroid);
                    break;
                }
                if (absValue > peek) {
                    stack.pop();
                } else if (absValue == peek) {
                    stack.pop();
                    break;
                } else {
                    break;
                }
            }
        }
        return stack;
    }

}
