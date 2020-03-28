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

![Screen Shot 2020-03-28 at 5 21 43 pm](https://user-images.githubusercontent.com/1612112/77816676-a7683680-7118-11ea-805e-460bc769c4f1.png)

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

## 4.3 Knuth Morris Pratt  (KMP) 

## 4.4 Rabin - Karp 

## 4.5 Aho - Corasick

## 4.6 Boyer – Moore

## 4.7 Suffix Tree

## 4.8 Determine Subsequence [ Sliding Window ] [  O (n) ]

## 4.9 Determine Anagrams O (n)
