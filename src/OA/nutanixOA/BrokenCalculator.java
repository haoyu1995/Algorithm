package OA.nutanixOA;

public class BrokenCalculator {
    // function to find minimum
    // number of given operations
    // to convert m to n
    public int convert(int m, int n)
    {
        if (m == n)
            return 0;

        // only way is to do
        // -1 (m - n) times
        if (m > n)
            return m - n;

        // not possible
        if (m <= 0 && n > 0)
            return -1;

        // n is greater and n is odd
        if (n % 2 == 1)

            // perform '-1' on m
            // (or +1 on n)
            return 1 + convert(m, n + 1);

            // n is even
        else
            // perform '*2' on m
            // (or n / 2 on n)
            return 1 + convert(m, n / 2);
    }
}
