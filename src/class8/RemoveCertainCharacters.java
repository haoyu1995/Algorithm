package class8;


import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        if (input == null || input == "" || t == null || t == ""){
            return input;
        }
        // t contains duplicate elements
        //!!!use char array to store input, hashset to store t, because need to delete duplicate ele and can check by contains.
        //String--> char[] : input.toCharArray()
        //char[] --> String : String.valueOf(input)
        //String length() size() 均可
        char[] inputarr = input.toCharArray();
        Set<Character> delet = new HashSet<>();
        for (int i = 0; i < t.length(); i++){
            delet.add(t.charAt(i));
        }
        int i = 0; //slow pointer
        int j = 0; //faster pointer
        while(j < inputarr.length){
            if (!delet.contains(inputarr[j])){

                inputarr[i] = inputarr[j];//copy
                i++;
            }
            j++;
        }
        return new String(inputarr,0,i); //!!!截取char array一部分并转化为String，用String的构造函数 not include input[i]

    }

    public static void main(String[] args){
        RemoveCertainCharacters test = new RemoveCertainCharacters();
        System.out.println(test.remove("abcdefg", "af"));
    }
}
