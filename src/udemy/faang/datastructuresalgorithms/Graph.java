package udemy.faang.datastructuresalgorithms;

import java.util.*;

public class Graph {

    Direction direction = Direction.UNDIRECTED;

    int numberOfNodes;
    Map<Character, Vertex> adjacentList;

    public Graph() {
        this.adjacentList = new HashMap<>();
    }

    public Graph(Direction direction) {
        this.adjacentList = new HashMap<>();
        this.direction = direction;
    }

    public void addVertex(Character node) {
        this.adjacentList.put(node, new Vertex(node));
        this.numberOfNodes++;
    }

    public void addEdge(Character node1, Character node2) {
        if (adjacentList.containsKey(node1) && adjacentList.containsKey(node2)) {
            Vertex vertex1 = adjacentList.get(node1);
            Vertex vertex2 = adjacentList.get(node2);
            if (direction == Direction.UNDIRECTED) {
                vertex1.addNeighbors(vertex2);
                vertex2.addNeighbors(vertex1);
            } else {
                vertex1.addNeighbors(vertex2);
            }
        } else {
            throw new RuntimeException("Add edge not possible as one or both Vertex missing");
        }

    }
}

enum Direction {
    DIRECTED, UNDIRECTED
}

class Vertex {
    Character id;
    Set<Vertex> neighbors;

    public Vertex(Character id) {
        this.id = id;
        this.neighbors = new HashSet<>();
    }

    public void addNeighbors(Vertex vertex) {
        this.neighbors.add(vertex);
    }
}

class MainGraph {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('0');
        graph.addVertex('1');
        graph.addVertex('2');
        graph.addVertex('3');
        graph.addVertex('4');
        graph.addVertex('5');
        graph.addVertex('6');

        graph.addEdge('0', '1');
        graph.addEdge('0', '2');
        graph.addEdge('1', '0');
        graph.addEdge('1', '2');
        graph.addEdge('1', '3');
        graph.addEdge('2', '0');
        graph.addEdge('2', '1');
        graph.addEdge('2', '4');
        graph.addEdge('3', '1');
        graph.addEdge('3', '4');
        graph.addEdge('4', '2');
        graph.addEdge('4', '3');
        graph.addEdge('4', '5');
        graph.addEdge('5', '4');
        graph.addEdge('5', '6');
        graph.addEdge('6', '5');

        System.out.println();
    }
}
