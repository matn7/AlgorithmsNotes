package october_2024;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,-2};

        AsteroidCollision asteroidCollision = new AsteroidCollision();
        int[] result = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(result);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            if (asteroid < 0) {
                while (!stack.isEmpty() && Math.abs(asteroid) > Math.abs(stack.peek())) {
                    if (stack.peek() > 0) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (!stack.isEmpty() && Math.abs(asteroid) == stack.peek()) {
                    stack.pop();
                    continue;
                }
                if (!stack.isEmpty() && Math.abs(asteroid) < stack.peek()) {
                    continue;
                }
                stack.push(asteroid);
            }
        }

        if (stack.isEmpty()) {
            return new int[] {};
        }

        int size = stack.size();
        int[] res = new int[size];

        while (!stack.isEmpty()) {
            res[size - 1] = stack.pop();
            size--;
        }

        return res;
    }

}
