package whiteboard;

import java.util.ArrayList;
import java.util.Comparator;

public class ClassPhoto {

    // O(nlog(n)) time | O(1) space
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        redShirtHeights.sort(Comparator.reverseOrder());
        blueShirtHeights.sort(Comparator.reverseOrder());

        String shirtColorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE";
        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            Integer redShirtHeight = redShirtHeights.get(idx);
            Integer blueShirtHeight = blueShirtHeights.get(idx);

            if (shirtColorInFirstRow.equals("RED")) {
                if (redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }
        }
        return true;
    }

}
