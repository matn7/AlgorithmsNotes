package august_2024;

import java.util.*;

public class RectangleMania {

    public static void main(String[] args) {
        Integer[][] coords = {{0,0}, {0,1}, {1,0}, {1,1}, {2,0}, {2,1}, {3,0}, {3,1}};
        List<Integer[]> coordsArr = new ArrayList<>(Arrays.asList(coords));

        rectangleMania(coordsArr);
    }

    // O(n^2) time | O(n) space
    public static int rectangleMania(List<Integer[]> coords) {

        Map<String, Boolean> coordsMap = new HashMap<>();
        for (Integer[] coord : coords) {
            String key = coord[0] + ":" + coord[1];
            coordsMap.put(key, Boolean.TRUE);
        }

        int counter = 0;
        for (int i = 0; i < coords.size(); i++) {
            Integer[] current = coords.get(i);
            for (int j = 0; j < coords.size(); j++) {
                Integer[] other = coords.get(j);
                if (!isUpperRight(current, other)) {
                    continue;
                }
                String key1 = current[0] + ":" + other[1];
                String key2 = other[0] + ":" + current[1];
                if (coordsMap.containsKey(key1) && coordsMap.containsKey(key2)) {
                    counter++;
                }
            }

        }

        return counter;
    }

    private static boolean isUpperRight(Integer[] coord1, Integer[] coord2) {
        int x1 = coord1[0];
        int y1 = coord1[1];
        int x2 = coord2[0];
        int y2 = coord2[1];
        return x2 > x1 && y2 > y1;
    }

}
