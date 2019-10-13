package blackrockOA;

enum Money{

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
        double change = cash - purchasePrice;
    }
}
