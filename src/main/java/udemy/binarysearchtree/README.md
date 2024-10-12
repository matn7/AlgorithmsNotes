# The Binary Search Tree

- This is also called an **ordered binary tree**, and it's a tree with some specific characteristics.
- For every node in the tree:
    - Each node in the **left** sub-tree of that node has a **value less than or equal to the value of the node**.
    - Each node in the **right** sub-tree of that node has a **value greater than the value of the node**.
- Binary search trees are typically used for **fast insertion** and **fast lookup**.
- In a tree when a new node is added there is exactly one place that it can be.
- The structure of a tree depends on the order in which the nodes are added.
- While searching for a node in the tree there is only one place where that node can be found.
- We can simply follow the right or left sub-trees based on the value we want to find.

**Insertion in a BST**

- The complexity for node insertion is `O(log(n))` in the average case.
- The actual complexity depends on the shape of the tree - skewed trees (i.e. with all left or right children only) can
have complexity of `O(n)`.

**Lookup in a BST**

- The complexity for value lookup is `O(log(n))` in the average case.
- For both insertion and lookup we halve the tree we have to traverse ar every step. This gives us the `O(log(n))` complexity.

**Minimum Value in a BST**

**Maximum depth**

**Mirror BST**

**Print node within range in a BST**

**Is BST**

## Red-black tree

