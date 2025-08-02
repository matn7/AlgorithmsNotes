package july_2025;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] people = {3,5,3,4};
        int limit = 5;

//        int[] people = {3,2,2,1};
//        int limit = 3;

        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();

        int result = boatsToSavePeople.numRescueBoats(people, limit);
        System.out.println(result);

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
