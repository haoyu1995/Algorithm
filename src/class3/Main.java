package class3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x,y;
        long x1 = 1000000000;
        long y1 = x1;
        long x2 = -x1;
        long y2 = x2;
        for (int i = 0; i<n; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            x1 = Math.min(x,x1);
            x2 = Math.max(x,x2);
            y1 = Math.min(y,y1);
            y2 = Math.max(y,y2);
        }
        long a = Math.max(Math.abs(x2-x1),Math.abs(y2-y1));
        System.out.println(a*a);
        sc.close();


    }
}
