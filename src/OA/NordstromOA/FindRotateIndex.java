package OA.NordstromOA;

import OA.Quora.FindEvenDigit5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindRotateIndex {
    public List<Integer> findRotateIndex(List<Integer> target, List<Integer> sorted){
        List<Integer> res = new ArrayList<>();
        Collections.sort(sorted);
        for (int ele : target){
            res.add(binarySearch(sorted,ele));
        }
        return res;
    }

    private int binarySearch(List<Integer> list, int target){
        int lo = 0;
        int hi = list.size()-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if (list.get(mid) > target){
                hi = mid-1;
            }else if (list.get(mid) < target){
                lo = mid+1;
            }else{
                return mid;
            }
        }
        return hi;
    }

    public static void main(String[] args){
        FindRotateIndex test = new FindRotateIndex();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        b.add(6);
        b.add(8);
        b.add(9);
        b.add(10);
        b.add(1);
        b.add(2);
        b.add(3);
        a.add(3);
        a.add(1);
        a.add(9);
        List<Integer> t1 = test.findRotateIndex(a,b);
        for (int ele : t1){
            System.out.println(ele);
        }
    }
}
