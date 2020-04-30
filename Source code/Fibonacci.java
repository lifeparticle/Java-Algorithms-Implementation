import java.util.*;
import java.math.*;

public class Fibonacci {


    public static void main (String args []){
        Scanner sc = new Scanner (System.in);

        int i=1;
        BigInteger b[] = new BigInteger[5001];
        b[1]=BigInteger.ONE;
        b[2]=BigInteger.ONE;
        for(i=3;i<=5000;++i){
            b[i]=b[i-1].add(b[i-2]);
        }

      while(sc.hasNextInt()){
            int num = sc.nextInt();
            System.out.println(b[num]);
        }

    }
}