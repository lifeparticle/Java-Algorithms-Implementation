# Java-Code-Snippet

## Row Sum (2d array)
```java
for (int row = 0; row < matrix.length; ++row) {
    int rowSum = 0;
    for (int col = 0; col < matrix[row].length; ++col) {
        rowSum += matrix[row][col];
    }
    System.out.println("row sum: " + rowSum);
}   
```

## Column Sum (2d array)
```java
// when length of each row is same
for (int col = 0; col < matrix[0].length; ++col) {
    int colSum = 0;
    for (int row = 0; row < matrix.length; ++row) {
        colSum += matrix[row][col];
    }
    System.out.println("col sum: " + colSum);
}
```

## Copy Array
```java
// Any changes made to copied object will not be reflected in original object or vice-versa.
String[] temp = Arrays.copyOf(inputArray, inputArray.length);
```

## List to Array

### String
```java
List<String> res = new ArrayList<String>();
res.toArray(new String[0]);
```

### int
```java
List<Integer> res = new ArrayList<Integer>();
res.stream().mapToInt(i->i).toArray();
```

### String to charecter frequency array
```java
int [] s1Freq = new int [26];
for(int i = 0; i < s1.length(); ++i){
    s1Freq[s1.charAt(i) - 'a']++; 
}
```
 
 ### Digit Sum
 
 ```java
 String number = "2345";
 for (int x = 0; x < number.length(); x++)
    sum += Integer.parseInt(number.charAt(x)+"");
 ```
 
 ### Converting minutes to 24 hour format
 
```java
int hours = minutes / 60;
int minutes = minutes % 60;
```
