# 3. Searching
3.1 Basics

```
O (n) Linear Search
O (log n) Binary Search  // Pre-Condition: Array has to be sorted
O (1) Hashing [depends]
```

3.2 Binary Search [ O (log n) ]

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

3.3 Binary Search [ First occurrence ] [ O (log n) ]

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

3.4 Binary Search [ Last occurrence ] [ O (log n) ]

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

3.5 Lower Bound [ O (log n) ] And Upper Bound [ O (log n) ]

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

![Screen Shot 2020-03-28 at 4 22 40 pm](https://user-images.githubusercontent.com/1612112/77815731-5c96f080-7111-11ea-801b-9793ab543908.png)

What is the first occurrence of 10, but if it is not there it also return the insertion position which will maintain the sorted order, the position will be 4 because we can’t push 10 into index number 3, if we push then the array will become unsorted, keep in mind that we assumed that if we push 10 into index number 4 then the array will shift right by one index. 
So if we ask lower bound to give me the index of 10, it will return index 4 Boss.

Special case 1:

Array a [] Numbers are:

![Screen Shot 2020-03-28 at 4 22 53 pm](https://user-images.githubusercontent.com/1612112/77815742-691b4900-7111-11ea-927e-64c68de47e0f.png)

Input: 8

Output: index 4, which is not a valid index in array a []


Special case 2:

Array a [] Numbers are: 

![Screen Shot 2020-03-28 at 4 23 06 pm](https://user-images.githubusercontent.com/1612112/77815753-73d5de00-7111-11ea-81d7-69e07e1b9a30.png)

Input: 3

Output: index 1

### Upper Bound

![Screen Shot 2020-03-28 at 4 23 18 pm](https://user-images.githubusercontent.com/1612112/77815620-99161c80-7110-11ea-8fcc-4373f6eb6345.png)

What is the last position of 10, but if it is not there it also return the insertion position which will maintain the sorted order, the position will be 4 because we can’t push 10 into index number 3, if we push then the array will become unsorted, keep in mind that we assumed that if we push 10 into index number 4 then the array will shift right by one index. 
So if we ask upper bound to give me the index of 10, it will return index 4 Boss.

Special case 1:

Array a [] Numbers are:

![Screen Shot 2020-03-28 at 4 23 06 pm](https://user-images.githubusercontent.com/1612112/77815623-99161c80-7110-11ea-9363-186f07bf7105.png)

Input: 3

Output: index 8

3.6 Uses of upper and lower bounds

![Screen Shot 2020-03-28 at 4 22 53 pm](https://user-images.githubusercontent.com/1612112/77815625-99aeb300-7110-11ea-8b47-1b1af2840da4.png)

/* we can use lower bound to find the upper nearest prime for any composite number (positive integers that are not prime and not equal to 1). For 10 the answer will be 11 and for 23 the answer will be 27 */

// count the frequencies [2 log (n)]
public static int countOccurrence(int[] a, int n, int key) {
return upperBound(a, n, key) - lowerBound(a, n, key);
}

// Notations for intervals
// the two numbers are called the endpoints of the interval
(a, b) = excluding, excluding = lowerBound(high) - upperBound (low);
[a, b] = including, including = upperBound (high) - lowerBound(low);
(a, b] = excluding, including = upperBound (high) - upperBound (low);
[a, b) = including, excluding = lowerBound(high) - lowerBound(low);
// here b = high and a = low

![Screen Shot 2020-03-28 at 4 22 40 pm](https://user-images.githubusercontent.com/1612112/77815626-99aeb300-7110-11ea-833b-e347fb9a4fd4.png)

(1, 29) = 9
[1, 29] = 10
(1, 29] = 10
[1, 29) = 9

3.7 Linear Search [ O (n) ]

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
