package october_2024;

import java.util.*;

public class BrickWall2 {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));

        BrickWall2 wall2 = new BrickWall2();
        int result = wall2.leastBricks(wall);

        System.out.println(result);

    }

    // leetcode 554

    // O(n*m) time | O(n) space
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countGap = new HashMap<>();

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> currentRow = wall.get(i);
            int gapIndex = 0;
            for (int j = 0; j < currentRow.size() - 1; j++) {
                Integer brick = currentRow.get(j);
                gapIndex += brick;
                countGap.put(gapIndex, countGap.getOrDefault(gapIndex, 0) + 1);
            }
        }
        int counts = wall.size();

        for (Map.Entry<Integer, Integer> element : countGap.entrySet()) {
            Integer count = element.getValue();
            int currCut = wall.size() - count;
            counts = Math.min(counts, currCut);
        }
        return counts;
    }


}
