package march_2024;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] people = {3, 2, 1, 3};
        int limit = 4;

        System.out.println(numRescueBoats(people, limit));
    }

    // O(nlog(n)) time | O(n) space
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int heavyP = people.length - 1;
        int lightP = 0;
        int boats = 0;

        while (heavyP >= lightP) {
            if (people[heavyP] + people[lightP] <= limit) {
                heavyP--;
                lightP++;
            } else {
                heavyP--;
            }
            boats++;
        }

        return boats;
    }

}
