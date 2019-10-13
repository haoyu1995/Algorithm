package class9;

public class Reverse {
    public String reverse(String input) {
        // Write your solution here
        //corner case
        if (input == null || input == ""){
            return input;
        }
        //method 1: iterative
        char[] in = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;
        while(i < j){
            swap(in, i, j);
            i++;
            j--;
        }
        String s = new String(in);
        return s;
    }

    private void swap(char[] array, int i, int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        Reverse test;
        test = new Reverse();
        System.out.println((test.reverse("plpegge")));
    }
}
