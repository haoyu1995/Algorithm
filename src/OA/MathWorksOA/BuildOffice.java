package OA.MathWorksOA;

import java.util.*;

public class BuildOffice {
    public int minOfMaxDis(int w, int h, int n){
        //step 1: calculate all combinations of building n offices
        //use DFS
        List<List<Integer>> combis = new ArrayList<List<Integer>>();
        List<Integer> newcom = new ArrayList<>();
        dfs(combis, newcom, w*h, n, 0);

        //iterate all combinations
        // for each combination, initialize, calculate distance from nearest office, get max
        int shortdis = Integer.MAX_VALUE;
        for (List<Integer> com:combis){
            int maxdis = getDis(com,w,h);
            shortdis = Math.min(maxdis,shortdis);
        }
        return shortdis;
    }

    private void dfs (List<List<Integer>> combis,List<Integer> newcom, int len, int n, int index){
        //base case
        if (newcom.size() == n){
            combis.add(new ArrayList<>(newcom));
            return;
        }
        for (int i = index; i < len; i++){
            newcom.add(i);
            dfs(combis,newcom,len,n,index+1);
            newcom.remove(newcom.size()-1);
        }
    }

    private int getDis(List<Integer> com, int w, int h){
        //initialize lots
        int[][] lots = new int[h][w];
        for(int[] ele: lots){
            Arrays.fill(ele, -1);
        }

        int maxDist = 0;
        Queue<Location> Q = new LinkedList<>();
        for (int spot: com){
            int row = spot/w;
            int col = spot%w;
            lots[row][col] = 0;
            Q.add(new Location(row,col));
        }

        //bfs to calculate dis
        while(!Q.isEmpty()) {
            int x = Q.peek().x;
            int y = Q.peek().y;
            maxDist = Math.max(maxDist, lots[x][y]);
            Q.poll();

            for(int d = 0; d < 4; d++) {
                int newx = x;
                int newy = y;
                if (d < 2) {
                    newx = d==0? x+1: x-1;
                }else {
                    newy = d==2? y+1: y-1;
                }

                if(newx >= h || newy >= w || newx < 0 || newy < 0) {
                    continue;
                }
                if(lots[newx][newy] == -1) {
                    lots[newx][newy] = lots[x][y] + 1;
                    Q.add(new Location(newx, newy));
                }
            }
        }

        return maxDist;

    }
    public static void main(String[] args){
        BuildOffice test = new BuildOffice();
        //System.out.println(test.minOfMaxDis(4,4,3));
        //System.out.println(test.minOfMaxDis(2,3,2));
        System.out.println(test.minOfMaxDis(5,1,1));
    }
}

class Location{
    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
