package class10;

public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        // Write your solution here

        //Step 1: do XOR on the 2 numbers, for this result, for every bit, if it is '1': that bit is different for a,b
        int c = a ^ b;
        int count = 0;

        // Step 2: calculate the number of bits that is '1' for c
        while (c != 0) {       //error 2: 不能是c>0, 因为可能c本来就 <0;
            if ((c & 1) == 1){        //error 1: == 逻辑运算符优先级高于位运算符
                count++;
            }
            c = c >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfDifferentBits test = new NumberOfDifferentBits();
        System.out.println(test.diffBits(-1,2147483647));
    }
}
