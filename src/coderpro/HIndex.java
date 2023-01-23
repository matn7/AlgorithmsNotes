package coderpro;

public class HIndex {

    public static void main(String[] args) {
        int[] pubs = {3, 5, 0, 1, 3};

        HIndex hIndex = new HIndex();
        int result = hIndex.hIndex(pubs);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int hIndex(int[] pubs) {
        int n = pubs.length;
        int[] freqs = new int[n + 1];

        for (int pub : pubs) {
            if (pub >= n) {
                freqs[n] += 1;
            } else {
                freqs[pub] += 1;
            }
        }

        int total = 0;
        int i = n;
        while (i >= 0) {
            total += freqs[i];
            if (total >= i) {
                return i;
            }
            i--;
        }

        return 0;
    }

}
