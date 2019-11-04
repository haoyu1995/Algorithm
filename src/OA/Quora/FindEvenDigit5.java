package OA.Quora;

public class FindEvenDigit5 {
    public int findEvenDigit(int[] a) {

        int sum = 0;
        for (int ele : a){
            String elestr = Integer.toString(ele);
            if (ele < 0){
                elestr = elestr.substring(1,elestr.length());
            }
            if (elestr.length()%2 == 0){
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        FindEvenDigit5 test = new FindEvenDigit5();
        System.out.print(test.findEvenDigit(new int[]{12, 3, 5, -3456}));
    }
}
