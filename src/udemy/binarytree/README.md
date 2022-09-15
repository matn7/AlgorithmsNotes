# The Tree

- A tree is a data structure which is made up of nodes. Each node can point to a **number of nodes**, noy just **one**.
- Unlike stacks, queues, linked lists etc. the order of the elements in not important in a tree.
- It's a non-linear data structure.
- A tree is typically used to represent **hierarchical** information.

*The binary tree**

- A general tree data structure can have any nu,ber of children but these trees are less useful and not vert commonly
used as a data structure.
- In a **binary tree** each node can have **0**, **1**, or **2** children.

```
            A           ROOT - A node with no parents, every tree has exactly one root
           / \          EDGE - A link from a parent node to a child node
          B   C
             / \
            D   E       SIBLINGS - Nodes at the same **level** in the tree
           / \   \
          F   H   G     LEAF - A node with no children
```

- **C** is an ancestor of **F**.
- **F** is a descendant of **C**.
- The ROOT node **A** is an ancestor of every node.
- Every node is a descendant of the ROOT node.

**The binary tree - traversal**

- There are a whole number of ways to visit the nodes of a tree.
- They vary based on the **order** in which the nodes are **accessed**.
- Visiting nodes of a tree is called **traversing** a tree.
- **Breadth-first**
- **Depth-first**

**Breadth-first traversal**

- Breadth first traversal involves visiting nodes at **every level** before moving to the next level.
- Start with the root node - it's at level 0 and is the **FIRST NODE TO VISIT**.
- The next step is to check whether there are other nodes at the **SAME LEVEL AND VISIT THEM**.
- Once a level is exhausted then we move to the next level.
- We continue this till **every node** of the tree has been visited.

**Implementing breadth-first traversal**

- Start from the root and add it to a **QUEUE**.
- **DEQUEUE** and **PROCESS** the node.
- Add it's **LEFT** and then **RIGHT** child to the queue.
- Continue this as long as the queue is not empty.
- The nodes get added level-wise from left to right to the queue.
- And are dequeued and processed in that order.

**Depth-first traversal**

- Depth-first traversal involves going **right to the leaf** of the binary tree first before moving up the tree.
- Going **deep** before moving up.
- Here are a whole variety of possibilities in how the nodes are processed.
- Depth-first traversal can be:
    - **PRE-ORDER**
    - **IN-ORDER**
    - **POST-ORDER**
- All depth first traversal are most efficiently and intuitively implemented using **recursion**.    
- At every point we work with a subtree rooted at some node.
- **The base case is when the root is null**.
- The recursive step is on **2 SUBTREES** - the left and the right.
- The processing can be performed, the recursive case:
    - Before - **PRE-ORDER**
    - In-between - **IN-ORDER**
    - After - **POST-ORDER**
    
**Pre-order traversal**

- Each node is processed **FIRST (PRE)** before it's right and left subtrees.    
- The left sub-trees are processed **BEFORE** the right subtrees.

**Count the number of unique binary trees**

**Has path sum**

**Print all paths**

**Find the least common ancestor**













