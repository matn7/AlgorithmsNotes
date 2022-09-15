# The Graph

- A graph is used to represent relationship between entities.
- The entities can be anything - graphs find applications in variety of ways in the real world.
- These relationships can be arbitrarily complicated and of a variety of different types. 

**Vertex**

**Edge**

| Graph | Vertex | Edge | Company |
|---|---|---|---|
| Professional | The entities are people | Professional relationships - People work together | LinkedIn |
| Social | The entities are people | Personal relationships - People are friends | Facebook |
| Maps | The entities are locations | A way to get from one location to another | Google Maps |
| Phone Network | The entities are old fashioned phones - landlines | A network to carry voice from one instrument to another | at&t |
| Internet | The entities are computers across the world | A way to send info of data from one computer to another | Google |

- Graphs are used to represent information in many many real world applications.
- Graph theory is a complex field of study by itself - there are many algorithms to optimize different problems 
represented using graphs.

## What is a graph?

- A graph is a set of **vertices* and **edges**.
- Two vertices and a single edge is also a valid graph.
- The arrow on the edge:
    - This means that the relationship between the two vertices is directed - the edge is a **directed edge**.
- **Undirected** edges represent 2-way relationship such as:
    - **Two** way roads.    
    - I am his friend, and he is mine
- **Directed** edges represent 1-way relationships such as:
    - **One** way road.
    - I report to my manager.

**Undirected Graph**

- A and C are **ADJACENT** nodes.
- 3 edges are **INCIDENT** on a vertex F:
    - F is said to have a **DEGREE** of 3.
- Series of edges is called a **PATH**.
- **Undirected acyclic** graph, graph with no cycles.    
    - Every node is **connected to every other node** via a series of edges.
    - There is a **path** from every node to every other node.
    - This is a **connected** graph.
- A connected graph with no cycles is **a tree**.    
- **Forest** - a disjoint **set of trees**.

**Directed Graph**

- **Directed acyclic** graph.
    - Graph with no cycles with directed edges.
    
## The Graph representation

- What do you need to represent a graph?
- A way to model a vertex which may hold some information.    
- A way to model directed or undirected edges.
- There are 3 standard ways that graphs can be represented.
    - **Adjacency Matrix**
    - **Adjacency List**
    - **Adjacency Set**

**Adjacency Matrix**

- Use a matrix with rows and columns.
- A matrix is just a table.
- The row labels, and the column labels represent the vertices.
- Each cell represents the relationship between the vertices i.e. the edges.

|   | A | B | C | D | E |
|---|---|---|---|---|---|
| A | 0 | 1 | 1 | 0 | 0 |
| B | 0 | 0 | 0 | 1 | 0 |
| C | 0 | 0 | 0 | 0 | 1 |
| D | 0 | 0 | 0 | 0 | 0 |
| E | 0 | 1 | 0 | 1 | 0 |

- A value 1 or true in **(row A, column B)** indicates an **edge from A to B**.

**For an undirected graph**

|   | A | B | C | D | E |
|---|---|---|---|---|---|
| A | 0 | 1 | 1 | 0 | 0 |
| B | 1 | 0 | 0 | 1 | 1 |
| C | 1 | 0 | 0 | 0 | 1 |
| D | 0 | 1 | 0 | 0 | 1 |
| E | 0 | 1 | 1 | 1 | 0 |

```java
class Graph {
    int[][] adjacencyMatrix;
    int numVertices;
}
```

**Adjacency List**

- Each vertex is a node.
- Each vertex has a pointer to a linked list.
- This linked list contains all the other nodes this vertex connects to directly.
- If a vertex **V** has an edge leading to another vertex **U**.
- The **U** is present in **V**'s linked list.

| List representation |
|---|
| `A` -> `B` -> `C` |
| `B` -> `D` |
| `C` -> `E` |
| `D` |
| `E` -> `B` -> `D` |

**For an undirected graph**

| List representation |
|---|
| `A` -> `B` -> `C` |
| `B` -> `D` -> `E` -> `A` |
| `C` -> `E` -> `A` |
| `D` -> `B` -> `E` |
| `E` -> `B` -> `D` -> `C` |

```java
class Node {
    int vertexId;
    Node next;
}
```

```java
class Node {
    int vertexId;
    List<Node> next;
}
```

```java
class Graph {
    List<Node> vertices;
}
```

- Adjacency lists are not the best representations of graphs.
- They have some major downsides.
- The **order** of the vertices in the adjacency lists **matter**.
- The same graph can have **multiple representations**.
- Certain operations become tricky e.g. deleting a node involves looking through all the adjacency lists to remove the node
from all lists.

**Adjacency set**

- This is very similar to an adjacency list.
- Instead of a linked list to maintain the adjacent vertices, **use a set**.

## The Graph representation comparison

**Adjacency matrix**

- This works well when the graph is **well-connected** i.e. many nodes are connected with many other nodes.
- The overhead of `V^2` space is worth when the number of connections are large.

**Adjacency list/set**

- A **sparse** graph with **few connections** between nodes might be more efficiently represented using adjacency list or set.

**E = number of edges**

**V = number of vertices**

|   | Adjacency matrix | Adjacency list | Adjacency set |
|---|---|---|---|
| Space | `V^2` | `E + V` | `E + V` |
| Is edge present | `1` | `degree of V` | `log(degree of V)` |
| Iterate over edges on a vertex | `V` | `degree of V` | `degree of V` |

## The Graph traversal

- This is very similar to tree traversal.
- 2 types:
    - **Depth-first**
    - **Breadth-first**
    
**Depth first**
    
- In a tree there is only one path from the root to a specific node.
- In a graph multiple paths can lead from one node to another.
- A graph can also have cycles, so the same node can be visited multiple times.
- In order to avoid infinite looping in a graph we need to keep track of the nodes previously visited.
- Use a visited list to keep track of nodes already visited.
- The visited list can be a simple boolean array.
- Visited = `true` means the node has been seen before.
- Do not process these nodes again.

**Breadth first**

- Go level wise from the first node.
- Use a visited list to keep track of nodes already visited.
- Add non-visited child nodes to a queue.
- Visited = `true` means the node has been seen before.
- Do not process those nodes again.

## Topological sort

- It is an ordering of vertices in a **directed acyclic graph** in which each node comes before all the nodes to which
**it has outgoing edges**.
- A graph can have multiple topological sort (`A`, `C`, `E`, `B`, `D`).
    - `A` should come before `B` and `C`.
    - `C` should come before `E`.
    - `E` should come before `B` and `D`.
    - `B` should come before `D`.
- We first find a vertex which has no incoming edge.
- **It is the destination of no edge**.
- **No arrow points to it**.
- `A` is the only vertex with no incoming edge - this is the first element to sort.
- **Indegree** - number of inward directed graph edges for a given graph vertex.
- **Indegree of A is 0!**
- If there were **no vertices with 0 indegree**, then there would have been no topological sort.
    - **The graph has a cycle!**
- We now know `A` is the **first** element in our sort.
- If we "remove" `A` from this graph, we have to **reduce the indegree** of all its immediate neighbors.    
- Running time for topological sort is `O(V + E)`.

## Problems

**Design a course scheduling**

***

## The Shortest Path Algorithms

- Given A Graph `G` with vertices `V` and edges `E`.
- Choose any vertex `S` - the **SOURCE**.
- What is the shortest path from `S` to a specific **DESTINATION** vertex `D`?
- It is the path with **the fewest hops** to get from `S` to `D`.
- There can be **multiple** paths to the same vertex with different distances.
- Getting the shortest path is very similar to BFS.

| Path | Distance |
|---|---|
| `A` -> `B` -> `D` | 2 |
| `A` -> `C` -> `E` -> `D` | 3 |
| `A` -> `C` -> `E` -> `B` -> `D` | 4 |

```
A -----------------> B
|                    ^ \ 
|                    |  D
v                    | /
C -----------------> E
```

- We need to setup something called a **distance table**.
- The **distance** column will hold the distance of that vertex from the source `A`.
- This column is the **last vertex** in the path from the source `A` to that vertex.

| Vertex | Distance | Last Vertex |
|---|---|---|
| A | 0 | A |
| B | 3 | E |
| C | 1 | A |
| D | 4 | B |
| E | 2 | C |

```
DISTANCE[VERTEX] = DISTANCE[LAST VERTEX] + 1

A -> C -> E -> B -> D
```

**Algorithm**

- We initialize this table by setting `-1` in the distance column for all vertices other than the source vertex.
- The distance of `A` from itself id `0`.
- Update the table as explore the graph using BFS.
- Pop elements from stack to get path.

**Complexity**

- Running time is: `O(V + E)` if adjacency lists are used.
- Running time is: `O(V*V)` if adjacency matrix is used.

### Weighted Graph

- A graph having a weight, or number, associated with each edge.
- The weights can be **-VE** or **+VE**!
- These weights can represent anything!
- If it were a map, these weights could represent **time taken** or **distance** or **traffic conditions** between 
any two points!

```
        2
A -----------------> B
|                    ^ \ 2
| 3                5 |  D
v                    | / 4
C -----------------> E
        6
```

**The shortest path in a weighted graph**

- The algorithm here is similar to what we have discussed in finding the shortest path in an **unweighted graph**.
- There are 3 major differences!
- Finding the shortest path in a weighted graph is called Dijkstra's algorithm!
- We still use the **distance table** to store information.
    - The distance from a node now has to account for the **weight of the edges traversed**.
        - `DISTANCE[NEIGHBOR] = DISTANCE[VERTEX] + WEIGHT OF EDGE[VERTEX, NEIGHBOR]`
    - Each vertex has neighbors. Greedy Algorithm In a weighted Graph - visit the neighbor which is connected by an edge 
    with the **lowest weight**.
        - Use a **priority queue** to implement this.
        - To get the next vertex in the path pop the element with **the lowest weight**!
    - It's possible to visit a vertex more than once!
        - We check whether new distance (via the alternative route) is smaller than old distance.
        - `if new distance < original distance[neighbor]`
        - Update the distance table put the vertex in queue (once again)! **RELAXATION**

**Greedy Algorithm**

- A greedy algorithm builds up a solution **step by step**.
- A every step is only optimizes for that particular step - it **does not look at the overall problem**.
- It only considers the most **obvious** benefit of choosing **the best possible next step**.
- Greedy algorithms often **fail** to find **the best solution**.
- They do not operate on all the data, so they **may not see the big picture**.
- Greedy algorithms are used for optimization problems.
- Many algorithms have greedy solutions.
- Greedy solutions are especially useful to find **approximate** solutions to **very hard problems** which are close to
impossible to solve (technical term NP hard).
- E.g. the traveling salesman problem.

**Complexity**

- The algorithm's efficiency depends on how priority queue is implemented.
- It's two operations - **updating** the queue and **popping** out from the queue determines the running time!
- If binary heaps are used for priority queue, running time is: `O(E log(V))`
- If array is used for priority queue, running time is: `O(E + V*V)`

## The Shortest Path in negative weighted graph

**Bellman-Ford algorithm**

- Graphs can have negative weights on the edges as well.
- Finding the shortest path in graphs with negative weights is a different algorithm.
- Bellman-Ford algorithm is combination of **Dijkstra's** and **the shortest unweighted path** algorithm!

| Vertex | Distance | Last Vertex |
|---|---|---|
| A | 0 | A |
| B | INF |  |
| C | INF |  |
| D | INF |  |
| E | INF |  |

`DISTANCE[NEIGHBOR] = DISTANCE[VERTEX] + WEIGHT OF EDGE[VERTEX, NEIGHBOR]`

- However, this algorithm is **NOT "GREEDY"**, and we do not need a priority queue to traverse nodes.
- Greedy algorithms work well when **all edges are positive** allowing you to choose the most optimal step and every vertex.
- With negative distances the sum of distances are **not monotonically increasing** - A **single negative path** can change
the solution completely!
- With negative weigths it's possible that a path which seems **sub-optimal currently** leads to negative edge which 
makes it the best path!

```
        2
A -----------------> B --+
|                  ^ |    \ 3
|         -5      /  |     v
| 1 +-----------+    |     D
|  /              -2 |     ^
v /                  v    / 1
C -----------------> E --+
        2
```

| Path | Distance |
|---|---|
| `A` -> `B` -> `D` | 4 |
| `A` -> `C` -> `E` -> `D` | 3 |

- In the greedy algorithm we would have chosen the `A` -> `B` -> `D` path over the `A` -> `C` -> `E` -> `D` but that
would have been sub-optimal as later on we would discover the smaller weight path.
- Dijkstra's algorithm uses a priority queue to **greedily** select **the closest vertex** and visits all 
it's adjacent edges - the process called **relaxation**.
- By contrast, the Bellman-Ford algorithm process all the edges i.e. relaxes all the edges.
- We do computation for every edge and do it `(V - 1)` times **for each edge**!
- The longest possible path in a graph has **V - 1** edges.
- After **1 iteration** all vertices which are **1 edge away from the source** are accurate.
- After **2 iterations** all vertices which are **2 edge away from the source** are accurate.
- After **3 iterations** all vertices which are **3 edge away from the source** are accurate.
- With **V - 1** iterations we can guarantee that the vertex **furthest** away from the source will its distance
accurately calculated.

**Negative cycles**

- A cycle with a negative distance!
- There is **no shortest or cheapest path**! Every time we go around we will find something shorter and cheaper.
- :star: How do we detect a cycle?
    - After **(V-1)** iteration, we will do one more iteration (relaxation).
    - If distance of any vertex still gets updated, then there is definitely a cycle!
    - Note: if no negative cycles exist then the longest path between two vertices is at most **V-1** edges.
    - The presence of a negative cycle can make a path between two vertices **longer than the longest possible path** 
    in a graph i.e. grater than **V-1**.

```
        2
A -----------------> B <+
|                    |   \ 2
|                    |    \ 
| 3               -5 |     D
|                    |    ^ 
v                    v   /  -4
C -----------------> E -+
        6
```

**Bellman-Ford complexity**

- In the worst case we traverse all edges V - 1 times.
- Running time is: `O(E * V)` if adjacency lists are used.
- Running time is: `O(V^3)` if adjacency matrix are used.
    - `E = V * V` in adjacency matrix.
    
***
    
## Minimal spanning tree, Prim's algorithm

- Spanning tree is a subgraph that contains all the vertices and is also a tree.
- Minimum spanning tree is a subgraph that contains all the vertices and is also a tree, **with minimum total cost**.

```
        2
A ------------------ B -+
|                    |   \ 2
|                    |    \ 
| 3                5 |     D
|                    |    /
|                    |   /  4
C ------------------ E -+
        6

        2
A ------------------ B -+
|                        \ 2
|                         \ 
| 3                        D
|                         /
|                        /  4
C                    E -+
```

- The algorithm that we will study works well for undirected connected graphs.
- The shortest weight path from `A` to `B` is the same as `B` to `A`.
- This is **Prim's** algorithm.
- It's very similar to Dijkstra's shortest path for weighted graphs.
- There are 2 parts to this algorithm:
    - Generate the distance table using Dijkstra's like algorithm using any vertex as the source.
        - `DISTANCE[NEIGHBOR] = WEIGHT OF EDGE[VERTEX, NEIGHBOR]`
        - We only care about the weight of the edge not the cumulative distance from the source.
    - Use this distance table to get paths to all other vertices from the arbitrarily chosen source.    
- We want to minimize **total distance** and not just distance from one specific vertex.
- In dijkstra's algorithm, you specify one source vertex.
- In Prim's algorithm start with any random vertex!
- An edge is chosen to be part of the spanning tree if:
    - The vertex is the closest vertex at the current step (i.e. connected by the lowest weighted edge).
    - The vertex is not part of the spanning tree already.

```
        5
A ------------------ B -+
| \-----+   +------/ |   \ 11
|    3   \ /   5     |    \ 
| 15      B        4 |     D
|    2   / \   8     |    /
| /-----+   +--------|   /  4
C ------------------ E -+
          9
```

| Vertex | Distance | Last Vertex |
|---|---|---|
| A | 3 | B |
| B | 5 | E |
| C | 2 | B |
| D | 4 | F |
| E | 4 | F |
| F | 0 | F |

```
A                    B
  \-----+   +------/ |   
     3   \ /   5     |     
          B        4 |     D
     2   /           |    /
  /-----+            |   /  4
C                    E -+
```

- When would you use the minimal spanning tree vs the shortest path algorithm?
- The shortest path to find **the shortest route** to travel from a source to get to a destination.
- Minimal spanning tree to find **the cheapest way to interconnect** cities.
- To find the minimal spanning tree for a forest (unconnected trees) just run Prim's algorithm on each connected graph!

**Prim's algorithm complexity**

- Running time is: `O(e log(v))` if binary heaps are used for priority queue.
- Running time is: `O(e + v * v)` if array is used for priority queue.

## Minimal spanning tree on the forrest, Kruskal's algorithm

- A forest is an unconnected graph, **Kruskal's algorithm**.
- This is a 'Greedy algorithm' it tries to find the optimal next step at every step - a local optimum not the global optimum.
- At every step we choose the smallest weighted edge from the entire graph.
- 2 things to keep in mind while implementing Kruskal's algorithm.
    - Use a priority queue of edges where the weights of the edges determine the priority of the edge.
    - While adding a new edge, always make sure that the new edge does not create a cycle in the spanning tree.
        - Continue adding edges till we get **V -1** edges so the graph is connected i.e. it's a tree.
- This algorithm works for both connected and unconnected graphs i.e forests.        

```
        5
A ------------------ B -+
| \-----+   +------/ |   \ 11
|    3   \ /   5     |    \ 
| 15      B        4 |     D
|    2   / \   8     |    /
| /-----+   +--------|   /  4
C ------------------ E -+
          9
```

**Complexity**

- The algorithm's running time is `e(log(e))`!
    - The main processing time involves sorting the edges by weight and this is the running time of the best sorting
    algorithm.



