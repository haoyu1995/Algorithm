package class9;


import java.util.Arrays;

public class DecompressStringII {
    public String decompress(String input) {
        // Write your solution here
        char[] in = input.toCharArray();

        //Step 1: decompress the letters with 0 or 1 occurence from left to right
        // because the string will become shorter after decompression
        //at the same time, precalculate the extended size at step 2
        int slow = 0;
        int fast = 0;
        int extend = 0;
        while (fast < in.length){
            if (fast < in.length-1 && in[fast+1] == '0'){
                fast += 2;
            }else if (fast < in.length-1 && in[fast+1] == '1'){
                in[slow++] = in[fast++];
                fast++;
            }else{
                if(in[fast]>='2' && in[fast]<='9'){
                    int num = (int)(in[fast]-'2');
                    extend += num;
                }
                in[slow++] = in[fast++];
            }
        }
        in = Arrays.copyOfRange(in,0,slow);

        //Step 2: resize based on the precalculate extended size, then decompress the duplicate letters
        char[] res = new char[in.length + extend];
        slow = res.length-1;
        fast = in.length-1;
        while(fast >= 0){
            if(in[fast]>='2' && in[fast]<='9'){
                int count = (int)(in[fast]-'0');
                for (int i = 0; i < count; i++){
                    res[slow--] = in[fast-1];
                }
                fast -=2;

            }else{
                res[slow--] = in[fast--];
            }
        }
        return new String(res);



    }

    public static void main(String[] args){
        DecompressStringII test = new DecompressStringII();
        System.out.println(test.decompress("x2y0i0z3"));
    }
}
