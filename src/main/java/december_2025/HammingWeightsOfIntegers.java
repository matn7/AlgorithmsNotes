package december_2025;

public class HammingWeightsOfIntegers {

    // O(1) time | O(1) space
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


}
