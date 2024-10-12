package september_2023;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BlackjackProbability {

    public static void main(String[] args) {
        BlackjackProbability blackjackProbability = new BlackjackProbability();
        blackjackProbability.blackjackProbability(21, 13);
    }

    // O(t - s) time | O(t - s) space: t - target, s - starting hand
    public float blackjackProbability(int target, int startingHand) {
        // Write your code here.
        Map<Integer, Float> memo = new HashMap<>();
        float result = calculateProbability(startingHand, target, memo);
        DecimalFormat df = new DecimalFormat("#.###");
        String format = df.format(result);
        return Float.parseFloat(format);
    }

    private float calculateProbability(int currentHand, int target, Map<Integer, Float> memo) {
        if (memo.containsKey(currentHand)) {
            return memo.get(currentHand);
        }
        if (currentHand > target) {
            return 1;
        }
        if (currentHand + 4 >= target) {
            return 0;
        }
        float totalProbability = 0;
        for (int drawnCard = 1; drawnCard <= 10; drawnCard++) {
            totalProbability += 0.1 * calculateProbability(currentHand + drawnCard, target, memo);
        }
        memo.put(currentHand, totalProbability);
        return totalProbability;
    }

}
