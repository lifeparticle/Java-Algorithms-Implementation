# 9. Greedy

## 9.1 Coin Change problem [ US Coin ]

TODO

## 9.2 Knapsack problem [ Fractional ]

TODO

## 9.3 Huffman Coding

Input 1, 2, 3

1 + 2 = 3, cost = 3
3 + 3 = 6, cost = 6
Total = 9


1 + 3 = 4, cost = 4
2 + 4 = 6, cost = 6
Total = 10

2 + 3 = 5, cost = 5
1 + 5 = 6, cost = 6
Total = 11

```java
while (pq.size() > 1) {                         
    sum = pq.poll() + pq.poll();               
    ans += sum;					      
    pq.add(sum);                             
}                                                                  			         

writer.println(ans); 
```

```
Min heap
        1
       / \
      2   3
     / \
    4
    
1 + 2 = 3 -> add 3  
ans = 3

        3
       / \
      3   4
     
3 + 3 = 6 -> add 6 
ans = 3 + 6

        4
       /
      6
       
4 + 6 = 10 -> add 10
ans = 3 + 6 + 10

        10
        
ans = 19
```
