package blackrockOA;

public class Question1 {
    public void reverseSpell(String input){
        // filter all non-alphanumeric
        String in = input.replaceAll("[^A-Za-z0-9]","");
        // transfer to lowercase
        in = in.toLowerCase();

        //reverse and add -
        String res = "";
        for (int i = in.length()-1; i >= 0; i--){
            res += in.charAt(i);
            res += "-";
        }

        System.out.println(res.substring(0,res.length()-1));

    }

    public static void main(String[] args){
        Question1 test = new Question1();
        String t1 = "Hello, world!";
        test.reverseSpell(t1);
    }
}
