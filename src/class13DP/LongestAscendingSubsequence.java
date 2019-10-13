package class13DP;

public class LongestAscendingSubsequence {
    public int longest(int[] array) {
        // Write your solution here
        //DP
        // base case: array.length == 1 --> 1
        // induction rule: M[i] represents the length of longest ascending subsequence from 0th to ith element
        //                 M[i] = M[k]+1 when looking back from ith element, array[k] is the first element smaller than array[i]

        //corner case
        if (array == null || array.length == 0){
            return 0;
        }
        int[] record = new int[array.length];
        //base case
        record[0] = 1;
        int globalmax = 1;
        //induction
        for (int i = 1; i < array.length; i++){
            int longestSmaller = 0;
            for (int j = i - 1; j >=0; j--){
                if (array[j] < array[i]){
                    longestSmaller = Math.max(longestSmaller, record[j]);
                }
            }
            record[i] = longestSmaller + 1;
            globalmax = Math.max(globalmax, record[i]);
        }
        return globalmax;
    }
    public static void main(String[] args){
        LongestAscendingSubsequence test = new LongestAscendingSubsequence();
        int[] a = new int[]{1,5,3,2,6,4,3,2,8,4,9,5,5,3,1,6,4,2,7,6,3,8};
        System.out.println(test.longest(a));
    }
}
