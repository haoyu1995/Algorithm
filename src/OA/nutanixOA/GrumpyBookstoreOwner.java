package OA.nutanixOA;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //sliding window
        int ori = 0;
        int max = 0;
        int maxToSatisfied = 0;
        int l = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                ori += customers[i];
            }

            maxToSatisfied += customers[i]*grumpy[i];
            if(i>=X){
                maxToSatisfied -= customers[l]*grumpy[l];
                l++;
            }
            max = Math.max(max,maxToSatisfied);
        }
        return ori+max;

    }
}
