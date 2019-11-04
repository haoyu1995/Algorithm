package OA.nutanixOA;

public class StringWeight_Hard {
    // Max of two cases: case1 character considered separately
    //                   case2 pair considered separately
    //DP dp[n]
    // dp[i] represents the max weight of substring from ith char to end char
    //  dp[i] = max(case1: 1+dp[i+1],
    //              case 2: 3/4 + dp[i+2])
    public int maxWeight(String str){
        //corner case
        if (str == null || str == ""){
            return 0;
        }
        char[] array = str.toCharArray();
        int len = array.length;
        int[] dp = new int[len+1];
        //base case: only one char in string
        dp[len] = 0;
        dp[len-1] = 1;
        for (int i = len-2; i >=0; i--){
            if (array[i] != array[i+1]){
                //transfer to different,then as pair--3
                dp[i] = Math.max(4+dp[i+2],1+dp[i+1]);
            }else{
                dp[i] = Math.max(1+dp[i+1],3+dp[i+2]);
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        StringWeight_Hard test = new StringWeight_Hard();
        System.out.println(test.maxWeight("110"));
        System.out.println(test.maxWeight("00"));
        System.out.println(test.maxWeight("011"));
    }
}
