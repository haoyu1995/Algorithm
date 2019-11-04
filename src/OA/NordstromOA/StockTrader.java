package OA.NordstromOA;

import java.util.LinkedList;
import java.util.Queue;

public class StockTrader {
    public String stockTraderBullish(String[] pairs){
        double sum9 = 0;
        double sum50 = 0;
        int dma9 = 0;
        int dma50 = 0;
        for (int i = 0; i < pairs.length; i++){
            String[] item = pairs[0].split("\\|");
            String date = item[0];
            double price = Double.parseDouble(item[1]);
            sum9 += price;
            if (i > 8){
                sum9 -= Double.parseDouble(pairs[dma9].split("\\|")[1]);
                dma9++;
            }
            sum50 += price;
            if (i > 49){
                sum50 -= Double.parseDouble(pairs[dma50].split("\\|")[1]);
                dma50++;
            }
            if (i >= 49){
                if (dma9/9.0 > dma50/50.0){
                    return date;
                }
            }
        }
        return "NULL";
    }
}
