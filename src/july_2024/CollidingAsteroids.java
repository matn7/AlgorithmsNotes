package july_2024;

import java.util.Stack;

public class CollidingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {-3, 5, -8, 6, 7, -4, -7};
    }

    // O(n) time | O(n) space
    public static Stack<Integer> collidingAsteroids(int[] asteroids) {
        Stack<Integer> resultStack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                resultStack.push(asteroid);
                continue;
            }
            while (true) {
                if (resultStack.isEmpty() || resultStack.peek() < 0) {
                    resultStack.push(asteroid);
                    break;
                }
                int asteroidSize = Math.abs(asteroid);
                if (resultStack.peek() > asteroidSize) {
                    break;
                } if (resultStack.peek() == asteroidSize) {
                    resultStack.pop();
                    break;
                }
                resultStack.pop();
            }
        }
        return resultStack;
    }

}
