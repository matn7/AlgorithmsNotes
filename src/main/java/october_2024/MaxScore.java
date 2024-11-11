package october_2024;

import java.util.Arrays;

public class MaxScore {

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;

//        int[] cardPoints = {2, 2, 2};
//        int k = 2;

//        int[] cardPoints = {9,7,7,9,7,7,9};
//        int k = 7;

        MaxScore maxScore = new MaxScore();
        int result = maxScore.maxScore(cardPoints, k);
        System.out.println(result);
    }

    // O(k) time | O(1) space
    public int maxScore(int[] cardPoints, int k) {
        int l = 0;
        int r = cardPoints.length - k;
        int total = 0;
        for (int i = r; i < cardPoints.length; i++) {
            total += cardPoints[i];
        }
        int res = total;

        while (r < cardPoints.length) {
            total += cardPoints[l] - cardPoints[r];
            res = Math.max(res, total);
            l++;
            r++;
        }

        return res;
    }

}
