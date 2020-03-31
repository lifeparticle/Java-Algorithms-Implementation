# 7. Combinatorics


## 7.1 nCr

TODO

## 7.2 nPr

TODO

## 7.3 Kth Permutation

TODO

## 7.4 Determine how many digits in n factorials using log

```java
public static double countDigit(long a) {
     double sum;
     long i;
     if(a == 0) 
	 return 1;
     else {
        sum = 0;
        for(i = 1; i <= a; ++i)
            sum += Math.log10(i); 
        return Math.floor(sum) + 1;
}
double sum;
long n;
n = sc.nextLong();
sum = count_digit(n);
System.out.printf("%.0f\n",sum);
```

```java
// digitCount array conatins 1! to 10000000! digit count
public static double digitCount [] = new double [10000001];
public static void countDigit() {  
    double sum;
    int i;
    sum = 0;
    for(i = 1; i <= 10000000; ++i) {
        sum += Math.log10(i); 
        digitCount [i] =  Math.floor(sum) + 1;
    }
}
```

## 7.5 Determine how many digits in nCr using log

```java
int n,k;
double digit;
long i,j;
n = sc.nextInt();
k = sc.nextInt();
digit = 0;         
if(k > n - k)
   i = k + 1;
else
   i = n - k + 1;         
for (j = 1; i <= n; i++,j++)
    digit += (Math.log10 (i) - Math.log10 (j));
digit = Math.floor(digit) + 1;
System.out.printf("%.0f\n",digit);
```

## 7.6 Determine how many digits in a number [ O log (n) ]

```java
double digit = Math.log10(num);
digit = Math.floor(digit) + 1;
```

## 7.7 Determine how many times digit d occurs from 1 to n

TODO

## 7.8 Digit Occurrence Count in a number

TODO

## 7.9 Josephus Ring Survivor [ O (n) ]

```java
// Using Queue
ArrayDeque<Integer> Q = new ArrayDeque<Integer>();
    Q.clear();
    for(int i = 1; i <= n; ++i)
        Q.addLast(i);
    int i = 1;
    int gap = 2;
    int temp = 0;

    while(true) {
        if(Q.size() == 1)
            break;
        if(i != gap) {
            temp =  Q.removeFirst();
            Q.addLast(temp); 
            ++i;
        }
        if(i == gap) {
            temp = Q.removeFirst(); 
            i = 1;
        }
    }
    temp =  Q.removeFirst();
    System.out.println(temp);
}
```

## 7.10 Number of ways 

### How many different ways you can give m elements to n people. You can give nm ways.

### If there are ‘a’ ways to do one thing and ‘b’ ways to do another thing, then there are 
‘a’  ‘b’ ways to do these two things in succession.

### How many different ways you can rearrange the letters in a word. The number of ways to arrange a word of length d is: 

```
d! / (nA!  nB!  nC!  …) 
```

Where nX is the number of times the letter X appears in the word

HAPPY = 5!\2!  = 120\2 = 60

[As P appears two times, it is trivial that we don’t divide by 1! For other letters☺]

### How many different pairs you can create with N elements.

N  (N-1) / 2

```java
1, 2, 3, 4, 5 (N = 5)
(1, 2), (1, 3), (1, 4), (1, 5)
(2, 3), (2, 4), (2, 5)
(3, 4), (3, 5)
(4, 5)
5  (5-1)/2 = 10
```

### How many ways 2 queens can attack in n  m chess board

1. For horizontal attack = row  column  (column – 1)
2. For vertical attack = column  row  (row – 1)
3. For diagonal attack =;
