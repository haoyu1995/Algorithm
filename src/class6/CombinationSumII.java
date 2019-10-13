package class6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        Arrays.sort(num);
        int[] used = new int[num.length];
        dfs(0, used, res, ele, num, target);
        return res;
    }

    private void dfs(int level, int[] used, List<List<Integer>> res, List<Integer> ele, int[] num, int target){
        //base case
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList(ele));
            return;
        }
        //recursion
        for (int i = level; i < num.length; i++){
            //!!!!! important !deal with the duplicates number
            if (i > 0 && num[i] == num[i - 1] && used[i-1] == 0){
                continue;
            }
            if (used[i] == 0 && target >= num[i]){
                ele.add(num[i]);
                used[i] = 1;
                dfs(i + 1, used, res, ele, num, target - num[i]); //level = i+1 maintain the non-descending order in combimation
                ele.remove(ele.size() - 1);
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args){
        CombinationSumII test = new CombinationSumII();
        int[] t1 = new int[]{1,5,1,7,2,4,5,9,5,6,7,7,8,11,14};
        System.out.println(test.combinationSum2(t1,21));
    }
}
