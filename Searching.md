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

3.6 Uses of upper and lower bounds 

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
