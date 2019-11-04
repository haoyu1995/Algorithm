package OA.Quora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {
//    array = [1,1,2,3,2]
//    matrix = [[1,2,1], [2,4,2], [0,3,1]]
//    output : 5
    public int queryCount(int[] array, int[][] query){
        // hashmap to store the query
        // key: x  value: queries
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] q : query){
            if (!map.containsKey(q[2])){
                map.put(q[2],new ArrayList<>());
            }
            List<int[]> list = map.get(q[2]);
            list.add(q);
            map.put(q[2],list);
        }

        int res = 0;
        for (int i = 0; i < array.length; i++){
            if (map.containsKey(array[i])){
                List<int[]> ranges = map.get(array[i]);
                for (int[] range : ranges){
                    if (i >= range[0] && i <= range[1]){
                        res++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Query test = new Query();
        System.out.println(test.queryCount(new int[]{1,1,2,3,2}, new int[][]{ {1,2,1}, {2,4,2}, {0,3,1}}));
    }

}

