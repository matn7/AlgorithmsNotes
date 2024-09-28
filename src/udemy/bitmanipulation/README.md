# Bit Manipulation

- Variables of type `char` are represented by a single BYTE `8 bits`.
- Variables of type `int` are usually represented by 4 bytes `32 bits`.
- `char`, `int`, `long`, `short` all consists of the straight binary representation of data.
- Doubles and floats are represented by 8-byte or 4-byte data items, but these have a **special format**, not
just the binary representation of a number.

**char**

- Characters are represented as numbers using a code called ASCII, where each character has a number between 0 and 127.
- Take the character `A`, which has ASCII value decimal `65`.
- Thus, character `A` corresponds to an 8-bit binary representation of `0100 0001`.

**Bit number**

| 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|
| 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |

**Bit value**

- There are problems.easy ways to access and manipulate individual bits.

**flip operator**

- Use the `~` operator to **reverse every bit** in a number, unary operator.

```java
char x = 'A'; // 0100 0001
chat y = ~x; // reverse every bit in x
```

|    | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| X  | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |
|Y=~X| 1 | 0 | 1 | 1 | 1 | 1 | 1 | 0 |

**and operator**

- Use the `&` operator to perform a **bitwise and of every bit** in 2 numbers.

```java
char x = 'A';   // 0100 0001
chat y = 'L';   // 0100 1100
char z = x & y; // bitwise and each operator
```

|     | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| X   | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |
| Y   | 0 | 1 | 0 | 0 | 1 | 1 | 0 | 0 |
|Z=X&Y| 0 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |

**or operator**

- Use the `|` operator perform a **bitwise or of every bit** in 2 numbers.

```java
char x = 'A';   // 0100 0001
chat y = 'L';   // 0100 1100
char z = x | y; // bitwise or each operator
```

|        | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| X      | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |
| Y      | 0 | 1 | 0 | 0 | 1 | 1 | 0 | 0 |
|Z=X or Y| 0 | 1 | 0 | 0 | 1 | 1 | 0 | 1 |

**xor operator**

- Use the `^` operator to perform a **bitwise xor or every bit** of two numbers.

```java
char x = 'A';   // 0100 0001
chat y = 'L';   // 0100 1100
char z = x ^ y; // bitwise xor each operator
```

|      | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| X    | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |
| Y    | 0 | 1 | 0 | 0 | 1 | 1 | 0 | 0 |
|Z=X^Y | 0 | 0 | 0 | 0 | 1 | 1 | 0 | 1 |

**Bit manipulation is incredibly powerful**

- Use the `>>` operator to **shift right** the bits of a number.

```java
char x = 'A';    // 0100 0001
char z = x >> 3; // shift each bit 3 places to the right   
```

|      | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| X    | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |
|Z=X>>3| 0 | 0 | 0 | 0 | 1 | 0 | 0 | 0 |

- Use the `<<` operator **shift left** the bits of a number.

```java
char x = 'A';    // 0100 0001
char z = x << 3; // shift each bit 3 places to the left   
```

|      | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| X    | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 1 |
|Z=X<<3| 0 | 0 | 0 | 0 | 1 | 0 | 0 | 0 |

- The left and right shift operators are **very difficult to use correctly**.
- The **overflow** issue we just saw is one reason.
- The **fill** is also system-dependent, especially for signed numbers.

## Bit manipulation techniques

- The first thing to understand is the bit operators:
    - AND: `&`
    - XOR: `^`
    - OR: `|`
    - NOT: `~`
    - SHIFT RIGHT: `>>`
    - SHIFT LEFT: `<<`

**tricks**

- `B` is an integer variable

| 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|

**b & 0 = 0**

| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `0` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| `0` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

**b | 0 = b**

| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `0` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 

**b ^ 0 = b**

| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `0` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 

**b & all 1s = b**

| `b`      | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `all 1s` | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 
| `b`      | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 

**b | all 1s = all 1s**

| `b`      | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `all 1s` | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 
| `all 1s` | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 

**b ^ all 1s = ~b**

| `b`      | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `all 1s` | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 
| `~b`     | 0 | 1 | 1 | 0 | 1 | 1 | 0 | 0 | 

**b & b = b**

| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 

**b | b = b**

| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 

**b ^ b = 0**

| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `b` | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
| `0` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 

### Get the nth bit

- Return `1` if it is `1` and `0` if it is `0`.
- How do you identify a specific bit in a series of bits?
- Result equals to check_bit.

| `b`         | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `check_bit` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 
| `b & c_b`   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |

- Checking the 4th bit - or the bit at position 4 from the right.
- Result equals to check_bit.

| `b`              | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `check_bit << 4` | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 
| `b & c_b`        | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 0 |

- How do we get a 1 bit to a specific position?
    - Use SHIFT LEFT!
    
| `1`      | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 
|---|---|---|---|---|---|---|---|---|
| `1 << 2` | 0 | 0 | 0 | 0 | 0 | 1 | 0 | 0 |     
| `1 << 4` | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 0 |     

### Set the nth bit to 1

- If a bit at a position is or'ed `|` with bit 1 at the same position then that particular bit's value will become 1.
- This is true whatever the original value of that bit.

| `num`     | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 1 |
|---|---|---|---|---|---|---|---|---|
| `set_bit` | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 0 |
| `result`  | 1 | 0 | 1 | 1 | 0 | 0 | 1 | 1 |

### Print bits in an integer

- Extract the bits one by one from the integer.
- Get whether they are `0` or `1` - print that out to screen.
- Start at the left most position so we print the bits in a logical order.
- How do we set the left most bit of an integer to `1`!
- Shift it left `sizeof(int) * 8 - 1` times.
- `sizeof` will return the size of an integer in **bytes**.
- Multiply by **8** to get the size in **bits**.
- Subtract 1 to account for the right most position being at **index 0**.
- After we get the `1` bit in the **left most** position, it should be **shifted right**.
- If the left most bit is `1`, the **fill bit tends to be 1 when shifted right**.
- This is because right shift **preserves the sign** of the integer - A `1` in the right most position is a negative number.
- Use an **unsigned integer** as a check bit to avoid this issue!

```c
void print_bits(int num) {
    unsigned int check_bit = 1 << (sizeof(int) * 8 - 1); // the right most position in the check bit should be 1
    
    // once the right most 1 is moved out to the left and is shifted out then check_bit will be 0
    while (check_bit != 0) {
        int result = num & check_bit;
        if (result == check_bit) {
            printf("%d ", 1);
        } else {
            printf("%d ", 0);
        }

        // move the 1 to the right
        check_bit = check_bit >> 1;
    }
    printf("\n");
}
```

### Count the number of 1 bits

- Check each bit, increment a count in the bit is `1`.
- It's complexity is **O(number of bits)**.
- There is another, more optimized technique which a complexity of **O(number of 1s)**.
- Consider a number represented in binary form.
- Subtract 1 from this number.

| `num`   | 1 | 0 | 0 | 1 | 0 | 0 | 1 | 0 |
|---|---|---|---|---|---|---|---|---|
| `sub 1` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
| `res`   | 1 | 0 | 0 | 1 | 0 | 0 | 0 | 1 |

- All the bits from the right up to the very first 1 are **toggled**.

| `num`   | 1 | 0 | 0 | 1 | 0 | 0 | 0 | 0 |
|---|---|---|---|---|---|---|---|---|
| `sub 1` | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
| `res`   | 1 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |

- Now if we bitwise and thses two `n & (n - 1)`.

| `n`         | 1 | 0 | 0 | 1 | 0 | 0 | 0 | 0 |
|---|---|---|---|---|---|---|---|---|
| `n - 1`     | 1 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |
| `n & (n-1)` | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |

- The original number had two `1` - bits.
- Continue the bitwise and till the number is all zeroes.
- A counter can keep track of how often this operation is performed.
- The count will give you the number of `1` - bits in the integer.
- With a complexity of **O(number of 1s)**.

### Reverse the bits in an integer

- Get the bits one at a time from the right most end.
- Shift the bit extracted from the original number into the result from the right.
- Shift the original number right to extract the new right most bit.
- Shift the result number left to make room to get the new rightmost bit.

| `original number` | 1 | 0 | 0 | 0 | 1 | 1 | 1 | 1 |
|---|---|---|---|---|---|---|---|---|
| `result`          | 1 | 1 | 1 | 1 | 0 | 0 | 0 | 1 |

```c
int reverse_bits(int num) {
    int reverse_num = 0;
    unsigned int count = sizeof(int) * 8 - 1;

    while (num != 0) {
        int last_bit = num & 1;               // extract the fight most bit
        reverse_num = reverse_num | last_bit; // add it to the rightmost bit of the result
        reverse_num = reverse_num << 1;       // shift the result left
        num = num >> 1;                       // shift the original number right
        count--;
    }

    // if the original number has only zeroes shift left the remaining bits
    reverse_num = reverse_num << count;
    return reverse_num;
}
```


