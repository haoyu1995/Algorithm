package OA.nutanixOA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ColoredLoop {
    public boolean checkLoop(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] expanded = new int[n][m];
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (checkNei(i,j,matrix)<2){
                    continue;
                }
                ////use BFS
                q.offer(new Pos(i,j));
                while(!q.isEmpty()){
                    //expand
                    Pos temp = q.poll();
                    expanded[temp.x][temp.y] = 1;
                    //generate
                    if (temp.y < m-1 && expanded[temp.x][temp.y+1]==0 && matrix[temp.x][temp.y+1] == matrix[temp.x][temp.y]){
                        if (q.peek()!=null && temp.x == q.peek().x && temp.y+1 == q.peek().y){//meet in one point
                            return true;
                        }
                        q.offer(new Pos(temp.x,temp.y+1));
                    }
                    if (temp.y > 0 && expanded[temp.x][temp.y-1]==0 && matrix[temp.x][temp.y-1] == matrix[temp.x][temp.y]){
                        if (q.peek()!=null && temp.x == q.peek().x && temp.y-1 == q.peek().y){//meet in one point
                            return true;
                        }
                        q.offer(new Pos(temp.x,temp.y-1));
                    }
                    if (temp.x > 0 && expanded[temp.x-1][temp.y]==0 && matrix[temp.x-1][temp.y] == matrix[temp.x][temp.y]){
                        if (q.peek()!=null && temp.x-1 == q.peek().x && temp.y == q.peek().y){//meet in one point
                            return true;
                        }
                        q.offer(new Pos(temp.x-1,temp.y));
                    }
                    if (temp.x < n-1 && expanded[temp.x+1][temp.y]==0 && matrix[temp.x+1][temp.y] == matrix[temp.x][temp.y]){
                        if (q.peek()!=null && temp.x+1 == q.peek().x && temp.y == q.peek().y){//meet in one point
                            return true;
                        }
                        q.offer(new Pos(temp.x+1,temp.y));
                    }

                }

            }
        }
        return false;
    }
    private int checkNei(int x, int y, int[][] matrix){
        int up = Math.max(0,x-1);
        int left = Math.max(0,y-1);
        int bot = Math.min(x+1,matrix.length-1);
        int right = Math.min(y+1, matrix[0].length-1);
        int sum=0;
        if (matrix[x][y] == matrix[up][y]){
            sum++;
        }
        if (matrix[x][y] == matrix[x][left]){
            sum++;
        }
        if (matrix[x][y] == matrix[bot][y]){
            sum++;
        }
        if (matrix[x][y] == matrix[x][right]){
            sum++;
        }
        return sum;
    }
    public static void main(String[] args){
        ColoredLoop test = new ColoredLoop();
        int[][] t1 = new int[][]{{'A','A','A','B'},{'A','B','A','B'},{'A','B','A','A'},{'B','B','A','B'}};
        System.out.println(test.checkLoop(t1));
    }
}
class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
