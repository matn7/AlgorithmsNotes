package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhoto {

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));

        ClassPhoto classPhoto = new ClassPhoto();
        classPhoto.classPhotos(redShirtHeights, blueShirtHeights);

    }

    // O(nlog(n)) time | O(1) space
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        // Write your code here.
        redShirtHeights.sort(Collections.reverseOrder());
        blueShirtHeights.sort(Collections.reverseOrder());

        String shirtColorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "red" : "blue";
        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            Integer redShirtHeight = redShirtHeights.get(idx); // 1
            Integer blueShirtHeight = blueShirtHeights.get(idx); // 2

            if (shirtColorInFirstRow.equals("red")) {
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
