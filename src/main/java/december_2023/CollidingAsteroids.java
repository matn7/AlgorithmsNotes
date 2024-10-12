package december_2023;

import java.util.Stack;

public class CollidingAsteroids {

    public static void main(String[] args) {
        int[] asteroids = {-3, 5, -8, 6, 7, -4, -7};

        CollidingAsteroids collidingAsteroids = new CollidingAsteroids();
        collidingAsteroids.collidingAsteroids(asteroids);
    }

    // O(n) time | O(n) space
    public int[] collidingAsteroids(int[] asteroids) {
        // Write your code here.
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
                }

                if (resultStack.peek() == asteroidSize) {
                    resultStack.pop();
                    break;
                }

                resultStack.pop();
            }
        }

        int size = resultStack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = resultStack.pop();
        }
        reverse(result);

        return result;
    }

    private void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

}
