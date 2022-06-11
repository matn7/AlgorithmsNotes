package whiteboard;

import java.util.List;
import java.util.Map;

public class ApartmentHunting {

    // O(br) time | O(br) space
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.

        int[] distances = new int[blocks.size()];

        for (int i = 0; i < blocks.size(); i++) {
            for (String req : reqs) {
                int currDistance = Integer.MAX_VALUE;
                for (int j = 0; j < blocks.size(); j++) {
                    Map<String, Boolean> currApartment = blocks.get(j);
                    if (currApartment.get(req)) {
                        if (i == j) {
                            currDistance = 0;
                            break;
                        }
                        currDistance = Math.min(currDistance, Math.abs(i - j));
                    }
                }
                distances[i] = Math.max(currDistance, distances[i]);
            }
        }

        int minIdx = 0;
        int minVal = distances[0];
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] < minVal) {
                minVal = distances[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

}
