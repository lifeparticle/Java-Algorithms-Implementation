# 12. Numerical Methods

## 12.1 Root Finding Methods

<img width="715" alt="Screen Shot 2020-04-05 at 4 43 06 pm" src="https://user-images.githubusercontent.com/1612112/78468572-8e850400-775c-11ea-92f5-33a02bc84402.png">

```java
double bisection(){
  double lo = 0, hi = 1;
  while (lo + EPS < hi){
    double x = (lo+hi)/2;
    if (f(lo) * f(x) <= 0){
      hi = x;
    } else {
      lo = x;
    }
  }
  return (lo+hi)/2;
}
```

```java
double secant(){
  if (f(0)==0) return 0;
  for (double x0=0, x1=1; ; ){               // initial guess for x0 and x1
    double d = f(x1)*(x1-x0)/(f(x1)-f(x0));  // compute delta
    if (Math.abs (d) < EPS) return x1;       // the guess is accurate enough
    x0 = x1;
    x1 = x1 - d;
  }
}
```

```java
double fd(double x){ // the derivative of function f
  return -p*exp(-x) + q*cos(x) - r*sin(x) + s/(cos(x)*cos(x)) + 2*t*x;
}
 
double newton(){
  if (f(0)==0) return 0;
  for (double x=0.5; ;){             	   // initial guess x = 0.5
    double x1 = x - f(x)/fd(x);      	   // x1 = next guess
    if (Math.abs(x1-x) < EPS) return x;  // the guess is accurate enough
    x = x1;
  }
}
```

https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1282

```java
import java.util.*;
public class P10341 {
    public static int p,q,r,s,t,u;
    public static double EPS = 1e-7;
    public static double f(double x){
        return p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*x*x+u;
    }
    public static double bisection(){
        double lo = 0, hi = 1;
        while (lo + EPS < hi){
            double x = (lo+hi)/2;
            if (f(lo) * f(x) <= 0)
                hi = x;
              else 
                lo = x;
        }
        return (lo+hi)/2;
    }
    public static void main (String args []) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNextInt()) {
            p = sc.nextInt();q = sc.nextInt();r = sc.nextInt();
            s = sc.nextInt();t = sc.nextInt();u = sc.nextInt();
            if (f(0) * f(1) > 0) 
                System.out.println("No solution");
              else 
                System.out.printf("%.4f\n", bisection());
        }
    }
}
```

## 12.2 Big Integer Square Root [ Newton-Raphson Method ] 

```java
public static BigInteger sqrt(BigInteger A)  {

       BigInteger Xo;
        BigInteger bit = BigInteger.valueOf(A.bitLength());
        Xo = A.shiftRight((bit).shiftRight(1).intValue()); 
        BigInteger X1;
        boolean PSN = false; // perfect square number
        
        while(true) {
            X1 = (Xo.add(A.divide(Xo))).shiftRight(1);
            Xo = X1;
            if((Xo.multiply(Xo)).compareTo(A) <= 0)
                break;
        }   
        if (Xo.multiply(Xo).compareTo(A) == 0)
            PSN = true;
        return Xo; 
}
```

## 12.3 Interpolation and Extrapolation with Equal Intervals [ Newton’s Formula ] [ poly(n) ]

<img width="765" alt="Screen Shot 2020-04-05 at 4 46 27 pm" src="https://user-images.githubusercontent.com/1612112/78468624-081cf200-775d-11ea-989d-dfdf8dd6dd44.png">

We can see that at ∆^2y we have same values (the second differences are constant); hence, the tabulated function represents a polynomial of the second degree. 

<img width="195" alt="Screen Shot 2020-04-05 at 4 47 55 pm" src="https://user-images.githubusercontent.com/1612112/78468664-5f22c700-775d-11ea-9605-b34fa0795b24.png">

So in this individual case we can use the general formula of the polynomial other than Newton’s formula.

<img width="583" alt="Screen Shot 2020-04-05 at 4 48 11 pm" src="https://user-images.githubusercontent.com/1612112/78468666-61852100-775d-11ea-869a-68bfad43bda7.png">

<img width="656" alt="Screen Shot 2020-04-05 at 4 48 48 pm" src="https://user-images.githubusercontent.com/1612112/78468668-63e77b00-775d-11ea-84ec-51f4b6833bd7.png">

## 12.4 Interpolation and Extrapolation with Unequal Intervals [ Newton & Lagrange Formula ] 

<img width="618" alt="Screen Shot 2020-04-05 at 4 51 32 pm" src="https://user-images.githubusercontent.com/1612112/78468713-bf196d80-775d-11ea-9382-49caa122c023.png">

### Lagrange’s Formula:

// find dependent variable for given independent variable

<img width="662" alt="Screen Shot 2020-04-05 at 4 53 14 pm" src="https://user-images.githubusercontent.com/1612112/78468748-03a50900-775e-11ea-8050-2f60120d4a86.png">

// find independent variable for given dependent variable

<img width="665" alt="Screen Shot 2020-04-05 at 4 53 19 pm" src="https://user-images.githubusercontent.com/1612112/78468749-07389000-775e-11ea-8e6a-ca8970af3960.png">

### Newton’s General Formula:

<img width="665" alt="Screen Shot 2020-04-05 at 4 53 25 pm" src="https://user-images.githubusercontent.com/1612112/78468752-0a338080-775e-11ea-8059-3ae1b109a7b9.png">

```java
/* Lagrange */

public static double xToY (double x [], double y [], double xx) {
        
    int i, j , size = x.length;
    double sum = 0, term;
        
    for(i = 0; i < size; ++i) {
        term = y[i];
        for(j = 0; j < size; ++j) {
            if(i != j)
                term *= (xx - x [j]) / (x[i] - x[j]); 
        }
        sum += term;
    }
    return sum;
}
    
public static double yToX (double x1 [], double y1 [], double yy) {
        
    int i, j, size = x1.length;
    double term, sum = 0 ;
        
    for(i = 0; i < size; ++i){
        term = x1[i];
        for(j = 0; j < size; ++j){
            if(i != j)
                term *= (yy - y1[j]) / (y1[i] - y1[j]);
            }
            sum += term ; 
    }
    return sum;
}
```

## 12.5 Factorial [ Stirling's approximation ]

<img width="202" alt="Screen Shot 2020-04-05 at 4 55 23 pm" src="https://user-images.githubusercontent.com/1612112/78468789-541c6680-775e-11ea-84de-7e59e19fcc04.png">

```java
/* digit count when n >= 13, not accurate for digit count */        

 double digits = Math.floor( ( Math.sqrt( ( Math.log10(2) + Math.log10(Math.PI) + Math.log10(n) ) ) ) + (n * Math.log10 (n) - n * Math.log10(Math.E))) + 1;

/**
 * GAMMA FUNCTION
 * gamma function for approximating factorials.
 * z only works for 1 <= z <= 142 but also defined for non-integers.
 * returns approximation to (z-1)!
 * author Roedy Green
*/

/* for answer of n! Ceil the return value */
/* Send it like gamma (double n+1) */

public static double gamma (double z) {
   return Math.exp( -z ) * Math.pow( z, z - 0.5 ) * Math.sqrt( 2 * Math.PI ) * ( 1 + 1 / ( 12 * z ) + 1 / ( 288 * z * z ) - 139 / ( 51840 * z * z * z ) - 571 / ( 2488320 * z * z * z * z ));
}
```
## 12.6 Descartes' rule of signs

•	In a polynomial equation P(x)= 0, the terms being written in the order of power of x, the number of positive roots cannot exceed the number of changes of sign (+ to - & vice versa) in the coefficients of P(x), and the negative roots cannot exceed the number of changes of sign P(-x). The number of positive and negative roots of the polynomial is either equal to the number of sign differences between consecutive nonzero coefficients, or is less than it by a multiple of 2.

```
P (x) = x^5 - 3x^3 + 8x – 10    ------------>  3, 1 (+-, -+, +-)

P (-x) = -x^5 + 3x^3 - 8x – 10  ------------>  2, 0 (-+, +-, --)
```

<img width="564" alt="Screen Shot 2020-04-05 at 5 01 55 pm" src="https://user-images.githubusercontent.com/1612112/78468904-43b8bb80-775f-11ea-8925-67abd458464b.png">

•	If P(x) is continuous in [a, b], then if P(a) & P(b) have opposite signs, there exists an odd number of real roots of the equation P(x) = 0 in (a, b). If P(a) & P(b) have same sign, then there exists no (zero) real root or an even number of real roots in (a, b). 

<img width="597" alt="Screen Shot 2020-04-05 at 4 58 22 pm" src="https://user-images.githubusercontent.com/1612112/78468834-acebff00-775e-11ea-8cef-fc90f0792d7b.png">
