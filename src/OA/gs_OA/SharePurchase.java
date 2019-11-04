package OA.gs_OA;
import java.util.*;

public class SharePurchase {
    // given a string AABCA ，找出有几个subarray 包含abc

    public int numContainABC(String s){
        //corner case
        if (s == null || s.length() < 3){
            return 0;
        }

        // build a hashmap to record the A,B,C in substring
        Map<Character, Integer> record = new HashMap<>();

        int count = 0;
        // use sliding window to scan all substring
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            char rchar = s.charAt(right);

            //if is ABC, record it in hashmap
            if (isABC(rchar)) {
                if (record.containsKey(rchar)) {
                    record.put(rchar, record.get(rchar) + 1);
                } else {
                    record.put(rchar, 1);
                }
            }

            if (record.size() == 3){
                count++;
            }

            // do
            while (record.get(s.charAt(left)) > 1 && record.size() == 3) {
                char lchar = s.charAt(left);
                if (isABC(lchar) && record.containsKey(lchar)) {
                    record.put(lchar, record.get(lchar) - 1);
                }
                left++;
                count++;

            }

        }
        return count;
    }

    private boolean isABC(char c){
        return c >= 'A' && c<= 'C';
    }

    public static void main(String[] args){
        SharePurchase test = new SharePurchase();
        System.out.println(test.numContainABC("ABCCBA"));
    }

}
