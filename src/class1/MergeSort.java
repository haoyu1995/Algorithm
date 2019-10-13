package class1;

import java.util.Arrays;

public class MergeSort {
    public int[] MergeSort(int[] array) {
        // Write your solution here
        if (array==null || array.length == 0){
            return array;
        }
        int left = 0;
        int right = array.length-1;
        int[] temp = new int[array.length];
        mergeSort1(array,temp,left,right);
        return array;
    }
    private void mergeSort1(int[] array, int[] temp, int left, int right){
        if (left >= right){
            return;
        }
        int mid = left+(right-left)/2;
        mergeSort1(array,temp,left,mid);
        mergeSort1(array,temp,mid+1,right);
        merge(array,temp,left,mid,right);
    }
    private void merge(int[] array, int[] temp, int left, int mid, int right){
        for(int k=0; k<right-left+1; k++){
            temp[left+k] = array[left+k];
        }
        int i = left;
        int j = mid+1;
        int l = 0;
        while(i<=mid && j<=right){
            if (temp[i] <= temp[j]){
                array[left+l] = temp[i];
                i++;
            }else{
                array[left+l] = temp[j];
                j++;
            }
            l++;
        }
        //if we still have some elements uncomparable at left side, we need to copy it at end
        while(i<=mid){
            array[left+l] = temp[i];
            i++;
            l++;
        }
        //but if we still have some elements uncomparable at right side, we don't need copy it, because already there
        }

    public static void main(String[] args){
        MergeSort result = new MergeSort();
        //test case
        int[] array=null;
        array = result.MergeSort(array);
        System.out.println(Arrays.toString(array));

        int[] array1=new int[0];
        array1 = result.MergeSort(array1);
        System.out.println(Arrays.toString(array1));

        int[] array2=new int[]{2,4,1,5};
        array2 = result.MergeSort(array2);
        System.out.println(Arrays.toString(array2));

        int[] array3=new int[]{23,1,4,1,6,3,7,2,11};
        array3 = result.MergeSort(array3);
        System.out.println(Arrays.toString(array3));

        int[] array4=new int[]{2,4,1,5,7,6,2,4};
        array4 = result.MergeSort(array4);
        System.out.println(Arrays.toString(array4));
    }
}

