package medium;

public class ValidStartingCityREPEAT {

    public static void main(String[] args) {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;

        ValidStartingCityREPEAT validStartingCityREPEAT = new ValidStartingCityREPEAT();

        int result = validStartingCityREPEAT.validStartingCity(distances, fuel, mpg);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    // OK - repeated 12/02/2022
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;
        int milesRemaining = 0;

        //                              *
        // city      = [0,  1,  2,  3,  4]
        // distances = [5, 25, 15, 10, 15]
        // fuel =      [1,  2,  1,  0,  3]
        int indexOfStartingCityCandidate = 0;
        int milesRemainingAtStartingCityCandidate = 0;

        for (int cityIdx = 1; cityIdx < numberOfCities; cityIdx++) { // 4
            int distanceFromPreviousCity = distances[cityIdx - 1]; // 10
            int fuelFromPreviousCity = fuel[cityIdx - 1]; // 0
            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity; // 1 * 10 - 5 = 5
            // -5 += 0 - 10 = -15
            if (milesRemaining < milesRemainingAtStartingCityCandidate) { // -15 < -5
                milesRemainingAtStartingCityCandidate = milesRemaining; // -15
                indexOfStartingCityCandidate = cityIdx; // 4
            }
        }
        return indexOfStartingCityCandidate; // 4
    }

//    // O(n^2) time | O(1) space
//    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
//        // Write your code here.
//        int numberOfCities = distances.length;
//        //                              s
//        //                              c
//        // city      = [0,  1,  2,  3,  4]
//        // distances = [5, 25, 15, 10, 15]
//        // fuel      = [1,  2,  1,  0,  3]
//        for (int startCityIdx = 0; startCityIdx < numberOfCities; startCityIdx++) {
//            int milesRemaining = 0;
//
//            for (int currentCityIdx = startCityIdx; currentCityIdx < numberOfCities; currentCityIdx++) {
//                if (milesRemaining < 0) {
//                    continue;
//                }
//                currentCityIdx = currentCityIdx % numberOfCities; // 4 % 5 = 4
//
//                int fuelFromCurrentCity = fuel[currentCityIdx]; // 0
//                int distanceToNextCity = distances[currentCityIdx]; // 10
//                milesRemaining += fuelFromCurrentCity * mpg - distanceToNextCity; // 10 += 1 * 10 - 10 = 0
//                if (startCityIdx == 4) {
//                    System.out.println(currentCityIdx);
//                }
//            }
//
//            if (milesRemaining >= 0) {
//                return startCityIdx;
//            }
//        }
//        return -1;
//    }



}
