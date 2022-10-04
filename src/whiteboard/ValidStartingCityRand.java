package whiteboard;

public class ValidStartingCityRand {

    public static void main(String[] args) {
        int[] distances = {5, 25, 15, 10, 15};
        int[] fuel = {1, 2, 1, 0, 3};
        int mpg = 10;

        ValidStartingCityRand validCity = new ValidStartingCityRand();
        validCity.validStartingCity(distances, fuel, mpg);
    }

    // O(n) time | O(1) space
    public int validStartingCityOptimal(int[] distances, int[] fuel, int mpg) {
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

    // O(n^2) time | O(1) space
    // rand: 20/09/2022
    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        // Write your code here.
        int startCity;
        int range;
        for (int d = 0; d < distances.length; d++) {
            startCity = d;
            range = 0;
            for (int n = d; n < distances.length; n++) {
                if (range < 0) {
                    continue;
                }
                n = n % distances.length;
                int distance = distances[n];
                range += fuel[n] * mpg;
                range -= distance;
            }
            if (range >= 0) {
                return startCity;
            }
        }
        return -1;
    }
}
