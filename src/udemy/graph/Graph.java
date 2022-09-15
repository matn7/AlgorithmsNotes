package udemy.graph;

import java.util.List;

public interface Graph {

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int v1, int v2);

    int getIndegree(int v);

    List<Integer> getAdjacentVertices(int v);

    int getNumVertices();

    int getWeightedEdge(int v1, int v2);
}
