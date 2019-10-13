package class6;


import java.util.ArrayList;
import java.util.List;


public class AllSubets {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<String>();
        if (set==null){
            return res;
        }
        if (set == ""){
            res.add(set);
            return res;
        }
        StringBuilder ele = new StringBuilder();
        finalSubset(set,0,ele,res);
        return res;
    }

    private void finalSubset(String set, int level, StringBuilder ele, List<String> res){
        //base case
        if (level == set.length()){
            res.add(ele.toString());
            return;
        }
        //recursion
        //case1:add element
        ele.append(set.charAt(level));
        finalSubset(set,level+1,ele,res);
        ele.deleteCharAt(ele.length()-1); // !!!!important return to parentnode status
        //case2:add nothing
        finalSubset(set,level+1,ele,res);


    }

    public static void main(String[] args){
        AllSubets res = new AllSubets();

        String t1 = new String("abcde");
        System.out.println(res.subSets(t1));



    }
}
