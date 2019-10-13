package class9;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class LongestSubWithKTypedChar {
    public String longest(String input, int k) {
        // Write your solution here.
        //sliding window

        //cornercase
        if (input == null || input== ""){
            return input;
        }
        if (k <= 0){
            String demo = "";
            return demo;
        }

        //when move right: when types of character in sliding window <= k
        //                 when types of character in sliding window = k
        //when move left: types of character in sliding window > k && [right] != [right+1]

        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int globalmax = 0;
        Map<Character,Integer> window = new HashMap<Character,Integer>();
        while (right < input.length()){
            if (window.containsKey(input.charAt(right))){
                window.put(input.charAt(right),window.get(input.charAt(right))+1);
            }else{
                window.put(input.charAt(right),1);
            }
            if (window.size() > k){
                if(right == input.length()-1 ||input.charAt(right) != input.charAt(right+1)){ //move left
                    while(window.size()>k){
                        window.put(input.charAt(left),window.get(input.charAt(left))-1);
                        if(window.get(input.charAt(left)) == 0){
                            window.remove(input.charAt(left));
                        }
                        left++;
                    }
                }
            }
            if (window.size() == k && globalmax < right-left+1){
                globalmax = right-left+1;
                start = left;
                end = right;
            }
            right++;
        }

        if(right == input.length() && window.size() < k){
            String t = "";
            return t;
        }

        return input.substring(start,end+1);
    }

    public static void main(String[] args){
        LongestSubWithKTypedChar test = new LongestSubWithKTypedChar();
        String t1 = "aabbbbacccc";
        System.out.println(test.longest(t1,4));
    }
}
