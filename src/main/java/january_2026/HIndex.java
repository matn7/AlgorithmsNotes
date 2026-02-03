package january_2026;

public class HIndex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        HIndex hIndex = new HIndex();
        int result = hIndex.hIndex(citations);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freqs = new int[n + 1];

        for (int citation : citations) {
            if (citation >= n) {
                freqs[n] += 1;
            } else {
                freqs[citation] += 1;
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
