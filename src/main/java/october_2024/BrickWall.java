package october_2024;

import java.util.*;

public class BrickWall {

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));

        BrickWall brickWall = new BrickWall();
        int result = brickWall.leastBricks(wall);
        System.out.println(result);

    }

    public int leastBricks(List<List<Integer>> wall) {
        int min = wall.size();
        Map<Integer, Row> wallMap = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> bricks = wall.get(i);
            wallMap.put(i, new Row(bricks, 0, 0));
        }

        int wallWidth = 0;
        List<Integer> oneRow = wall.get(0);
        for (Integer r : oneRow) {
            wallWidth += r;
        }

        for (int currIdx = 1; currIdx < wallWidth; currIdx++) {
            int currCross = 0;
            for (int i = 0; i < wall.size(); i++) {
                Row row = wallMap.get(i);
                int index = row.brickIndex;
                int distanceFromEdge = row.distanceFromEdge;
                Integer currBrickWidth = row.bricks.get(index);
                if (currIdx >= currBrickWidth + distanceFromEdge) { // 1 >= 1 + 0
                    row.brickIndex++;
                    row.distanceFromEdge += currBrickWidth;
                } else {
                    currCross++;
                }
            }
            min = Math.min(min, currCross);
        }

        return min;
    }

    static class Row {
        List<Integer> bricks;
        int brickIndex;
        int distanceFromEdge;

        public Row(List<Integer> bricks, int brickIndex, int distanceFromEdge) {
            this.bricks = bricks;
            this.brickIndex = brickIndex;
            this.distanceFromEdge = distanceFromEdge;
        }
    }
}
