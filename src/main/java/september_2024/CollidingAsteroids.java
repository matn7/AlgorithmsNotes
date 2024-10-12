package september_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollidingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {-3, 5, -8, 6, 17, -4, -7, -9};

        List<Integer> result = collidingAsteroids(asteroids);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> collidingAsteroids(int[] asteroids) {
        List<Integer> result = new ArrayList<>();
        if (asteroids.length == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    break;
                }
                int peek = stack.peek();
                if (peek < 0) {
                    stack.push(asteroid);
                    break;
                }
                int asteroidSize = Math.abs(asteroid);

                if (asteroidSize == peek) {
                    stack.pop();
                    break;
                }
                if (asteroidSize > peek) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

}
