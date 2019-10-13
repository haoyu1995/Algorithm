package class6;


import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ele = new ArrayList<>();
        dfs (2, res, ele, target);
        return res;
    }
    private void dfs(int start, List<List<Integer>> res, List<Integer> ele, int target){
        //base case
        if (target == 1){
            if (ele.size() > 1){
                res.add(new ArrayList(ele));
            }
            return;
        }
        for (int i = start; i <= Math.sqrt(target); i++ ){
            if (target % i == 0){
                ele.add(i);
                dfs(i, res, ele, target/i); //不是i+1
                ele.remove(ele.size()-1);
            }
        }
        // when i > sqrt(target), add (target).
        ele.add(target);
        dfs(target, res, ele, 1);
        ele.remove(ele.size()-1);

    }

    public static void main(String[] args){
        FactorCombinations test = new FactorCombinations();
        System.out.println(test.combinations(2523));
    }
}
