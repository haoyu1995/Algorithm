package class9;


import class6.CombinationSumII;

import java.util.ArrayList;
import java.util.List;


public class CompressString {
    public String compress(String input) {

        //Time = O(2n) Space = O(1)

        // Write your solution here
        char[] in = input.toCharArray();
        List<Integer> occur1 = new ArrayList<Integer>();

        //Step 1: from left to right, compress the only duplicate letters to this pattern;
        //        record the the index of that letters occured only once
        int slow = 0;
        int fast = 0;
        while (fast < in.length){
            int counter = 1;
            char temp = in[fast++];
            while(fast < in.length && in[fast] == temp){
                fast++;
                counter++;
            }
            if (counter >= 2){
                in[slow++] = temp;
                //in[slow++] = (char)('0' + counter); 只适用于0-9
                //如何将两位数int转化为char
                String cou = Integer.toString(counter);
                for(int j = 0; j < cou.length(); j++){
                    in[slow++] = cou.charAt(j);
                }
            }else{
                occur1.add(slow);
                in[slow++] = temp;
            }
        }

    /*

    //in = in.slice(0,slow); 如何截取数组

    // Step 2: first we need to extend the array based on the occur1,
    //         then from right to left, deal the letters that only occur once(abc --> a1b1c1)
    char[] res = new char[in.length + occur1.size()];
    slow = res.length - 1;
    fast = in.length - 1;
    int i = occur1.size() - 1;
    while (fast >= 0){
        if (i >= 0 && fast == occur1.get(i)){
            res[slow--] = '1';
            i--;
        }
        res[slow--] = in[fast--];
    }
    return new String(res);
    */
        return new String(in,0,slow);
    }

    public static void main(String[] args){
        CompressString test = new CompressString();
        System.out.println(test.compress("aaaaabbcccc"));
    }
}
