package class9;

public class Stringshuffle {
    public int[] reorder(int[] array) {
        // Write your solution here
        //Method 1: inplace space = O(1)
        int left = 0;
        int right = array.length-1;
        if (array.length % 2 != 0){
            right = right - 1;
        }
        reversedMergesort(array,left,right);
        return array;
    }
    private void reversedMergesort(int[] array, int left, int right){
        //base case
        if (left >= right - 1){
            return;
        }
        //recursion
        int size = right - left + 1;
        int m = left + size/2;
        int lm = left + size/4;
        int rm = left + size*3/4;

        //swap the word
        reverse(array, lm, m-1);
        reverse(array, m, rm-1);
        reverse(array, lm, rm-1);

        //!!! you need to consider k is odd
        reversedMergesort(array, left, left + 2*(lm - left)-1);  //!!!!consider the odd k situation
        reversedMergesort(array, left + 2*(lm - left), right);

    }

    private void reverse(int[] array, int left, int right){
        int i = left;
        int j = right;
        while(i <= j){
            swap(array,i,j);
            i++;
            j--;
        }

    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        int[] t1 = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        Stringshuffle test = new Stringshuffle();
        System.out.println(test.reorder(t1));
    }
}
