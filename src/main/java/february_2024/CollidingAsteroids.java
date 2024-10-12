package february_2024;


import java.util.Stack;

public class CollidingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {-3, 5, -8, 6, 7, -4, -7};

        collidingAsteroids(asteroids);

    }

    // O(n) time | O(n) space
    public static int[] collidingAsteroids(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            while (true) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                    break;
                }
                int asteroidSize = Math.abs(asteroid);
                if (stack.peek() > asteroidSize) {
                    break;
                }
                if (stack.peek() == asteroidSize) {
                    stack.pop();
                    break;
                }
                stack.pop();
            }
        }
        int[] result = new int[stack.size()];
        int counter = 0;
        while (!stack.isEmpty()) {
            result[counter] = stack.pop();
            counter++;
        }
        return result;
    }

}
