# 11. Number Theory

## 11.1 Chinese Remainder Theorem

TODO

## 11.2 Number of Divisors [ O sqrt(n) ]

```java
public static long countDiv1 (long n) {
     long nd = 0, i;
        
     for(i = 1; i * i < n; ++i) {
         if(n % i == 0)
             nd += 2;  
    }
        
    if(i * i == n)
        ++nd;
        
   return nd;
}
```


```java
public static long countDivV2 (long n) {
     long nd = 0, i;
        
     for(i = 1; i < n / i; ++i) {  
          if(n % i == 0)
             nd += 2;  
     }
        
     if(i * i == n)
         ++nd;
        
    return nd;
}
```

```java
public static long countDivV3 (long n) {
     long nd = 0, nb = n, i;
     n = (long)Math.sqrt(n);
        
     for(i = 1; i < n; ++i) {  
        if(nb % i == 0) 
            nd += 2;  
    }
        
    if(i * i == nb)
       ++nd;
        
    return nd;
}
```

```java
public static long countDivV4 (long n) {
    long nd = 0, i, i2 = 1, di = 3;
        
    for(i = 1; i2 < n;++i,i2+=di,di+=2){  
        if(n % i == 0)
            nd += 2;  
    }
        
    if(i * i == n)
        ++nd;
        
    return nd;
}
```

```java
// using prime factors
public static long countDivP1 (long n) {
        long c, nd = 1;
        int i;
        for(i = 0; p[i] * p [i] <= n && n > 1; ++i) {  
            c = 1;
            while(n % p[i] == 0) {
                n /= p[i];
                ++c;
            }
            nd *= c;
        }
        if (n > 1) 
            nd *= 2;
        return nd; 
}
```

## 11.3 Sum of Divisors [ O sqrt(n) ]

```java
public static long sumDivV1 (long n) {
        long sd = 0, i;
        for(i = 1; i * i < n; ++i) {
            if(n % i == 0)
                sd += i + n / i;  
        }
        if(i * i == n)
            sd += i;
        
        return sd;
}
```

```
// using prime factors
public static long sumDivP1 (long n) {
        long m, c, sd = 1;
        int i;
        for(i = 0; p[i] * p [i] <= n && n > 1; ++i) {  
            m = p[i];
            c = 1;
            while(n % p[i] == 0) {
                n /= p[i];
                m *= p[i];
            }
            sd *= (m - 1) / (p[i] - 1);
        }
        if (n > 1) 
            sd *= n + 1;
        return sd;
}
```

## 11.4 Prime divisors

```java
// prime factors
static void primeFactors (long N) {   
    int i = 0;
    long PF = p [i];    
    while (N != 1 && (PF * PF <= N)) {  
        while (N % PF == 0) { 
            N /= PF; 
            System.out.println(PF);
        }    
        PF = p [i];    
        ++i;
    }
    if (N != 1) // special case if N is actually a prime
        System.out.println(PF);
}
```

```java
// number of prime factors
static long numPF (long N) {   
        int i = 0;
        long PF = p [i], ans = 0;;    
        while (N != 1 && (PF * PF <= N)) {  
            while (N % PF == 0) { 
                N /= PF; 
                ++ans;
            }
            PF = p [i];    
            ++i;
        }
        if (N != 1) // special case if N is actually a prime
            ++ans;
        return ans;
}
```

```java
// number of different prime factors
static long numDiffPF (long N) {   
        int i = 0;
        long PF = p [i], ans = 0;;    
        
        while (N != 1 && (PF * PF <= N)) {  
            if (N % PF == 0) 
                ++ans;        
            while (N % PF == 0) 
                N /= PF; 
            PF = p [i];    
            ++i;
        }
        if (N != 1) // special case if N is actually a prime
            ++ans;
        return ans;
}
```

```java
// sum of prime factors
static long numPF (long N) {   
        int i = 0;
        long PF = p [i], ans = 0;;    
        while (N != 1 && (PF * PF <= N)) {  
            while (N % PF == 0) { 
                N /= PF; 
                ans += PF;
            }
            PF = p [i];    
            ++i;
        }
        if (N != 1) // special case if N is actually a prime
            ans += N;
        return ans;
}
```

## 11.5 Base Conversion [ 2 to 9 ]

```java
static BigInteger one = BigInteger.valueOf(1);
static BigInteger zero = BigInteger.valueOf(0);
public static BigInteger conv(BigInteger n,BigInteger from,BigInteger to){
  BigInteger total = zero;
  BigInteger power = one;
  while(n.compareTo(zero) > 0){
      total = total.add((n.mod(to)).multiply(power));
      n = n.divide(to);
      power = power.multiply(from);
  }
  return total;  
}
```

```java
/* any base to any base between 2 to 9 */
// total = 0; 
// power = 1;
// while (n > 0) {
//   total += (n % in which base you want to convert) * power;
//   n /= in which base you want to convert;
//   power* = from which base you want to convert;
// }
// System.out.println(total);
```

```java
/* from decimal [base 10] to binary [base 2] */
int n = sc.nextInt();
int total = 0;
int power = 1;
while(n > 0) {
    total +=  (n % 2) * power;
    n /= 2;
    power *= 10;  
}
System.out.println(total);
```

## 11.6 Base Conversion [ any base to any base ] [ O (n) ]

```java
/* Given a starting base b1, and a target base b2, and a string represented a nonnegative number N in base b1, returns the base b2 representation of N as a string */
String key = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    
String convert_base(String n, int  base1, int base2) {
    int i, x;
    String n2 = "", n3 = "";
    BigInteger a = BigInteger.ZERO, 
              b1 = BigInteger.valueOf(base1), 
              b2 = BigInteger.valueOf(base2);
        
    for(i = 0; i < n.length(); i++) {
         a = a.multiply(b1);
         x = key.indexOf(n.charAt(i));
         a = a.add(BigInteger.valueOf(x));
    }
        
    while(a.signum() == 1){
         BigInteger r[] = a.divideAndRemainder(b2);
         n2 += key.charAt(r[1].intValue());
         a = r[0];
    }
        
    for(i = n2.length()-1; i >= 0; i--) 
         n3 += n2.charAt(i);
        
    if(n3.length() == 0) 
          n3 += '0';
        
    return n3;
}
```

## 11.7 Determine if the number valid or not providing the base [ O (n) ]

```java
// 190 is valid 10 base number but 126 is not a valid 6 base number 

public boolean isValidBase(String s, int b) {
        
        int range, c;
        
        for(int i = 0; i < s.length(); ++i) {
            
            c = s.charAt(i);
            
            if(Character.isDigit(c)) 
                range = c - 48;
            else
                range = c - 55;
            
            if(range < 0 || range >= b)
                return false;
            
        }
        return true;   
}
```

```java
/* to convert 132 in base 8 (octal) into base 2 (binary), we can use base 10 (decimal) as the intermediate step: 
(132)8 = 1 × 82 + 3 × 81 + 3 × 80 = 64 + 24 + 2 = (90)10 and 
(90)10 → 45(0) → 22(1) → 11(0) → 5(1) → 2(1) → 1(0) → 0 (1) = (1011010)2
(That is divide by 2 until 0, then read the remainders from backwards)*/
```

## 11.8 Arabic Numerals to Roman Numerals and Roman Numerals to Arabic Numerals

TODO

## 11.9 Primility test

```java
// native [O (sqrt (n))]
public static boolean isPrime(long num) {
      int i;
      if(num < 2)
  return false;
     if(num == 2)
        return true;
      if((num & 1) == 0)      
          return false;
      long sqrt = (long) Math.sqrt(num); 
      for(i = 3; i <= sqrt; i += 2) {
          if(num % i == 0)
             return false;
      }  
    return true;  
}
```

```
Skipping the even integers saving 50% division
```

```java
// also can be written as
// long sqrt = (int) Math.sqrt(num);
for(i = 3; i * i <= num; i += 2) {
    if(num % i == 0)
       return false;
}  
```

```
This generates a series of integers which are not multiple of 2 or 3 or both. The integers of this series can be used to divide a given integer. Skipping the even integer’s saving 50% division and skipping multiple of 3s avoids an additional 17% divisions, that makes total 67% avoided integer divisions.
```

```java
if(num == 2 || num == 3)
   return true;
int dx = 4;
for(i = 5; i * i <= num; i += dx) {
    if(num % i == 0)
       return false;
    dx = - (dx - 6);
}  
```

## 11.10 Big Number Divisibility Check

| Divisor  | Divisibility condition  | Examples | 
|---|---|---|
| 1 | Automatic | Any integer is divisible by 1  |
| 2 | The last digit is even (0, 2, 4, 6, or  8) | 1,294: 4 is even |
| 3 | Sum the digits will divisible by 3  | 16,499,205,854,376 => 1+6+4+9+9+2+0+5+8+5+4+3+7+6 sums to 69 => 6 + 9 = 15 => 1 + 5 = 6, which is divisible by 3   |
| 4 | Examine the last two digits | 40832: 32 is divisible by 4 |
| 5 | The last digit is 0 or 5 | 495: the last digit is 5 |
| 6 | It is divisible by 2 and by 3  | 1,458: 1 + 4 + 5 + 8 = 18, so it is divisible by 3 and  2 |
| 7 | Form the alternating sum of blocks  of three from right to left | 1,369,851: 851 - 369 + 1 = 483 = 7 × 69 |
| 8 | It is divisible by 2 and by 4 | 624: 24 is divisible by 4 and the last digit is even, hence the number is divisible by 8  |
| 9 | Sum the digits. | 2,880: 2 + 8 + 8 + 0 = 18: 1 + 8 = 9 |
| 10 | The last digit is 0. | 130: the last digit is 0 |
| 11 | Form the alternating sum of the digits. <br>Sum of odd digits – Sum of even digits | 918,082: 9 - 1 + 8 - 0 + 8 - 2 = 22 <br> 9 + 8 + 8 = 25 <br> 1 + 0 + 2 = 3 <br> 25 – 3 = 22 |
| 12 | It is divisible by 3 and by 4  | 324: it is divisible by 3 and by 4  |
| 13 | Form the alternating sum of blocks of three from right to left | 2,911,272: -2 + 911 - 272 = 637  |
| 14 | It is divisible by 2 and by 7 | 224: it is divisible by 2 and by 7  |
| 15 | It is divisible by 3 and by 5 | 390: it is divisible by 3 and by 5 |
| 17 | Examine the last four digits | 157,648: 7,648=428 × 16  |
| 18 | Subtract 5 times the last digit from  the rest | 221: 22 - 1 × 5 = 17  |
| 19 | It is divisible by 2 and by 9 | 342: it is divisible by 2 and by 9  |
| 20 | Add twice the last digit to the rest | 437: 43 + 7 × 2 = 57  |
| 21 | If the number formed by the last  two digits is divisible by 20 | 480: 80 is divisible by 20  |

## 11.11 Pascal’s triangle

Each number in the triangle is the sum of the two directly above it

<img width="810" alt="Screen Shot 2020-04-04 at 10 38 00 pm" src="https://user-images.githubusercontent.com/1612112/78445713-056ebe00-76c5-11ea-8f9c-6acde25c4077.png">

The numbers on diagonals of the triangle add to the Fibonacci series, as shown below

<img width="805" alt="Screen Shot 2020-04-04 at 10 38 08 pm" src="https://user-images.githubusercontent.com/1612112/78445769-09024500-76c5-11ea-8aff-c62a36106d14.png">

<img width="727" alt="Screen Shot 2020-04-04 at 10 39 34 pm" src="https://user-images.githubusercontent.com/1612112/78446367-351dc600-76c5-11ea-86dd-310e16492002.png">

A binomial coefficient equals the number of combinations of r items that can be selected from a set of n items. It also represents an entry in Pascal's triangle. These numbers are called binomial coefficients because they are coefficients in the binomial theorem

<img width="270" alt="Screen Shot 2020-04-04 at 10 39 41 pm" src="https://user-images.githubusercontent.com/1612112/78446407-37802000-76c5-11ea-9118-5bf0b94b6dad.png">


Here, the binomial coefficients 1, 2, 1 appearing

```java
// generate Pascal’s triangle using 2d array
BigInteger one = BigInteger.ONE;
int i,j;
BigInteger pas [] [] = new BigInteger [1000] [1000];

pas[0][0] = one;
pas[1][0] = pas[1][1] = one;
System.out.println(pas[0][0]); // first line
System.out.println(pas[0][0]+" "+pas[0][0]); // second line
        
for(i = 2; i < 1000; ++i) {
     pas[i][0] = one;
     System.out.print(pas[i][0]+ " ");
     for(j = 1; j < i; ++j) {
          pas[i][j] = pas[i-1][j-1].add(pas[i-1][j]);
          System.out.print(pas[i][j]+" ");
     }
     pas[i][j] = one;
     System.out.print(pas[i][j]);
     System.out.println();
}
```

## 11.12 Bézout's identity

ax + by = d

where x and y are integers (called Bézout coefficients for (a, b)), which is such that d is a common divisor of a and b. Bézout's lemma states that such coefficients exist for every pair of nonzero integers (a, b), with in addition d > 0, which is then in fact their greatest common divisor and also the smallest positive integer that can be written in this form for any integers x, y. This value of d is therefore uniquely determined by a and b, but the Bézout coefficients are not unique. A pair of Bézout coefficients (in fact the ones that are minimal in absolute value) can be computed by the extended Euclidean algorithm.

The greatest common divisor of 12 and 42 is 6. Bézout's identity states that there must exist an integer solution for x and y in the following equation:

12x + 42y = 6

One of its solutions is x = −3 and y = 1: indeed, we have (−3)×12 + 1×42 = 6. Another solution is x = 4 and y = −1.

## 11.13 Lagrange's four-square theorem

Lagrange's four-square theorem, also known as Bachet's conjecture, states that any natural number can be represented as the sum of four integer squares

<img width="272" alt="Screen Shot 2020-04-04 at 10 43 47 pm" src="https://user-images.githubusercontent.com/1612112/78448432-c856fb80-76c5-11ea-905f-92b4268530d7.png">

Where the four numbers a0, a1, a2, a3 are integers. For illustration, 3, 31 and 310 can be represented as the sum of four squares as follows:

3 = 1^2 + 1^2 + 1^2 + 0^2
31 = 5^2 + 2^2 + 1^2 + 1^2
310 = 17^2 + 4^2 + 2^2 + 1^2
