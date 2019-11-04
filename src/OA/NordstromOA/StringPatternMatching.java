package OA.NordstromOA;

public class StringPatternMatching {
    public boolean stringPatternMatching(String s1, String s2){

//        Given two strings as input.
//                str1 => binary (consists 1/0)
//        str2 => consists A/B’s
//        Also, 0 represents ONE/more A’s
//        1 might represent ONE/more A’s (or) one/more B’s
//        Find if str2 matches str1 (based on the conditions specified) and return True/False
//        Example 1:
//        i/p:
//        str1 = 0100
//        str2 = AABBBAAA
//        o/p:
//        True
//        Explanation:
//        First 0 of str1 can match 2 initial A’s of str2. The next 1 can match the following 3 B’s. The next 0 of str1 can match the following 1 A and the final 0 of str1 can match the last 2 A’s of str2.
//

        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0 || i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                int c1 = s1.charAt(i - 1);
                int c2 = s2.charAt(j - 1);
                if (c1 == '0') {
                    if (c2 == 'A') {
                        dp[i][j] = dp[i - 1][j - 1];
                        if (j - 2 >= 0 && s2.charAt(j - 2) == 'A') {
                            dp[i][j] |= dp[i][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                    if (c2 == 'A') {
                        if (j - 2 >= 0 && s2.charAt(j - 2) == 'A') {
                            dp[i][j] |= dp[i][j - 1];
                        }
                    } else {
                        if (j - 2 >= 0 && s2.charAt(j - 2) == 'B') {
                            dp[i][j] |= dp[i][j - 1];
                        }
                    }
                }

            }
        }
        return dp[n][m];
    }
}
