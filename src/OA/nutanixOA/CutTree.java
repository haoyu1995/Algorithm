package OA.nutanixOA;

public class CutTree {

//    perfect row。一个人有一堆树，有高有低，
//    他想剪成 （先升后降 ｜ 全升 ｜ 全降）的序列，问你最少需要砍掉几棵树

    public int beautifulTree(int[] arr){
        //return the tree cut
//        Step1: construct two arrays lis[] and lds[] using Dynamic Programming solution of LIS problem.
//                lis[i] stores the length of the Longest Increasing subsequence ending with arr[i].
//                lds[i] stores the length of the longest Decreasing subsequence starting from arr[i].
//        Step2: return the max value of lis[i] + lds[i] – 1
        int n = arr.length;
        int i, j;

        /* Allocate memory for LIS[] and initialize LIS values as 1 for
            all indexes */
        int[] lis = new int[n];
        for (i = 0; i < n; i++)
            lis[i] = 1;

        /* Compute LIS values from left to right */
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        /* Allocate memory for lds and initialize LDS values for
            all indexes */
        int[] lds = new int [n];
        for (i = 0; i < n; i++)
            lds[i] = 1;

        /* Compute LDS values from right to left */
        for (i = n-2; i >= 0; i--)
            for (j = n-1; j > i; j--)
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;


        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = lis[0] + lds[0] - 1;
        for (i = 1; i < n; i++)
            if (lis[i] + lds[i] - 1 > max)
                max = lis[i] + lds[i] - 1;

        return arr.length-max;

    }
}
