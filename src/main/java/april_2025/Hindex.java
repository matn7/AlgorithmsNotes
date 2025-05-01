package april_2025;

import java.util.Arrays;
import java.util.Comparator;

public class Hindex {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        Hindex hindex = new Hindex();
        int result = hindex.hIndex(citations);
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

    // O(nlog(n)) time | O(n) space
    public int hIndex2(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length / 2; i++) {
            int temp = citations[i];
            citations[i] = citations[citations.length - 1 - i];
            citations[citations.length - 1 - i] = temp;
        }

        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < i + 1) {
                return i;
            }
        }

        return citations.length;
    }


}
