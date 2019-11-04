package OA.Quora;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoolFeature4 {
//    Input:
//    a = [1, 2, 3]
//    b = [3, 4]
//    query = [[1, 5], [1, 1 , 1], [1, 5]]
//    Output:
//            [2, 1]
//    Explain:
//    Just ignore every first element in sub array in query.
//    So we will get a new query like this query = [[5], [1, 1], [5]]
//    Only record the result when meet the single number in new query array.
//    And the rule of record is find the sum of the single number.
//    The example above is 5 = 1 + 4 and 5 = 2 + 3, there are two result.
//    So currently the output is [2]
//    When we meet the array length is larger than 1, such as [1, 1]. That means we will
//    replace the b[x] = y, x is the first element, y is second element. So in this example, the
//    b will be modify like this b = [1, 4]
//    And finally, we meet the [5] again. So we will find sum again. This time the result is 5
//            = 1 + 4.
//    So currently the output is [2, 1]

    public int[] coolfeature(int[] a, int[] b, int[][] querys){
        List<Integer> res = new ArrayList<>();
        // because maybe need to dynamic modify the array b
        //so we store the ele of a in Hashset
        Set<Integer> aset = new HashSet<>();
        for (int ele : a){
            aset.add(ele);
        }
        for (int[] query : querys){
            if (query.length == 2){
                int num = 0;
                int target = query[1];
                // find the num of sum
                for (int ele:b){
                    if (aset.contains(target-ele)){
                        num++;
                    }
                }
                res.add(num);

            }else if (query.length == 3){
                b[query[1]] = query[2];
            }
        }
        int[] resarray = new int[res.size()];
        // transfer list to array
        for (int i = 0; i < res.size(); i++){
            resarray[i] = res.get(i);
        }
        return resarray;
    }

    public static void main(String[] args){
        CoolFeature4 test = new CoolFeature4();
        int[] t1 = test.coolfeature(new int[]{1, 2, 3},new int[]{3, 4}, new int[][]{{1, 5},{1, 1 , 1},{1, 5}});
        for (int i : t1){
            System.out.print(i+",");
        }
    }
}
