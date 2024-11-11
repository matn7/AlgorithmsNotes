package november_2024;

import java.util.*;

public class InsertInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1,3}, {6,9}};
//        int[] newInterval = {10,12};

        int[][] intervals = {{1,2}, {3,5}, {6, 7}, {8,10}, {12,16}};
        int[] newInterval = {4,8};

        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                int[][] result = new int[res.size()][2];
                for (int k = 0; k < res.size(); k++) {
                    result[k] = res.get(k);
                }
                return result;
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);

        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> arr = new ArrayList<>(Arrays.asList(intervals));
        arr.add(newInterval);
        arr.sort(Comparator.comparing(a -> a[0]));
        List<int[]> newArr = new ArrayList<>();
        for (int[] in : arr) {
            if (newArr.isEmpty()) {
                newArr.add(in);
            } else {
                int[] top = newArr.get(newArr.size() - 1); // [1,3]
                // in = [2,5]
                if (top[1] >= in[0]) {
                    top[1] = Math.max(top[1], in[1]);
                } else {
                    newArr.add(in);
                }
            }
        }
        int[][] res = new int[newArr.size()][2];
        for (int i = 0; i < newArr.size(); i++) {
            res[i] = newArr.get(i);
        }

        return res;
    }

}
