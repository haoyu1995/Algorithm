package Strengthpractice2;

public class CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        // Write your solution here
        // Solution: DP maintain matrix M[length+2][length+2]
        //          index 0 represent the head of wood,
        //          index length-1 represent the end of wood
        //          M[i][j] represents the min cost to cut the stick between A[i-1] and A[j-1]
        //          for k in A array, if i < k < j, M[i][j] = min(M[i][k]+M[k][j])+(A[j-1]-A[i-1]);
        //          base case: i==j: M[i][i+1] = 0
        //
        //          0 1 2 3 4   fill the matrix from bottom-up, left to right
        //       0    0
        //       1      0
        //       2        0 3
        //       3          0
        //       4

        int[][] M = new int[cuts.length+2][cuts.length+2];
        int len = M.length;

        for (int i = len-2; i >= 0; i--){
            for (int j = i+1; j < len; j++){
                if (j == i+1){//base case
                    M[i][j] = 0;
                }else{
                    int min = Integer.MAX_VALUE;
                    int right = j == len-1 ? length: cuts[j-1];
                    int left = i == 0? 0: cuts[i-1];
                    for(int k = i+1; k < j; k++){
                        min = Math.min(min, M[i][k]+M[k][j]);
                    }
                    M[i][j] = min + right-left;
                }
            }
        }
        return M[0][len-1];
    }

    public static void main(String[] args){
        CuttingWoodI test = new CuttingWoodI();
        System.out.println(test.minCost(new int[]{2, 4, 7},10));
    }
}
