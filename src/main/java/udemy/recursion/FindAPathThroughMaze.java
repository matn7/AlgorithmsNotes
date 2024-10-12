package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAPathThroughMaze {

    public static boolean findPath(Cell current, List<Cell> currentPath) {
        currentPath.add(current);
        if (current.isEnd()) {
            return true;
        }

        for (Cell neighbor : current.getNeighborList()) {
            if (!currentPath.contains(neighbor)) {
                List<Cell> neighborPath = new ArrayList<>();
                neighborPath.addAll(currentPath);

                if (findPath(neighbor, neighborPath)) {
                    currentPath.clear();;
                    currentPath.addAll(neighborPath);
                    return true;
                }
            }
        }
        return false;
    }

    public static class Cell {
        private String id;
        private boolean isEnd = false;

        public List<Cell> neighborList = new ArrayList<>();

        public Cell(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public List<Cell> getNeighborList() {
            return neighborList;
        }

        public void addNeighbor(Cell... neighbors) {
            for (Cell neighbor : neighbors) {
                neighborList.add(neighbor);
            }
        }

        @Override
        public String toString() {
            return id;
        }
    }

}
