package october_2023;

import java.util.ArrayList;
import java.util.List;

public class GetLocations {

    public static void main(String[] args) {
        String str = "testthis is a testtest to see if testestest it works";

        List<Integer[]> result = getLocations(str, "test");
        for (Integer[] res : result) {
            System.out.println("[" + res[0] + "," + res[1] +"]");
        }
    }

    public static List<Integer[]> getLocations(String str, String subStr) {
        List<Integer[]> result = new ArrayList<>();
        int startIdx = 0;
        while (startIdx < str.length()) {
            int nextIdx = str.indexOf(subStr, startIdx);
            if (nextIdx == -1) {
                break;
            }
            result.add(new Integer[]{nextIdx, nextIdx + subStr.length()});
            startIdx = nextIdx + 1;
        }
        return result;
    }

}
