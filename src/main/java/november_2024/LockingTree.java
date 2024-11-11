package november_2024;

import java.util.*;

public class LockingTree {

    int[] parent;
    Integer[] locked;
    Map<Integer, List<Integer>> child;

    public LockingTree(int[] parent) {
        this.parent = parent;
        this.locked = new Integer[parent.length];
        Arrays.fill(locked, null);
        child = new HashMap<>();

        // Build the tree structure.
        for (int i = 1; i < parent.length; i++) {
            child.putIfAbsent(parent[i], new ArrayList<>());
            child.get(parent[i]).add(i);
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num] != null) {
            return false; // Already locked
        }
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] == null || !locked[num].equals(user)) {
            return false; // Not locked by this user
        }
        locked[num] = null;
        return true;
    }

    public boolean upgrade(int num, int user) {
        // Check if any ancestor is locked
        int i = num;
        while (i != -1) {
            if (locked[i] != null) {
                return false;
            }
            i = parent[i];
        }

        // Count and unlock all descendants that are locked
        int lockedCount = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (locked[node] != null) {
                locked[node] = null;  // Unlock the node
                lockedCount++;
            }
            for (int childNode : child.getOrDefault(node, Collections.emptyList())) {
                q.add(childNode);
            }
        }

        // If any descendants were unlocked, lock the current node
        if (lockedCount > 0) {
            locked[num] = user;
            return true;
        }
        return false;
    }
}























