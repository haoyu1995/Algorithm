package class10;

public class ReverseBits {
    public long reverseBits(long n) {
        // Write your solution here
        // 01001011001000000000000000000000
        //  i                            j
        // if ith bit != jth bit: i: 1-->0, j:  0-->1
        int j = 0;
        int i = 31;
        while (i >= j){
            //get element at i,j
            long ele_i = (n >> i) & 1;
            long ele_j = (n >> j) & 1;
            if (ele_i != ele_j){
                n ^= ((1l << i) | (1l << j));
            }
            i--;
            j++;

        }
        return n;

    }
    public static void main(String[] args) {
        ReverseBits test = new ReverseBits();
        System.out.println(test.reverseBits(255));
    }
}
