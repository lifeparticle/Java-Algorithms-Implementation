# 6. Fibonacci Series

## 6.1 Brick Wall Patterns [ O(n) ] [ DP ]

Brick Numbers

<img width="874" alt="Screen Shot 2020-03-30 at 1 36 40 pm" src="https://user-images.githubusercontent.com/1612112/77870423-1ebed700-728d-11ea-806e-7c05026bc7d2.png">

For 1 bricks there is1 pattern
For 2 bricks there are 2 patterns
For 3 bricks there are 3 patterns
For 4 bricks there are 5 patterns

This is a Fibonacci Series.

```java
long fibo [] = new long [51];
fibo [1] = 1;
fibo [2] = 2;
for(int i = 3; i < fibo.length; ++i)
	fibo [i] = fibo [i - 1] + fibo [i - 2];
```

## 6.2 Determine the number of n-bit sequences that contain no adjacent 1’s [ O(n) ] [ DP ]

For example, for n = 3 the answer is 5 (sequences 000, 001, 010, 100, 101 are acceptable while 011, 110, 111 are not)

```
0	1			[n = 1]		[2]


0	0			[n = 2]		[3]
0	1
1	0
1	1

0 	0	0		[n = 3]		[5]
0	0	1
0	1	0
0	1	1
1	0   	0
1	0	1
1	1	0
1	1	1
```

```java
long fibo [] = new long [51];
fibo [1] = 2;
fibo [2] = 3; 
for(int i = 3; i < fibo.length; ++i)
	fibo [i] = fibo [i - 1] + fibo [i - 2];
```

## 6.3 Bee [ Modified version of Fibonacci sequence ] [ O(n) ] [ DP ]

| Input(Year) | Output(Male) | Output(Total)  |
|---|---|---|
| 0 | 0 | 1 |
| 1 | 1 | 2 |
| 2 | 2 | 4 |
| 3 | 4 | 7 |
| 4 | 7 | 12 |

From analyzing the input & output we could figure out an output sequence 0, 1, 2, 4, 7 …..
(3rd number = 1st number + 2nd number + 1) that is nothing but a modified Fibonacci series.
For this series the recursive definition should be 

<img width="808" alt="Screen Shot 2020-03-30 at 1 46 50 pm" src="https://user-images.githubusercontent.com/1612112/77870360-ee773880-728c-11ea-830a-6813c9888bba.png">

```java
long fibo[] = new long[60];
fibo [0] = 0;
fibo [1] = 1;

for(int i = 2; i < fibo.length; ++i)
	fibo [i] = fibo [i - 1] + fibo [i - 2] + 1;

fibo [year], For finding out the Output (Male)
fibo [year+1], For finding out the Output(Total)
```
