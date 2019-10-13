package class12;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
        // corner case
        if (array == null || array.length == 0){
            return array;
        }
        quickSortRecur(array, 0, array.length-1);
        return array;
    }
    void quickSortRecur(int[] array, int left, int right){
        //base case
        if (left >= right){
            return;
        }
        //get pivot and put it at the end of array
        int pid = getPid(left,right);
        int pivot = array[pid];
        swap(array, pid, right);

        //divided by pivot
        int newpid = divided(array,left,right,pivot);
        quickSortRecur(array, left, newpid-1);
        quickSortRecur(array, newpid+1, right);
    }
    private int getPid(int i, int j){
        return i + (int)Math.random() * (j - i + 1);
    }
    private int divided(int[] array, int left, int right, int pivot){
        int i = 0;
        int j = right-1;
        while(i <= j){
            if (array[i] > pivot){
                swap(array,i,j);
                j--;
            }else{
                i++;
            }
        }
        swap(array,i,right);
        return i;
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        QuickSort result = new QuickSort();

        int[] array3=new int[]{23,1,4,1,6,3,7,2,11};
        array3 = result.quickSort(array3);
        System.out.println(Arrays.toString(array3));

    }
}
