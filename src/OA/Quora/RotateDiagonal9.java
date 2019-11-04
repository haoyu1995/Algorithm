package OA.Quora;

public class RotateDiagonal9 {
    public void rotateDiagonal(int[][] matrix, int k) {
        for(int i = 0; i < k; i++){
            // use recursion
            dfsRotate(matrix, 0, matrix.length);
        }
    }

    private void dfsRotate(int[][] matrix, int offset, int size){
        //base case
        if (size <= 2){
            return;
        }
        // rotate 4 edges except the diagonal
        for (int i = 0; i < size-2; i++){
            int temp = matrix[offset][offset+1+i];
            matrix[offset][offset+1+i] = matrix[offset+size-2-i][offset];
            matrix[offset+size-2-i][offset] = matrix[offset+size-1][offset+size-2-i];
            matrix[offset+size-1][offset+size-2-i] = matrix[offset+1+i][offset+size-1];
            matrix[offset+1+i][offset+size-1] = temp;
        }

        //recurse into next circle
        dfsRotate(matrix, offset+1, size-2);
    }
//    主对角线对称
//    for (int i = 0; i < matrix.length; i++) {
//        for (int j = i; j < matrix[0].length; j++) {
//            if (i == j || i + j + 1 == matrix.length) {
//                continue;
//            }
//            int temp = matrix[i][j];
//            matrix[i][j] = matrix[j][i];
//            matrix[j][i] = temp;
//        }
//    }

//    副对角线对称
//    for (int i = 0; i < matrix.length; i++) {
//        for (int j = 0; i+j < matrix[0].length; j++) {
//            if (i == j || i + j + 1 == matrix.length) {
//                continue;
//            }
//            int temp = matrix[i][j];
//            matrix[i][j] = matrix[matrix.length-1-j][matrix.length-1-i];
//            matrix[matrix.length-1-j][matrix.length-1-i] = temp;
//        }
//    }

    public static void main(String[] args){
        RotateDiagonal9 test = new RotateDiagonal9();
        int[][] m = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        test.rotateDiagonal(m,1);
        for (int[] array: m){
            for (int ele : array){
                System.out.print(ele+",");
            }
            System.out.println(" ");
        }
    }

}
