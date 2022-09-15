# Recursion

**Reverse String**

**Binary Search**

- By halving the search area at every step, binary search works much faster than linear search.
- The iterative approach to binary search might perform better than the recursive approach in terms of space complexity.
There is not recursive stack in the iterative approach, which means we save on some space.

**Find all subsets in set**

**Find whether 2 binary trees are exactly the same**

- A Binary Tree is one where every node can have a maximum of two children - a left child and right child.
- Two binary trees are the same if:
    - Every corresponding node has the same value.
    - The structure of the tree at every corresponding node is the same.
    
**Paint fill**

**Build a car**

- The tasks and it's dependencies for a directed acyclic graph.
- The graph may not be fully connected, i.e. certain tasks stand completely alone.
- Topological sort.
- We have to visit every task to execute it, the complexity is `O(n)`, when `n` is the number of tasks.
    
**Generate Anagram**

- The number of anagrams for a word with unique letters is `n!` which means the complexity of this algorithm is also `O(n!)`.
- This cannot be further optimized.

**Find a Path**

- The direct complexity impacted by the connectivity of the maze.

**Place 8 queens**

- The complexity of this algorithm is `O(n!)`, we're trying every possible position for the queen.