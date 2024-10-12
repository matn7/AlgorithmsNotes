package september_2024;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    Map<Integer, Integer> parents = new HashMap<>();

    public void createSet(int value) {
        parents.put(value, value);
    }

    public int find(int value) {
        if (!parents.containsKey(value)) {
            throw new RuntimeException("Invalid key");
        }
        int currentParent = value;
        while (currentParent != parents.get(currentParent)) {
            currentParent = parents.get(currentParent);
        }
        return currentParent;
    }

    public void union(int valueOne, int valueTwo) {
        if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)) {
            throw new RuntimeException("Invalid key");
        }

        int valueOneRoot = find(valueOne);
        int valueTwoRoot = find(valueTwo);
        parents.put(valueTwoRoot, valueOneRoot);
    }


}
