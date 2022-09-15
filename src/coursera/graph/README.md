# GRAPH

- In Practice use adjacency-list representation:
    - Algorithms based on iterating over vertices adjacent to v.
    - Real world graphs tend to be sparse.
    
| representation | space | add edge | edge between v and w? | iterate over vertices adjacent to v? |
|---|---|---|---|---|
| list of edges | E | 1 | E | E |
| adjacency matrix | V^2 | 1 | 1 | V |
| adjacency lists | E + V | 1 | degree(v) | degree(v) |

## Maze

