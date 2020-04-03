# 10. Algorithm

## 10.1 Leap year check

```java
if ( ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) )
```

## 10.2 Digital Root [ O (1) ]

The digital root (also repeated digital sum) of a number is the (single digit) value obtained by an iterative process of summing digits, on each iteration using the result from the previous iteration to compute a digit sum. The process continues until a single-digit number is reached.
For example, the digital root of 65,536 is 7, because 6 + 5 + 5 + 3 + 6 = 25 and 2 + 5 = 7

•	Digital root of a square is 1, 4, 7, or 9.

•	Digital root of a perfect cube is 1, 8 or 9.

•	Digital root of a prime number (except 3) is 1, 2, 4, 5, 7, or 8.

•	Digital root of a power of 2 is 1, 2, 4, 5, 7, or 8. Digital roots of the powers of 2 progress in the sequence 1, 2, 4, 8, 7, 5, 1. This even applies to powers less than 1; for example, 2 to the power of 0 is 1; 2 to the power of -1 (minus one) is .5, with a digital root of 5; 2 to the power of -2 is .25, with a digital root of 7; and so on, ad infinitum in both directions.

•	Digital root of an even perfect number (except 6) is 1.

•	Digital root of a star number is 1 or 4.

•	Digital root of a nonzero multiple of 9 is 9.

•	Digital root of a nonzero multiple of 3 is 3, 6 or 9.

•	Digital root of a triangular number is 1, 3, 6 or 9.

•	Digital root of a factorial ≥ 6! is 9.

•	Digital root of Fibonacci Series is a repeating pattern of 1, 1, 2, 3, 5, 8, 4, 3, 7, 1, 8, 9, 8, 8, 7, 6, 4, 1, 5, 6, 2, 8, 1, 9.

•	Digital root of the product of twin primes, other than 3 and 5, is 8. The digital root of the product of 3 and 5 (twin primes) is 6.

•	Digital root of a non-zero number is 9 if and only if the number is itself a multiple of 9

```java
// without using loop we have order 1 solution
  public int lastDigit1(int n) {
        if (n < 10) 
		return n;
        if (n % 9 == 0) 
		return 9;
        return n % 9;
    }
}
```

## 10.3 Last Digit by Mod

```java
int num1 = 12;
int last1 = num1 % 10; 
System.out.println(last1);

int num2 = 123;
int last2 = num2 % 100;
System.out.println(last2);
        
// If we want to last one digit then % 10
// If we want to last two digit then % 100
// If we want to last three digit then % 1000
// and so on just add zero 
```

## 10.4 Minimums Cuts

<img width="416" alt="Screen Shot 2020-04-03 at 12 39 35 pm" src="https://user-images.githubusercontent.com/1612112/78315267-3e654080-75a8-11ea-990b-29bf1c8912d1.png">

You have to cut the Chocolate or Cake to get the unit of that.
Minimum Cuts = (Row * Column) – 1
Row = 3
Column = 4
Minimum Cuts = 12 – 1 = 11

## 10.5 Map [ O (n) ]

Given a string of 0's and 1's up to 1000000 characters long and indices i and j, you are to answer a question whether all characters between position min (i, j) and position max (i, j) (inclusive) are the same.

  Input:  00000 11111 000 11111 0 1 0 1
Mapping:  00000 11111 222 33333 4 5 6 7

```java
int memo = 0;
String l = sc.nextLine();
for (int i= 0; i < l.length(); ) {
    char p = l.charAt(i);
    for (int j = i; j < l.length(); ++j)
        if (p == l.charAt(j)) {
        ar[i] = memo;
        ++i;
    }else {
        ++memo;
        break;
    }
}

int s = sc.nextInt();
int e = sc.nextInt();

if(ar[s] == ar [e])
     System.out.println("Yes");
else
     System.out.println("No");  
```

```
Input

0000011111
3
0 5
4 2
5 9

Output

No
Yes
Yes
```

## 10.6 Clock Algebra

Find the smallest angle between the hour hand and minute hand in an analogue clock

<img width="320" alt="Screen Shot 2020-04-03 at 12 42 10 pm" src="https://user-images.githubusercontent.com/1612112/78315391-9439e880-75a8-11ea-97cd-a3a1e685ad00.png">

The hour hand of a normal 12-hour analogue clock turns 360° in 12 hours (720 minutes) or 0.5° per minute.

```
In 12 hour (720 min) (43200 sec) the hour hand rotate --------------------- 360°
In 1 hour (60 min) (3600 sec) the hour hand rotate    --------------------- 360°/12 = 30°
In 1 (60 sec) minute the hour hand rotate             --------------------- 30°/60 = 0.5°
In 1 second the hour hand rotates                     --------------------- 30°/(60*60) = 1°/120
```

Angle of 03:45:20 respect to 12:00:00 
= (3 * 30) + (45 * 0.5) + (20 *  1/120) = 112.67° (hour hand)

The minute hand rotates through 360° in 60 minutes or 6° per minute.

```
In 60 (3600 sec) minute the minute hand rotate ------------------------ 360°
In 1 (60 sec) minute the minute hand rotate    ------------------------ 360°/60 = 6°
In 1 second the minute hand rotates            ------------------------ 6°/60 = 0.1°
```

Angle of 00:45:15 respect to 12:00:00 
= (45 * 6) + (15 * 0.1) = 271.5° (minute hand)
Angle between 03:45:20 (hour hand) and 00:45:15 (minute hand)
= (112.5 – 270) ° = 158.83° 
[We need the difference so we take the absolute value]

Special Case 1

In case of a 24 hour clock, the hour input should be checked if it is greater than 12 or not. If it is, then 12 should be subtracted from the original value.

Special Case 2

<img width="310" alt="Screen Shot 2020-04-03 at 12 45 58 pm" src="https://user-images.githubusercontent.com/1612112/78315556-19bd9880-75a9-11ea-9f12-70cb0d854a6f.png">

As we are looking for smallest angle so if the angle is greater than 180 then the smallest angle will be x = (360 - 𝜃)°

```java
int h = sc.nextInt();
int m = sc.nextInt();
int s = sc.nextInt();

if (h > 12)		// special case 1
  h -= 12;

double hAngle = (h * 30) + (m * 0.5) + (s * (1.0 / 120));
double mAngle = (m * 6) + (s * 0.1);
// double sAngle = 6 * s;

double angle = Math.abs(hAngle - mAngle);

if (angle > 180)	// special case 2
  angle = 360 - angle;

System.out.println(angle);
```

## 10.7 Traverse

<img width="508" alt="Screen Shot 2020-04-03 at 12 47 50 pm" src="https://user-images.githubusercontent.com/1612112/78315652-5e493400-75a9-11ea-8f17-013551f43b6f.png">

```java
int[] _r = {-1, 1, 0, 0, -1, 1, -1, 1};
int[] _c = { 0, 0, -1, 1, 1, 1, -1, -1};
for(int k = 0; k < 8; ++k){             
    posR = i + _r [k];
    posC = j + _c [k];   
    if(posR >= 0 && posC >= 0 && posR < r && posC < c) { // boundary check
    }
}
```

## 10.8 Bitwise operation’s

```java
/* checking if an integer is a 2’s power */
/* 20 21 22 23 ……… */

public static boolean is_power_of_2(int n) {
     return (n & (n-1)) == 0;
} 
// 16 = 10000
// 15 = 01111
// 16 & 15 = 10000 & 01111 = 00000 
/* Special case for 0 handle it by checking manually */
```

```java
/* checking if an integer is an even or odd number */

if (( x & 1 ) == 0) {
 	 // even
}

if (( x & 1 ) != 0) {
 	 // odd
}

// 6 = 110
// 6 & 1 = 110 & 001 = 000
// 7 = 111
// 7 & 1 = 111 & 001 = 001
```

<img width="242" alt="Screen Shot 2020-04-03 at 12 51 14 pm" src="https://user-images.githubusercontent.com/1612112/78315823-d6aff500-75a9-11ea-9245-e827b8c6b51a.png">

Last bit of any even number is 0 and
Last bit of any odd number is 1

```java
// returns true if odd
public static boolean isOdd(int i) 
    return (i & 1) != 0;
```

/* the << and >> bit shift operators (Arithmetic shift) */

Shifting an integer left by n places is equivalent to multiplying or dividing that number by 2n

/* Right Shift [Divide by powers of two] */
The >> operator shifts the bits of the left operand to the right by the number of places specified by the right operand. The low-order bits of the left operand are shifted away and are lost. The high-order bits shifted in are the same as the original high-order bit of the left operand. In other words, if the left operand is positive, zeros are shifted into the high-order bits. If the left operand is negative, ones are shifted in instead. This technique is known as sign extension; it is used to preserve the sign of the left operand.

```
10 >> 1      // 00001010 >> 1 = 00000101 = 5 = 10/2
27 >> 3      // 00011011 >> 3 = 00000011 = 3 = 27/8
-7 >> 2      // 11111111111111111111111111111001 >> 2                                         = 11111111111111111111111111111110 = -7/4 = -2 (why)
```

/* Left Shift [Multiply by powers of two] */
The << operator shifts the bits of the left operand left by the number of places specified by the right operand. High-order bits of the left operand are lost, and zero bits are shifted in from the right. 

```
10 << 1    // 00001010 << 1 = 00010100 = 20 = 10 * 2
7 << 3     // 00000111 << 3 = 00111000 = 56 = 7 * 8
-1 << 2    // 11111111111111111111111111111111 << 2 
              = 11111111111111111111111111111100 = -1 * 4 = -4 
```

/* Unsigned Right Shift (>>>) */
This operator is like the >> operator, except that it always shifts zeros into the high-order bits of the result, regardless of the sign of the left-hand operand. This technique is called zero extension; it is appropriate when the left operand is being treated as an unsigned value (despite the fact that Java integer types are all signed). 

```
-7 >>> 2     // 11111111111111111111111111111001 >>> 2
                001111111111111111111111111110 = 1073741822
```


/* add Two numbers without carry */

<img width="851" alt="Screen Shot 2020-04-03 at 1 00 06 pm" src="https://user-images.githubusercontent.com/1612112/78316318-11665d00-75ab-11ea-9b1e-73228d7df7ab.png">

/* How Java Store Negative Numbers */
Let us take a negative number for example, -7.
int a = -7; //declaration
The bit representation will be in 2’s complement form.
Steps to find 2’s Complement.
Take binary representation of positive value (in this case, it is 7)
0000 0000 0000 0000 0000 0000 0000 0111
Take 1’s Complement of it.
(Note: 1’s complement is calculated by inverting 1s with 0s and 0s with 1s.
1111 1111 1111 1111 1111 1111 1111 1000 
Now add 1 to 1’s Complement to get 2’s complement.
1111 1111 1111 1111 1111 1111 1111 1001
Therefore, -7 is stored as (1111 1111 1111 1111 1111 1111 1111 1001).


## 10.9 Parentheses Balance check using Stack

```java
boolean b = true;
for(int i = 0; i < line.length(); ++i){
	c = line.charAt(i);
	if(line.charAt(i) == ('(') || line.charAt(i) == ('[')){
		s.push(""+c);
	}else if (line.charAt(i) == (')') || line.charAt(i) == (']') ){
		if(s.size() != 0){
			temp = s.pop();
			if( (temp.equals("(" ) && c != ')') || (temp.equals("[" )&& c != ']')){
				b = false;
				break;
			}
		}else{
			b = false;
			break;
		}
	}
}

if(b  && s.size() == 0)
	System.out.println("Yes");
else
	System.out.println("No");
```
## 10.10 Given number 1 to N, how many steps need to make them zero by subtract a positive number in every step [ O log2(n) ]

```
1 2 3 [given]
1 0 1 [subtract 2] [step 1]
0 0 0 [subtract 1] [step 2]

1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 8 [subtract 8] [step 1]
1 2 3 0 1 2 3 0 1 2 3 0 1 2 3 4 [subtract 4] [step 2]
1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 2 [subtract 3] [step 3]
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2 [subtract 1] [step 4]
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 [subtract 2] [step 5]
```

```java
/ * The idea is in each step chose a number that will cut most of them and subtract most so that’s why we don’t choose 1 for step one, in step one 1 can be subtracted from 16 numbers but the subtracted value is not much as 8. It is trivial that the middle one has that ability in any step. If we look into deep the step number are log_2⁡n as we can easily see that at each step the problem size getting half as the other half is the mirror of the first half so we can easily ignore them */ 

writer.printf("%.0f",Math.floor (Math.log10(num) / Math.log10(2)) + 1);
```

## 10.11 Hangman Judge [ O (n  + k ) ]

```java
public static boolean shadow [] = new boolean [30];
    
public static String make (String s) {
        
    Arrays.fill(shadow, false);
        
    String ans = "";
    for(int i = 0; i < s.length(); ++i) {
        if(shadow[s.charAt(i) - 97] == false)
            ans += s.charAt(i);
            shadow[s.charAt(i) - 97] = true;
        }
        return ans;
}
```

```
Input
xannaaapqlppppppllllllllllxxxxx

Output
xanpql
```

```
/* the idea is to maintain the input order and only take the first occurrence letter and form the output string */
/* it can be done with HashMap or TreeSet [O (n log n)] */
```


## 10.12 Compute b^p and (b^p) % m [ O log(p) ]

```java
static int prilt(int b, int p) {
        
        if(p == 0) 
            return 1; 
        
        int a = Prilt(b, p / 2);
        a = a * a;
        
        if((p & 1) == 1)
            a = a * b;
        
        return a;   
}
```

```java
// use BigInt modPow() method
static int mp(int b, int p, int m) {
	
    if(p == 0)
        return 1 % m;
        
    int a = MP(b, p/2, m);
		
    a = (a * a) % m;
        
    if((p & 1) == 1) 
        a = (a * b) % m;
        
     return a;   	
}
```

Be careful about intermediate overflow

```java
long Prilt (long b, long p) {
        long a = 1;
        
        while (p > 0) {
            if((p & 1) == 1)
                a = (a * b);
            p >>= 1;
            b = (b * b);
        }
        return a; 
}
```

```java
// use BigInt modPow() method
long mp (long b, long p, long m) {
        long a = 1;
        
        while (p > 0) {
            if((p & 1) == 1)
                a = (a * b) % m;
            p >>= 1;
            b = (b * b) % m;
        }
        return a; 
}
```
## 10.13 Merge [ O (n + m) ]

// Assume, that both arrays are sorted in ascending order and we want resulting array to maintain the same order. Algorithm to merge two arrays A[0..m-1] and B[0..n-1] into an array C[0..m + n-1] is as following: size of C array must be equal or greater than sum of A and B arrays' sizes 

<img width="333" alt="Screen Shot 2020-04-03 at 1 12 06 pm" src="https://user-images.githubusercontent.com/1612112/78316959-bf263b80-75ac-11ea-88c8-3512b2e36b3c.png">

```java
public void merge(int[] A, int[] B, int[] C) { 
    int i, j, k, m, n, p; 
    i = j = k = 0; 
    m = A.length; // size
    n = B.length; // size
    while (i < m && j < n) { 
        if (A[i] <= B[j]) { 
            C[k] = A[i]; 
            i++; 
        } else { 
            C[k] = B[j]; 
            j++; 
        } 
        k++; 
    } 
    if (i < m) { 
        for (p = i; p < m; p++, k++) 
            C[k] = A[p]; 
    } else { 
        for (p = j; p < n; p++, k++)  
            C[k] = B[p]; 
    } 
}
```

## 10.14 How many squares are there in a n by n square grid  [ O (n) ]

There are 5 squares in a 2 × 2 grid

<img width="797" alt="Screen Shot 2020-04-03 at 1 12 55 pm" src="https://user-images.githubusercontent.com/1612112/78317009-dcf3a080-75ac-11ea-90f6-3bf5d1b2d9c7.png">

```java
public static long squares [] = new long [105];
public static void gen () {
    squares [1]  = 1 * 1;
    for(int i = 2; i <= 100; ++i) 
       squares [i] = squares [i - 1] + (i * i); 
}
```

```
// for 5 × 5
1^2 + 2^2 + 3^2 + 4^2 +5^2
= 1 + 4 + 9 + 16 + 25
= 55
```

```java
public static long squares [] = new long [105];
public static void gen () {
	long di = 3, i2 = 1;
	squares [1]  = i2;
	for(int i = 2; i <= 100; ++i) {
		i2 += di;
		di += 2;
		squares [i] = squares [i - 1] + i2; 
	}
}
```

## 10.15 Maximum contiguous subsequence sum [ 1D, 2D ]

Kadane's Algorithm [For one-dimensional sequence] [O (n)]

```java
runSum = 0;
max = -1;
while(t-- > 0) {
	runSum += sc.nextInt();
	if (runSum > max)
		max = runSum;
	if(runSum < 0)
		runSum = 0;
}
if(max <= 0)
	System.out.println("Losing streak.");
else
	System.out.println("The maximum winning streak is "+ max +".");
```

```
Kadane's Algorithm(array[1..n])
begin
    (maxSum, maxStartIndex, maxEndIndex) := (-INFINITY, 0, 0)
    currentMaxSum := 0
    currentStartIndex := 1
    for currentEndIndex := 1 to n do
        currentMaxSum := currentMaxSum + array[currentEndIndex]
        if currentMaxSum > maxSum then
            (maxSum, maxStartIndex, maxEndIndex) := 
			(currentMaxSum, currentStartIndex, currentEndIndex)
        endif

        if currentMaxSum < 0 then
            currentMaxSum := 0
            currentStartIndex := currentEndIndex + 1
        endif
    endfor

    return (maxSum, maxStartIndex, maxEndIndex)
end
```

## 10.16 McNuggets

values of a, b, and c such that
6a + 9b + 20c = n

```
def McNuggets(n):
    """
    n is an int

    Returns True if some integer combination of 6, 9 and 20 equals n
    Otherwise returns False.
    """
    for six in range(n/6 + 1):
        for nine in range(n/9 + 1):
            for twenty in range(n/20 + 1):
                if 6*six + 9*nine + 20*twenty == n:
                    return True
    return False
```
