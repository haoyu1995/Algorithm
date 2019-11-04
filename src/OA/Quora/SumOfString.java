package OA.Quora;

public class SumOfString {
    public String sumOfString(String s1, String s2) {
        return ""+sum(s1)+sum(s2);
    }

    private int sum(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum += s.charAt(i)-'0';
        }
        return sum;
    }

    public static void main(String[] args){
        SumOfString test = new SumOfString();
        System.out.println(test.sumOfString("99","99"));
        System.out.println(test.sumOfString("12","99"));
    }
}
