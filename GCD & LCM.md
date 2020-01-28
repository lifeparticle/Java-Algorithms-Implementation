# 1. GCD & LCM
1.1 Basics of GCD and LCM
+ The greatest common divisor (gcd), also known as the greatest common denominator, greatest common factor (gcf), or highest common factor (hcf), of two or more non-zero integers, is the largest positive integer that divides the numbers without a remainder
+ if there are no greatest common divisor the answer is 1, that means they are relatively prime
+ the lowest common multiple or (LCM) least common multiple or smallest common multiple of two rational numbers a and b is the smallest positive rational number that is an integer multiple of both a and b

+ m * n = GCD (m, n) * LCM (m, n)
+ Any number that divides both a and b divides GCD (a, b)
+ gcd (a, b, c) = gcd (gcd (a, b), c)
+ lcm (a, b, c) = lcm (lcm (a, b), c)
+ Reduces a fraction (in pq form) into its lowest terms [irreducible fraction]
```
25/45 // consider the reducible fraction
```

Now, the greatest common divisor for the denominator and numerator must be calculated; which in this case is 5. Afterwards, both the denominator and numerator must be divided by the gcd. The result would be
```
5/9 // this is an irreducible fraction
```
```java
public void reduceFraction (int [] a) {
    int b = GCD(a[0], a[1]);
    a[0] /= b;
    a[1] /= b;
} 
```
+ Multiply Fractional Number
```java
public int [] multiplyFractions (int [] a, int [] b) {
	int c [] = {a[0] * b[0], a[1] * b[1]};
	return c;
} 
```
+ Summing Fractional Number
5/1 + 9/2 + 6/3 + 7/4 = 159/12 = 13.25

```java
neu [0] = 5; neu [1] = 9; neu [2] = 6; neu [3] = 7;
den [0] = 1; den [1] = 2; den[2] = 3; den [3] = 4;
lcm = 1;
for(j = 0; j < 4; ++j)
    lcm = LCM (lcm, den[j]); // lcm = 12
ans = 0;
for(int j = 0; j < 4; ++j)
    ans += (lcm / den [j]) * neu [j]; 
System.out.println((double)((double)ans/(double)lcm)); 
```

1.2 GCD [ Euclid’s Algorithm ] [ O log10(n), n = max(a, b) ]
```java
// recursive
public int gcd (int M, int N) {
    if (N == 0) 
	    return M; 
    return gcd (N, M % N); 
}
```

```java
// iterative
public int gcd (int a, int b) {
    int t = 0;
    while(b != 0) {
        t = b;
        b = a % b;
        a = t;
    }
    return a;
}
```

1.3 LCM [ O log10(n), n = max(a, b) ]
```java
/* divide first, as it MUST be divisible by gcd. It will prevent overflow, if any */
public int lcm (int m, int n) {
   return m / gcd (m,n) * n;
}
```

1.4 Extended Euclid’s Algorithm
```java
/* returns d = GCD (a, b), and give one pair x, y such that ax + by = d */
int x, y, d;
public void extendedEuclid (int a, int b) {
    if (b == 0) {
        x = 1;
        y = 0;
        d = a;
        return;
    }
    extendedEuclid (b, a % b);
    int x1 = y;
    int y1 = x – (a / b) * y;
    x = x1;
    y = y1;
}
```
// solving Linear Diophantine Equation using Extended Euclid’s Algorithm
```
ax + by = c
x = x0 + (bd) n
y = y0 - (ad) n
```
Where n is an integer and x0 and y0 are the first solution
