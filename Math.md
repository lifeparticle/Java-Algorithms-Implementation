# 16. Math

## 16.1 Value Comparisons

1. Value Comparisons

```
Smaller Value/Greater Value < 1
Greater Value/Smaller Value > 1
```

## 16.2 Quadratic equation

```
ax² + bx + c = 0
```

<img width="401" alt="Screen Shot 2020-04-09 at 7 36 30 pm" src="https://user-images.githubusercontent.com/1612112/78881007-8d740f80-7a99-11ea-8035-26828ee3d5e7.png">

```java
double bSquared = (b * b);
double twoA = 2 * a;
double calSqrt = Math.sqrt(bSquared - (4 * a * c));
double cal1 = (-b - calSqrt) / twoA;
double cal2 = (-b + calSqrt) / twoA;
```

## 16.3 Series

<img width="470" alt="Screen Shot 2020-04-09 at 7 38 06 pm" src="https://user-images.githubusercontent.com/1612112/78881117-b4cadc80-7a99-11ea-8a83-c57b86bbe75b.png">

### Arithmetic progression:
In mathematics, an arithmetic progression (AP) or arithmetic sequence is a sequence of numbers such that the difference of any two successive members of the sequence is a constant. For instance, the sequence 1, 3, 5, 7, 9, 11, 13 … is an arithmetic progression with common difference 2.
If the initial term of an arithmetic progression is a1 and the common difference of successive members is d, then the nth term of the sequence is given by:

```
a_n = a_1 + (n - 1) * d
In general 
a_n = a_m + (n - m) * d

a_1 = 1
d = 2
For
1, 3, 5, 7, 9, 11, 13…
```

### Geometric progression:
In mathematics, a geometric progression, also known as a geometric sequence, is a sequence of numbers where each term after the first is found by multiplying the previous one by a fixed non-zero number called the common ratio. For example, the sequence 2, 6, 18, 54 ... is a geometric progression with common ratio 3. Similarly 10, 5, 2.5, 1.25 ... is a geometric sequence with common ratio 1/2.

```
Gauss Law
S = Sum of all number's
F = First number in sequence
L = Last number in sequence
T = number of Terms in sequence
S = (F + L) * (T) / 2 
```

### Harmonic Series:

<img width="325" alt="Screen Shot 2020-04-09 at 7 40 54 pm" src="https://user-images.githubusercontent.com/1612112/78881364-0bd0b180-7a9a-11ea-835d-d5e5b6483daf.png">

```java
double sum = 0.0;
for (int i = 1; i <= N; ++i) {
     sum += 1.0 / i;
}       
// print out Nth harmonic number
System.out.println(sum);
```

## 16.4 Modular arithmetic theorem 

```
Addition: (x + y) mod n = ((x mod n) + (y mod n)) mod n
Subtraction:  (x - y) mod n = ((x mod n) - (y mod n) + n) mod n 
Multiplication: (x * y) mod n = ((x mod n) * (y mod n)) mod n
Division: (x / y) mod n = ((x mod n) * (y-1 mod n)) mod n 
Power: (a^b) mod n = ((a^(b/2) mod n) * (a^(b/2) mod n)) mod n //assume that b is even
```

## 16.5 Logarithms 

<img width="634" alt="Screen Shot 2020-04-09 at 7 43 01 pm" src="https://user-images.githubusercontent.com/1612112/78881650-7255cf80-7a9a-11ea-9a43-4c7fa0320744.png">

```java
public static double log2(int num) {
    return (Math.log10(num) / Math.log10(2));
}

public static double logB(int num, int base) {
    return (Math.log10(num) / Math.log10(base));
}
```

## 16.6 Trigonometry

<img width="573" alt="Screen Shot 2020-04-09 at 7 48 18 pm" src="https://user-images.githubusercontent.com/1612112/78882405-5d2d7080-7a9b-11ea-9ee1-caf9789c5bc7.png">
<img width="522" alt="Screen Shot 2020-04-09 at 7 49 23 pm" src="https://user-images.githubusercontent.com/1612112/78882418-5ef73400-7a9b-11ea-838c-5941185078c2.png">
<img width="506" alt="Screen Shot 2020-04-09 at 7 49 50 pm" src="https://user-images.githubusercontent.com/1612112/78882426-61598e00-7a9b-11ea-8b9d-2d43b7c769ab.png">

## 16.7 Basics of Division, Multiplication, Addition and Subtraction

```
Division:
Dividend ÷ Divisor = Quotient 
18 ÷ 3 = 6
Quotient × Divisor = Dividend 
6 × 3 = 18
23 ÷ 5 Here Quotient 4 and Remainder 3

Multiplication:
Factor × Factor = Product
3 × 4 = 12

Addition:
Addends/Terms + Addends/Terms = Sum
7 + 7 = 14

Subtraction:
Minuend/Terms – Subtrahend/Terms = Difference 
6 – 4 = 2
```

## 16.8 Basics of Fraction

Numerator/Denominator

Continued Fractions: [CF]

A finite continued fraction is an expression of the form

<img width="236" alt="Screen Shot 2020-04-09 at 7 51 22 pm" src="https://user-images.githubusercontent.com/1612112/78882518-88b05b00-7a9b-11ea-9582-7dfd0afa984c.png">

## 16.9 Basics of Root

<img width="226" alt="Screen Shot 2020-04-09 at 7 52 21 pm" src="https://user-images.githubusercontent.com/1612112/78882616-a5e52980-7a9b-11ea-8e5c-f1529c5a5794.png">

## 16.10 Even & Odd number

```
even ± even = even
even ± odd = odd
odd ± odd = even
odd * odd = odd
even * even = even
```

```
even = 2n
odd = 2n + 1
```

## 16.11 Set Theory

## Subset:

If every element of a set B is also a member of a set A, then we say B is a subset of A. We use the symbol ⊂ to mean “is a subset of” and the symbol ⊄ to mean “is not a subset of”. 

Example: 
```
A = {1, 3, 5}, B = {1, 2, 3, 4, 5}
```
So,  A ⊂ B because every element in A is also in B.
```
X = {1, 3, 5}, Y = {2, 3, 4, 5, 6}. 
```
X ⊄ Y , because 1 is in X  but not in Y.

•	Every set is a subset of itself i.e. for any set A, A ⊂ A

•	The empty set is a subset of any set A i.e. Ø ⊂  A

•	For any two sets A and B, if A ⊂  B and B ⊂  A then A = B

The number of subsets for a finite set A is given by the formula:
Number of subsets = 2 n (A), where n (A) = number of elements in the finite set A
List all the subsets of the set Q = {x, y, z}. The subsets of Q are 

```
{ }, {x}, {y}, {z}, {x, y}, {x, z}, {y, z} and {x, y, z}
N (Q) = 3
Number of subsets = 23 = 8
```

## 16.12 Zero

```
Something/0 = undefined (অসংজ্ঞায়িত)
// it has two limiting value -∝ and +∝
// if we know the value is positive then we can put +∝
// mass =   97/0, mass cannot be negative so we can write mass = +∝
0/0 = indeterminate (অনিণেয়)
```
