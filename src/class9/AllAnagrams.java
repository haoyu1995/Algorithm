package class9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
    public List<Integer> allAnagrams(String sh, String lo) {
        //异序词
        // Write your solution here
        List<Integer> res = new ArrayList<Integer>();
        if (lo == null || lo == ""){
            return res;
        }
        Map<Character,Integer> match = new HashMap<Character,Integer>();
        for (int i = 0; i < sh.length(); i++){
            char c = sh.charAt(i);
            if (match.containsKey(c)){
                match.put(c, match.get(c)+1);
            }else{
                match.put(c, 1);
            }
        }
        int left = 0;
        int right = 0;
        int mat = 0;
        while (left < lo.length()-sh.length()+1 && right < lo.length()){
            char rchar = lo.charAt(right);
            if(match.get(rchar) != null){
                match.put(rchar, match.get(rchar)-1);
                if (match.get(rchar) == 0){
                    mat++;
                }
            }
            if(right >= sh.length()){
                char lchar = lo.charAt(left);
                if (match.get(lchar) != null){
                    if (match.get(lchar) == 0){
                        mat--;
                    }
                    match.put(lchar, match.get(lchar)+1);
                }
                left++;
            }
            right++;
            if (mat == match.size()){
                res.add(right-sh.length());
            }
        }
        return res;
    }
    public static void main(String[] args){
        AllAnagrams test = new AllAnagrams();
        System.out.println(test.allAnagrams("aab","ababacbbaac"));
    }
}
