package OA.nutanixOA;

import java.util.ArrayList;
import java.util.List;

public class NearestPrimeChar {
    public char nearPrime(char a){
        //assumption the range of char is in AscII table
        //total number of Character in ASCII table is 256 (0 to 255)
        //use a List to store the index of prime character in ascii

        //there 55 primes from 0 to 255
        //Time complexity = O(255*15 + log55) = O(1)
        List<Integer> primeChars = new ArrayList<>();
        for (int i = 1; i < 256; i++){
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primeChars.add(i);
            }
        }
        //binary search
        int target = a;
        int i = 0;
        int j = primeChars.size()-1;

        while (i<j-1){ //find the final two most close primes to target
            int mid = i + (j-i)/2;
            if (primeChars.get(mid) > target){
                j = mid;
            }else if (primeChars.get(mid) < target){
                i = mid;
            }else{
                return a;
            }
        }
        int left = primeChars.get(i);
        int right = primeChars.get(j);
        return Math.abs(left-target)<Math.abs(right-target)? (char)left:(char)right;
    }

    public static void main(String[] args){
        NearestPrimeChar test = new NearestPrimeChar();
        System.out.println(test.nearPrime('A'));
        System.out.println(test.nearPrime('a'));
    }
}
