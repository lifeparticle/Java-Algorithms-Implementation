# 13. Basics of Numbers

## 13.1 Factorial

The n! Gives the number of ways in which n objects can be permuted. For example, 
3! = 6, since the six possible permutations of
{1, 2, 3} are 
{1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1} 

## 13.2 Derangement or Subfactorial or Rencontres numbers

In combinatorial mathematics, a derangement is a permutation of the elements of a set such      that none of the elements appear in their original position.

n¡ is sometimes used instead of !n

Derangements of {1, 2, 3} are
{2, 3, 1}, {3, 1, 2} so !3 = 2

তাহলে আমরা বলতে পারি:
d (n) = (n-1) d(n-1) + (n-1) d(n-2)
বা d (n) = (n-1) (d (n-1) + d (n-2))
বেস কেস: d (1) = 0, d (2) = 1

<img width="144" alt="Screen Shot 2020-04-06 at 10 02 45 pm" src="https://user-images.githubusercontent.com/1612112/78556546-827b6e00-7852-11ea-8a46-a287d1568776.png">

## 13.3 Fibonacci sequence

• ফিবোনাচি ধারার যেকোনো পরপর ৪ টি সংখ্যার শেষের দুটির যোগফল এবং মাঝের দুটির যোগফলের পার্থক্য প্রথম সংখ্যাটার সমান।

```
(Fn1 + Fn4) – (Fn2 + Fn3) = Fn1
8 	13 	21 	34
(8 + 34) – (13 + 21) = 42 – 34 = 8	
```

• ফিবোনাচি ধারার প্রতি 60 ফিবোনাচি সংখ্যার পর আবার ফিবোনাচি ধারাই শেষ ডিজিট হিসেবে ফিরে আসে।

```
F60 =1548008755920
F61 =2504730781961
F62 =4052739537881
F63 =6557470319842
F64 =10610209857723
F65 =17167680177565
```
• পাশাপাশি দুটি ফিবোনাচি পদ ভাগ করলে সেটাই সোনালি অনুপাতের দিকে যায়।

```
F2 / F1 = 1 / 1 = 1
F3 / F2 = 2 / 1 = 2
F4 / F3 = 3 / 2 = 1.5
F5 / F4 = 5 / 3 = 1.667
F6 / F5 = 8 / 5 = 1.6
F7 / F6 = 13 / 8 = 1.625
F8 / F7 = 21 / 13 = 1.6153846
F9 / F8 = 34 / 21 = 1.6190476
```

অনুপাত গুলো খেয়াল করলে দেখবেন ভাগফলগুলো ক্রমশই একটি নির্দিষ্ট মানের দিকে পৌছাচ্ছে। এই নির্দিষ্ট মানটা হচ্ছে 1.6180339887……… একটা অমূলদ সংখ্যা.
Golden ratio is denoted by the Greek lowercase letter phi (φ), while its reciprocal, 1 / φ or φ-1 is denoted by the uppercase variant Phi (ɸ).

x^2  - x – 1 = 0

φ=  (1+ √5)/2 ≈ 1.6180339887…
fib (n)=  φ^n/√5 [O (1) approximation for nth Fibonacci number]

## 13.4 Prime numbers

### Goldbach conjecture: 
Every even integers greater than 2 can be expressed as the sum of two  numbers.

```
4 = 2 + 2
6 = 3 + 3
8 = 3 + 5
10 = 7 + 3, 5 + 5
12 = 5 + 7
14 = 3 + 11, 7 + 7
```

### Euler Formula:
For, 0 ≤ n ≤ 40, n^2 + n + 41

## 13.5 Permutations

nPr means out of n elements choose r elements. That is, choose r elements from n and consider the different orders possible for the same choices of numbers.
nPr = (n !)/(n-r)!

## 13.6 Combinations

nCr means out of n elements choose r elements. That is, choose r elements from n and do not consider the different orders possible for the same choices of numbers.

```
nCr = (n !)/(r! × (n-r)!)

nCr = nC(n-r)
10C2 = 10C8
11C4 = 11C7
```

Two Cases:

When r > n – r -> 10C7 -> (7 > 3) 

10C7 = (1×2 ×3 ×4 ×5 ×6 ×7 ×8 ×9×10 )/((1×2 ×3 ×4 ×5 ×6 ×7 )  × (1×2 ×3))

     = (8 ×9×10  )/(1×2 ×3)
     
     = (r + 1 -> (7 + 1)->8  )/(n-i +1) // here i = r + 1

When r < n – r -> 8C2 -> (2 < 8) -> 

8C2 = (1×2 ×3 ×4 ×5 ×6 ×7 ×8 )/( (1×2)  × (1×2 ×3 ×4 ×5 ×6))

    = (7×8  )/(1×2 )
    
    = (n – r + 1 -> (8 - 2 + 1) -> 7)/(n-i +1) // here i = r + 1

## 13.7 Catalan number

In combinatorial mathematics, the Catalan numbers form a sequence of natural numbers that occur in various counting problems, often involving recursively defined objects. 
The nth Catalan number is given directly in terms of binomial coefficients by

C_n=  1/(n+1)  (2n¦n)=  (2n)!/((n+1)! ×n!)       for n ≥0

The first Catalan numbers for n = 0, 1, 2, 3 ... are

1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190, 6564120420, 24466267020, 91482563640, 343059613650, 1289904147324, 4861946401452, ...

### Problem 1:  [Binary Bracketing]
How many ways are there to build a balanced formula from n sets of left and right parentheses? For example, there are five ways to do it for n = 3: ((())), () (()), (()) (), (() ()), and () () (). The leftmost parenthesis l matches some right parenthesis r, which must partition the formula into two balanced pieces, the part between l and r, and the part to the right of r. If the left part contains k pairs, the right part must contain n − k − 1 pairs, since l, r represent one pair.  


```java
static void ParCheck(int left,int right,String str) {
     if (left == 0 && right == 0)
         System.out.println(str);
     if (left > 0)
         ParCheck(left-1, right+1 , str + "(");
     if (right > 0)
         ParCheck(left, right-1, str + ")");
}

public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
     int num = input.nextInt();
     String str = "";
     ParCheck(num,0,str);
}
```

```
3
((()))
(()())
(())()     5
()(())
()()()

4
(((())))
((()()))
((())())
((()))()
(()(()))
(()()())
(()())()   14
(())(())
(())()()
()((()))
()(()())
()(())()
()()(())
()()()()
```

### Problem 2: 
How many binary search trees is there that contain n different elements? Remember that a binary search tree always obeys the rule of having smaller elements to the left of larger ones. For example, there are 2 BST's with 2 nodes (2 choices for the root) and 5 BST's with 3 nodes. Let us call the number of BST's with n nodes〖 C〗_n. 

Whenever you have a problem involving trees, it's always a good idea to think about a recursive solution. Here is one. We will pick one of the n nodes to be the root. If the nodes are numbered from 1 to n, imagine picking node number i. This splits the problem nicely into 2 sub problems. In the left subtree, we have a BST on i-1 nodes, and there are C_(i-1) ways of building those. In the right subtree, we have n-i nodes and so, C_(n-i) ways of building a BST. The two subtrees are independent of each other, so we simply multiply the two numbers. 

That is if we have chosen node i to be the root. Picking a different root is sure to give us a different tree, so to get all the possible trees, we pick all the possible root nodes and multiply the numbers for the two subtrees that we get. This gives us a neat, recursive formula.

<img width="164" alt="Screen Shot 2020-04-06 at 10 13 12 pm" src="https://user-images.githubusercontent.com/1612112/78557289-daff3b00-7853-11ea-8b35-f35de42d7100.png">

Of course, we need some base cases. Simply setting C_0 to be 1 is enough – there is just one way to make a tree with zero nodes.



### Problem 3: 
Handshakes that include everyone in the group while avoiding any crossed handshake.
The following figure illustrates the case for 3 pairs of persons: 

<img width="620" alt="Screen Shot 2020-04-06 at 10 13 25 pm" src="https://user-images.githubusercontent.com/1612112/78557301-de92c200-7853-11ea-9fb3-84e56d9d8220.png">

Problem 4:

The number of distinct binary tree with n vertices can be found with the Catalan formula, written using binomial coefficients notation nC_k above as 

<img width="369" alt="Screen Shot 2020-04-06 at 10 15 01 pm" src="https://user-images.githubusercontent.com/1612112/78557412-16016e80-7854-11ea-8695-a72182d37b93.png">

With 3 vertices there are 5 distinct binary trees

```
    *     *     *      *     *
   /     /     / \      \     \
  *      *    *   *      *     *
 /       \              /       \
*         *            *         *
```

## 13.8 Odd numbers 

Addition of consecutive odd numbers starting from one always is a perfect square number
1 = 1 = 1^2
1 + 3 = 4 = 2^2
1 + 3 + 5 = 9 = 3^2
1 + 3 + 5 + 7 = 16 = 4^2
1 + 3 + 5 + 7 + 9 = 25 = 5^2
So, the sum of the first 50 natural odd numbers will be 50^2 = 2500

## 13.9 Perfect Square numbers

A number have Odd number of factors if and only if it is a Perfect Square.
[9 = 1, 3, 9] [10 = 1, 2, 5, 10]

```java
// determine a number is a perfect square 
int x = (int)Math.sqrt(n);
return x * x == n;
```

```
1^2 = 1
2^2 = 4
3^2 = 9
```

Squares of even numbers are even, since (2n)^2 = 4n^2.
Squares of odd numbers are odd, since (2n + 1)^2 = 4(n^2 + n) + 1.
It follows that square roots of even square numbers are even, and square roots of odd square numbers are odd.

```java
// Find how many square numbers are there between a and b (inclusive)

Simulation for a = 10 and b = 20
1 to 20 there are 4 square numbers which are 1, 2, 3, and 4
1 to 9 there are 3 square numbers which are 1, 2, and 3
Between of 10 to 20 there is 1 square number which is 4.
    
// Finding How many Square number between 1 to b       
int sqrt1 = (int) Math.sqrt(b);     
// Finding How many Square number between 1 to a-1       
int sqrt2 = (int) Math.sqrt(a-1);
// Finding How many Square number between a to b       
int ans = sqrt1 - sqrt2;       
System.out.println(ans);
```

1. Any square number can be expressed as 3k or 3k + 1.
2. Square of an odd number can be expressed as 4k + 1; square of an even number can be   expressed as 4k.
3. Last digit of a square number cannot be 2, 3, 7, 8.
4. Square of any prime number can be expressed as 6K + 1 (p > 3) [2, 3 excluded]
5. If last digit of a number is odd the previous number would be even.
6. A square number cannot be a perfect number.
7. Number of divisor must be odd; all the other number has even divisors.

## 13.10 Triangular Number

A triangular number or triangle number is the number
Of dots in an equilateral triangle uniformly filled with dots.
For example, three dots can be arranged in a triangle;
Thus three is a triangle number. The nth triangle number is
the number of dots in a triangle with n dots on a side.
A triangle number is, equivalently, the sum of the n natural numbers from 1 to n.

Tn = 1 + 2 + 3 + … + (n - 1) + n =   (n (n +1))/2   // n = row number

<img width="245" alt="Screen Shot 2020-04-06 at 10 19 08 pm" src="https://user-images.githubusercontent.com/1612112/78557738-a9d33a80-7854-11ea-9ebd-51b0b564c6de.png">

### Triangular roots and tests for triangular numbers:

So if the numbers of total dots are given we can find the n 
means the row number, that can hold those dots

<img width="242" alt="Screen Shot 2020-04-06 at 10 20 24 pm" src="https://user-images.githubusercontent.com/1612112/78557834-df782380-7854-11ea-8995-b6808da78eb4.png">
<img width="145" alt="Screen Shot 2020-04-06 at 10 20 39 pm" src="https://user-images.githubusercontent.com/1612112/78557841-e30baa80-7854-11ea-8076-54b64a334cfd.png">

```java
double twoA = 2;
double calSqrt = Math.sqrt(1 + (8 * num));
double ans = (-1 + calSqrt) / twoA;
```

An integer x is triangular exactly if 8x + 1 is a odd square. Equivalently, if the positive triangular root n of x is an integer, then x is the nth triangular number. This test is based on the identity

```
// Odd square number
// 1st check if it is a square number [8Tn + 1]
// 2nd check if it is odd
// if 1st and 2nd condition is true Tn is a triangular number
```

√(8Tn + 1) = 2n + 1
8Tn + 1 = (2n + 1)^2 

## 13.11 Co-prime

```java
// using prime factors /* faster */
static long EulerPhi(long N) {
        int i = 0;
        long PF = p [i], ans = N;               // start from ans = N
        while (N != 1 && (PF * PF <= N)) {
            if (N % PF == 0) 
                ans -= ans / PF;                // only count unique factor
            while (N % PF == 0) 
                N /= PF;
            PF = p[i];
            ++i;
        }
        if (N != 1) 
            ans -= ans / N;                     // last factor
        return ans;
}
```

```java
static int totient(int n) {
        int i, result = n;
        for(i = 2; i * i <= n; i++) {
            if(n % i == 0) 
                result -= result / i;
            while(n % i == 0) 
                n /= i;
        }
        if(n > 1) 
            result -= result / n;
        return result;
}
```

## 13.12 Rational Number

A rational number is a number that can be expressed as a fraction p/q (i.e. as a ratio), where p and q are integers and q ≠ 0
