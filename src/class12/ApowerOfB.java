package class12;

public class ApowerOfB {
    public double power(int a, int b){
        if (a == 0 && b <= 0){    /// 0^0不成立 分母为0不成立
            return -1;
        }

        if (a == 0){
            return 0;
        }
        if (b == 0){
            return 1;
        }
        if (b == 1){
            return a;
        }
        if (b == -1){
            return (double)1.0/a;
        }

        double half1 = power(a, b/2);
        double half2 = power(a, b-b/2);
        return half1 * half2;
    }

    public static void main(String[] args){
        ApowerOfB test = new ApowerOfB();
        System.out.println(test.power(2,3));
        System.out.println(test.power(-2,3));
        System.out.println(test.power(-2,-3));
        System.out.println(test.power(0,8));
    }
}
