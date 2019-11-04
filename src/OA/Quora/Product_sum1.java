package OA.Quora;

public class Product_sum1 {
    public int product_sum (int number) {
        int product = 1;
        int sum = 0;
        while(number > 0){
            int digit = number%10;
            product *= digit;
            sum += digit;
            number = number/10;
        }
        return product-sum;
    }

    public static void main(String[] args){
        Product_sum1 test = new Product_sum1();
        System.out.println(test.product_sum(230));
    }
}
