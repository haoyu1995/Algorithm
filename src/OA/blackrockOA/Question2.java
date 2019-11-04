package OA.blackrockOA;

import java.math.BigDecimal;

enum Money{
    OnePence(0.01, "OnePence"), TwoPence(0.02, "TwoPence"),
    FivePence(0.05, "FivePence"), TenPence(0.10, "TenPence"), TwentyPence(0.20, "TwentyPence"),
    FiftyPence(0.50, "FiftyPence"), OnePound(1, "OnePound"),
    TwoPounds(2, "TwoPound"), FivePounds(5, "FivePound"), TenPounds(10, "TenPound"),
    TwentyPounds(20, "TwentyPound"), FiftyPound(50, "FiftyPound");
    private double value;
    private String name;
    private Money(double value, String name){
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
public class Question2 {
    public void calculateChange(double purchasePrice, double cash){
        if (purchasePrice == cash){
            System.out.println("Zero");
            return;
        }
        if (purchasePrice > cash || cash < 0 || purchasePrice < 0){
            System.out.println("Error");
            return;
        }
        double change = subtract(cash, purchasePrice);
        String output = "";
        Money[] moneys = Money.values();
        for (int i = moneys.length-1; i >= 0; i--){
            int num = (int)(change/moneys[i].getValue());
            change = subtract(change, num * moneys[i].getValue());
            for (int j = 0; j < num; j++){
                output += moneys[i].getName() + ",";
            }
            if (change == 0){
                break;
            }
        }
        System.out.println(output.substring(0,output.length()-1));
    }

    // solve precision of double when do subtract
    private double subtract(double a, double b){
        BigDecimal c = new BigDecimal(Double.toString(a));
        BigDecimal d = new BigDecimal(Double.toString(b));
        return c.subtract(d).doubleValue();
    }

    public static void main(String[] args){
        Question2 t1 = new Question2();
        t1.calculateChange(0,0);
        t1.calculateChange(0.2,0.25);
        t1.calculateChange(50,12);
    }
}
