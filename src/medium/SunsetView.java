package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SunsetView {

    public static void main(String[] args) {

        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};

        SunsetView sunsetView = new SunsetView();
        sunsetView.sunsetViewsStack(buildings, "WEST");

    }

    // O(N^2) time | O(N) time
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        boolean east = direction.equalsIgnoreCase("WEST");

        ArrayList<Integer> result = new ArrayList<>();

        if (east) {
            for (int i = 0; i < buildings.length; i++) {
                boolean blocking = false;
                for (int j = i + 1; j < buildings.length; j++) {
                    if (buildings[i] <= buildings[j]) {
                        blocking = true;
                        break;
                    }
                }
                if (!blocking) {
                    result.add(i);
                }
            }
        } else {
            List<Integer> resultWest = new ArrayList<>();
            for (int i = buildings.length - 1; i >= 0; i--) {
                boolean blocking = false;
                for (int j = i - 1; j >= 0; j--) {
                    if (buildings[i] <= buildings[j]) {
                        blocking = true;
                        break;
                    }
                }
                if (!blocking) {
                    resultWest.add(i);
                }
            }

            int counter = resultWest.size() - 1;
            for (Integer element : resultWest) {
                result.add(resultWest.get(counter));
                counter--;
            }
        }

        return result;
    }

    // O(n) time | O(n) space
    public ArrayList<Integer> sunsetViews2(int[] buildings, String direction) {
        // Write your code here.
        boolean east = direction.equalsIgnoreCase("EAST");
        int maxHeight = 0;
        ArrayList<Integer> result = new ArrayList<>();
        if (east) {
            ArrayList<Integer> resultEast = new ArrayList<>();
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > maxHeight) {
                    resultEast.add(i);
                    maxHeight = buildings[i];
                }
            }
            int counter = resultEast.size() - 1;
            for (Integer element : resultEast) {
                result.add(resultEast.get(counter));
                counter--;
            }
        } else {
            for (int i = 0; i < buildings.length - 1; i++) {
                if (buildings[i] > maxHeight) {
                    result.add(i);
                    maxHeight = buildings[i];
                }
            }
        }

        return result;
    }

    // O(n) time | O(n) space
    public ArrayList<Integer> sunsetViewsStack(int[] buildings, String direction) {
        // Write your code here.
        if (buildings.length == 0) {
            return new ArrayList<Integer>();
        }
        boolean east = direction.equalsIgnoreCase("EAST");
        int maxHeight = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (east) {
            stack.push(0);
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] >= buildings[stack.peek()]) {
                    while (!stack.isEmpty()) {
                        if (buildings[i] >= buildings[stack.peek()]) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
            for (Integer element : stack) {
                result.add(element);
            }
        } else {
            stack.push(buildings.length - 1);
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] >= buildings[stack.peek()]) {
                    while (!stack.isEmpty()) {
                        if (buildings[i] >= buildings[stack.peek()]) {
                            stack.pop();
                        } else {
                            break;
                        }
                    }
                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
            List<Integer> tempRes = new ArrayList<>();
            for (Integer element : stack) {
                tempRes.add(element);
            }
            int counter = tempRes.size() - 1;
            for (Integer element : tempRes) {
                result.add(tempRes.get(counter));
                counter--;
            }

        }

        return result;
    }

}
