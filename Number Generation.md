# 5. Number Generation

## 5.1 Generation of  Fibonacci Numbers [ O(n) ] [ DP ]

```java
// DP
BigInteger b [] = new BigInteger[10000];
b [0] = BigInteger.ZERO;
b [1] = BigInteger.ONE;     
for (int i = 2; i < b.length; ++i)
     b [i] = b [i - 1].add(b [i - 2]);
for (int i = 0; i < b.length; ++i)
     System.out.println(b [i]);
```

```java
int fib Recursive (int num) {
    if (num == 0)
       return 0;
    else if (num == 1)
       return 1;
    else
        return fib(num - 1) + fib(num - 2);      
}
```

```java
int fibIterative (int n) {
    if (n == 0)
  return 0;
    if (n == 1)
  return 1;
    int a, b, c = -1;
    int i;
    a = 0;
    b = 1;
    for (i = 2; i <= n; ++i) {
        c = (a + b);
        a = b;
        b = c;
    }
    return c;
}
```

```java
// O (1) approximation for nth Fibonacci number
// it is not accurate for large Fibonacci numbers
int fibonacci(int n) {
    double phi = (1 + Math.sqrt(5)) / 2;
    return (int) (Math.pow(phi, n) / (Math.sqrt(5)));
}
```

less than 2^31 Fibonacci number is 1,836,311,903

## 5.2 Generation of  Fibonacci Numbers [ log(n) ]
/* Matrix exponentiation */

```java
public static int fib (int n) {
        int i = n - 1, a = 1, b = 0, c = 0, d = 1, t;
        if (n <= 0)
            return 0;
        while (i > 0) {
            while (i % 2 == 0) {
                t = d * (2 * c + d);
                c = (c * c) + (d * d);
                d = t;
                i = i / 2;
            }
            t = d * (b + a) + (c * b);
            a = (d * b) + (c * a);
            b = t;
            i--; 
        }
        return a + b;
}
```
## 5.3 Factorial [ O(n) ] [ DP ]

```java
BigInteger one = BigInteger.valueOf(1); 
BigInteger dp [] = new BigInteger[1005];
dp[0] = one; 
BigInteger fact = one;
int j = 1;
BigInteger i;

for (i = one; j <= 1000; i = i.add(one), ++j) {
    fact = fact.multiply(i);
    dp [j] = fact ;
}
```

```java
int factorialRecursive (int n) { 
    if (n <= 1) // 0! = 1
        return 1; 
    else 
        return n * factorial(n - 1); 
}
```

less than 2^31 Factorial is 10! = 3628800

## 5.4 Generation of  Derangement or Subfactorial or Rencontres numbers [ O (n) ] [ DP ]

```java
public static void dGen () {
    BigInteger one = BigInteger.valueOf(1);
    BigInteger three = BigInteger.valueOf(3);
    BigInteger eHun = BigInteger.valueOf(800);
    d [1] = BigInteger.valueOf(0);
    d [2] = BigInteger.valueOf(1);
    BigInteger i;
    int j;
    for (i = three, j = 3; j <= 800; i = i.add(one), ++j) 
        d [j] =  (i.subtract(one)).multiply(d [j - 1].add(d [j - 2]));
}
```

## 5.5 Generation of  Prime Numbers by The Sieve of Eratosthenes  [ O (n log log n) ]

```java
public static int MAX = 100001;
public static int np; // total number of primes from 1 to MAX-1 or size
public static int p [] = new int [MAX/10]; // not work when MAX is small
public static boolean s [] = new boolean [MAX];
```

```java
public static void gen() {
    int i, j;
    s[1] = s[0] = true;  // mark 1 and 0 non-prime.
    p[0] = 2;            // 2 is specially handled.
    np++;

    for(i = 3; i * i < MAX; i += 2) {
        if(s[i] == false){
            p[np++] = i; 
            for(j = i * i; j < MAX; j += 2 * i)
                s[j] = true;
        }
    }
    for( ; i < MAX; i += 2) {
        if(s[i] == false)
            p[np++] = i;
    }
}
```

1. Call gen();
2. For small MAX value tune it
3. 0 indexing 

```
p[i] = 2;
p[i] = 3;
p[i] = 5;
p[i] = 7;
```

4. 1 indexing, where i is 1 to n

```
p[i-1] = 2;
p[i-1] = 3;
p[i-1] = 5;
p[i-1] = 7;
```

```java
/* determine a number is prime or not */
// 2, 3, 5, 7, 11, 13 
public boolean isPrime(int num) {
     return (num == 2 || ((num & 1) != 0 && s[num] == false));
}
/* ami ekbare likhina ar ki. (NAFI) */
public boolean isPrime(int num) {
     if(num < 2) return false;
     if(num == 2) return true;
     if(num % 2 == 0) return false; // if(num & 1 == 0) return false;
     return s[num] == false;
}
// 1, 2, 3, 5, 7, 11, 13 
```

```java
// 1, 2, 3, 5, 7, 11, 13 

/* for permitting 1 as a prime */ 
s[0] = true;
p[0] = 1;
p[1] = 2;           
np = 2;

public boolean isPrime(int num) {
   if(num < 1) return false;
   if(num == 1 || num == 2) return true;
   if(num % 2 == 0) return false; 
   return s[num] == false;
}
```

largest prime in signed 32‐bit int is 2,147,483,647

```java
/* bitwise sieve */
TODO
```

## 5.6 Generation of Catalan number [ O (n) ] [ DP ]


```java
// O (n)
long cat [] = new long [35];
void getcat() {
  int i;
  cat [0] = cat [1] = 1;
  for (i = 2; i < 35; i++)
      cat[i] = cat[i-1]*(4*i-6)/i;
}
```

```java
// Recursive Solution 
public static int C(int n) {
       if ( n == 0 ) 
  	return 1;
       int ans = 0;
       for (int i = 1; i <= n; ++i)
           ans += C(i - 1) * C(n - i);
       return ans;
}
```

```java
// O (n^2)
int cat  [] = new int [25];
cat [0] = 1;
int i,j;
for(i = 1; i < 20; ++i) { 
	for(j = cat[i] = 0; j < i; ++j)
		cat[i] += cat[j] * cat[i - 1 - j]; 
}
```

catalan numbers grows quickly, so for large n use BigInteger. long can hold upto 34th catalan number 212336130412243110

```java
// n! * nth catalan number
BigInteger binTree [] = new BigInteger[301];
binTree[0] = BigInteger.valueOf(1);
  for (int k = 0; k < binTree.length - 1; k++) {
    int top = (((2 * k) + 1) * ((2 * k) + 2));
    int bottom = (k + 2);
            
    binTree[k+1] = binTree[k].multiply(BigInteger.valueOf(top));
    binTree[k+1] = binTree[k+1].divide(BigInteger.valueOf(bottom));
}
```
