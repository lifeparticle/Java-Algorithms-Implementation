# 2. Sorting
## 2.1 Basics
Sorting Algorithms
+ (n^2) comparison-based sorting algorithms Bubble/Selection/Insertion
+ (n log n) comparison-based sorting algorithms Merge/Heap/Quick [Arrays.sort()] 
+ (n + k) Counting/Radix/Bucket
+ (n) key Indexed 

Any comparison based sort can't do better than n log n. Merge Sort, Out place [Memory Cost]. Here k is constant, called hidden constant; consider input for key indexed: 1, 100000, 10000000

Sorting Stability: Stable sorting algorithms maintain the relative order of records with equal keys. If all keys are different then this distinction is not necessary. But if there are equal keys, then a sorting algorithm is stable if whenever there are two records (let's say R and S) with the same key, and R appears before S in the original list, then R will always appear before S in the sorted list. When equal elements are indistinguishable, such as with integers or more generally, any data where the entire element is the key, stability is not an issue. However, assume that the following pairs of numbers are to be sorted by their first component:
(4, 2)  (3, 7)  (3, 1)  (5, 6)

In this case, two different results are possible, one which maintains the relative order of records with equal keys, and one which does not:
(3, 7)  (3, 1)  (4, 2)  (5, 6)   (Order maintained)
(3, 1)  (3, 7)  (4, 2)  (5, 6)   (Order changed)   

Mean, Median, Mode, & Range:

13, 18, 13, 14, 13, 16, 14, 21, 13 
The mean is the usual average 
(13 + 18 + 13 + 14 + 13 + 16 + 14 + 21 + 13) ÷ 9 = 15 
The largest value in the list is 21, and the smallest is 13, so the range is 21 – 13 = 8
The mode is the number that is repeated more than any other, so 13 is the mod (4 times)

The median is the middle value in a sorted list

13, 13, 13, 13, 14, 14, 16, 18, 21 [odd] [9 / 2 = 4]

<img width="597" alt="Screen Shot 2020-03-29 at 3 02 53 pm" src="https://user-images.githubusercontent.com/1612112/77840030-7ba78800-71ce-11ea-97a1-ba0b7d27c7ed.png">

13, 13, 13, 13, 14, 14, 16, 18 [even] [9 / 2 = 4 and 4 - 1]

<img width="534" alt="Screen Shot 2020-03-29 at 3 03 03 pm" src="https://user-images.githubusercontent.com/1612112/77840032-82ce9600-71ce-11ea-946d-be8243d42495.png">

There is no "middle" number, because there are even numbers of numbers. In this case, the median is the mean (the usual average) of the middle two values: (13 + 14) ÷ 2 = 13.5       

## 2.2 Bubble Sort [ O (n2) ]

```java
// with two optimizations

public void bubbleSort(int[] arr) {
    
    boolean swapped = true;
    int j = 0, i;
    int tmp;
    
    while (swapped) {
        swapped = false;
        j++;
        for (i = 0; i < arr.length - j; ++i) {
            if (arr [i] > arr [i + 1]) {
                tmp = arr [i];
                arr [i] = arr [i + 1];
                arr [i + 1] = tmp;
                swapped = true;
            }
        }                
    }
}
```

## 2.3 Key-indexed sorting [ O (n + k) ]

```java
int [] ar = new int [11];  // Will Sort range of  0 to 10
int x;
for (int i = 1; i <= 10; ++i) {
	x = sc.nextInt();
	ar [x]++; 
}

int j, k;
// Printing method  
for (j = 0; j < ar.length; ++j) { 
   for (k = 0; k < ar [j]; ++k)
		System.out.println(j);
}

// input 
// 1, 0, 4, 6, 7, 8, 0, 8, 1, 1
```

![Screen Shot 2020-01-28 at 8 36 36 pm](https://user-images.githubusercontent.com/1612112/73251905-edcf1100-420d-11ea-9770-1fa2ab8ad05f.png)

## 2.4 Insertion Sort [ O (n2) ]

```java
// key < ascending && key > descending

public void insertionSort(int[] arr) {
	int key, i, j;
	for (i = 1; i < ar.length; ++i) {
		key = ar [i];
		j = i - 1;
		while (j >= 0 && key < ar [j]) { 
			ar [j + 1] = ar [j];
			--j;
		}
		ar [j + 1] = key;
	}
}
 
// insert a value in a sorted array

int [] ar = new int [10];
int size = 10;
int j = size - 1;
int key = 20;

while (j >= 0 && key < ar [j]) {
    ar [j + 1] = ar [j];
    --j;
}
ar [j + 1] = key;

```
## 2.5 Selection Sort [ O (n2) ]

```java
public void selectionSort(int[] arr) { 
      int i, j, minIndex, tmp; 
      int n = arr.length; 
      for (i = 0; i < n - 1; ++i) { 
            minIndex = i; 
            for (j = i + 1; j < n; ++j) {
                  if (arr[j] < arr[minIndex]) 
                        minIndex = j; 
		  }
            if (minIndex != i) { 
                  tmp = arr [i]; 
                  arr [i] = arr[minIndex]; 
                  arr [minIndex] = tmp; 
            } 
      } 
}
```

## 2.6 Object Sort [ O (n log n) ]

```java
public class ObjectSort {
    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        Student sT [] = new Student [15];
        for(int i = 0; i < 10; ++i)
            sT[i] = new Student();
        for (int i = 0; i < 10; ++i) {
            sT[i].marks = sc.nextInt(); sc.nextLine(); sT[i].name = sc.nextLine();
        }
        Arrays.sort(sT, 0, 10);
        for(int i = 0; i < 10; ++i) {
            System.out.println("Students Marks: "+sT[i].marks+" Students Name: "+sT[i].name); 
        }
    }
}
class Student implements Comparable <Student> {
    int marks; String name;
    /* a negative integer, zero, or a positive integer as this object 
     is less than, equal to, or greater than the specified object */
    public int compareTo(Student that) {
        if (this.marks > that.marks)  
            return 1;
        else if (this.marks < that.marks) 
            return -1;
        else { // this.time == that.time
		// case - insensitive comparisons
		if (this.name.toLowerCase().compareTo(that.name.toLowerCase()) > 0)                  
			return 1 ;
		else if (this.name.toLowerCase().compareTo(that.name.toLowerCase()) < 0)
			return -1; 
		return 0;
        } 
    }
    // first sort the students by their marks and if number of two students are same then sort by their name in lexicographically order 
    // if (this.name.compareTo(that.name) > 0)      // case - sensitive comparisons
    // else if (this.name.compareTo(that.name) < 0) // case - sensitive comparisons 
}

/*
* Ascending order
* this.a > that.a
*   retrun 1;
* this.a < that.a
*   return -1;
* Descending
* this.a > that.a
*   retrun -1;
* this.a < that.a
*   return 1;
*/
```
