package class9;


import java.util.HashSet;
import java.util.Set;


public class LongestSubstringwithoutRepeatingLetters {
    public int longest(String input) {
        // Write your solution here
        if (input==null || input == ""){
            return 0;
        }
        //sliding window
        int globalmax = 0;
        Set<Character> window = new HashSet<Character>();
        int left = 0;
        int right = 0;
        while(right < input.length()){
            if (!window.contains(input.charAt(right))){
                window.add(input.charAt(right));
                if (right-left+1 > globalmax){
                    globalmax = right-left+1;
                }
                right++;
            }else{
                while(left <= right && input.charAt(left) != input.charAt(right)){
                    window.remove(input.charAt(left));
                    left++;
                }
                left++;
                right++;
            }
        }
        return globalmax;

    }
    public static void main(String[] args){
        LongestSubstringwithoutRepeatingLetters test = new LongestSubstringwithoutRepeatingLetters();
        System.out.println(test.longest("abcabcbbcda"));
    }
}
