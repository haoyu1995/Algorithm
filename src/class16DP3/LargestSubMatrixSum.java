package class16DP3;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // Write your solution here
    /*-----------------------------------------------------
    // solution 1: Time = O(n^4) Space = O(n^2)
    // maintain a auxiliary matrix M[i][j] to store the sum of matrix with [i][j] as right-bottom corner,
    // [0][0] as top left corner.
    //     xxxxxxxxx
    //     xxxaxxxbx
    //     xxxcxxxdx
    // So the the largest submatrix sum = Md-Mb上-Mc左+Ma左上
    // **** How to get the matrix M?
    // maintain a variable prefix to store the sum from 0th to j-1th on i row
    // from left to right, top-down: M[i][j] = M[i-1][j] + array[j]

    //corner case
    if (matrix == null|| matrix[0] == null || matrix.length == 0||matrix[0].length == 0){
      return 0;
    }

    //Step 1:maintain the auxiliary matrix M
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] M = new int[m][n];
    int prefix_sumRow = 0;
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if (i == 0){ //row 1
          M[i][j] = j == 0? matrix[0][0]:M[i][j-1]+matrix[i][j];
        }else{
          if (j == 0){
            prefix_sumRow = matrix[i][j];
            M[i][j] = M[i-1][j] + matrix[i][j];
          }else{
            prefix_sumRow += matrix[i][j];
            M[i][j] = M[i-1][j] + prefix_sumRow;
          }
        }
      }
    }
    //Step 2:
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < m; i++){//upper bound
      for(int j = i; j < m; j++){//lower bound   //--------------error3!! j,l应该以i，k为起始
        for(int k = 0; k < n; k++){ // leftbound
          for(int l = k; l < n; l++){ //rightbound
            //考虑 OutOfBound--------------------------------------error2!!!
            int sum = 0;
            if (i == 0 && k == 0){
              sum = M[j][l];
            }else if(i == 0){
              sum = M[j][l] - M[j][k-1];
            }else if (k == 0){
              sum = M[j][l] - M[i-1][l];
            }else{
              sum = M[j][l] - M[i-1][l] - M[j][k-1] + M[i-1][k-1];    //--------!!error1!!!!
            }

            res = Math.max(res,sum);
          }
        }
      }
    }
    return res;
    ----------------------------*/

        //solution 2 Time = O(n*m*2n)
        // when choose the upper bound i, lower bound j,
        // calculate the sum of each column between rowi and rowj by do prefix-sum on each column
        // we will get an array sum[n], find the largest sum of subarray
        //Step 1: preprocess: maintain a matrix ver[][] to store 1-D prefix sum on each column
        //        ver[i][j] represents the sum from matrix[0][j] to matrix[i][j] vertically
        //Step 2: for all possible upper bound and lower bound:
        //             do sum on each col of it by processed matrix ---> sum[n]
        //              find the largest sum of subarray for sum[n]

        //corner case
        if (matrix == null|| matrix[0] == null || matrix.length == 0||matrix[0].length == 0){
            return 0;
        }

        //preprocess
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ver = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0){
                    ver[i][j] = matrix[i][j];
                }else{
                    ver[i][j] = matrix[i][j] + ver[i-1][j];
                }
            }
        }

        //Step 2
        int res = Integer.MIN_VALUE;
        int[] sum = new int[n];
        for(int i = 0; i < m; i++){  //upper
            for (int j = i; j < m; j++){  //lower
                for(int k = 0; k < n; k++){
                    if (i == 0){
                        sum[k] = ver[j][k];
                    }else{
                        sum[k] = ver[j][k] - ver[i-1][k];       // --------------error ver[i-1][k] not[i][k]
                    }
                }
                res = Math.max(res, largestSumSubarray(sum));
            }
        }

        return res;

    }

    private int largestSumSubarray(int[] array){
        // m[i] represents the largest sum of subarray from 0th to ith(including ith)
        if (array == null || array.length == 0){
            return 0;
        }
        int[] m = new int[array.length];
        m[0] = array[0];
        int global = array[0];
        for (int i = 1; i < array.length; i++){
            if (m[i-1] >= 0){
                m[i] = m[i-1] + array[i];
            }else{
                m[i] = array[i];
            }
            global = Math.max(global,m[i]);
        }
        return global;
    }
    public static void main(String[] args){
        LargestSubMatrixSum test = new LargestSubMatrixSum();
        int[][] t1 = {{-1}};
        System.out.println(test.largest(t1));
    }
}
