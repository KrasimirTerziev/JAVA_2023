# Algorithm Complexity Tasks

Define the complexity of each program/algorithm.

## Task 1

```java
static int product(int a, int b) {
    int sum = 0;
    for (int i = 0; i < b; i++) {
        sum += a;
    }
    return sum;
}
```

> Answer: $`O(n)`$ where $`n = b`$.

## Task 2

```java
int power(int a, int b) {
    if (b < 0) {
        return 0;
    }
    if (b == 0) {
        return 1;
    }
    int power = a;
    while (b > 1) {
        power *= a;
        b--;
    }
    return power;
}
```

> Answer: $`O(n)`$ where $`n = b`$.

## Task 3

```java
int mod(int a, int b) {
    if (b < 0) {
        return -1;
    }
    int div = a / b;
    return a - div * b;
}
```

> Answer: $`O(1)`$

## Task 4

```java
static int sum3(int n) {
    int sum = 0;
    for (int a = 0; a < n; a++) {
        for (int b = 0; b < n; b++) {
            for (int c = 0; c < n; c++) {
                sum += (a * b * c);
            }
        }
    }
    return sum;
}
```

> Answer: $`O(n^3)`$. The number of elementary steps is ~$`n^3`$.

## Task 5

```java
static int sumNM(int n, int m) {
    int sum = 0;
    for (int a = 0; a < n; a++) {
        for (int b = 0; b < m; b++) {
            sum += (a * b);
        }
    }
    return sum;
}
```

> Answer: $`O(nm)`$. The number of elementary steps is ~$`n*m`$.

## Task 6
//f(n) = 3 * 5 * 3 = 45 (if it was cubic)
// f(n) = 3 * 5 + 3 * 5 = 30 (the current)
```java
static int sumNM(int n, int m) { // 5 , 3
    int sum = 0; // 1
    for (int a = 0; a < n; a++) { // 1 + n
        for (int b = 0; b < m; b++) { //1 + n*m
            if (a == b) { // 1 + n*m + min(n,m) + 
                for (int c = 0; c < n; c++) { // // 1 + n*m + min(n,m)*n -> 2 + 2*(n*m) = 32
                // n == m -> n2 | m2
                // n < m -> n*m | n2
                // n > m -> n*m | n*m
                    sum += (a * b * c);
                }
            }
        }
    }
    // 
    return sum;
}
```

> Answer: $`O(nm)`$. The number of elementary steps is ~$`n*m + min(m, n) * n`$.

## Task 7

```java
static int factorial(int n) {
    int factorial = 1;
    while (n > 1) {
        factorial *= n;
        n--;
    }
    return factorial;
}
```

> Answer: $`O(n)`$. The number of elementary steps is ~$`n`$.