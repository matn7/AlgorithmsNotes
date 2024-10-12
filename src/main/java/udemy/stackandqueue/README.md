# The Stack

- A stack is a data structure to hold elements such that the **last element** you add to the stack is the 
**first one** you access.
- **LIFO** - Last in first out.
- Major operations that you perform on the stack are always focused on one end of the stack, called **TOP**.

**Stack ADT**

- Adding new element to the top of the stack is called **PUSH**.
    - PUSH an element to the top of a stack.
- Removing an element from the top of a stack is called **POP**.
    - POP an element from the top of a stack.
- See what the element is without remove **PEEK**.
    - PEEK at the top element of a stack.
    - PEEK let's you access the top element in the stack without actually changing the data structure.

**Common operations on the stack**

- PUSH
- POP
- PEEK

**Other operations**

- IsEMPTY
- IsFULL
- SIZE

**Try to POP from an empty stack**

- StackUnderflowException

**Try to PUSH into a full stack**

- StackOverflowException

**The stack - underlying data structure**

- The most common operations on a stack involve pushing and popping elements from the top.
- The operations are confined to one end of the stack.
- A linked list lends itself perfectly to build a stack.

**The stack - performance and complexity**

| Operation | Complexity time |
|---|---|
| push | `O(1)` |
| pop | `O(1)` |
| isEmpty | `O(1)` |
| isFull | `O(1)` |
| size | `O(1)` |

- Space complexity of Stack `O(n)`.

**Where can stacks be used?**

- Implementing undo in an application.
- Implementing the back button on the web browser.
- Holding the memory for recursive calls in a programming language.
- Translating infix notation for expressions to postfix.

***

# The Queue

- A queue is a data structure where you add elements to the **end of the queue** and remove elements from the
**beginning of the queue**.
- **FIFO** - First in first out. 
- The operations on a queue are performed at two ends, **removal** is at the **beginning** and **addition** is at the 
**end** of the queue.
- **LILO** - Last in last out.

**Queue ADT**

- Adding a new element to the end of the queue is called **ENQUEUE**.
    - Enqueue an element to the queue.
- Removing an element from the beginning of a queue is called **DEQUEUE**.
    - Dequeue an element from the queue.
- Similar to a stack you might just want to see what the first element in a queue is without removing it **PEEK**.
    - Peek at the first element in a queue.
- Adds to a queue if space is available **OFFER**.

**Common operations on the queue**

- ENQUEUE
- DEQUEUE
- PEEK

**Other operations**

- IsEMPTY
- IsFULL
- OFFER

**Try to DEQUEUE from an empty queue**

- QueueUnderflowException

**Try to ENQUEUE into a full queue**

- QueueOverflowException

**The stack - underlying data structure**

- The most common operations on a queue involve enqueuing and dequeuing elements.
- The operations are on both ends of the queue.
- A Linked List with a pointer to head and the tail works well.
- A common data structure used is a **circular queue** with pointers to the head and the tail.
- Implemented using an array where the last element wraps around to the first element.

**Circular Queue**

- `HEAD = -1` - A special empty value to denote an empty list.
- `TAIL` - Point to last element in a queue.

**The queue - performance and complexity**

| Operation | Complexity time |
|---|---|
| enqueue | `O(1)` |
| dequeue | `O(1)` |
| isEmpty | `O(1)` |
| isFull | `O(1)` |

- Space complexity of Stack `O(n)`.

**Where can a queue be used?**

- Customer service hotline, calls are assigned to representatives in the order that they are received.
- Queueing jobs to be printed.
- Any order processing systems like in e-commerce websites or bank transaction systems.

**Queue using 2 stacks - performance and complexity**

- All enqueue and then all dequeues are `O(1)` - if only one of these operations are performed.
- Each element is pushed no more than twice.
    - Once onto the forward stack to enqueue it and once onto the reverse stack just before dequeueing.
- Each element is popped no more than twice.
    - Once to move to the reverse from the forward stack just before dequeuing and then to actually dequeue it.
- The complexity is `O(m)` where `m` is the number of operations we perform on the queue.





