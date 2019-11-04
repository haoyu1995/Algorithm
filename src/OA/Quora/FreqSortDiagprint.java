package OA.Quora;

import java.util.*;

public class FreqSortDiagprint {
    public int[][] freqSortDiagprint(int[][] matrix){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())){
                    return (int) o1.getKey()-o2.getKey();
                }
                return (int) o1.getValue()-o2.getValue();
            }
        });
        for(Map.Entry<Integer,Integer> ele : map.entrySet()){
            pq.add(ele);
        }
        int[] array = new int[matrix.length*matrix[0].length];
        int index = 0;
        while(pq.size() != 0 && index < array.length){
            Map.Entry<Integer,Integer> ele = pq.poll();
            for (int i = 0; i < ele.getValue(); i++) {
                array[index++] = ele.getKey();
            }
        }
        index = 0;
        for (int i = matrix.length * 2 - 2; i >= 0; i--) {
            // j as start row
            int j = (i >= matrix.length) ? matrix.length - 1 : i;
            while(j >= 0 && i-j < matrix.length){
                matrix[j][i-j] = array[index++];
                j--;
            }
        }

        return matrix;

    }

    public static void main(String[] args){
        FreqSortDiagprint test = new FreqSortDiagprint();
        int[][] matrix = new int[][] {
                {1,1,2},
                {2,3,3},
                {3,3,4}
        };
        int[][] t1 = test.freqSortDiagprint(matrix);
        for (int[] ele : t1){
            System.out.println(Arrays.toString(ele));
        }
    }
}
