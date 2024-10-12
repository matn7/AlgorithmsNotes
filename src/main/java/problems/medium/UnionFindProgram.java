package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class UnionFindProgram {
//    static class UnionFind {
//        // Write your code here.
//        Map<Integer, Integer> parents = new HashMap<>();
//
//        // O(1) time | O(1) space
//        public void createSet(int value) {
//            // Write your code here.
//            parents.put(value, value);
//        }
//
//        // O(n) time | O(1) space
//        public Integer find(int value) {
//            // Write your code here.
//            if (!parents.containsKey(value)) {
//                return null;
//            }
//            int currentParent = value;
//            while (currentParent != parents.get(currentParent)) {
//                currentParent = parents.get(currentParent);
//            }
//            return currentParent;
//        }
//
//        // O(n) time | O(1) space
//        public void union(int valueOne, int valueTwo) {
//            // Write your code here.
//            if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
//                return;
//            }
//            int valueOneRoot = find(valueOne);
//            int valueTwoRoot = find(valueTwo);
//
//            parents.put(valueTwoRoot, valueOneRoot);
//        }
//    }

//    static class UnionFind {
//        // Write your code here.
//        Map<Integer, Integer> parents = new HashMap<>();
//        Map<Integer, Integer> rank = new HashMap<>();
//
//        // O(1) time | O(1) space
//        public void createSet(int value) {
//            // Write your code here.
//            parents.put(value, value);
//            rank.put(value, 0);
//        }
//
//        // O(log(n)) time | O(1) space
//        public Integer find(int value) {
//            // Write your code here.
//            if (!parents.containsKey(value)) {
//                return null;
//            }
//            int currentParent = value;
//            while (currentParent != parents.get(currentParent)) {
//                currentParent = parents.get(currentParent);
//            }
//            return currentParent;
//        }
//
//        // O(log(n)) time | O(1) space
//        public void union(int valueOne, int valueTwo) {
//            // Write your code here.
//            if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
//                return;
//            }
//            int valueOneRoot = find(valueOne);
//            int valueTwoRoot = find(valueTwo);
//            if (rank.get(valueOneRoot) < rank.get(valueTwoRoot)) {
//                parents.put(valueOneRoot, valueTwoRoot);
//            } else if (rank.get(valueOneRoot) > rank.get(valueTwoRoot)) {
//                parents.put(valueTwoRoot, valueOneRoot);
//            } else {
//                parents.put(valueTwoRoot, valueOneRoot);
//            }
//        }
//    }

    static class UnionFind {
        // Write your code here.
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();

        // O(1) time | O(1) space
        public void createSet(int value) {
            // Write your code here.
            parents.put(value, value);
            rank.put(value, 0);
        }

        // O(alpha n), approximately O(1) time |O(alpha n), approximately O(1) time
        public Integer find(int value) {
            // Write your code here.
            if (!parents.containsKey(value)) {
                return null;
            }
            if (value != parents.get(value)) {
                parents.put(value, find(parents.get(value)));
            }

            return parents.get(value);
        }

        // O(alpha n), approximately O(1) time |O(alpha n), approximately O(1) time
        public void union(int valueOne, int valueTwo) {
            // Write your code here.
            if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
                return;
            }
            int valueOneRoot = find(valueOne);
            int valueTwoRoot = find(valueTwo);
            if (rank.get(valueOneRoot) < rank.get(valueTwoRoot)) {
                parents.put(valueOneRoot, valueTwoRoot);
            } else if (rank.get(valueOneRoot) > rank.get(valueTwoRoot)) {
                parents.put(valueTwoRoot, valueOneRoot);
            } else {
                parents.put(valueTwoRoot, valueOneRoot);
            }
        }
    }
}
