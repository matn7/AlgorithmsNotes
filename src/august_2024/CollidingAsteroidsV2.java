package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollidingAsteroidsV2 {

    public static void main(String[] args) {
        int[] asteroids = {-3, 5, -8, 6, 7, -4, -7};

        collidingAsteroids(asteroids);
    }

    // O(n) time | O(n) space
    public static List<Integer> collidingAsteroids(int[] asteroids) {

        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            int asteroidSize = Math.abs(asteroid);
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                if (stack.peek() > asteroidSize) {
                    continue;
                }
                while (!stack.isEmpty() && asteroidSize > stack.peek()) {
                    if (asteroid < 0 && stack.peek() < 0) {
                        break;
                    }
                    stack.pop();
                }
                if (!stack.isEmpty() && asteroidSize == stack.peek()) {
                    stack.pop();
                    continue;
                }

                stack.push(asteroid);
            }
        }

        return result;
    }

}
