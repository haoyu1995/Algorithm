package OA.nutanixOA;

public class EmailRead {
    public int countOper(int[] emails){
        int sum = 0;
        for (int i = 0; i < emails.length;i++){
            if (emails[i] == 1){
                sum++;
                if (i < emails.length-1 && emails[i+1] == 0){
                    sum++;
                }
            }
        }
        if (emails[emails.length-1] == 0){
            sum--;
        }
        return sum;
    }

    public static void main(String[] args){
        EmailRead test = new EmailRead();
        System.out.println(test.countOper(new int[]{0,0,0,1,1,0,0,1,0,1,0,0}));
    }
}
