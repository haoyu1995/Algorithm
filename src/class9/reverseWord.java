package class9;

public class reverseWord {
    public String reverseWords(String input) {
        // Write your solution here
        // I love yahoo trick!! reverse twice!
        //corner case
        if (input == null || input == ""){
            return input;
        }
        char[] in = input.toCharArray();
        reverse(in, 0, in.length-1);
        int i = 0;
        int j = 0;
        while (i <= j && j < in.length){
            if (j == in.length-1 || in[j+1] == ' '){
                reverse(in, i, j);
                j = j+2;
                i = j;
            }else{
                j++;
            }
        }
        return new String(in);

    }

    private void reverse(char[] arr, int left, int right){
        //base case
        if (left >= right){
            return;
        }
        swap(arr, left, right);
        reverse(arr, left+1, right-1);
    }

    private void swap(char[] arr, int left, int right){
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args){
        reverseWord test = new reverseWord();
        System.out.println(test.reverseWords("It is a good day"));
    }
}
