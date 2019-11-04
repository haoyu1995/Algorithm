package OA.nutanixOA;

public class PizzaTreat {
    public boolean pizzaCoupon(int[] pizzas){
        // transfer all even(excluding 0) to 2, all odd to 1
        for (int i = 0; i < pizzas.length;i++){
            if (pizzas[i] != 0 && pizzas[i] % 2 == 0){
                pizzas[i] = 2;
            }
            if (pizzas[i] % 2 == 1){
                pizzas[i] = 1;
            }
        }
        int i = 0;
        while (i < pizzas.length){
            if (pizzas[i] == 1){
                if (i == pizzas.length-1 || (i < pizzas.length-1 && pizzas[i+1]<1)){
                    return false;
                }else{
                    pizzas[i+1]--;
                }
            }
            i++;
        }
        return true;

    }

    public static void main(String[] args){
        PizzaTreat test = new PizzaTreat();
        System.out.println(test.pizzaCoupon(new int[]{1,2,1,2}));
        System.out.println((test.pizzaCoupon(new int[]{1,0,1})));
    }
}
