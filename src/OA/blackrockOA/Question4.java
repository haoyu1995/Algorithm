package OA.blackrockOA;

import java.util.*;

public class Question4 {
//    Assumptions:
    //  Shares are positive decimals
    //  There will always be at least 1 asset present in the Portfolio and Benchmark
//      A particular asset can be bond, stock, or both
//      The trades should be sorted in alphabetical order based on the names of the assets;
//      if both bonds and stock are present for an asset, list bonds first
//    輸入:
//    The first part of the input is the Portfolio holdings (in the format Name,AssetType,Shares where each asset is separated by '|' symbol)
//    The second part of the input is the Benchmark holdings (in the format Name,AssetType,Shares where each asset is separated by '|' symbol)
//    Example input: Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15
//    Note that the two parts are separated by the ':' symbol.
//
//            輸出：
//    The output is a list of transactions (separated by new line) in the format TransactionType,Name,AssetType,Shares. Note that the TransactionType should only be BUY or SELL.
//    Example output: SELL,Google,STOCK,5 BUY,Vodafone,STOCK,5
    public void matchBenchmark(String input){
        String[] inputs = input.split(":");
        String[] portsStr = inputs[0].split("\\|");
        String[] benchStr = inputs[1].split("\\|");
        //get HashMap for Portfolio and Benchmark
        Map<Asset, Double> ports = getMap(portsStr);
        Map<Asset, Double> benchs = getMap(benchStr);
        // calculate the trasactions
        List<Trade> trades = tradeForMatch(ports,benchs);
        Collections.sort(trades);
        for (Trade trade: trades){
            System.out.println(trade.toString());
        }


    }

    private Map<Asset, Double> getMap(String[] assets){
        Map<Asset, Double> map = new HashMap<>();
        for (String asset : assets){
            String[] one = asset.split(",");
            Asset newasset = new Asset();
            newasset.setName(one[0]);
            newasset.setType(one[1]);
            if (!map.containsKey(newasset)){
                map.put(newasset,Double.parseDouble(one[2]));
            }else{
                map.put(newasset,Double.parseDouble(one[2])+map.get(newasset));
            }
        }
        return map;
    }

    private List<Trade> tradeForMatch(Map<Asset, Double> ports, Map<Asset, Double> benchs){
        List<Trade> tradelist = new ArrayList<>();
        //check to benchmarks
        for (Asset key: benchs.keySet()){
            if (ports.containsKey(key)){
                if (ports.get(key) > benchs.get(key)){
                    //sell the diff num of shares
                    Double diff = ports.get(key) - benchs.get(key);
                    tradelist.add(new Trade(key,"SELL",diff));
                }else if (ports.get(key) < benchs.get(key)){
                    //buy diff num of shares
                    tradelist.add(new Trade(key,"BUY",benchs.get(key)-ports.get(key)));
                }
            }else{
                //buy same num of shares as benchs
                tradelist.add(new Trade(key,"BUY",benchs.get(key)));
            }
            ports.put(key,benchs.get(key));
        }
        //SELL the asset which bench doesn't hold
        for (Asset key: ports.keySet()){
            if (!benchs.containsKey(key)){
                //sell
                tradelist.add(new Trade(key,"SELL",ports.get(key)));
            }
        }
        return tradelist;
    }

    public static void main(String[] args){
        Question4 test = new Question4();
        test.matchBenchmark("Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15");
    }
}

class Asset implements Comparable<Asset>{
    private String name;
    private String type;

    public Asset(){

    }
    public Asset(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

//    @Override
//    public boolean equals(Object o) {
//        //check reference
//        if (this == o) return true;
//        //check null and class Type
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Asset asset = (Asset) o;
//        if (name.equals(asset.name)&&type.equals(asset.type)){
//            return true;
//        }
//
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (name != null ? !name.equals(asset.name) : asset.name != null) return false;
        return type != null ? type.equals(asset.type) : asset.type == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Asset o) {
        return name.compareTo(o.name);
    }
}

class Trade implements Comparable<Trade>{
    private Asset asset;
    private String tradetype;
    private double num;

    public Trade(){

    }

    public Trade(Asset asset, String tradetype, double num) {
        this.asset = asset;
        this.tradetype = tradetype;
        this.num = num;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public String getTradetype() {
        return tradetype;
    }

    public void setTradetype(String tradetype) {
        this.tradetype = tradetype;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return tradetype + "," + asset.getName() + "," +asset.getType() + "," + (int)num;
    }

    @Override
    public int compareTo(Trade o) {
        return asset.compareTo(o.asset);
    }
}
