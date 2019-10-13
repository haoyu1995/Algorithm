package class8;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        //cornercase
        if (input==null || input == ""){
            return input;
        }
        char[] arr = input.toCharArray();
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != ' '){
                if (i>0 && arr[j-1] == ' '){
                    arr[i] = ' ';
                    i++;
                }
                arr[i] = arr[j];
                i++;
            }
        }
        return new String(arr, 0, i);
    }
    public static void main(String[] args){
        RemoveSpaces test = new RemoveSpaces();
        System.out.println(test.removeSpaces("   ILove  Yahoo"));
    }
}
