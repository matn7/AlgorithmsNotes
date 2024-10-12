package july_2024;

import java.util.ArrayList;
import java.util.List;

public class GetLocations {

    public static void main(String[] args) {
        List<int[]> test = getLocations("testthis is a testtest to see if testthetest it works", "test");
        System.out.println(test);
    }

    // O(n) time | O(n) space
    public static List<int[]> getLocations(String str, String substr) {
        List<int[]> locations = new ArrayList<>();
        int startIdx = 0;
        while (startIdx < str.length()) {
            int nextIdx = str.indexOf(substr, startIdx);
            if (nextIdx != -1) {
                locations.add(new int[] {nextIdx, nextIdx + substr.length()});
                startIdx = nextIdx + 1;
            } else {
                break;
            }
        }
        return locations;
    }

}
