package OA.Quora;

import java.util.HashSet;
import java.util.Set;

public class MaxArithmeticLength11 {
    public int maxArithmeticLength(int[] a, int[] b){
        //corner case
        if (a == null || a.length == 0){
            //use elements in b to get arithmetic progression
            return maxArithB(b);
        }
        if (b == null || b.length == 0){
            return isArith(a)? a.length:-1;
        }

        //get a set of a,b(no duplicate)
        Set<Integer> bset = new HashSet<>();
        for (int ele : b){
            bset.add(ele);
        }
        Set<Integer> aset = new HashSet<>();
        for (int ele : a){
            aset.add(ele);
        }

        int res = -1;

        //edge case
        if (a.length == 1){ //
            return MaxArithWithSingleNum(a[0],b,bset);
        }

        //a.length >= 2
        //find the greatest diff-- smallest diff of neighbors in a as max common dif
        int maxcd = Integer.MAX_VALUE;
        for (int i = 0; i < a.length-1; i++){
            maxcd = Math.min(maxcd, a[i+1]-a[i]);
        }
        // iterate common dif from maxcd to 1
        for (int i = maxcd; i > 0; i--){
            //iterate array a;
            int len = 1;
            int cur = a[0];
            // add ele before a[0]
            while(bset.contains(cur-i)){
                cur -= i;
                len++;
            }
            //add ele after a[0]
            while(aset.contains(cur+i) || bset.contains(cur+i)){
                cur += i;
                if (aset.contains(cur)){
                    aset.remove(cur);
                }
                len++;
            }

            res = Math.max(res, len);
        }

        return res;

    }

    private int MaxArithWithSingleNum (int a, int[] b, Set<Integer> hsB) {
        int ans = 1;
        for (int value : b) {
            int count = 2;
            int diff = value > a ? value - a : a - value;
            int cur = value > a ? value : a;
            while (hsB.contains(cur + diff)) {
                count++;
                cur += diff;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }


    //DP to find the longest arithmetic subarray in b
    private int maxArithB(int[] b){
        // maintain M[n][n]
        // M[i][j] ( i<j) represents the longest length of arithmetic progression with b[i],b[j] as first 2 element
        // base case: when j == n-1, the longest length of AP is 2
        // induction rule: based on the M[i][j], if find k > j to make b[j]*2 = b[i] + b[k]
        //                so M[i][j] = M[j][k]+1

        if (b == null || b.length < 2){
            return -1;
        }
        if (b.length == 2){
            return b.length;
        }

        int global = 2;

        int n = b.length;
        int[][] M = new int[n][n];

        //base case
        for (int i = 0; i < n; i++){
            M[i][n-1] = 2;
        }

        // find k, and do induction rule
        for (int j = n-2; j >= 0 ; j--){
            // fixed b[j] as middle, find b[i],b[k] to make b[j]*2 = b[i] + b[k]
            int i = j - 1;
            int k = j + 1;
            while(i >= 0 && k <= n-1){
                if (b[i] + b[k] > 2*b[j]){
                    M[i][j] = 2;
                    i--;
                }else if (b[i] + b[k] < 2*b[j]){
                    k++;
                }else{
                    //LLAP with i and j as first two elements = LLAP with j and k as first two elements + 1
                    M[i][j] = M[j][k] + 1;
                    global = Math.max(global,M[i][j]);
                    i--;
                    k++;
                }
            }
            // when k outofBound, but i didn't reach to 0
            //set remaining elements in column j as 2
            while (i >= 0){
                M[i][j] = 2;
                i--;
            }
        }
        return global;

    }

    private boolean isArith(int[] a){
        if (a.length < 2){
            return false;
        }
        if (a.length == 2){
            return true;
        }
        int diff = a[1] - a[0];
        for (int i = 1; i < a.length-1; i++){
            if (a[i+1] - a[i] != diff){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        MaxArithmeticLength11 test = new MaxArithmeticLength11();
        System.out.println(test.maxArithmeticLength(new int[]{}, new int[]{5,7,12,16,20}));
        System.out.println(test.maxArithmeticLength(new int[]{}, new int[]{}));
        System.out.println(test.maxArithmeticLength(new int[]{0,1,4,8,20}, new int[]{}));
        System.out.println(test.maxArithmeticLength(new int[]{20}, new int[]{5,7,12,16,22}));
        System.out.println(test.maxArithmeticLength(new int[]{0,4,8,20}, new int[]{5,7,12,16,22}));
    }
}
