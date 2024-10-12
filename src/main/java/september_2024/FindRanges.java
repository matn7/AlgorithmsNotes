package september_2024;

import java.util.*;

public class FindRanges {

    public static void main(String[] args) {
        FindRanges findRanges = new FindRanges();
        findRanges.add(5, 9);
        findRanges.add(13, 16);

        boolean exists = findRanges.exists(7, 8);
        System.out.println(exists); // expects true
    }

    Set<Range> rangesMap = new HashSet<>();

    boolean exists(int start, int end) {
        Range rangeKey = new Range(start, end);
        // Change this to check if any range in the set contains the key range
        for (Range range : rangesMap) {
            if (range.contains(rangeKey)) {
                return true;
            }
        }
        return false;
    }

    void add(int start, int end) {
        Range newRange = new Range(start, end);
        rangesMap.add(newRange);
    }

    static class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Range range = (Range) o;
            return start == range.start && end == range.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        // Method to check if the range contains another range
        public boolean contains(Range other) {
            return this.start <= other.start && this.end >= other.end;
        }
    }
}
