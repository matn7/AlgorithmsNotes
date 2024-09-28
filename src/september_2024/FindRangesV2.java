package september_2024;

import java.util.Map;
import java.util.TreeMap;

public class FindRangesV2 {

    public static void main(String[] args) {
        FindRangesV2 findRanges = new FindRangesV2();
        findRanges.add(5, 9);
        findRanges.add(13, 16);

        boolean exists = findRanges.exists(7, 8);
        System.out.println(exists); // expects true

        boolean exists2 = findRanges.exists(6, 12);
        System.out.println(exists2);
    }

    // ********
    // * STAR *
    // ********

    // Use TreeMap to store ranges where the key is the start of the range, and the value is the end of the range
    TreeMap<Integer, Integer> rangesMap = new TreeMap<>();

    // O(log(n)) time | O(n) space
    boolean exists(int start, int end) {
        // Find the largest range whose start is less than or equal to `start`
        Map.Entry<Integer, Integer> floorEntry = rangesMap.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() >= end) {
            // If this range covers the [start, end] interval, return true
            return true;
        }
        return false;
    }

    // O(log(n)) time | O(n) space
    void add(int start, int end) {
        // Find overlapping or adjacent ranges
        Map.Entry<Integer, Integer> lower = rangesMap.floorEntry(start);  // Entry whose start is <= start
        Map.Entry<Integer, Integer> higher = rangesMap.ceilingEntry(start);  // Entry whose start is >= start

        // Merge with the lower range if it overlaps or is adjacent
        if (lower != null && lower.getValue() >= start - 1) {
            start = Math.min(start, lower.getKey());
            end = Math.max(end, lower.getValue());
            rangesMap.remove(lower.getKey());
        }

        // Merge with the higher range if it overlaps or is adjacent
        if (higher != null && higher.getKey() <= end + 1) {
            start = Math.min(start, higher.getKey());
            end = Math.max(end, higher.getValue());
            rangesMap.remove(higher.getKey());
        }

        // Insert the merged range
        rangesMap.put(start, end);
        System.out.println();
    }
}