package medium;

public class ValidStartingCity {

    public static void main(String[] args) {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;

        ValidStartingCity validStartingCity = new ValidStartingCity();
        validStartingCity.validStartingCity(distances, fuel, mpg);
    }

//    // O(n^2) time | O(1) space
//    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
//        // Write your code here.
//        int numberOfCities = distances.length;
//        for (int startCityIdx = 0; startCityIdx < numberOfCities; startCityIdx++) {
//            int milesRemaining = 0;
//
//            for (int currentCityIdx = startCityIdx; currentCityIdx <= startCityIdx + numberOfCities; currentCityIdx++) {
//                if (milesRemaining < 0) {
//                    continue;
//                }
//                currentCityIdx = currentCityIdx % numberOfCities;
//
//                int fuelFromCurrentCity = fuel[currentCityIdx];
//                int distanceToNextCity = distances[currentCityIdx];
//                milesRemaining += fuelFromCurrentCity * mpg - distanceToNextCity;
//            }
//            if (milesRemaining >= 0) {
//                return startCityIdx;
//            }
//        }
//
//        return -1;
//    }

    // O(n) time | O(1) space
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;
        int milesRemaining = 0;

        int indexOfStartingCityCandidate = 0;
        int milesRemainingAtStartingCity = 0;

        for (int cityIdx = 1; cityIdx < numberOfCities; cityIdx++) {
            int distanceFromPreviousCity = distances[cityIdx - 1];
            int fuelFromPreviousCity = fuel[cityIdx - 1];
            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if (milesRemaining < milesRemainingAtStartingCity) {
                milesRemainingAtStartingCity = milesRemaining;
                indexOfStartingCityCandidate = cityIdx;
            }
        }
        return indexOfStartingCityCandidate;
    }

}
