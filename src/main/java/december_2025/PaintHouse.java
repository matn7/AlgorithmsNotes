package december_2025;

public class PaintHouse {

    // O(n) time | O(1) space
    public int minCost(int[][] costs) {
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int newRed = costs[i][0] + Math.min(blue, green);
            int newBlue = costs[i][1] + Math.min(red, green);
            int newGreen = costs[i][2] + Math.min(red, blue);

            red = newRed;
            blue = newBlue;
            green = newGreen;
        }

        return Math.min(red, Math.min(blue, green));
    }

}
