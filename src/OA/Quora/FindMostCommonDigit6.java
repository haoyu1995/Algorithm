package OA.Quora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMostCommonDigit6 {
    public List<Integer> findMostCommonDigit(int[] A) {

        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        // iterate the array, and record the occurrence of each element and num of most common element
        for (int ele : A){
            while (ele > 0) {
                int d = ele%10;
                map.put(d, map.get(d) == null ? 0 : map.get(d) + 1);
                max = Math.max(max, map.get(d));
                ele = ele/10;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()){
            if (map.get(key) == max){
                res.add(key);
            }
        }
        return res;

    }

    public static void main(String[] args){
        FindMostCommonDigit6 test = new FindMostCommonDigit6();
        System.out.print(test.findMostCommonDigit(new int[]{222, 23, 3, 33, 5}));
    }

}
