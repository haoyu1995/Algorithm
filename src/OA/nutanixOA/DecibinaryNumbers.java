package OA.nutanixOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecibinaryNumbers {
    public List<Integer> findDecibinary(int a){
        //step 1: find the maximum digit and store every digit in an array
        List<Integer> digits = new ArrayList<>(); //lower digit ----> high digit
        int maxdigit = Integer.MIN_VALUE;
        while (a > 0){
            maxdigit = Math.max(maxdigit, a%10);
            digits.add(a%10);
            a /= 10;
        }

        //step2: do maxdigit times loop to find represents
        List<Integer> res = new ArrayList<>();
        for (int i = maxdigit; i > 0; i--){
            int sum = 0;
            for (int j = digits.size()-1; j >= 0; j--){
                if (digits.get(j) >= 1){
                    sum = sum*10 + 1;
                    digits.set(j, digits.get(j)-1);
                }else {
                    sum = sum*10;
                }
            }
            res.add(sum);
        }
        Collections.sort(res);

        return res;

    }

    public static void main(String[] args){
        DecibinaryNumbers test = new DecibinaryNumbers();
        List<Integer> t1 = test.findDecibinary(21);
        System.out.println(t1.toString());
        List<Integer> t2 = test.findDecibinary(4);
        System.out.println(t2.toString());

    }


}
