package class6;


import java.util.ArrayList;
import java.util.List;

public class CombinationCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ele = new ArrayList<Integer>(coins.length);
        findDfs(target, coins, res, ele, 0);
        return res;
    }

    private void findDfs(int target, int[] coins, List<List<Integer>> res, List<Integer> ele, int level){
        //base case
        if (level == coins.length){
            if (target == 0){     //very important!!!!!
                res.add(new ArrayList<Integer>(ele));    //!!!如果直接add（ele）res中的ele和后面使用的ele是同一个，会不断改变，所以讲ele中内容复制并储存
            }
            return;          //!!!放的位置很重要
        }
        //recursion
        for(int i=0; i <= target / coins[level]; i++){
            ele.add(i);
            findDfs(target - i * coins[level], coins, res, ele, level +  1);
            ele.remove(ele.size() - 1);  //ArrayList.size() not .length()
        }
    }

    public static void main(String[] args){
        CombinationCoins test = new CombinationCoins();
        int target = 10;
        int[] coins = new int[]{34,31,29,16,2};
        System.out.println(test.combinations(target,coins));
    }
}
