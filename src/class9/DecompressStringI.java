package class9;

public class DecompressStringI {
    public String decompress(String input) {
        // Write your solution here
        char[] in = input.toCharArray();
        //resize
        int extend = 0;
        for(int i = 0; i < in.length; i++){
            if (in[i] >= '2' && in[i] <= '9'){
                int num = (int)(in[i] - '0') - 2;
                extend += num;
            }
        }
        char[] res = new char[in.length + extend];

        int slow = res.length - 1;
        int fast = in.length - 1;
        while (fast >= 0){
            if (fast >=1 && in[fast] >= '2' && in[fast] <= '9'){
                int count = (int)(in[fast] - '0');
                for(int j = 0; j < count; j++){
                    res[slow--] = in[fast-1];
                }
                fast -= 2;
            }else{
                res[slow--] = in[fast--];
            }
        }
        return new String(res);
    }
    public static void main(String[] args){
        DecompressStringI test = new DecompressStringI();
        System.out.println(test.decompress("ap2lec3n"));

    }
}
