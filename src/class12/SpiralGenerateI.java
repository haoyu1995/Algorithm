package class12;

public class SpiralGenerateI {
    public int[][] spiralGenerate(int n) {
        // Write your solution here
        int[][] res = new int[n][n];
        int start = 1;
        int offset = 0;
        spiralgenerateR(n,start,offset,res);
        return res;
    }
    private void spiralgenerateR(int n, int start, int offset, int[][] res){
        //base case
        if (n == 1){
            res[offset][offset] = start;
            return;
        }
        if (n < 1){
            return;
        }
        // generate the circle 12 --> 34--> 56--> 78
        //generate the top row
        for (int i = 0; i < n-1; i++){
            res[offset][offset+i] = start;
            start++;
        }
        //generate the right col
        for (int i = 0; i < n-1; i++){
            res[offset+i][offset+n-1] = start;
            start++;
        }
        //generate the bottom row
        for (int i = 0; i < n-1; i++){
            res[offset+n-1][offset+n-1-i] = start;
            start++;
        }
        //generate the left col
        for (int i = 0; i < n-1; i++){
            res[offset+n-1-i][offset] = start;
            start++;
        }

        //explore to the next circle by recursion
        spiralgenerateR(n-2,start,offset+1,res);
    }

    public static void main(String[] args){
        SpiralGenerateI test = new SpiralGenerateI();
        int[][] t1 = test.spiralGenerate(4);
        for (int i = 0; i < 4; i++){
            System.out.println(t1[i]);
        }
    }
}
