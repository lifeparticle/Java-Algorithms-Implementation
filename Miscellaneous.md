# 19. Miscellaneous

## 19.1 Pictures

<img width="523" alt="Screen Shot 2020-04-09 at 8 11 57 pm" src="https://user-images.githubusercontent.com/1612112/78884505-623fef00-7a9e-11ea-977f-8a82b965b497.png">

## 19.2 Contest Time Errors

### 1. Print a blank line between datasets. Means no blank line after last output.

<img width="213" alt="Screen Shot 2020-04-09 at 8 13 19 pm" src="https://user-images.githubusercontent.com/1612112/78884634-9ca98c00-7a9e-11ea-8a1e-447b02dfcd9f.png">


### 2. For floating calculation remember the following things

```
11/7=1 [Integer division][Yields wa]
11.0/7 = 1.5714285714285714 [11/7.0  or  11.0/7.0]
```


### 3.	0-indexing and 1-indexing

### 4.	Run time errors

a.	divide by zero [Arithmetic Exception]

b.	sqrt(-ve or < 0) [NaN]

c.	Array indexing (-ve) [Array Index Out Of Bounds Exception]

### 5. Overflow

a.	sqrt(a*b*c*d) instead of sqrt(a*b)*sqrt(c*d)

b.	intermediate value overflow

c.	double is reliable for upto 15 digits, long 18 digits, int 9 digits.

d.	exp, log, log10, sqrt, cbrt math functions are returns values in double 

e.	use BigInteger for big number calculation

### 6. Don’t optimize too much, it may lead you wa (avoid clever programming tricks)

### 7. Try to avoid initialization of a same variable repetitively.

### 8. When working with large numbers, watch out for overflow, it's a silent killer. 
    // long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;

### 9. The lowercase letter el (l) and the digit 1 are nearly identical, so don’t use el (l) as a variable name

### 10. Avoid mixed-type computations 

### 11.	Avoid Unicode escapes except where they are necessary.

### 12. Double and BigDecimal

```java
double a = 2;                               // 2.0                                
double b = 2.0;                             // 2.0
        
BigDecimal c = BigDecimal.valueOf(2);      // 2 
BigDecimal d = BigDecimal.valueOf(2.0);    // 2.0
```

BigDecimal.equals and BigDecimal.compareTo() == 0 give different results. equals considers two BigDecimal objects equal only if they are equal in value and scale (thus 2.0 is not equal to 2.00 when compared by this method). Two BigDecimal objects that are equal in value but have a different scale (like 2.0 and 2.00) are considered equal by compareTo.

### 13. Newline

```java
// New Line Scheme for AC
System.out.println();
writer.println();    // PrintWriter writer;
writer.printf("\n"); // PrintWriter writer;
writer.newLine();    //  BufferedWriter writer;
writer.write("\n");  // BufferedWriter writer;

// New Line Scheme for WA
System.out.println("\n");
writer.write("\n\r"); //  BufferedWriter writer;
writer.write("\r\n"); //  BufferedWriter writer;
```
