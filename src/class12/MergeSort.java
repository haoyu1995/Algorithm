package class12;


import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here
        int[] res = new int[array.length];
        //corner case
        if (array == null || array.length == 0){
            return array;
        }
        mergeSortRecur(array, res, 0, array.length-1);
        return array;
    }

    void mergeSortRecur(int[] array, int[] res, int left, int right){
        int mid = left + (right-left)/2;
        //base case
        if (left >= right){
            return;
        }
        mergeSortRecur(array, res, left, mid);
        mergeSortRecur(array, res, mid+1, right);
        //use 2 pointers to merge array1 = array[left, mid] with array2=array[mid+1,right]
        merge(array, left, mid, right, res);

    }
    void merge(int[] array, int left, int mid, int right, int[] res){
        for (int k = left; k <= right; k++){
            res[k] = array[k];
        }
        int i = left;
        int j = mid+1;
        while (i <= mid && j <= right){
            array[i+j-mid-1] = res[i] <= res[j]? res[i++]: res[j++];
        }

        if (j > right){
            while(i <= mid){
                array[i+j-mid-1] = res[i++];
            }
        }
    }

    public static void main(String[] args){
        MergeSort result = new MergeSort();

        int[] array3=new int[]{23,1,4,1,6,3,7,2,11};
        array3 = result.mergeSort(array3);
        System.out.println(Arrays.toString(array3));

    }
}
