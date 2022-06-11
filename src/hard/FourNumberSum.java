package hard;

import java.util.*;
import java.util.stream.Collectors;

public class FourNumberSum {

    public static void main(String[] args) {
//        int[] array = {7, 6, 4, -1, 1, 2};
//        fourNumberSum(array, 16);

//        int[] array = {1, 2, 3, 4, 5, 6, 7};
//        fourNumberSum(array, 10);

//        int[] array = {-2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] array = {-10, -3, -5, 2, 15, -7, 28, -6, 12, 8, 11, 5};
        fourNumberSum(array, 20);
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        int start = 0;
        int end = array.length - 1;

        // Key in map must be differ as (-1,1) = 0 and (-2,2) = 0 but only -2,2 is stored
        Map<Integer, List<Integer[]>> sumMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int curr = array[i] + array[j];
                if (sumMap.containsKey(curr)) {
                    Integer[] currIntArr = {array[i], array[j]};
                    sumMap.get(curr).add(currIntArr);
                } else {
                    List<Integer[]> resArr = new ArrayList<>();
                    Integer[] currIntArr = {array[i], array[j]};
                    resArr.add(currIntArr);
                    sumMap.put(curr, resArr);
                }
            }
        }

        Arrays.sort(array);

        Set<Integer> resultSet = new HashSet<>();
        Map<String, Integer[]> resMap = new HashMap<>();

        for (start = 0; start <array.length; start++) {
            for (end = array.length - 1 - start; end >= 0; end--) {
                int first = array[start];
                int second = array[end];
                int currentSum = first + second;
                int mapKey = targetSum - currentSum;

                if (sumMap.containsKey(mapKey)) {
                    List<Integer[]> listOfInts = sumMap.get(mapKey);
                    for (Integer[] el : listOfInts) {
                        boolean changed = false;
                        Integer[] integers = el;
                        for (Integer element : integers) {
                            if (element == first) {
                                // start++;
                                changed = true;
                            }
                            if (element == second) {
                                // end--;
                                changed = true;
                            }
                        }
                        if (changed) {
                            // we do not do not result continue
                            continue;
                        } else {
                            // found ok result
                            Integer[] res = new Integer[4];
                            res[0] = first;
                            res[1] = second;
                            res[2] = integers[0];
                            res[3] = integers[1];

                            Arrays.sort(res);

                            resultSet.clear();

                            resultSet.add(first);
                            resultSet.add(second);
                            resultSet.add(integers[0]);
                            resultSet.add(integers[1]);
                            if (resultSet.size() == 4) {
                                String key = Arrays.toString(res);
                                resMap.put(key, res);
                            }
                        }
                    }
                }
            }
        }

        List<Integer[]> collect = new ArrayList<>();

        for (Map.Entry<String, Integer[]> element : resMap.entrySet() ) {
            collect.add(element.getValue());
        }


        return collect;
    }

}
