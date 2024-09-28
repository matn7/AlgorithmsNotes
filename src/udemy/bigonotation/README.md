# Complexity and the Big-O notation

**How performant is your code?**

- Performance is measured along resource consumption and code consumes a variety of resources.
- Improving code performance beyond a certain point involves tradeoffs.
- Consuming more of one resource can help consume less of another.

**Measures of performance**

- Time: The amount of processing or number of operations code has to perform to accomplish it's objective.
- Space: This is both memory needed by code to store information at run-time as well as disk space needed by code for
persistent storage.
- Network: The bandwidth code uses to pass information to clients or problems.other machines.

**Measures of performance - continue**

- Performance indicates how much of these resources the code uses
- Efficient code uses fewer resources along all these axes.
- Code can also be more performant when it uses the resources we have in plenty rather than we lack.

**What is complexity?**

- Complexity is a measure of how resource requirements change as the size of the problem gets larger.
- Complexity affects performance.
- The higher the complexity of a problem the lower the performance.
- The exact relationship depends on the algorithm.
- The time required by code to run depends on the basic operations it performs.

**Operations - building blocks**

- Arithmetic operations
- Read
- Assignment
- Write
- Test

**Get a clear understanding of complexity**

- Do not worry about the exact number of operations.
- How that number changes based on the input size.
- This is how performance changes based on input size.
- We also focus on the worst case performance.
- What is the maximum number of basic operations that might have to be performed based on the input?

**A Quick summary**

- Code uses time, space and network resources.
- The amount of resource used determines code's performance.
- Complexity is a measure of performance.
- Complexity ignores actual operations in code and focuses on how that change based on input size.

## Big-O notation

- This expresses the complexity of an algorithm.
- An algorithm whose complexity does not change with the input size is `O(1)`.
    - The algorithm is said to have **constant time complexity**.
    - It takes the same amount of time even if input size is doubled, tripled or increased to any level.

**If "N" is the size of the input...**

- The complexity of an algorithm is `O(N)` if the time taken by the algorithm increases **linearly** when `N` increases.
- The complexity of an algorithm is `O(N^2)` if the time taken by the algorithm increases **quadratically** when `N` increases.

**What is the complexity of common operations?**

- The complexity of an algorithm is `O(N)` if the time taken by the algorithm increases linearly when `N` increases.
- The complexity of an algorithm is `O(N^2)` if the time taken by the algorithm increases quadratically when `N` increases.
- Lower order terms and constants **do not matter** while expressing complexity, the assumption is that `N` is very large.
- **O(N^2 + 1000)** is equivalent to **O(N^2)**.
- **O(N^2 + N)** is equivalent to **O(N^2)**.

**Which algorithms are faster?**

**Time taken:**
- `O(1)` < `O(N)` < `O(N^2)` < `O(N^3)` 

**What are the complexities of the following pieces of code?**

- Note that we don't care about the actual number of operations, complexity is based on the size of the input.
- This is a constant time operation, `O(1)`. The code takes the same time whatever the value of `N`, it uses the value
of `N`, rather than use it as a size of input.

```java
// O(1) time
public static void simpleFunction(int n) {
    int a = 9;
    int b = 3;
    
    int sum = a + b + n;
    int product = a * b * n;
    int quotient = a * n / b;
    System.out.println(sum + " : " + product + " : " + quotient);
}
```

***

- The number of operations obviously changes with the size of the input.
- The complexity of this code is `O(N)`, the operations change linearly with the size of input.
- If the value of "n" doubles, this code will take roughly twice as long.

```java
// O(n) time
public static void singleForLoop(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(Math.pow(i, 2.0));
    }
}
```

***

- The complexity of thgis operation is `O(N)`, the operations change linearly with the size of input.
- If the value of "n" doubles, this code will take roughly twice as long.

```java
// O(n) time
public static void singleWhileLoop(int n) {
    int i = 0;
    while (i < n) {
        System.out.println(Math.pow(i, 2.0));
        i++;
    }
}
```

***

- The complexity is based on the worst case scenario.
- The complexity of this operation is `O(N)`, the worst case is that the input is odd, and we enter the for-loop.
- If the value of "n" doubles, this code will take roughly twice as long.

```java
// O(n) time
public static void ifStatement(int n) {
    if (n % 2 == 0) {
        System.out.println("Input is even");
    } else {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }
}
```

***

- The complexity of this operation is `O(N^2)`, as `n` changes the number of operations change quadratically.
- For  ever iteration of the outer loop the inner loop iterates `n` times, so the statement is call `n * n` times = `n^2`.

```java
// O(n^2) time
public static void nestedForLoop(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i * j);
        }
    }
}
```

***

- To express complexity we assume `n` is very large.
- The complexity of this operation is `O(n)`, for very large `n` the constant 100 associated with the second for loop
can be ignored.
- `O(n + 100) ~= O(n)` 

```java
public static void twoForLoop(int n) {
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
    for (int i = 0; i < 100; i++) {
        System.out.println(i);
    }   
}
```

***

- There are 2 loops here, one length `n` and the problems.other of length `m`, where both `n` and `m` can be very large.
- The complexity of this operation is `O(n + m)`.
- Each complexity is independent and takes a different input, so the complexity is additive.

```java
public static void twoForLoopsNM(int n, int m) {
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
    for (int i = 0; i < m; i++) {   
        System.out.println(i);
    }
}
```

***

- Nested loops once again but working on different inputs each of which can be large.
- The complexity of this operation is `O(n * m)`.
- For each iteration of the loop going to `n`, the second loop iterates `m` times. Number of operations = `n * m`.

```java
public static void twoForLoopsNAndM(int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            System.out.println(i * j);
        }
    }
}
```

***

- There is a nested as well as a single for loop here, remember we only care about the highest order term.
- The complexity of this operation is `O(n^2)`.
- Since there are 2 loops the complexity is actually `O(n^2 + n)`, lower order terms are ignored.

```java
public static void twoForLoopsNestedAndNonNested(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i * j);
        }
    }
    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }
}
```

***

- How often the inner loop will be called.
- For every `n` the inner loops executes `n/2` times.
- The complexity of this code is `n * (n/2) = O(n^2)`.

```java
public static void twoForLoops(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = n; j > n / 2; j--) {
            System.out.println(i + " : " + j);
        }
    }
}
```

***

- We break out of the loop much faster than incrementing by a constant such as 1, 2, etc.
- What is the value of `i` at the start of each iteration?
- First iteration starts with the value of `i = 1 = 2^0`.
- Second iteration `i = 1 * 2 = 2 = 2^1`.
- Third iteration `i = 2 * 2 = 4 = 2^2`.
- Fourth iteration `i = 4 * 2 = 8 = 2^3`.
- `...`
- `(k + 1) th` iteration `i = 2^(k-1) * 2 = 2^k`.

| `#` | `i` |
|---|---|
| 0 | 1 |
| 1 | 2 |
| 2 | 4 |
| 3 | 8 |

- There is some number `k` for which `2^k = n`.
- This `k` is the value at which we brake out of the loop.
- The loop runs `k` times. 
 
```java
public static void doublingLoopVariable(int n) {
    for (int i = 1; i < n;) {
        System.out.println(i);
        i = i * 2;
    }
}
```

- Let's derive this, the value of `i` doubles at every iteration.

```
2^k = n
log2(2^k) = log2(n)
klog2(2) = log2(n)
k = log2(n)
```

- Remember the loop runs `k` times.
- The loop runs `log(n)` times.
- The complexity of this code is `O(k)` which is equivalent to `O(log(n))`.

***

- Once again the loop decrement is not a simple decrement, we divide in half the loop variable at every iteration.
- If `n` is the length of the input, and the input space is halved in some way for every iteration.
- The complexity of this code is `O(k)` which is equivalent to `O(log(n))`.

```java
public static void halvingLoopVariable(int n) {
    for (int i = n; i > 0;) {
        System.out.println(i);
        i = i / 2;
    } 
}
```

## Sorting

**:star: Tradeoffs in sorting**

- What is the complexity of the algorithm used?
    - How does it scale as the input size increases?
- How much space does it occupy?
    - Does it need extra space to hold information during sorting?
- Is sort stable?
    - Do equal elements maintain their original order after sorting?
- How many comparisons and how many element swaps needed?
    - Do the algorithms work better with nearly sorted lists?
- Is the sort adaptive?
    - Does it break early when the list is sorted?

### Selection Sort

- At each iteration 1 element is selected and compared with every problems.other element in the list to find the smallest one.
- First we find the smallest element, get it into the first position, next we find the second smallest till the entire
list is sorted.

| 4 | 5 | 6 | 2 | 1 | 7 | 10 | 3 | 8 | 9 |
|---|---|---|---|---|---|---|---|---|---|
| `1` | 5 | 6 | 4 | 2 | 7 | 10 | 3 | 8 | 9 |
| `1` | `2` | 6 | 5 | 4 | 7 | 10 | 3 | 8 | 9 |
| `1` | `2` | `3` | 5 | 6 | 7 | 10 | 4 | 8 | 9 |
| `1` | `2` | `3` | `4` | 6 | 7 | 10 | 5 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | 7 | 10 | 6 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | 10 | 7 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | 10 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | 10 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9` | 10 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9` | `10` |

- Selection sort selects one element at a time, compares it to all problems.other elements in the list.
- The correct position for that selected element is found before moving on to the next element.

**Selection sort characteristics**

- For each element the entire list is checked to find the smallest element.
- So in the worst case `n` elements are checked for every selected element.
- The complexity of selection sort is `O(n^2)`.
- **Not a stable sort** - entities which are equal might be re-arranged.
- It takes `O(1)` extra space, it sorts in place.
- It makes `O(n^2)` comparisons and `O(n)` swaps.
- **Not an adaptive** - no way to break up sorting early.

### Bubble sort

- For each iteration, every element is compared with its neighbor and swapped if they are not in order.
- This results in smaller elements bubbling to the beginning of the list.
- At the end of the first iteration, the smallest element is in the right position, at the end of second iteration
the second smallest is in the right position and so on.
- The interesting thing here is that not only after 1, 2, 3 in the right position - the entire list is sorted.
    - In the next iteration we perform **no swaps**. This is an indication then the list is completely sorted.
    - We can break out of the loop early.
    
| 4 | 5 | 6 | 2 | 1 | 7 | 10 | 3 | 8 | 9 |
|---|---|---|---|---|---|---|---|---|---|
| `1` | 4 | 5 | 6 | 2 | 3 | 7 | 10 | 8 | 9 |
| `1` | `2` | 4 | 5 | 6 | 3 | 7 | 8 | 10 | 9 |
| `1` | `2` | `3` | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9` | `10` |

**Bubble sort characteristics**

- The smallest element bubbles to the correct position by comparing adjacent elements.
- In the worst case (if the list is originally sorted in descending order) `n` elements are checked and swapped for
every selected element to get to the right position.
- Checking `n` elements for each `n` selected elements.
- The complexity of bubble sort is `O(n^2)`.
- **A stable sort** - original ordering of equals elements maintained.
- It takes `O(1)` extra space, it sorts in place.
- It makes `O(n^2)` comparisons and `O(n^2)` swaps.
- **An adaptive** - break up early, when no swaps.

### Insertion sort

- Start with a sorted sub-list of size 1.
- Insert the next element into the sorted sub-list at the right position. Now the sorted sub-list has 2 elements.
- This continues till the entire list is sorted.
- By inserting into a sorted sub list at every step the sub-list soon grows to be the entire list.

| 4 | 5 | 6 | 2 | 1 | 7 | 10 | 3 | 8 | 9 |
|---|---|---|---|---|---|---|---|---|---|
| `4` | 5 | 6 | 2 | 1 | 7 | 10 | 3 | 8 | 9 |
| `4` | `5` | 6 | 2 | 1 | 7 | 10 | 3 | 8 | 9 |
| `4` | `5` | `6` | 2 | 1 | 7 | 10 | 3 | 8 | 9 |
| `2` | `4` | `5` | `6` | 1 | 7 | 10 | 3 | 8 | 9 |
| `1` | `2` | `4` | `5` | `6` | 7 | 10 | 3 | 8 | 9 |
| `1` | `2` | `4` | `5` | `6` | `7` | 10 | 3 | 8 | 9 |
| `1` | `2` | `4` | `5` | `6` | `7` | `10` | 3 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `10` | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `10` | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9` | `10` |

**Insertion sort characteristics**

- This sort first assumes a sorted list of size 1 and inserts additional elements in the right position.
- In the worst case (if the list is originally sorted in descending order) `n` elements are checked and swapped
for every selected element to get to the right position.
- **It has very low overhead and is traditionally the sort of choice when used with faster algorithms which follow the
divide and conquer approach.**
- Checking `n` elements for each of `n` selected elements.
- The complexity of insertion sort is `O(n^2)`.
- **A stable sort:**
    - As entities bubble to the correct position in the sublist that is sorted. The list the original order of entities
    are maintained for equal elements.
- It takes `O(1)` extra space, it sorts in place.
- It makes `O(n^2)` comparisons and `O(n^2)` swaps.
- **An adaptive:**
    - Break up early, when no swaps.
    - In that nearly sorted lists complete very quickly.
    
**Insertion sort vs bubble sort**

- Bubble sort requires an additional pass over all elements to ensure that the list is fully sorted.
- Bubble sort has to do `n` comparisons at every step. Insertion sort can stop comparison elements when the right position
in the sorted list is found.    
- Bubble sort performs poorly with modern hardware because of the number of writes and swaps that it performs. Results in
cache misses so has greater overhead than insertion sort.

### Shell sort

- Shell sort partitions the original list into sub-lists where a sub-list is made of elements separated by an "increment".
- Each sub-list is then sorted using insertion sort.
- The increment is slowly reduced till it's 1.
- At this point it's basically insertion sort of a nearly sorted list.
- Suppose the increment = 3 then the sublists would look something like this.
- The cool thing is that since the list was almost sorted it's far easier to get to a fully sorted state with increment set to 1.

| 4 | 5 | 6 | 2 | 1 | 7 | 10 | 3 | 8 | 9 | Increment |
|---|---|---|---|---|---|---|---|---|---|---|
| 2 | 5 | 6 | 4 | 1 | 7 | 9 | 3 | 8 | 10 | **3** |
| 2 | 1 | 6 | 4 | 3 | 7 | 9 | 5 | 8 | 10 | **3** |
| 2 | 1 | 6 | 4 | 3 | 7 | 9 | 5 | 8 | 10 | **3** |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9` | `10` | **1 vanilla insertion sort** |

**Shell sort characteristics**

- Shell sort uses insertion sort, the entire list is divided, and those sub-lists are sorted.
- Getting the exact complexity of shell sort is problems.hard because it depends on the increment values chosen.
- Also it's not clear what the best increment value is.
- The complexity of shell sort is better than insertion sort as the final iteration with increment = `1` has to work with
a nearly sorted list.
- The complexity of shell sort is somewhere between `O(n)` and `O(n^2)`.
    - Different values of increments produce different complexities.
    - For increments `2^k - 1` for `k = 1, 2, 3 ...`, the complexity is `O(n^(3/2))`.
- **A stable sort**.    
- It takes `O(1)` extra space, it sorts in place.
- It makes `O(n^2)` comparisons and `O(n^2)` swaps.
- The algorithm is **adaptive** since its based on insertion sort which is adaptive.

### Merge sort

- This follows the divide and conquer approach to create smaller sub-problems.
    - A list is broken down into smaller and smaller parts recursively.
- At some point there will be a list of length one.
    - We can consider that a sorted list.
- Then merge the sorted lists together to get the fully sorted list.

**Divide and conquer - the weapon? recursion**

- This is a classic recursion based algorithm, divide till the problem is so small as to be trivial.
- Solve for the trivial case and then build up the complete solution as recursion unwinds.
- Merge the lists keeping the sorted order.

**Merge sort characteristics**

- Merge sort uses divide and conquer to create smaller problems which are easier to tackle.
- To calculate the complexity we need to consider the recursive step where the problem is divided into 2, and the merge
of two lists of `n/2` length.
- The complexity of merge sort is `O(nlog(n))`.
- It takes `O(n)` extra space when we use arrays (all the smaller lists we create in the divide phase).
- **A stable sort**.
- It takes `O(n)` extra space.
- It makes `O(???)` comparisons and `O(???)` swaps.
- **Not an adaptive** - no way to break up sorting early.

### Quick sort

- This is a divide and conquer algorithm which partitions the list at every step.
- The partition is not based on the length, or an artificial index, it's based on a pivot.
- The pivot is an element from the list.
- The list is partitioned with all elements smaller than the pivot on one side and larger than the pivot on the problems.other.
- This pivot partition is applied to all sub-lists till the list is sorted.
- In the very first iteration the sublist which we partition is the entire list.
- First we choose a pivot to partition the list.
- There is no exact science behind the pivot, usually the first or the last elements of the sub-list are chosen.

| **6** | 5 | 4 | 2 | 1 | 10 | 3 | 7 | 8 | 9 |
|---|---|---|---|---|---|---|---|---|---|
| **3** | 5 | 4 | 2 | 1 | `6` | 10 | 7 | 8 | 9 |
| **1** | 2 | `3` | 4 | 5 | `6` | 10 | 7 | 8 | 9 |
| `1` | `2` | `3` | **4** | 5 | `6` | 10 | 7 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | **10** | 7 | 8 | 9 |
| `1` | `2` | `3` | `4` | `5` | `6` | **9** | 7 | 8 | `10` |
| `1` | `2` | `3` | `4` | `5` | `6` | **8** | 7 | `9` | `10` |
| `1` | `2` | `3` | `4` | `5` | `6` | `7` | `8` | `9` | `10` |

**Quick sort characteristics**

- Quick sort uses divide and conquer to create smaller problems which are easier to tackle.
- Just as in the case of problems.other divide and conquer algorithms the complexity has to be derived.
- The avarage case complexity of quick sort is `O(nlog(n))`.
- It takes `O(n)` extra space when we use arrays (all the smaller lists we create in the divide phase).
- **Not a stable sort** - does not resolve the relative order of equal elements.
- It takes `O(log(n))` extra space.
- It makes `O(???)` comparisons and `O(???)` swaps.
- **Not an adaptive** - no way to break up sorting early.

***

| Sorting Algorithm | Complexity | Stable | Space | Comparisons | Swaps | Adaptive |
|---|---|---|---|---|---|---|
| Selection Sort | `O(n^2)` | `No` | `O(1)` | `O(n^2)` | `O(n)` | `No` |
| Bubble Sort | `O(n^2)` | `Yes` | `O(1)` | `O(n^2)` | `O(n^2)` | `Yes` |
| Insertion Sort | `O(n^2)` | `Yes` | `O(1)` | `O(n^2)` | `O(n^2)` | `Yes` |
| Shell Sort | Between `O(n)` and `O(n^2)` | `Yes` | `O(1)` | `O(n^2)` | `O(n^2)` | `Yes` |
| Merge Sort | `O(nlog(n))` | `Yes` | `O(n)` | `O(???)` | `O(???)` | `No` |
| Quick Sort | `O(nlog(n))` | `No` | `O(log(n))` the worst case `O(n)` | `O(???)` | `O(???)` | `No` |
| Heap Sort | `O(nlog(n))` | `No` | `O(1)` | `O(???)` | `O(???)` | `No` |
