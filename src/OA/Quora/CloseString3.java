package OA.Quora;

import java.util.HashMap;
import java.util.Map;

class CloseString3 {
//    If two strings are close enough.
//    Given two rules to define two strings are close enough.
//            1. you can swap neighbor char any times. Ex. "abb" -> "bba"
//            2. If two strings have the same character, then you can change the character into
//    another.
//    Ex. If both strings contain "a" and "b", you can change all "a"s in the first string or
//    change all "b"s in the first string. same as the second string
//    Ex.
//            Input: S1 = "babzccc", S2 = "abbzczz"
//    Output: True
    public boolean compareString(String s1, String s2) {
        //corner case
        if ((s1 == null && s2 == null) || (s1.length() == 0 && s2.length() == 0)){
            return true;
        }
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0){
            return false;
        }
        // Map<frequency,the time of frequency occurence>
        Map<Integer, Integer> s1Freq = calFreq(s1);
        Map<Integer, Integer> s2Freq = calFreq(s2);
        if (s1Freq.size() != s2Freq.size()){
            return false;
        }
        for (Integer f: s1Freq.keySet()){
            if (s1Freq.get(f) != s2Freq.get(f)){
                return false;
            }
        }
        return true;

    }

    private Map<Integer, Integer> calFreq(String str){
        // use Map<character, frequency> to get the frequency of each char in String
        Map<Character, Integer> charfreq = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if (!charfreq.containsKey(str.charAt(i))){
                charfreq.put(str.charAt(i), 1);
            }else {
                charfreq.put(str.charAt(i), charfreq.get(str.charAt(i)) + 1);
            }
        }

        // use map to calculate the occurence of each frequency by iterate the map above
        Map<Integer, Integer> freq = new HashMap<>();
        for (Character c: charfreq.keySet()){
            int f = charfreq.get(c);
            if (!freq.containsKey(f)){
                freq.put(f, 1);
            }else{
                freq.put(f,freq.get(f)+1);
            }
        }
        return freq;
    }

    public static void main(String[] args){
        CloseString3 test = new CloseString3();
        System.out.println(test.compareString("babzccc","abbzczz"));
        System.out.println(test.compareString("abzcccm","bbazzczl"));
    }

}