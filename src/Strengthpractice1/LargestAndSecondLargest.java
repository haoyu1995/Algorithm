package Strengthpractice1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class LargestAndSecondLargest {
    public int[] largestAndSecond(int[] array) {
        // Write your solution here
        // do Quicksort + Merge sort-like
        // 1. compare the elements in pairs: 0 vs end, 1 vs end-1,.....
        //    move all larger element to the left side,
        //    maintain a list for each larger element i to record the values that i defeated---defeated history
        // 2. do the same thing as 1 within the larger part,
        //    get new larger part and update the history
        // 3. do until there are only 1 element in the larger part(that is largest), -----O(n)
        //     then find max value in its defeated list as the second largest-------------O(logn)

        //Total time = O(n + logn)
        int i = 0;
        int j = array.length-1;
        Map<Integer, List<Integer>> history = new HashMap<>();
        while (j != i){
            int left = i;
            int right = j;
            while(left < right){
                if (array[left] < array[right]){
                    updateHistory(history, array[right], array[left]);
                    swap(array,left,right); //move all larger to left
                }else{
                    updateHistory(history, array[left], array[right]);
                }
                left++;
                right--;
            }
            // get the larger part 0---left-1, then do the same thing in next loop in range[0,left-1]
            i = 0;
            j = left == right? left : left-1;
        }

        int[] res = new int[2];
        res[0] = array[0];
        List<Integer> defeated = history.get(array[0]);
        res[1] = findLargest(defeated);

        return res;


    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void updateHistory(Map<Integer, List<Integer>> history, int key, int addval){
        if (!history.containsKey(key)){
            List<Integer> defeated = new ArrayList<>();
            history.put(key,defeated);
        }
        List<Integer> defeat = history.get(key);
        defeat.add(addval);
    }

    private int findLargest(List<Integer> list){
        int global = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++){
            global = Math.max(global, list.get(i));
        }
        return global;
    }

    public static void main(String[] args){
        LargestAndSecondLargest test = new LargestAndSecondLargest();
        int[] t1 = new int[]{5,4,2,1,3,6};
        System.out.println(test.largestAndSecond(t1));
    }
}
