package OA.Quora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiagonalSort {
    int[][] diagonalSort(int[][] matrix){
        //row-col = diff
        List<Integer> temp = new ArrayList<>();
        for (int diff = 0-matrix.length+1; diff < matrix.length; diff++){
            //start row
            int row = diff<=0 ? 0: diff;
            while(row < matrix.length && row-diff < matrix.length){
                temp.add(matrix[row][row-diff]);
                row++;
            }
            Collections.sort(temp);
            row = diff<=0 ? 0: diff;
        while(row < matrix.length && row-diff <matrix.length){
            matrix[row][row-diff] = temp.remove(0);
            row++;
        }
    }
        return matrix;
}
    public static void main(String[] args){
        DiagonalSort test = new DiagonalSort();
        int[][] matrix = new int[][] {
                {8, 4, 1},
                {4, 4, 1},
                {4, 8, 9}
        };
        int[][] t1 = test.diagonalSort(matrix);
        for (int[] ele : t1){
            System.out.println(Arrays.toString(ele));
        }
    }
}
