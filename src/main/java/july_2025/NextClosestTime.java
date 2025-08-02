package july_2025;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

    public static void main(String[] args) {
        String time = "23:59";

        NextClosestTime nextClosestTime = new NextClosestTime();
        String result = nextClosestTime.nextClosestTime(time);
        System.out.println(result);
    }

    public String nextClosestTime(String time) {
        int minutes = Integer.parseInt(time.substring(0, 2)) * 60;
        minutes += Integer.parseInt(time.substring(3));

        Set<Integer> digits = new HashSet<>();
        for (char c : time.toCharArray()) {
            digits.add(c - '0');
        }

        while (true) {
            minutes = (minutes + 1) % (24 * 60);
            int[] nextTime = { minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10};

            boolean isValid = true;
            for (int digit : nextTime) {
                if (!digits.contains(digit)) {
                    isValid = false;
                }
            }

            if (isValid) {
                return String.format("%02d:%02d", minutes / 60, minutes % 60);
            }
        }
     }

}
