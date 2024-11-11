package october_2024;

public class PaintHouse {


    public static void main(String[] args) {
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};

        PaintHouse paintHouse = new PaintHouse();
        int result = paintHouse.paintHouse(costs);
        System.out.println(result);
    }
    // leetcode premium 256

    int min = Integer.MAX_VALUE;

    public int paintHouse(int[][] costs) {
        helper(costs, 0, 0, -1);
        return min;
    }

    private void helper(int[][] costs, int curr, int index, int idx) {
        if (index == 3) {
            min = Math.min(curr, min);
            return;
        }

        for (int i = index; i < costs.length; i++) {
            if (i == idx) {
                continue;
            }
            int[] cost = costs[i];
            for (int c : cost) {
                helper(costs, curr + c, index + 1, i);
            }
        }

    }

}
