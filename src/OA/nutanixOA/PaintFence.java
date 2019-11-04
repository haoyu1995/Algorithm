package OA.nutanixOA;

public class PaintFence {
//    https://leetcode.com/discuss/interview-question/403548/Nutanix-Online-Assessment
//    Test Cases:
//    n = 5, arr = 10101
//    Output = 4
//
//    The ways to divide the fence are:
//            10|10|1
//            1|010|1
//            10|1|01
//            1|01|01
//
//    n = 2, arr = 00
//    Output = 0

//    solution:
//    Just count 0s between 1s and increment it.---the index of '1' - index of next '1'
//    Then multiply all counts it willl given number of ways

    public int countWays(int arr[], int n)
    {
        int pos[] = new int[n];
        int p = 0;

        // for loop for saving the
        // positions of all 1s
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == 1)
            {
                pos[p] = i + 1;
                p++;
            }
        }

        // If array contains only 0s
        if (p == 0)
            return 0;

        int ways = 1;
        for (int i = 0; i < p - 1; i++)
        {
            ways *= pos[i + 1] - pos[i];
        }

        // Return the total ways
        return ways;
    }
}
