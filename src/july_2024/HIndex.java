package july_2024;

public class HIndex {

    public static void main(String[] args) {
        int[] pubs = {5, 3, 3, 1, 0};

        int result = hIndex(pubs);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int hIndex(int[] pubs) {
        int n = pubs.length; // 5
        int[] freqs = new int[n + 1];
        //  0  1  2  3  4  5
        // [1, 1, 0, 2, 0, 1]

        // [5, 3, 3, 1, 0]
        //              *
        for (int pub : pubs) {
            if (pub >= n) {  // 0 >= 5
                freqs[n] += 1;
            } else {
                freqs[pub] += 1;
            }
        }

        // [1, 1, 0, 2, 0, 1]
        //           *
        int total = 0;
        int i = n; // 5
        while (i >= 0) { // 3 >= 0
            total += freqs[i]; // 1 + 2 = 3
            if (total >= i) { // 3 >= 3
                return i;
            }
            i--;
        }
        return 0;
    }

}
