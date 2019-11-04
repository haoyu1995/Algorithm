package OA.stripeOA;

import java.util.*;

public class Question {
    /*

     * Complete the 'calculate_total_owed' function below.

     *

     * The function is expected to return an INTEGER.

     * The function accepts STRING_ARRAY actions as parameter.

     */

    Map<String, Integer> status = new HashMap();

    Map<String, Integer> num = new HashMap();

    public int calculate_total_owed(List<String> actions) {
        status.clear();
        num.clear();
        // Write your code here
        for (String action : actions){

            Action parsedAction = parse(action);
            if (parsedAction == null){ //check non usd
                continue;
            }
            if (parsedAction.getType().equals("CREATE")){
                if (!status.containsKey(parsedAction.getId()) && !num.containsKey(parsedAction.getId())){
                    status.put(parsedAction.getId(), 0); //status 0 represent CREATE
                    num.put(parsedAction.getId(), Integer.parseInt(parsedAction.getAmount()));

                }
            }
            if (parsedAction.getType().equals("FINALIZE")){
                if (status.get(parsedAction.getId()) == 0 && num.containsKey(parsedAction.getId())){
                    status.put(parsedAction.getId(),1); //status 1 represent FINALIZE
                    num.put(parsedAction.getId(),Integer.parseInt(parsedAction.getAmount()));
                }
            }
            if (parsedAction.getType().equals("PAY")){
                if (status.get(parsedAction.getId()) != null && status.get(parsedAction.getId()) == 1 && num.containsKey(parsedAction.getId())){
                    status.put(parsedAction.getId(),2); //status 2 represent PAY
                    num.put(parsedAction.getId(),0);
                }
            }
        }

        int sum = 0;
        for (String id : status.keySet()){
            if (status.get(id) != 2){
                sum += num.get(id);
            }
        }
        return sum;
    }

    // parse the String action content to Object Action
    private Action parse(String action){
        Action newaction = new Action();
        String[] contents = action.split(": ");
        if (contents.length < 2){
            return null;
        }
        newaction.setType(contents[0]);
        String[] temps = contents[1].toLowerCase().split("&");
        for (String temp: temps){
            String[] attr = temp.split("=");
            switch(attr[0]){
                case "id":
                    newaction.setId(attr[1]);
                    break;
                case "amount":
                    newaction.setAmount(attr[1]);
                    break;
                case "currency":
                    newaction.setCurrency(attr[1]);
            }
        }
        //check non-usd
        if (newaction.getCurrency() != null && !newaction.getCurrency().equals("usd")){
            return null;
        }
        return newaction;
    }

    public static void main(String[] args){
        Question test = new Question();
        List<String> test1 = new ArrayList<>(Arrays.asList(
                "CREATE: id=13&amount=800&currency=USD"
        ));
        System.out.println(test.calculate_total_owed(test1)); //800

        List<String> test2 = new ArrayList<>(Arrays.asList(
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD"
        ));
        int t2 = test.calculate_total_owed(test2);
        System.out.println(t2); //600

        List<String> test3 = new ArrayList<>(Arrays.asList(
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "CREATE: id=13&amount=800&currency=USD"
        ));
        System.out.println(test.calculate_total_owed(test3)); //1400

        List<String> test4 = new ArrayList<>(Arrays.asList(
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "PAY: id=16"
        ));
        System.out.println(test.calculate_total_owed(test4)); //0

        // Test9:

        List<String> test5 = new ArrayList<>(Arrays.asList(
                "CREATE: amount=800&id=16&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD&otherfield=a",
                "PAY: otherfield=a&id=16"
        ));
        int t5 = test.calculate_total_owed(test5);
        System.out.println(t5); //0

        // Not USD
        List<String> test6 = new ArrayList<>(Arrays.asList(
                "CREATE: amount=800&id=16&currency=USD",
                "FINALIZE: id=16&amount=600&currency=US"
        ));
        System.out.println(test.calculate_total_owed(test6)); // 800
        test6.add("PAY: id=16");
        System.out.println(test.calculate_total_owed(test6)); // 800

        //如果action 不在 create/finalize/pay里面，忽略
        List<String> test7 = new ArrayList<>(Arrays.asList(
                "Random action"
        ));
        System.out.println(test.calculate_total_owed(test7)); // 0

        //test 10: create 2 invoice with same id
        List<String> test8 = new ArrayList<>(Arrays.asList(
                "CREATE: id=16&amount=800&currency=USD",
                "FINALIZE: id=16&amount=600&currency=USD",
                "PAY: id=16",
                "CREATE: id=16&amount=800&currency=USD"
        ));
        System.out.println(test.calculate_total_owed(test8)); // 0
    }
}

class Action{
    private String type;
    private String id;
    private String amount;
    private String currency;

    public Action(){

    }

    public Action(String type, String id, String amount, String currency) {
        this.type = type;
        this.id = id;
        this.amount = amount;
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
