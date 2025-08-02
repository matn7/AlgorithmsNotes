package july_2025;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,-2};

        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] result = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid > 0) {
                stack.push(asteroid);
            } else if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    if (stack.peek() < 0) {
                        break;
                    }
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                } else {
                    if (stack.peek() < 0) {
                        stack.push(asteroid);
                    }else if (Math.abs(asteroid) == stack.peek()) {
                        stack.pop();
                    }
                }
            }
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[size - i - 1] = stack.pop();
        }
        return result;
    }

}
