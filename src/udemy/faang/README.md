## Recursion

**Tail recursion**

- Normal recursion space: `O(N)`.
- Tail recursion space: `O(1)`.

**Factorial**

`4!`    ->  `4 * 3 * 2 * 1`

**Normal recursion space: `O(N)`**

```java
public int recFactorial(int x) {
    if (x <= 1) {
        return 1;
    } else {
        return x * recFactorial(x - 1);
    }
}
```

```
recFactorial(4);
4 * recFactorial(3);
4 * (3 * recFactorial(2));
4 * (3 * (3 * recFactorial(1)));
4 * (3 * (2 * 1));

----> 24 
```

**Tail recursion space: `O(1)`**

```java
public static int tailFactorial(int x, int totalSoFar) {
    if (x == 0) {
        return totalSoFar;
    } else {
        return tailFactorial(x - 1, totalSoFar * x);
    }
}
```

```
tailFactorial(4, 1);
tailFactorial(3, 4);
tailFactorial(2, 12);
tailFactorial(1, 24);
tailFactorial(0, 24);

----> 24 
```

## Divide & Conquer

- Multi-branched recursion.
- Breaks a problem into multiple smaller but same sub-problems.
- Combines the solutions of sub-problems into the solution for the original problem.

## Hoare's QuickSelect algorithm

- Find kth smallest element in an unordered list.

## Binary Trees

**Full Tree**

- Each node has 2 or no children.

**Complete Tree**

- Every level in the tree is completely fill.
- Only level does not have to be full is last level.

## Heaps

**Max Heap**

- Root node Greatest Value.

```
[50, 40, 25, 20, 35, 10, 15]
```

**Min Heap**

- Root node Smallest Value.

```
[10, 15, 25, 20, 35, 30, 50]
```

**Properties**

- parent: `floor((idx - 1) / 2)`
- left: `(idx * 2) + 1`
- right: `(idx * 2) + 2`

## 2-D arrays, matrices

**Depth first search**

- Go Up
- Go Right
- Go Down
- Go left

```
    1   2   3   4   5
    6   7   8   9   10
    11  12  13  14  15
    16  17  18  19  20

[1, 2, 3, 4, 5, 10, 15, 20, 19, 14, 9, 8, 13, 18, 17, 12, 7, 6, 11, 16]
```

## Graphs

- Vertex
- Edge
- Cycle in Graph
- Undirected Graph
- Directed Graph
- Unweighted
- Weighted

**Representing Graphs**

- Adjacency matrix
- Adjacency list

**Topological Sort**

- Indegree: How many connections going to this vertex.
- Directed Graph
- Directed Acyclic Graph: To be able to perform topological sort.

**Dijkstra's Algorithm**

- Greedy Algorithm
- Directed and weighted graph
- **Greedy Method:**
    - Optimization Problem: Max, Min

## Dynamic Programming

- Recognize it's a dynamic programming problem.
- Keyword **minimum** or **maximum** means this is optimization question.
- Recursion:
    - Base cases
    - Recursive Functions
- Recurrence Relation:
    - Formula for the basis of a recursive solution.    

## Interface Design

## Backtracking

- Return **ALL** solutions.
- Return a **VALID** solution amongst all solutions.

***

## Big O

**What is good code?**

- Readable
- Scalable:
    - Speed
    - Memory

**O(n)**

- Linear time

**O(1)**

- Constant time
- Assignment: `O(1)`

**Rule of Big O**

- Rule 1: Worst Case
- Rule 2: Remove Constants
- Rule 3: Different terms for inputs
- Rule 4: Drop Non Dominates

**O(n^2)**

- Quadratic Time

**O(n!)**

- You are adding a loop for every element.

**Space Complexity**

- Variables
- Data Structures
- Function call
- Allocations

***

## Data structures

**How computer store data**

***

## Trees

- Number of nodes in tree = `2^h - 1`
- log of nodes = height:
    - log means number of decisions we want to make
    - divide & conquer, only search subset of possibilities
- lookup: `O(log n)`
- insert: `O(log n)`
- delete: `O(log n)`

**Binary Search Tree**

**Balanced BST**

- lookup: `O(log n)`
- insert: `O(log n)`
- delete: `O(log n)`

**Unbalanced**

- lookup: `O(n)`
- insert: `O(n)`
- delete: `O(n)`

**BST pros and cons**

- **Pros:**
    - Better than `O(n)`
    - Ordered
    - Flexible Size
    - Sorted / Structured data
- **Cons:**
    - No `O(1)` operations.    

### Binary Heap

- Comparative operations, like people age above 33.
- lookup: `O(n)`
- insert: `O(log n)`
- delete: `O(lof n)`

**Binary Heaps pros and cons**

- **Pros:**
    - Better than `O(n)`
    - Priority
    - Flexible Size
    - Fast Insert
- **Cons:**
    - Slow lookup
    
### Trie

- Prefix tree (auto completion).
- Searching words in a dictionary.
- `O(length of the word)`
- Word ---> rare - `O(4)`

***

## Graph

- Modeling real life:
    - Friendships
    - Network
    - Maps
- Node (Vertex)
- Nodes connected with Edges.

**Types of Graphs**

- Directed: Twitter
- Undirected: Facebook
- Weighted Graph: Google Maps, optimal path
- Unweighted Graph
- Cyclic: Google Maps
- Acyclic
- Directed Acyclic Graph (DAG)

**Edge List**

```java
int[][] graph = {{0, 2}, {2, 3}, {2, 1}, {1, 3}};
```

**Adjacent List**

```java
int[][] graph = {{2}, {2, 3}, {0, 1, 3}, {1, 2}};
```

**Adjacent Matrix**

```java
int[][] graph = {
    {0, 0, 1, 0},   // node-0
    {0, 0, 1, 1},   // node-1
    {1, 1, 0, 1},   // node-2
    {0, 1, 1, 0}    // node-3
}
```

**Graphs pros and cons**

- **Pros:**
    - Relationships
- **Cons:**
    - Scaling is hard
    
**Production solutions**

- neo4j graph databases        

***

## Array

- lookup: `O(1)`
- push: `O(1)`
- insert: `O(n)`
- delete: `O(n)`

**Dynamic vs Static Array**

- Dynamic arrays, ArrayList in Java.
- Dynamic arrays, expand as needed. Add to end can be `O(n)`, when dynamic array have to be resized.

**Arrays pros and cons**

- **Pros:**
    - Fast lookups
    - Fast push/pop
    - Ordered
- **Cons:**
    - Slow inserts
    - Slow deletions
    - Fixed size (if using static array)

***

## Hash Tables

- Objects in JavaScript are type of HashTable.
- Useful in databases, caches.

```
basket.grapes = 1000

key     "grapes"    --> Hash function -->   711 | 10000
```

- A hash function is simply a function that generates a value of fixed length for each input that it gets.
- Hash aspects:
    - One way, from hash you should have no idea what the input was.
    - It is always the same for the same input.
    - Slight changes in input should result in complete new hash.
- Idempotent: Function given an input always outputs the same output.
- Hash Tables in all languages are implemented with an optimum hashing function that's really fast.

**Performance**

- insert: `O(1)`
- lookup: `O(1)`
- delete: `O(1)`
- search: `O(1)`

**Hash Tables VS Arrays**

| | Arrays | Hash Tables |
|---|---|---|
| search | `O(n)` | `O(1)` |
| lookup | `O(1)` | `O(1)` |
| insert | `O(n)` | `O(1)` |
| delete | `O(n)` | `O(1)` |
| push* | `O(1)` | `---` |

**Hash Tables pros and cons**

- **Pros:**
    - Fast lookups (Good collision resolution needed)
    - Fast inserts
    - Flexible Keys
- **Cons:**
    - Unordered
    - Slow key iteration    
  
## Classes

- Reference Type:
    - Non defined by programming language, created by a programmer.
- Context vs scope:
    - Where we are within an object.
    - **this** what is the object environment that we are right now.
- Instantiation:
    - Make copy of an object and reuse the code.

***

## Algorithms

**Recursion**

- Identify the base case.
- Identify the recursive case
- Get closer and closer and return when needed. Usually you have 2 returns.

**Recursive vs Iterative**

- Anything you do with a recursion can be done iteratively (loop).

**Recursion pros and cons**

- **Pros:**
    - DRY
    - Readability
- **Cons:**
    - Large Stack    

**When to use recursion**

- Every time you are using a tree or converting Something into a tree, consider a recursion.
    - Divided into a number of subproblems that are smaller instances of the same problem.
        - Each instance of the subproblem is identical in nature.
        - The solutions of each subproblem can be combined to solve the problem at hand.
- Divide and Conquer using Recursion.        

***

## Sorting

**Bubble Sort**

- Only used for educational purposes.

**Selection Sort**

- Only used for educational purposes.

**Insertion Sort**

- Useful for list that is almost completely sorted.

**Merge Sort**

- `O(n log(n))`
- Divide & Conquer
- Stable, keep original order
- Expensive in regards of space complexity it uses `O(n)`.

**Quick Sort**

- Sorting algorithm to choose.
- One disadvantages is `O(n^2)` time complexity when pivot is always either smallest or greatest element in the list.
- Good space `O(log(n))`.

**Radix Sort - Counting Sort**

- Improve `O(n log(n))` because we do not use comparision
- Non-Comparision Sort.
- Only works in numbers in restricted range.

**Sorting Interview**

- Sort 10 schools around your house by distance: **Insertion sort**
- eBay sorts listings by the current Bid amount: **Radix or Counting**
- Sport scores on ESPN: **Quick sort** 
- A massive database (can't fit all into memory) needs to sort through past year's used data: **Merge sort**
- Almost sorted Udemy review data needs to update and add 2 new reviews: **Insertion sort**
- Temperature Records for the past 50 years in Canada: **Radix or counting / Quick sort**
- Large user name database needs to be sorted. Data is very random: **Merge sort / Quick sort**
- You want to teach sorting for the first time: **Bubble sort / Selection sort**

***

## BFS + DFS (Searching)

**Linear Search**

- `O(n)`

**Binary Search**

- If it's sorted we can do better than `O(n)`.

**Graph + Tree Traversal**

**Breadth First Search/Traversal**

**Depth First Search/Traversal**

**BFS vs DFS**

- **BFS:**
    - **Pros:**
        - Shortest path
        - Closer nodes
    - **Cons:**
        - More memory
- **DFS:**
    - **Pros:**
        - Less memory
        - Does a path exist?
    - **Cons:**
        - Can get slow                

**BFS vs DFS**

- If you know a solution is not far from the root of the tree: **BFS**
- If the tree is very deep and solutions are rare: **BFS** (DFS will take long)
- If the tree is very wide: **DFS** (BFS will need too much memory)
- If solutions are frequent but located deep in the tree: **DFS**
- Determining whether a path exists between two nodes: **DFS**
- Finding shortest path: **BFS**

**Depth First Search/Traversal**

```
            9
    4               20
1       6       15      170
```

- In order: `{1, 4, 6, 9, 15, 20, 170}`
- Pre order: `{9, 4, 1, 6, 20, 15, 170}`
    - Recreate a tree
- Post order: `{1, 6, 4, 15, 170, 20, 9}`

**Graph Traversal**

- **Breadth First Search** - Shortest path.
- **Depth First Search** - Check to see if it exists.

**Dijkstra and Bellman-Ford**

- Shortest path with a weighted graph.

***

## Dynamic Programming

- It is an optimization technique
- Do you have something you can cache?

**Memoization ~~~~~ Caching**

- Dynamic Programming: Divide & Conquer + Memoization
- Can be divided into subproblem
- Recursive Solution
- Are there repetitive subproblems?
- Memoize subproblems












