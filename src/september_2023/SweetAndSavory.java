package september_2023;

import java.util.*;

public class SweetAndSavory {

    public static void main(String[] args) {
        int[] dishes = {5, 2, -7, 30, 12, -4, -20};

        SweetAndSavory sweetAndSavory = new SweetAndSavory();
        sweetAndSavory.sweetAndSavory(dishes, 4);
    }

    // O(nlog(n)) time | O(n) space
    public int[] sweetAndSavory(int[] dishes, int target) {
        // Write your code here.
        List<Integer> sweetDishes = new ArrayList<>();
        List<Integer> savoryDishes = new ArrayList<>();

        for (int dish : dishes) {
            if (dish < 0) {
                sweetDishes.add(dish);
            } else {
                savoryDishes.add(dish);
            }
        }
        sweetDishes.sort(Comparator.reverseOrder());
        Collections.sort(savoryDishes);
        if (sweetDishes.isEmpty() || savoryDishes.isEmpty()) {
            return new int[] {0, 0};
        }
        int sweetIdx = 0;
        int savoryIdx = 0;

        int bestDifference = Integer.MAX_VALUE;
        int[] bestPair = new int[2];

        while (sweetIdx < sweetDishes.size() && savoryIdx < savoryDishes.size()) {
            int sweetLevel = sweetDishes.get(sweetIdx); // -4
            int savoryLevel = savoryDishes.get(savoryIdx); // 2
            int currentSum = sweetLevel + savoryLevel; // -2
            if (currentSum <= target) {
                int currentDifference = target - currentSum;
                if (currentDifference < bestDifference) { // 4 -  (-2) = 6
                    bestDifference = currentDifference;
                    bestPair[0] = sweetLevel;
                    bestPair[1] = savoryLevel;
                }
                savoryIdx++;
            } else {
                sweetIdx++;
            }
        }

        return bestPair;
    }

}
