package udemy.recursion;

import java.util.*;

public class FindAPathThroughMazeMy {

    public static void main(String[] args) {

        Cell D = new Cell("D");
        Cell A = new Cell("A");
        Cell B = new Cell("B");
        Cell C = new Cell("C");
        Cell E = new Cell("E");
        Cell F = new Cell("F");
        Cell G = new Cell("G");
        Cell H = new Cell("H");
        Cell I = new Cell("I");

        D.addNeighbors(A);
        A.addNeighbors(D, B);
        B.addNeighbors(A, E, C);
        C.addNeighbors(B);
        E.addNeighbors(B, G, F);
        G.addNeighbors(E, H);
        F.addNeighbors(E, H);
        H.addNeighbors(G, F, I);
        I.addNeighbors(H);

        Map<String, Cell> inputMap = new HashMap<>();
        inputMap.put("D", D);
        inputMap.put("A", A);
        inputMap.put("B", B);
        inputMap.put("C", C);
        inputMap.put("E", E);
        inputMap.put("F", F);
        inputMap.put("G", G);
        inputMap.put("H", H);
        inputMap.put("I", I);

        findPath(inputMap, "D", "I");

    }

    public static List<String> findPath(Map<String, Cell> input, String start, String end) {
        List<String> result = new ArrayList<>();
        findPathHelper(input, start, end);
        Cell endCell = input.get(end);
        if (endCell.cameFrom != null) {
            Cell current = endCell;
            while (current != null) {
                result.add(current.id);
                current = current.cameFrom;
            }
            Collections.reverse(result);
        }
        return result;
    }

    private static void findPathHelper(Map<String, Cell> input, String start, String end) {
        Cell current = input.get(start);
        current.visited = true;
        List<Cell> neighbors = current.neighbors;
        for (Cell neighbor : neighbors) {
            if (neighbor.visited) {
                continue;
            }
            neighbor.cameFrom = current;
            findPathHelper(input, neighbor.id, end);
        }
        if (start.equals(end)) {
            return;
        }
    }

    static class Cell {
        String id;
        boolean visited = false;
        List<Cell> neighbors;
        Cell cameFrom = null;

        public Cell(String id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbors(Cell... neighbors) {
            for (Cell neighbor : neighbors) {
                this.neighbors.add(neighbor);
            }
        }
    }
}
