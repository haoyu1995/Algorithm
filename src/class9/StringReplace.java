package class9;

import java.util.List;

import java.util.ArrayList;

public class StringReplace {
    public String replace(String input, String source, String target) {
        // Write your solution here
        //corner case
        if (input == null || input == "" || source == null || source == "" || target == null){
            return input;
        }
        char[] in = input.toCharArray();
        // * we should consider the situation of target == ""
        if (source.length() >= target.length()){
            return longToshort(in, source, target);
        }else{
            return shortTolong(in, source, target);
        }
    }

    private String longToshort(char[] in, String s, String t){
        int slow = 0;
        int fast = 0;
        while (fast < in.length){
            int i = 0;
            if (fast+s.length() > in.length || in[fast+i] != s.charAt(i)){ //!!!fast+s.length() > in.length 的情况考虑到
                in[slow++] = in[fast++];
            }else{
                while (i < s.length() && in[fast+i] == s.charAt(i)){
                    i++;
                }
                if (i == s.length()){
                    for (int j = 0; j < t.length(); j++){
                        in[slow++] = t.charAt(j);
                    }
                    fast = fast + s.length();

                }else{  //！！！！如果不能完全匹配
                    in[slow++] = in[fast++];
                }
            }
        }
        return new String(in,0,slow);
    }

    private String shortTolong(char[] in, String s, String t){
        //record the occurence of s in input array
        List<Integer> occurs = countOccur(in, s);

        //step 2: resize
        char[] newarray = new char[in.length + occurs.size() * (t.length() - s.length())];

        //initialize
        int slow = newarray.length - 1;
        int fast = in.length - 1;
        int k = occurs.size()-1;

        while(fast >= 0){
            int i = 0;
            if (k < 0 || fast+i != occurs.get(k)){ ////!!!
                newarray[slow--] = in[fast--];
            }else{
                while(s.length() > i && in[fast+i] == s.charAt(i)){
                    i++;
                }
                if (i == s.length()){
                    slow += s.length()-1;
                    for(int j = t.length()-1; j >= 0; j--){
                        newarray[slow--] = t.charAt(j);
                    }
                    fast--;
                    k--;
                }else{ //!!!!!
                    newarray[slow--] = in[fast--];
                }
            }
        }
        return new String(newarray);
    }

    private List<Integer> countOccur(char[] in, String s){
        List<Integer> occurs= new ArrayList<>();
        for (int i = 0; i < in.length; i++){
            int j = 0;
            while (i+j < in.length && j < s.length() && in[i+j] == s.charAt(j)){
                j++;
            }
            if (j == s.length()){
                occurs.add(i);
                i = i + s.length() - 1;
            }
        }
        return occurs;
    }

    public static void main(String[] args){
        StringReplace test = new StringReplace();
        System.out.println(test.replace("aaa","aa","bbb"));
    }
}
