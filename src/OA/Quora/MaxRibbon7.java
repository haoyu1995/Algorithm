package OA.Quora;

public class MaxRibbon7 {
    public int maxRibbon(int[] A, int k) {
        //A is sorted.
        //corner case
        if ( A == null || A.length == 0 || k == 0){
            return 0;
        }
        if (k == 1){
            return A[A.length-1];
        }
        int maxsize = 0;
        //binary search to find the maxsize
        int lo = A[0];
        int hi = A[A.length-1];
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            int parts = cutPart(A,mid);
            if (parts >= k){
                maxsize = Math.max(maxsize,mid);
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return maxsize;
    }

    private int cutPart(int[] array, int len){
        int sum = 0;
        for (int rib : array){
            if (rib >= len){
                sum += rib/len;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        MaxRibbon7 test = new MaxRibbon7();
        System.out.print(test.maxRibbon(new int[]{1, 2, 3, 4, 9},5));
    }

}
