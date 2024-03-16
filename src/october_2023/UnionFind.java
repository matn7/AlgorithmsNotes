package october_2023;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    Map<Integer, Integer> parents = new HashMap<>();

    // O(1) time | O(1) space
    public void createSet(int value) {
        parents.put(value, value);
    }

    // O(n) time | O(1) space
    public Integer find(int value) {
        if (!parents.containsKey(value)) {
            return null;
        }
        int currentParent = value;
        while (currentParent != parents.get(currentParent)) {
            currentParent = parents.get(currentParent);
        }
        return currentParent;
    }

    // O(n) time | O(1) space
    public void union(int valueOne, int valueTwo) {
        if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
            return;
        }
        int valueOneRoot = find(valueOne);
        int valueTwoRoot = find(valueTwo);
        parents.put(valueTwoRoot, valueOneRoot);
    }

}
