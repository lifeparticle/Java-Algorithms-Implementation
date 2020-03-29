# 3. Searching
## 3.1 Basics

```
O (n) Linear Search
O (log n) Binary Search  // Pre-Condition: Array has to be sorted
O (1) Hashing [depends]
```

## 3.2 Binary Search [ O (log n) ]

```java
int binarySearchIterative (int key, int Array[]) {
	int left = 0;
	int right = Array.length - 1;
	int mid = 0;

	while (left <= right) {
		mid = (left + right) >> 1;

		if (key == Array [mid])
			return mid;
		else if(key > Array [mid])
			left = mid + 1;
		else
			right = mid - 1;
	}
	return -1;
}
```

```java
int binarySearchRecursive (int key, int l, int r) {
	if (l > r)
		return -1;

	int mid = (l + r) >> 1;

	if (key == Array [mid])
		return mid;
	else if(key > Array [mid])
		return Binary_Search_Recursive(key, mid + 1, r);
	else if(key < Array [mid])
		return Binary_Search_Recursive(key, l, mid - 1);
	else
		return -1;
}
```

## 3.3 Binary Search [ First occurrence ] [ O (log n) ]

```java
int binarySearchIterativeFirstOccurrence (int key) {
	int left = 0;
	int right = Array.length - 1;
	int mid = 0;
	int pos = -1; 

	while (left <= right){
		mid = (left + right) >> 1;

		if (key == Array [mid]){
			pos = mid;
			right = mid - 1;
		}
		else if(key > Array [mid])
			left = mid + 1;
		else
			right = mid - 1;
	}
	return pos;
}
```

## 3.4 Binary Search [ Last occurrence ] [ O (log n) ]

```java
int binarySearchIterativeLastOccurrence (int key) {
	int left = 0;
	int right = Array.length - 1;
	int mid = 0;
	int pos = -1; 

	while (left <= right){
		mid = (left + right) >> 1;

		if (key == Array [mid]){
			pos = mid;
			left = mid + 1;
		}
		else if(key > Array [mid])
			left = mid + 1;
		else
			right = mid - 1;
	}
	return pos;
}
```

## 3.5 Lower Bound [ O (log n) ] And Upper Bound [ O (log n) ]

```java
public static int lowerBound (int[] a, int n, int key) {
	/* int n = size or length */
	int lo = 0;
	int hi = n - 1;
	int m;

	if (a[hi] < key) 
		return n;

	while (hi > lo){
		m = (lo + hi) >> 1;
		if (a[m] < key)
			lo = m + 1;
		else
			hi = m; 
	}
	return lo;
}
```

```java
public static int upperBound (int[] a, int n, int key) {
	/* int n = size or length */       
	int lo = 0;
	int hi = n - 1;
	int m;

	if (a[hi] <= key) 
		return n; 

	while (hi > lo){
		m = (lo + hi) >> 1;
		if(a[m] <= key)    
			lo = m + 1;
		else
			hi = m; 
	}
	return lo;
}
```

### Lower Bound

<img width="728" alt="Screen Shot 2020-03-29 at 3 15 44 pm" src="https://user-images.githubusercontent.com/1612112/77840205-7ea37800-71d0-11ea-8697-68398af91bc8.png">

What is the first occurrence of 10, but if it is not there it also return the insertion position which will maintain the sorted order, the position will be 4 because we can’t push 10 into index number 3, if we push then the array will become unsorted, keep in mind that we assumed that if we push 10 into index number 4 then the array will shift right by one index. 
So if we ask lower bound to give me the index of 10, it will return index 4 Boss.

Special case 1:

Array a [] Numbers are:

<img width="308" alt="Screen Shot 2020-03-29 at 3 16 00 pm" src="https://user-images.githubusercontent.com/1612112/77840208-8105d200-71d0-11ea-8359-5b7d5860fd83.png">

Input: 8

Output: index 4, which is not a valid index in array a []


Special case 2:

Array a [] Numbers are: 

<img width="727" alt="Screen Shot 2020-03-29 at 3 16 32 pm" src="https://user-images.githubusercontent.com/1612112/77840209-882ce000-71d0-11ea-98fb-80fc0981178a.png">

Input: 3

Output: index 1

### Upper Bound

<img width="729" alt="Screen Shot 2020-03-29 at 3 16 41 pm" src="https://user-images.githubusercontent.com/1612112/77840210-91b64800-71d0-11ea-9fa0-97523701b463.png">

What is the last position of 10, but if it is not there it also return the insertion position which will maintain the sorted order, the position will be 4 because we can’t push 10 into index number 3, if we push then the array will become unsorted, keep in mind that we assumed that if we push 10 into index number 4 then the array will shift right by one index. 
So if we ask upper bound to give me the index of 10, it will return index 4 Boss.

Special case 1:

Array a [] Numbers are:

<img width="725" alt="Screen Shot 2020-03-29 at 3 16 50 pm" src="https://user-images.githubusercontent.com/1612112/77840214-967afc00-71d0-11ea-876f-75dfc1c7c9e3.png">

Input: 3

Output: index 8

## 3.6 Uses of upper and lower bounds

<img width="728" alt="Screen Shot 2020-03-29 at 3 17 38 pm" src="https://user-images.githubusercontent.com/1612112/77840216-9b3fb000-71d0-11ea-93aa-fce95d971902.png">

```java
/* we can use lower bound to find the upper nearest prime for any composite number (positive integers that are not prime and not equal to 1). For 10 the answer will be 11 and for 23 the answer will be 27 */

// count the frequencies [2 log (n)]
public static int countOccurrence(int[] a, int n, int key) {
	return upperBound(a, n, key) - lowerBound(a, n, key);
}
```

```
// Notations for intervals
// the two numbers are called the endpoints of the interval
(a, b) = excluding, excluding = lowerBound(high) - upperBound (low);
[a, b] = including, including = upperBound (high) - lowerBound(low);
(a, b] = excluding, including = upperBound (high) - upperBound (low);
[a, b) = including, excluding = lowerBound(high) - lowerBound(low);
// here b = high and a = low
```

<img width="736" alt="Screen Shot 2020-03-29 at 3 09 22 pm" src="https://user-images.githubusercontent.com/1612112/77840115-4cdde180-71cf-11ea-8fc0-0024f01fcfcd.png">

```
(1, 29) = 9
[1, 29] = 10
(1, 29] = 10
[1, 29) = 9
```

## 3.7 Linear Search [ O (n) ]

```java
// searching from end 
public static boolean linLast(int a[]) {
	int i;
	for(i = a.length - 1; i >= 0; --i) {
		if(a[i] == 4343)   
			return true;
	}
	return false;
}
```

```java
// searching from start
public static boolean linFirst(int a[]) {
	int i;
	for(i = 0; i < a.length; ++i) {
		if(a[i] == 4343)   
			return true;
	}
	return false;
}
```

```java
// searching from both ends, if the searched element is in the middle this code also takes n comparisons but in average case it saves time
public static boolean linOpt(int a[]) {
	int i;
	int j = a.length - 1;
	for(i = 0; i <= j; ++i, --j) {
		if(a[i] == 4343 || a[j] == 4343)   
			return true;
	}
	return false;
}
```
