# 8. Dynamic Programming


## 8.1 Coin Change problem [ CC ]

Determine how many ways you can use to pay an amount of money (n) with the help of some coins.

```java

long nway [] = new long [size]; // size = n + 1 	
nway [0] = 1;

/* nway[] অ্যারেতে থাকবে কোন টাকা কতভাবে বানানো যায়, মানে nway[1] = কতভাবে ১ টাকা বানানো যায়. nway[0] = 1, কারন আমরা ০ টাকা বানাতে পারি ১ ভাবে(কোন টাকা না নিয়ে) */

int coin [] = {50, 25, 10, 5, 1};
int v = 5;
int i,j,c,n;

for (i = 0; i < v; ++i){
    c = coin [i];
    for (j = c; j <= n; ++j) { // n is the highest money
        nway [j] += nway [j - c];
    }
}

while(sc.hasNextInt()) {                
    n = sc.nextInt();
    System.out.println(nway[n]);
}
// check if any overflow happens or not in that case use BigInteger
```

## 8.2 Knapsack problem [ 0/1 ]

TODO

## 8.3 Longest Common Subsequence [ LCS ]  [ O (mn) ]

```java
 // LCS [Recursion]  
 public static int LCS(int n, int m) {
        if (n < 0 || m < 0)
            return 0;
        if (A.charAt(n) == B.charAt(m))
            return 1 + LCS(n - 1, m - 1);
        else 
            return Math.max(LCS(n, m - 1),LCS(n - 1, m)); 
 }
```

```java
// LCS [DP] + parent reference
public static int LCSDP(String n, String m) {
    for (int i = 0; i < n.length(); ++i)
        dp[i][0] = 0;

    for (int j = 0; j < m.length(); ++j)
        dp[0][j] = 0;

    for (int k = 1; k <= n.length(); ++k) {
        for (int l = 1; l <= m.length(); ++l) {
            if (n.charAt(k - 1) == m.charAt(l - 1)) {
                dp [k][l] = 1 + dp [k - 1][l - 1];
                map [k][l] = 3; // dig
            } else {
                if (dp [k][l - 1] > dp [k - 1][l]) {
                    dp [k][l] =  dp [k][l - 1];
                    map [k][l] = 2; // left
                } else {
                    dp [k][l] = dp [k - 1][l];
                    map [k][l] = 1; // up
                }
            }
        }
    }
    return dp[n.length()][m.length()];
} 
```

```
// printing
public static void ans() {
    String ans = "";
    int i = A.length();
    int j = B.length();

    for( ;i !=0 && j !=0; ) {
        if (map[i][j] == 3) {
            ans += A.charAt(i - 1);
            --i;
            --j;
        }
        if (map[i][j] == 2)
            --j;
        if (map[i][j] == 1)
            --i;
    }
    System.out.println(new StringBuffer(ans).reverse().toString());
}
```
## 8.4 Longest Increasing Subsequence [ LIS]

## 8.5 Longest Decreasing Subsequence [ LDS ]

## 8.6 Edit Distance

## 8.7 Using 1,2,3 how many numbers you can make such that the sum of their digits is equal to the given number

```java
 dp [1] = 1;    
 dp [2] = 2;
 dp [3] = 4;

 dp [n] = how many ways we can made (n – 1) + 
	  how many ways we can made (n – 2) + 
	  how many ways we can made (n – 3);
```

```
n = 1
1 = 1

n = 2
1 + 1 = 2
2 = 2

n = 3
1 + 1 + 1 = 3
1 + 2 = 3
2 + 1 = 3
3 = 3

n = 4
1 + 1 + 1 + 1 = 4
1 + 1 + 2 = 4
2 + 1 + 1 = 4
1 + 2 + 1 = 4
2 + 2 = 4
1 + 3 = 4
3 + 1 = 4
```

## 8.8 Cumulative Sum

```java
// Returns the number that how many digit primes up to dp[i] [inclusive]

public void countDP(){
    for(int i = 1; i <= 1000000; ++i){
        if(isPrime(i) && isPrime(sum(i)))
            dp[i] = dp[i-1] + 1;
        else
            dp[i] = dp[i-1];
    }
}
```

## 8.9 Matrix Chain Multiplication [ MCM ]

You can multiply two matrices if, and only if, the number of columns in the first matrix equals the number of rows in the second matrix. Otherwise, the product of two matrices is undefined. The product matrix’s dimensions are
(Rows of first matrix)  (Columns of second matrix)

```java
// [O (pqr] where |A| = p  q and |B| = q  r for rectangular matrix
// [O (n^3)] for square matrix
public static boolean mcm (int A[][], int B [][], int r1, int c1, int r2, int c2) {
    if (c1 != r2)
        return false;
    C = new int [r1][c2];
    for (int i = 0; i < r1; ++i) {
        for (int j = 0; j < c2; ++j) {
            for (int k = 0; k < c1; ++k) {
                C [i][j] += A[i][k] * B[k][j];
            }
        }
    }
    return true;
}
```
