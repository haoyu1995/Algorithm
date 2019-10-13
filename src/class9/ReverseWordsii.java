package class9;

import java.util.Arrays;


public class ReverseWordsii {
    public String reverseWords(String input) {
        // Write your solution here
        if (input == null || input == ""){
            return input;
        }
        char[] in = input.toCharArray();

        //step 1: truncate all heading/trailing/duplicate space
        in = truncate(in);


        //step 2: reverse the whole string
        reverse(in, 0, in.length-1);

        //step 3: reverse the each word
        int i = 0;
        int j = 0;
        while(i <= j && j < in.length){
           if (j == in.length-1 || in[j+1] == ' '){
               reverse(in, i, j);
               j = j + 2;
               i = j;
           }else{
                 j++;
           }
        }

        return new String(in);

    }

    private char[] truncate(char[] in){
        int i = 0;
        int j;
        // i =0, j!=' ': copy, j++, i++
        //       j = ' ': j++;
        // i!=0, j =' ': while(..), copy' ',i++, copy,i++,j++
        //       j!=' ': copy, j++, i++
        for(j = 0; j < in.length; j++){
            if (in[j] == ' ' && i !=0){
                while(j < in.length && in[j] == ' '){
                    j++;
                }
                if (j == in.length){
                    break;
                }
                in[i++] = ' ';
                in[i++] = in[j];
            }else if (in[j] != ' '){
                in[i++] = in[j];
            }
        }

        return Arrays.copyOf(in,i);
    }

    private void reverse(char[] arr, int left, int right){
        if (left >= right){
            return;
        }
        swap(arr,left, right);
        reverse(arr, left+1, right-1);
    }

    private void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args){
        ReverseWordsii test = new ReverseWordsii();
        System.out.println(test.reverseWords("  I  love Yahoo "));
        System.out.println(test.reverseWords("A B C D"));

    }
}
