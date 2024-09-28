# The Priority Queue

- When a certain element is a collection has the **highest weightage or priority** - a common use case is to process
that **first**.
- The data structure you use to store elements where the highest priority has to be processed first can be called
a **priority queue**.
- The data structure needs to **understand the priorities** of the elements it holds.

**Common operations on a priority queue**

- **Insert elements** along with priority information.
- **Access** the highest priority element.
- **Remove** the highest priority element.
- Priority queues have a whole number of practical use cases in event simulation, thread scheduling - real world
problem like handling emergency room cases etc.

**How implement a priority queue?**

- Common operations are **insert**, **access the highest priority element** and **remove the highest priority** element.

**An array or a list**

- **Insertion**:
    - **Unordered** can be anywhere in the list or array - complexity `O(1)`.
    - **Ordered** requires finding the right position for the element based on priority - complexity `O(n)`.
- **Access**:
    - **Unordered** accessing the highest priority element requires going through all elements in the list - complexity `O(n)`.
    - **Ordered** accessing the highest priority element is then problems.easy - `O(1)`.
- **Remove**:
    - **Unordered** removing the highest priority element requires going through all elements in the list - complexity `O(n)`.
    - **Ordered** removing the highest priority element is straightforward - complexity `O(1)`.

**Balanced binary search tree**

- **Insertion**: For a balanced BST the worst case is - complexity `O(log(n))`.
- **Access**: Accessing the highest priority element is again `O(log(n))`.
- **Remove**: Removing the thigest priority element is `O(log(n))`.

**The binary heap**

- **Insertion**: Inserting a new element - complexity `O(log(n))`.
- **Access**: Accessing the highest priority element is fast - `O(1)`.
- **Remove**: Removing the highest priority element is `O(log(n))`.

| Operation | Unordered array | Ordered array | Balanced BST | Binary heap |
|---|---|---|---|---|
| Insertion | `O(1)` | `O(n)` | `O(log(n))` | `O(log(n))` |
| Access | `O(n)` | `O(1)` | `O(log(n))` | `O(1)` |
| Remove | `O(n)` | `O(1)` | `O(log(n))` | `O(log(n))` |

- This solution trades of by making **both insertion and access moderately fast** - list solution make one of these
super fast while comparing heavily on the problems.other.

**The binary heap**

- A heap is just a tree with a special properties or constraints on the values of its nodes.
- This is called a **heap property**.
- Heaps can be of two types (**Heap Property**):
    - **Minimum heap**: 
        - Every node value should be `<=` of it's children.
        - The node with the smallest value should be the root of the tree.
    - **Maximum heap**: 
        - Every node value should be `>=` value of it's children.
        - The node with the largest value should be the root of the tree.
- If **H** is the height of the tree - the leaf nodes should be only at level **H** or **H - 1**.
- The heap should form a complete binary tree - all levels except the last should be filled.

**Minimum heap, shape property**

- All leaf nodes are at height **H** or **H - 1**.
- All nodes at level **H - 1** have to be filled before moving on to level **H**.
- These nodes cannot have children till **all the nodes at level H - 1 have both left and right children**.

**The binary heap implementation**

- The logical structure of a binary heap is a **tree** - so theoretically we could represent a heap just as we would a tree.
- Each node would have a pointer to the left and right child.
- The operations typically performed on a heap requires us to:
    - Traverse downwards from the root towards the leaf nodes.
    - Traverse upwards from the leaf nodes towards the root.
- On a heap we want to be able to:
    - Get left child.
    - Get right child.
    - Get parent.
- A node would need 2 child pointers and a parent pointer.
- This is a lot of extra space.
- Heaps can be represented much more efficiently by using an array and having an implicit relationship to determine
the parent, left and right child of a node.
- Every level of the binary tree in a heap is filled except perhaps the last.
- This means contiguous slots in an array can be used to represent binary tree levels.

**Get parent**

- Node at index `i`:
    - **Get left child**: Has a left child at an index: `2i + 1`
    - **Get right child**: Has a right child at an index: `2i + 2`
    - **Get parent**: Has a parent at index: `(i - 1) / 2`

**Heapify**

- While inserting or removing an element into the heap how do we know which is the right position for the element to occupy?
- We place a single element in the **wrong position**.
- Then we try to find the **right position** for the element. 
- This process is called **HEAPIFY**.

**Sift down**

- An element is in the wrong position with respect to problems.other elements **below** it in the heap.
- It has to be moved **downwards** in the heap towards the leaf nodes to find it's right position.

**Sift up**

- An element is in the wrong position with respect to problems.other elements **above** it in the heap.
- It has to be moved **upwards** in the heap towards the root node to find it's right position.

**Insert**

- Insert an element as a **leaf node** in the heap.
- In an array implementation that would be at the very end - the newely inserted element would be the last element in
the array.
- The element might be in the wrong position with respect to all nodes above it.
- It has to be moved **upwards** in the heap towards the root node to find it's right position **SIFT UP**.

**Remove**

- Remove the highest priority element in the heap i.e. the minimum element.
- In an array implementation that would be the element at index 0.
- Copy over the last element in the array to index 0.
- The element might be in the wrong position with respect to all nodes below it.
- It has to be moved **downwards** in the heap towards the leaf nodes to find it's right position.

**Complexity of the binary heap**

- **Insertion**: Inserting a new element - complexity `O(log(n))`.
- **Access**: Accessing the highest priority element is fast - `O(1)`.
- **Remove**: Removing the highest priority element is `O(log(n))`.

**Heap sort**

- First converts the unsorted list or array into a heap - this can be done in place.
- Use the heap to access the maximum element and put it in the right position in the array.
- Take a portion of the array - make all elements in that portion satisfy the heap property.
- Keep adding additional elements into the heap portion ensuring that these additional elements also satisfy 
the heap property.
- The heap will grow to encompass all elements in the array.
- A heap offers `O(1)` access to the largest or the smallest element.
- Remove the largest element from the heap and position it at the end of the sorted array.
- The sorted array will grow to encompass all elements in the array.

**Heapify**

- Use a **maximum heap**, so we can always access the largest element in `O(1)` time.
- A heap can be represented using an array.
- Heapify is the operation to convert the unsorted array to a heap.
- We use the same array with no additional space to do the heapify.

**Heap Sort Complexity**

- Heap sort uses operations on a heap to get a sorted list.
- Insertion into a heap is done `n` times to get all the elements in heap form.
- Removal of the maximum element is done `n` times, followed by heapify.
- Insertion and removal have `log(n)` time complexity so doing it for `n` elements means: 
- The avarage case complexity of heap sort is `O(nlog(n))`.
- It takes `O(n)` extra space when we use arrays (all the smaller lists we create in the divide phase).
- **Not a stable sort** - does not resolve the relative order of equal elements.
- It takes `O(1)` extra space.
- It makes `O(???)` comparisons and `O(???)` swaps.
- **Not an adaptive** - no way to break up sorting early.    

### Heaps Problems

**Find the maximum element in a min heap**

**K largest element in a stream**

**Merge K sorted arrays**

**Find the median in a stream of elements**


