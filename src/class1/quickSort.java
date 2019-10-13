package class1;

import java.util.Arrays;

public class quickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
        if(array==null || array.length==1){
            return array;
        }
        int left = 0;
        int right = array.length-1;
        quickSort1(array,left,right);
        return array;
    }
    //recursion
    private void quickSort1(int[] array,int left, int right){
        //base case
        if(left>=right){
            return;
        }
        //recursive rule
        int pivotindex = partition(array,left,right);
        quickSort1(array,left,pivotindex-1);
        quickSort1(array,pivotindex+1,right);
    }
    //partition the array into 2 parts, left side < pivot, right      side >=pivot
    private int partition(int[] array, int left, int right){
        int pivotId = getPivot(array,left,right);
        int pivot = array[pivotId];
        swap(array,pivotId,right);
        int i = left;
        int j = right-1;
        while(i<=j){
            if(array[i]<pivot){
                i++;
            }else if(array[i]>=pivot){
                swap(array,i,j);
                j--;
            }
        }
        swap(array,i,right);
        return i;
    }
    private int getPivot(int[] array, int left, int right){
        return (int)(left+Math.random()*(right-left+1));
    }
    private void swap(int[] array, int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    public static void main(String[] args){
        quickSort result = new quickSort();
        //test case
        int[] array=null;
        array = result.quickSort(array);
        System.out.println(Arrays.toString(array));

        int[] array1=new int[0];
        array1 = result.quickSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2=new int[]{2,4,1,5};
        array2 = result.quickSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3=new int[]{23,1,4,1,6,3,7,2,11};
        array3 = result.quickSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4=new int[]{2,4,1,5,7,6,2,4};
        array4 = result.quickSort(array4);
        System.out.println(Arrays.toString(array4));
    }
}
