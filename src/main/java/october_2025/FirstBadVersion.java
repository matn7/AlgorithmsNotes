package october_2025;

public class FirstBadVersion {

    // O(log(n)) time | O(1) space
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        int version = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                version = Math.min(version, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return version;
    }

    private boolean isBadVersion(int version) {
        return true;
    }

}
