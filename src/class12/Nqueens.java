package class12;

import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    public int totalNQueens(int n) {
        // Write your solution here

        if (n <= 0){
            return 0;
        }
        // int count = 0不行
        int[] count = new int[1];
        List<Integer> cur = new ArrayList<Integer>();
        dfs(n, cur, count);
        return count[0];
    }

    void dfs(int n, List<Integer> cur, int[] count){
        if (cur.size() == n){
            count[0]++;
        }

        for(int i = 0; i < n; i++){
            if (isvaild(cur,i)){
                cur.add(i);
                dfs(n, cur, count);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isvaild(List<Integer> cur, int col){
        for (int i = 0; i < cur.size(); i++){
            if (cur.get(i) == col || Math.abs(col - cur.get(i)) == cur.size() - i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Nqueens test = new Nqueens();
        System.out.println(test.totalNQueens(4));
    }
}
