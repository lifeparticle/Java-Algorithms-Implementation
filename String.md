# 3. String

## 4.1 Basics

### Substring: 
A substring (or factor) of a string T = t1…..tn is a string T = t1+i…..tm+i , where 0  i  and m + i   n . A substring of a string is a prefix of a suffix of the string, and equivalently a suffix of a prefix. If T is a substring of T, it is also a subsequence, which is a more general concept. 
Given a pattern P, you can find its occurrences in a string T with a string searching algorithm. 
Finding the longest string which is equal to a substring of two or more strings is known as the longest common substring problem.
Example: The string ana is equal to substrings (and subsequences) of banana at two different offsets:

```
banana
 |||||
 ana||
   |||
   ana
```

Substrings are also called subwords (in America) or factors (in Europe). It is also a subsequence

### Subsequence: 
You are given two strings A and B. B will be the subsequence of A, if you can make B from A by deleting some (or none) characters. For example, ABD is a subsequence of ABCDEF. Where, order of the elements is preserved.

<img width="216" alt="Screen Shot 2020-03-29 at 3 21 15 pm" src="https://user-images.githubusercontent.com/1612112/77840252-01c4ce00-71d1-11ea-9f86-84e2acbceb96.png">

### Prefix: 
A prefix of a string T = t1…..tn is a string T^ = t1…..tm, where m  n. A proper prefix of a string is not equal to the string itself (0 ≤m<n); some sources in addition restrict a proper prefix to be non-empty (0 < m < n). A prefix can be seen as a special case of a substring.

Example: The string ban is equal to a prefix (and substring and subsequence) of the string banana:

```
banana
|||
ban
```

### Suffix: 
A suffix of a string T = t1…..tn is a string T^ = tn – m + 1…..tm where m  n. A proper suffix of a string is not equal to the string itself (0 <m≤n); again, a more restricted interpretation is that it is also not empty (0 < m < n). A suffix can be seen as a special case of a substring.

Example: The string nana is equal to a suffix (and substring and subsequence) of the string banana:

```
banana
  ||||
  nana
```

### Border: 
A border is a suffix and prefix of the same string, e.g. "bab" is a border of "babab".

### Anagram: 
A word or phrase formed by reordering the letters of another word or phrase, such as satin to stain.
Permutation: You are given two strings A and B. B will be said to be the permutation of A, if you can make B from A by rearranging some (or none) characters.

aabc is a permutation of caba

## 4.2 Brute Force [ O (n – m + 1) m ]

```
T = 000010001010001 and P = 0001, the occurrences are:
```
<img width="453" alt="Screen Shot 2020-03-29 at 3 21 24 pm" src="https://user-images.githubusercontent.com/1612112/77840256-05585500-71d1-11ea-88ea-9bfa696ffb78.png">
```
first occurrence starts at T[1]
second occurrence starts at T[5]
third occurrence starts at T[11]
```

```java
// T = Text & P = Pattern
// this code finds all occurrence
// T = aababdsffdsababab & p = ab [ab occurs 5 times]
public static void bruteForce (String T, String P) { 
        
    int i, n = T.length(); // n = length of T
    int j, m = P.length(); // m = length of P

    for(i = 0; i <= n - m; ++i) { 
        for(j = 0; j < m; ++j) {
            if(T.charAt(i + j) != P.charAt(j))
                break;
        }
        if (j == m) 
            System.out.println("at index "+i+" pattern starts");
    } 
}

```

## 4.3 Knuth Morris Pratt  (KMP) 

```java
String T, P;
int n, m; 
int [] b; // b = back table
    
void kmpPreprocess() { // call this before calling kmpSearch()
    int i = 0, j = -1; b[0] = -1; // starting values
    while (i < m) { // pre-process the pattern string P
        while (j >= 0 && P.charAt(i) != P.charAt(j)) 
            j = b[j]; // if different, reset j using b
        i++; 
        j++; // if same, advance both pointers
        b[i] = j; 
    } 
}           
    
void kmpSearch() { // this is similar as kmpPreprocess(), but on string T
    int i = 0, j = 0; // starting values
    while (i < n) { // search through string T
        while (j >= 0 && T.charAt(i) != P.charAt(j)) 
            j = b[j]; // if different, reset j using b
        i++;
        j++; // if same, advance both pointers
        if (j == m) { // a match found when j == m
            System.out.printf("P is found at index %d in T\n", i - j);
            j = b[j]; // prepare j for the next possible match
        }
    }
```

## 4.4 Rabin - Karp 

TODO

## 4.5 Aho - Corasick

TODO

## 4.6 Boyer – Moore

TODO

## 4.7 Suffix Tree

TODO

## 4.8 Determine Subsequence [ Sliding Window ] [  O (n) ]

```java
// for theory check String Matching Section
// Text = hmmAtaTumiThikBolso
// Match Text 1 = AtaBolso 
// Match Text 2 = dhuur 
// Text 1 true
// Text 2 false

// O (s1)
// determine if s2 is a Subsequence of s1
public boolean isSubsequence(String s1,String s2) {
     int a = s1.length(); 
     int b = s2.length();
     int i,j;
     if(b > a) // trivial check
        return false;
     else{
        for(i = j = 0; i < a ; ++i) {
           if(s2.charAt(j) == s1.charAt(i))
               ++j;
           if(j == b)
               return true;
        }
    }
  return false;
}
```
## 4.9 Determine Anagrams O (n)

```java
// returns true if a and b are Anagrams
public boolean isAnanagrams (String a, String b) {
        int len_a = a.length();
        int len_b = b.length();
        
        a = a.toLowerCase();
        b = b.toLowerCase();
        
        if(len_a != len_b)
            return false;
        
        int freq [] = new int [30];
        
        for(int i = 0; i < len_a; ++i) 
            freq [a.charAt(i) - 97]++;
        
        for(int i = 0; i < len_b; ++i) 
            freq [b.charAt(i) - 97]--;
        
        for(int i = 0; i < 26; ++i) {
            if(freq [i] > 0)
                return false;
        }
        return true; 
}
```

```java
for(int i = 0; i < 26; ++i) {
     res += Math.abs(freq[i]);
}

4
crocus
succor
dares
seared
empty

smell
lemon
Sample Output 
Case #1:  0
Case #2:  1
Case #3:  5
Case #4:  4
```

The anagrammatic distance between any two words is the minimum number of letters which must be removed so that the remaining portions of the two words become anagrams. For example, given the words sleep and leap, we need to remove a minimum of three letters --- two from sleep and one from leap --- before what's left are anagrams of each other (in each case, lep).
