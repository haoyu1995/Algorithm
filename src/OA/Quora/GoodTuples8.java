package OA.Quora;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GoodTuples8 {
    public int goodTuples(int[] a) {
        //corner case
        if (a == null || a.length < 3){
            return 0;
        }

        //maintain a sliding window with size 3, and a hashmap to dynamic record the element in sliding window in sync

        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;

        int left = 0;
        int right = 0;
        while(right < a.length){
            map.put(a[right],map.get(a[right])==null?1:map.get(a[right])+1);
            if (right < 2){
                right++;
            }else{
                if (isValid(map)){
                    sum++;
                }
                map.put(a[left],map.get(a[left])-1);
                if (map.get(a[left])==0){
                    map.remove(a[left]);
                }
                left++;
                right++;
            }
        }
        return sum;
    }

    private boolean isValid(Map<Integer, Integer> map){
        if (map.keySet().size() != 2){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        GoodTuples8 test = new GoodTuples8();
        System.out.print(test.goodTuples(new int[]{1, 1, 2, 1, 5, 3, 2, 3}));
    }


}
