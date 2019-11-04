package OA.Quora;

import java.util.HashSet;
import java.util.Set;

public class DivisorSubstring12 {
    public int divideSubString(String s, int k) {
        int res = 0;
        //corner case
        if (s == null || s.length() < k || k < 1){
            return 0;
        }

        int sint = Integer.parseInt(s);
        // filtering the duplicate substring
        Set<Integer> substrings = new HashSet<>();
        //sliding window with size k
        int i = 0;
        // find all substring of size k, check if s can be divided by substring
        // note: divisor cannot be 0
        while(i <= s.length()-k){
            int sub = Integer.parseInt(s.substring(i,i+k));
            if (!substrings.contains(sub)){
                substrings.add(sub);
                if(sub != 0 && sint % sub == 0){
                    res++;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        DivisorSubstring12 test = new DivisorSubstring12();
        System.out.println(test.divideSubString("120",2));
        System.out.println(test.divideSubString("555",1));
    }
}
