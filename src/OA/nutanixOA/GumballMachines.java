package OA.nutanixOA;

import java.util.HashMap;
import java.util.Map;

public class GumballMachines {
    public double countWast(String[] balls){
        // Maintain a Hashmap to record the fill of current gumballs
        // key: color value: date of refill
        double waste = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < balls.length; i++){
            map.put(balls[i], i);
            if (map.size() > 3){ //there is empty machine
                //find the machine with smallest balls
                String wasteColor = "";
                int small = Integer.MAX_VALUE;
                for (Map.Entry<String,Integer> entry : map.entrySet()){
                    if (small > entry.getValue()){
                        small = entry.getValue();
                        wasteColor = entry.getKey();
                    }
                }
                waste += (1000-10*(i-map.get(wasteColor)))/(double)100;
                //update map
                map.remove(wasteColor);
            }
        }
        return waste;
    }

    public static void main(String[] args){
        GumballMachines test = new GumballMachines();
        System.out.println(test.countWast(new String[]{"red", "green", "blue", "red", "white"}));
    }
}
