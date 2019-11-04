package OA.Quora;

import java.util.ArrayList;
import java.util.List;

public class KillKthPeople {
    public List<Integer> killkth(int n, int k){
        List<Integer> people = new ArrayList<>();
        for (int i = 0; i < n; i++){
            people.add(i);
        }
        List<Integer> res= new ArrayList<>();
        int start = 0;
        while(people.size()>1){
            int idToKill = (start+k-1)%people.size();
            res.add(people.get(idToKill)+1);
            people.remove(idToKill);
            start = idToKill;
        }
        return res;
    }
    public static void main(String[] args){
        KillKthPeople test = new KillKthPeople();
        List<Integer> t1 = test.killkth(5,3);
        for (int ele:t1){
            System.out.println(ele);
        }
    }
}
