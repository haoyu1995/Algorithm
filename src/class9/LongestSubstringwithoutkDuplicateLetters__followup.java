package class9;
import java.util.HashMap;
import java.util.Map;


public class LongestSubstringwithoutkDuplicateLetters__followup {
    public String longsubwithoutk(String input, int k){
        //sliding window
        int left = 0;
        int right = 0;
        int globalmax = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> window = new HashMap<Character,Integer>();
        while(right < input.length()){
            char rightCharacter = input.charAt(right);
            if(!window.containsKey(input.charAt(right))){
                window.put(rightCharacter,1);
            }else{
                //key: update left，right and hashmap in sync.
                //step1: regard the adjacent duplicated letters as a chunk, add element by move right bound
                //step2: when complete scan of a chunk or reach the last element, then check k-time duplicate letters in the sliding window by hashmap, if exist, move left bound untill no k-time duplicate
                window.put(rightCharacter,window.get(rightCharacter)+1);

                char leftChar = input.charAt(left);
                // make sure the letters with duplicate times larger than k can be returned
                //!!!! important
                if (right+1 == input.length() || input.charAt(right) != input.charAt(right+1)){
                    while(left<=right && window.get(rightCharacter) == k){
                        window.put(leftChar,window.get(leftChar)-1);
                        left++;
                     }

                }
            }
            if(right-left+1>globalmax){
                globalmax = right-left+1;
                start = left;
                end = right;

            }
            right++;
        }
        return input.substring(start, end+1);
    }

    public static void main(String[] args){
        LongestSubstringwithoutkDuplicateLetters__followup test = new LongestSubstringwithoutkDuplicateLetters__followup();
        System.out.println(test.longsubwithoutk("aabbcddd",3));
    }
}
