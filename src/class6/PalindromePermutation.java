package class6;


import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    //better method
    // palindrome means the string only have one character with odd number of occurence, left characters occurs even tinmes.
    public boolean canPermutePalindrome(String input) {
        // Write your solution here
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i < input.length(); i++){
            char ele = input.charAt(i);
            Integer val = map.get(ele);
            if (val == null){
                val = 0;
            }
            map.put(ele, val+1);
        }
        int count = 0;
        for (Character key : map.keySet()){
            count += map.get(key) % 2;
        }
        if (count > 1){
            return false;
        }
        return true;

    }


    //my method X
    //Time = O(n!)
    //space = O(n)
    /*

    public boolean canPermutePalindrome(String input) {
        // Write your solution here
        //solution 1
        int[] used = new int[input.length()];
        StringBuilder ele = new StringBuilder();
        return palindromePermute(used, input, ele);
    }

    private boolean palindromePermute(int[] used, String input, StringBuilder ele){
        //base case
        if (ele.length() == input.length()){
            return isPalindrome(ele);
        }
        //recursion

        for (int i = 0; i < input.length(); i++) {
            //how to deal with the duplicate element????
            if (used[i] == 0) {
                ele.append(input.charAt(i));
                used[i] = 1;
                boolean a = palindromePermute(used, input, ele);
                if (a){
                    return a;
                }
                ele.deleteCharAt(ele.length() - 1); //List size()
                used[i] = 0;
            }
        }
        return false;

    }

    private boolean isPalindrome(StringBuilder ele){
        String ori = ele.toString();
        StringBuilder rev = new StringBuilder(ele);
        String rever = rev.reverse().toString();
        return rever.equals(ori); //StringBuilder不能用equals比较内容，没有重写equal函数
    }
    */

    private boolean isPalindrome(StringBuilder ele){
        String ori = ele.toString();
        StringBuilder rev = new StringBuilder(ele);
        String rever = rev.reverse().toString();
        return rever.equals(ori); //StringBuilder不能用equals比较内容，没有重写equal函数
    }

    public static void main(String[] args){
        PalindromePermutation test = new PalindromePermutation();
        String t1 = new String("aab");
        System.out.println(test.canPermutePalindrome(t1));

    }
}
