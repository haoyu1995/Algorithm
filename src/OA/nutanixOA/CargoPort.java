package OA.nutanixOA;

public class CargoPort {
    public int countStop(int[] weights, int[] ports, int weightlimit, int conlimit){
        int i = 0;
        int sumWei = 0;
        int sumCon = 0;
        int prePort = -1; //-1 represents pick-up port
        int res = 1;
        while(i < weights.length){
            sumWei += weights[i];
            sumCon ++;
            //cal the num of ports
            if (ports[i] != prePort){
                res++;
                prePort = ports[i];
            }
            // when reach to max capicity, delivery the cargo loaded in ship
            if (i < weights.length-1 && (sumWei+weights[i+1] > weightlimit || sumCon+1 > conlimit)){
                //reset the cargo and Port
                sumCon = 0;
                sumWei = 0;
                prePort = -1;
                res ++; //return to pick up port
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        CargoPort test = new CargoPort();
        System.out.println(test.countStop(new int[]{70,60,30}, new int[]{2,4,1},150,2));
        System.out.println(test.countStop(new int[]{30,30,100,90,50}, new int[]{3,3,1,1,3},180,5));
    }
}
