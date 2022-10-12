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





