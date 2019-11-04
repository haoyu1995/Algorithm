package OA.Quora;

import java.util.HashSet;
import java.util.Set;

public class IsPrefix10 {
    public boolean isPrefix(String[] a, String[] b){
        //corner case
        if (a == null || a.length == 0){
            return false;
        }
        if (b == null || b.length == 0){
            return false;
        }
        //dfs store all permutation of a in hashSet
        Set<String> aset = new HashSet<>();
        StringBuilder str = new StringBuilder();
        dfspermu(aset, str, a, 0);
        for (String ele : b){
            if (!aset.contains(ele)){
                return false;
            }
        }
        return true;
    }

    private void dfspermu(Set<String> set,StringBuilder str, String[] a, int level){
        // base case
        if (level == a.length){
            return;
        }

        for (int i = level; i < a.length; i++){
            str.append(a[i]);
            swap(a,i,level);
            set.add(new String(str));
            dfspermu(set, str, a, level+1);
            if (str.length()!=0) {
                str.delete(str.length() - a[i].length(), str.length());
            }
            swap(a,i,level);
        }
    }

    private void swap(String[] a, int i, int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        IsPrefix10 test = new IsPrefix10();
        System.out.println(test.isPrefix(new String[]{"ab","c","d"}, new String[]{"abc","abd","cd","dab"}));
    }
}
