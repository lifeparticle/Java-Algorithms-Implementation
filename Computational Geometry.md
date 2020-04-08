# 15. Computational Geometry

## 15.1 Basics

•	The great-circle distance or orthodromic distance is the shortest distance between any two points on the surface of a sphere measured along a path on the surface of the sphere (as opposed to going through the sphere's interior).

•	The constant PI (π) is the ratio of any circle’s circumference to its diameter.

•	Diameter = the maximum distance between two points on the periphery of the circle

•	Perimeter is the distance around a two-dimensional shape, or the measurement of the distance around something; the length of the boundary.

| shape               | formula                | variables                                                                                                                  |
|---------------------|------------------------|----------------------------------------------------------------------------------------------------------------------------|
| circle              | 2πr                    | Where r is the radius.                                                                                                     |
| triangle            | a + b + c              | Where a, b and c are the lengths of the sides of the triangle.                                                             |
| square/rhombus      | 4a                     | where a is the side length                                                                                                 |
| rectangle           | 2 (h + w)              | where h is the height and  w is the width                                                                                  |
| equilateral polygon | na                     | Where n is the number of sides and a is the length of one of the sides.                                                    |
| regular polygon     | 2nb                    | Where n is the number of sides and b is the distance between center of the polygon and one of the vertices of the polygon. |
| general polygon     | <img width="226" alt="Screen Shot 2020-04-08 at 2 49 58 pm" src="https://user-images.githubusercontent.com/1612112/78745692-3e01e680-79a8-11ea-95d2-61505b9f46de.png"> | Where    is the length of the i-th (1st, 2nd, 3rd ... n-th) side of an n-sided polygon.                                    |

## 15.2 Triangle

```java
public class Geo_Triangle {
    public static double a, b, c;
    public static double alpha, beta, gama;


    // A = √(s*(s-a)*(s-b)*(s-c))
    // s = (a+b+c)/2, s is called the semi perimeter, or half the triangle's perimeter


    // given all three sides
    // s = half_perimeter
    double area_heron (double a, double b, double c, double s) { 
        return Math.sqrt(s * ((s - a) * (s - b) * (s - c)) );
    }

    // A = (4 / 3.0) * (√(s*(s-ma)*(s-mb)*(s-mc)))
    // s = (ma+mb+mc)/2,  given the length of three medians of a triangle, ma, mb, mc

    // ma, mb, mc are length of three medians
    double area_medians (double ma, double mb, double mc, double s) { 
        return (4.0 * Math.sqrt(s * (s - ma) * (s - mb) * (s - mc))) / 3.0;
    }
    
    // A = 1/2 * base * height
    // given Base and altitude
    // b = base and h = height
     double area_basic (double b, double h) { 
        return 0.5 * b * h;
    }
    
    // A = a² sin B sin C / 2 sin⁡A
    
    // sin formula
    // given two angles and a side
    double area_sin (double angleA, double angleB, double a) { 
        return (((a*a)*Math.sin(angleA)*Math.sin(angleB)) / (2.0*Math.sin(angleA))); 
    }

    // two sides and included angle (Side-angle-side method)
    // a, b are the two known sides and theta is the included angle
    public static double sAs (double a, double b, double theta) { 
        return 0.5 * a * b * Math.sin(angle);
    }
    
    // any of equal side a and theta is the included angle
    public static double area_isosceles_triangle (double a, double theta) {
        return 0.5 * a * a *  Math.sin(angle);   
    }
    
    // a is the length of one side of the triangle
    public static double area_equilateral_triangle (double a) {
        return (Math.sqrt(3) / 4) * a * a;   
    }     
    double perimeter (double a, double b, double c) {
        return a + b + c;
    }
    double half_perimeter (double a, double b, double c) {
        return (a + b + c) / 2.0;
    }
    
    
    double medians_perimeter (double ma, double mb, double mc) {
        return (ma + mb + mc) / 2.0;
    }
    
    // returns true if the tringle is valid false if not
    boolean is_valid_triangle (double a, double b, double c) {
        return ((a + b > c) && (a + c > b) && (b + c > a));
    }
    
    void make_lengths_of_three_side (double x1, double y1, double x2, double y2, double x3, double y3) {
        a = Math.sqrt(Math.pow( (x2 - x1),2) + Math.pow((y2 - y1),2) );
        b = Math.sqrt(Math.pow( (x3 - x2),2) + Math.pow((y3 - y2),2) );
        c = Math.sqrt(Math.pow( (x3 - x1),2) + Math.pow((y3 - y1),2) );
    }
    
    void three_angle_cosine_rule (double a, double b, double c) {
        alpha = Math.acos( ((b * b) + (c * c) - (a * a)) / (2.0 * b * c) );
        beta = Math.acos( ((c * c) + (a * a) - (b * b)) / (2.0 * c * a) );
        gama = Math.acos( ((a * a) + (b * b) - (c * c)) / (2.0 * a * b) );
    }

    // triangle inside the circle, returns the radius of the outer circle
    double triangleInCircle (double a, double b, double c, double area) {
        return a * b * c / (4.0 * area); 
    }
 
    // circle inside the triangle, returns the radius of the inner circle
    double CircleInTriangle (double a, double b, double c) {
         return area / (0.5 * perimeter); 
    }
    
    public static void main (String args []) {  
    }
}
```

<img width="411" alt="Screen Shot 2020-04-08 at 2 55 01 pm" src="https://user-images.githubusercontent.com/1612112/78745956-f9c31600-79a8-11ea-8f7f-540e75bb3c42.png">

•	Equilateral Triangle: The equilateral triangle has all three sides equal in length. The three equal angles always measure 60°.
•	Isosceles Triangle: The isosceles triangle has two sides equal and two equal angles.
•	Scalene Triangle: The scalene triangle has no equal sides or angles.

<img width="544" alt="Screen Shot 2020-04-08 at 2 55 08 pm" src="https://user-images.githubusercontent.com/1612112/78745959-fdef3380-79a8-11ea-9aca-30d8ffd03db6.png">

•	Acute Angle Triangle: This triangle has all the three angles less than 90°.
•	Right Angle Triangle: The right angle triangle has one angle that measures exactly 90°
•	Obtuse Angle Triangle: The obtuse triangle has one angle that measures more than 90°.

<img width="521" alt="Screen Shot 2020-04-08 at 2 55 13 pm" src="https://user-images.githubusercontent.com/1612112/78745968-021b5100-79a9-11ea-93f5-10fafe2cf9ed.png">


Basic Property of a Triangle:

1.	The sum of any two sides of a triangle must be greater than the third side of a triangle.

A + B > C and A + C > B and B + C > A

If the three lengths are sorted, with A being the smallest and C the largest, then we can simplify the check to just (A + B > C)

2.	The longest side of a triangle is opposite the largest angle of a triangle. Conversely, the smallest side of a triangle is opposite the smallest angle of a triangle

3.	Sum of Angles is 180°

4. 

<img width="411" alt="Screen Shot 2020-04-08 at 2 55 01 pm" src="https://user-images.githubusercontent.com/1612112/78745956-f9c31600-79a8-11ea-8f7f-540e75bb3c42.png">

Let a, b and c is the lengths of the legs of a triangle opposite angles A, B and C. Then the law of cosines states 

```
a² = b² + c² – 2 * b * c * cosA
b² = a² + c² – 2 * a * c * cosB
c² = a² + b² – 2 * a * b * cosC
```
				
Solving for the cosines yields the equivalent formulas

```
cosA = b² + c² - a² / 2bc
cosB = c² + a² - b² / 2ca
cosC = a² + b² - c² / 2ab
```

5. The Pythagorean Triple is a triple with three positive integers a, b and c such that 
a² + b²= + c². Such a triple is commonly written as (a, b, c). A well-known example is 
(3, 4, 5). If (a, b, c) is a Pythagorean triple, then so is (ka, kb, kc) for any positive integers k. 
Pythagorean Triples describe the integer lengths of the three sides of Right Triangle.

6. Relation between the radius and triangle inside the circle

<img width="196" alt="Screen Shot 2020-04-08 at 3 53 24 pm" src="https://user-images.githubusercontent.com/1612112/78749285-47dc1780-79b1-11ea-8b7a-98a437023fe5.png">

<img width="360" alt="Screen Shot 2020-04-08 at 3 54 25 pm" src="https://user-images.githubusercontent.com/1612112/78749299-50345280-79b1-11ea-856e-eab927545fbf.png">

7. Relation between the radius and circle inside the triangle

<img width="397" alt="Screen Shot 2020-04-08 at 3 53 53 pm" src="https://user-images.githubusercontent.com/1612112/78749296-4c083500-79b1-11ea-9a07-68ddaba8db26.png">

<img width="368" alt="Screen Shot 2020-04-08 at 3 54 32 pm" src="https://user-images.githubusercontent.com/1612112/78749306-53c7d980-79b1-11ea-8347-0f13670bcce4.png">

## 15.3 Circle

```java
public class GeoCircle {

    // Circumference = 2 * π * r  =  π * d

    public static double circumference (double r) {
        return 2.0 * Math.PI * r;
    }
    // Area = π * r²  =  1/4 * π * d²
    public static double area (double r) {
        return Math.PI * (r * r);
    }
    /* to check if a point is inside, outside or exactly at the borders of a circle, here p is the given point, c is the center and r is the radius */
    int inCircle(point p, point c, int r) {
		int dx = p.x – c.x, dy = p.y – c.y;
		int Euc = dx * dx + dy * dy, rSq = r * r;
		if (Euc < rSq) /* inside */
		   return 0; 
		if (Euc == rSq) /* boarder */
		   return 1;
		if (Euc == rSq) /* outside */
		   return 2;
    } 
    
    /* given 2 points on the circle (p1 and p2) and radius r of the corresponding circle, we can determine the location of the centers (c1 and c2) of two possible circles */
    /* to get the other center reverse p1 and p2 */
    // answer at point c
    boolean circle2PtsRad(point p1, point p2, double r, point c) {
        double d2 = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        double det = r * r / d2 - 0.25;
        if (det < 0.0) 
          return false;
        double h = Math.sqrt(det);
        c.x = (p1.x + p2.x) * 0.5 + (p1.y - p2.y) * h;
        c.y = (p1.y + p2.y) * 0.5 + (p2.x - p1.x) * h;
        return true; 
      }

    public static void main (String args []) {  
    }
}
```

Basic Property of a Circle:

1. বৃত্তের ব্যাস ভিন্ন যে কোন জ্যা এর মধ্যবিন্দু ও কেন্দ্রের সংযোজক রেখাংশ ঐ জ্যা এর উপর লম্ব এবং ঐ লম্ব জ্যা কে সমদিখন্ডিত করে.

OD ⟘ AB
AD = AB

<img width="287" alt="Screen Shot 2020-04-08 at 3 57 18 pm" src="https://user-images.githubusercontent.com/1612112/78749619-f2ecd100-79b1-11ea-9a68-2b9812a5cb8f.png">


2. If Circle centered at (a, b) in a 2D Euclidian space with radius r is the set of all points (x, y) such that (x-a)² + (y-b)² = r²

3. 

<img width="592" alt="Screen Shot 2020-04-08 at 4 00 11 pm" src="https://user-images.githubusercontent.com/1612112/78749663-0ef07280-79b2-11ea-807b-e2679344a8c1.png">


• Arc of a circle is defined as a connected section of the circumference c of the circle. Given the central angel α (angel with the vertex at the circles center) in degrees.

arc = α/360 × c
 
• Chord of a circle is defined a line segment whose endpoints lie on the circle (diameter is the longest chord in a circle). A circle with radius r and a central angle α (in degree) has the corresponding chord with length 

chord = √(2r²×(1- cos⁡α)) [Law of Cosines]

Another way to compute the length of chord given r and α is

chord = 2 × r × sin⁡(α)/2 [Trigonometry]

• Sector of a circle is defined as a region of the circle enclosed by two radiuses and an arc lying between the two radiuses. A circle with area A and a central angle α (in degree).

sector = α/360 × A

• Segment of a circle is defined as a region of the circle enclosed by a chord and an arc lying between the chords endpoints. The area of a segment can be found by subtracting area of an isosceles triangle with side’s r, r and chord-length (or if the chord length is not given then 0.5 * r * r *  Math.sin(α)) from the area of the corresponding sector.

segment = sector – area of an isosceles triangle

4. Circle through 2 points and radius

<img width="274" alt="Screen Shot 2020-04-08 at 4 01 11 pm" src="https://user-images.githubusercontent.com/1612112/78749733-30515e80-79b2-11ea-84be-fdb077d8344a.png">

## 15.4 Rectangle

```java
public class GeoRectangle {
    
    // P = 2l + 2w = 2(l + w)
    public static double perimeter (double le, double wi) {
        return 2.0 * (le + wi);
    }
    
    public static double area (double le, double wi) {
        return (le * wi);
    }
    
    public static double diagonalLength (double le, double wi) {
        return Math.sqrt((le * le) + (wi * wi));
    }
    
    public static void main (String args []) {  
    } 
}
```

## 15.5 Square

```java
public class GeoSquare {

    public static double perimeter (double a) {
        return (4.0 * a);
    }
    
    public static double area (double a) {
        return (a * a);
    } 
    
    public static void main (String args []) {  
    } 
} 
```

## 15.6 Trapezium

```java
public class GeoTrapezium { 
    
    // parallel edges of lengths w1 and w2 and a height h
    public static double area (double b, double h) {
        return 0.5 * (w1 + w2) * h;
    } 
    
    public static void main (String args []) {  
    } 
} 
```

## 15.7 Parallelogram

```java
public class GeoParallelogram { 
    
    public static double area (double b, double h) {
        return (b * h);
    } 
    
    public static void main (String args []) {  
    } 
} 
```

## 15.8 Sphere

```java
public class GeoSphere { 
    
    // Volume = 4/3 * π * r3
    public static double volume (double r) {
        return (4.0 / 3.0) * (Math.PI * (r * r * r));
    } 
    // Area = 4 * π * r2
    public static double area (double r) {
        return (4.0 * Math.PI * (r * r));
    }
    /* The spherical / geographical / great-circle distance between two cities p and q on earth with radius r, given (pLat, pLong) to (qLat, qLong)*/
    double gcDistance(double pLat, double pLong, double qLat, double qLong, double radius) {
    	pLat *= Math.PI / 180; pLong *= Math.PI / 180; // degree to radian
    	qLat *= Math.PI / 180; qLong *= Math.PI / 180; // degree to radian
    	return radius *  Math.acos(Math.cos(pLat)*Math.cos(pLong)*Math.cos(qLat)*Math.cos(qLong) + Math.cos(pLat)*Math.sin(pLong)*Math.cos(qLat)*Math.sin(qLong) + Math.sin(pLat)*Math.sin(qLat));
    }

    / * The Haversine formula for great-circle distance
    R = earth’s radius;
    Δlat = lat2 − lat1;
    Δlong = long2 − long1;
    a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2);
    c = 2.asin(√a);
    d = R.c; */
    
    double haversine (double pLat, double pLong, double qLat, double qLong) {
         double dlon = (qLong - pLong) * Math.PI / 180;
         double dlat = (qLat - pLat) * Math.PI / 180;
         double x = Math.pow (Math.sin(dlat/2), 2) + Math.cos(pLat * Math.PI / 180) * Math.cos(qLat * Math.PI / 180) *  Math.pow (Math.sin(dlon / 2), 2);
         double y = 2 * Math.asin(Math.min(1, Math.sqrt(x)));
         return EARTH_RAD * y;
    }
    
    double eucledianDistance(double pLat, double pLong, double qLat, double qLong, double  radius) {
        double phi1 = (90 - pLat) * Math.PI / 180;
        double theta1 = (360 - pLong) * Math.PI / 180;
        double x1 = radius * Math.sin(phi1) * Math.cos(theta1);
        double y1 = radius * Math.sin(phi1) * Math.sin(theta1);
        double z1 = radius * Math.cos(phi1);
        
        double phi2 = (90 - qLat) * Math.PI / 180;
        double theta2 = (360 - qLong) * Math.PI / 180;
        double x2 = radius * Math.sin(phi2) * Math.cos(theta2);
        double y2 = radius * Math.sin(phi2) * Math.sin(theta2);
        double z2 = radius * Math.cos(phi2);
        
        double dx = x1 - x2, dy = y1 - y2, dz = z1 - z2;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static void main (String args []) {  
    } 
}
```
    

## 15.9 Polygon

Basic Property of a Polygon:

<img width="420" alt="Screen Shot 2020-04-08 at 4 08 53 pm" src="https://user-images.githubusercontent.com/1612112/78750327-5b887d80-79b3-11ea-9e96-0a7c2422d06a.png">

Number of diagonals for any polygon

```
(n( n-3))/2 = Diagonals [where n = number of sides]
```

Relation between diagonals and n gon


<img width="207" alt="Screen Shot 2020-04-08 at 4 11 58 pm" src="https://user-images.githubusercontent.com/1612112/78750499-b4581600-79b3-11ea-93d3-16c1e81a50cf.png">


```java
double n = Math.ceil ((3 + Math.sqrt (9 + (8 * d))) / 2.0);
```

## 15.10 Cylinder

<img width="184" alt="Screen Shot 2020-04-08 at 4 26 13 pm" src="https://user-images.githubusercontent.com/1612112/78751496-b3c07f00-79b5-11ea-9c0c-49c1bfb9c3cf.png">

```java
public class Geo_Cylinder {
    
    // 2 * π * r * (r + h)
    public static double area (double h, double r) {
        return (2 * Math.PI * r * (r + h));
    } 
    
    // π * r2 * h
    public static double volume (double h, double r) {
        return (Math.PI * r * r * h);
    } 
    
    public static void main (String args []) {  
    } 
} 
```

1.  

```
Area = Area of top + Area of top bottom + Area of the side
     = π * r² + π * r² + 2 * π * r * h
     = 2 * π * r² + 2 * π * r * h
     = 2 * π * r * (r + h)
```

## 15.11 Cone

<img width="250" alt="Screen Shot 2020-04-08 at 4 26 19 pm" src="https://user-images.githubusercontent.com/1612112/78751503-b7ec9c80-79b5-11ea-8cc4-86e31f82aa76.png">

```java
public class Geo_=Cone {
    
    public static double area (double L, double r) {
        return (Math.PI * r * (r + L));
    } 
    
    public static double volume (double h, double r) {
        return ((1/3.0) * Math.PI * r * r * h);
    } 
    
    
    public static double lateralHeight (double h, double r) {
        return (Math.sqrt((r * r) + (h * h)));
    } 
    
    public static void main (String args []) {  
    } 
}
```

Basic Property of a Cone:

1. 

```
Area = Area of bottom + Area of the side 
        = π * r² + π * r * L 
        = π * r * (r + L)
```

## 15.12 Line

TODO

## 15.13 Basic Formula of Geometry

1. Euclidean distance: Given the two points (x1, y1) and (x2, y2), the distance between these points is given by the formula:

```
d = √(x_2-x_1)² + (y_2 - y_1)²
```

2. Convection degree to radian and vice versa

```java
double DEG_to_RAD(double d) { 
	return d * Math.PI / 180.0; 
}

double RAD_to_DEG(double r) { 
	return r * 180.0 / Math.PI; 
}
```

3. A sphere is divided into 360 degrees. The number space is divided into two halves, East and West in the case of longitude (vertical lines) and North and South in the case of latitude (horizontal lines). The maximum ranges are as follows: 


<img width="529" alt="Screen Shot 2020-04-08 at 4 34 26 pm" src="https://user-images.githubusercontent.com/1612112/78752112-d606cc80-79b6-11ea-92d5-1b0cb6d2e611.png">

Latitude and longitude (অক্ষাংশ এবং দ্রাঘিমাংশ)


### Conversion from DMS to Decimal Degree:
Given a DMS (Degrees, Minutes, Seconds) coordinate such as W87°43′41″)

•	Calculate the total number of seconds, 43′41″ = (43*60 + 41) = 2621 seconds.
•	The fractional part is total number of seconds divided by 3600. 2621 / 3600 = ~0.728056
•	Add fractional degrees to whole degrees to produce the final result: 87 + 0.728056 = 87.728056
•	Since it is a West longitude coordinate, negate the result.
•	The final result is -87.728056.

```
Longitude
180 W  = -180
180 E  =  180

Latitude
90 N   =  90
90 S   = -90
```

```java
// 44 16 0.00 N 76 30 0.00 W 43 41 0.00 N 79 38 0.00 W

pLat = ar[0] + (( ar[1] * 60 + ar[2]) / 3600);
if(ar[3].equals("S"))
	pLat *= -1;
pLong = ar[4] + ((ar[5] * 60 + ar[6])) / 3600);
if(ar[7].equals("W"))
	pLong *= -1;
qLat = ar[8] + ((ar[9] * 60 + ar[10])) / 3600);
if(ar[11].equals("S"))
	qLat *= -1;
qLong = ar[12] + ((ar[13] * 60 + ar[14])) / 3600);
if(ar[15].equals("W"))
	qLong *= -1;
```

### Conversion from Decimal Degree to DMS:
Given a decimal longitudinal coordinate such as -87.728055 it is trivial to convert it to DMS form. It will be necessary to know whether it is a latitudinal or longitudinal coordinate in order to fully convert it. The method is as follows:

• Subtract the whole number portion of the coordinate, leaving the fractional part. The whole number is the number of degrees. 87.728055 = 87 degrees.

• Multiply the remaining fractional part by 60. This will produce a number of minutes in the whole number portion. 0.728055 x 60 = 43.6833 = 43 minutes.

• Multiply the fractional part of the number of minutes by 60, producing a number of seconds. 0.6833 x 60 = 40.998 = 41 seconds. It is possible to count this as 40 seconds, truncating the decimal, round it to 41, or keep the entire number.

• Depending on whether the source number was a latitudinal or longitudinal coordinate, and the sign of the number, add the N/S/E/W specifier. The following table shows the possibilities:

```
  	  Type  Dir.    Sign    Test
•	  Lat.   N      +       > 0
•	  Lat.   S      -       < 0
•	  Long.  E      +       > 0
•	  Long.  W      -       < 0
```

## 15.14 Closest pair on 2D [ O (n log n) ]

The closest-pair problem is finding the two closest points in a set of n points. The brute force algorithm checks every pair of points, which will make it O (N²). We can avoid computing square roots by using squared distance. We compute the distances between all the n (n − 1) / 2 pairs of points.

<img width="250" alt="Screen Shot 2020-04-08 at 4 30 20 pm" src="https://user-images.githubusercontent.com/1612112/78751827-42cd9700-79b6-11ea-96e7-77639410265e.png">
Closest pair of points shown in red

```
Input
1 7
0 8
12 98
100 7
23 45
3 78
433 5
2 3
2 4
0 0

Output
Closest Pair Distance = 1.0
(x1, y1) (2.0, 3.0)
(x2, y2) (2.0, 4.0)
```

```java
// O (n^2) 
/* this code handles only integer points like 3 4 not floating points like 3.3 5.6 */
public class ClosestPair {
    public static void main (String args []) {
        Scanner sc = new Scanner (System.in);
        Points p [] = new Points [10];
        for(int i = 0; i < p.length; ++i)
            p [i] = new Points();
        for(int i = 0; i < p.length; ++i) {
            p [i].x = sc.nextInt(); p [i].y = sc.nextInt();
        }
        int ans [] [] = closestPairBF(p);
        System.out.println("Closest Pair Distance = " + Math.sqrt(ans [0][0]));
        System.out.println("(x1, y1) (" + p[ ans [0][1] ].x+", "+p[ans [0][1]].y+")");
        System.out.println("(x2, y2) (" + p[ ans [0][2] ].x+", "+p[ans [0][2]].y+")");
    }
    public static int [][] closestPairBF (Points [] p) {
        int min = Integer.MAX_VALUE, i, j, d, imin = 0, jmin = 0;
        for (i = 0; i < p.length; ++i) { 
            for (j = i + 1; j < p.length; ++j) {
                d = euclideanDistance(p[i], p[j]);
                if(d < min) {
                    min = d; imin = i; jmin = j;
                } 
            }
        }
        int ans [] [] = new int [1] [3];
        ans [0][0] = min; ans [0][1] = imin; ans [0][2] = jmin;
        return ans;
    }
    public static int euclideanDistance (Points p1, Points p2) {
        return (int) (Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }
}
class Points {
    double x;
    double y;
}
```

```java
// O (n log n)]
// TODO
```

4. 

```
pi = acos (-1.0) or pi = 2 × acos (0.0) /* for C or C++ */
```

## 15.15 Convex Hull

TODO
