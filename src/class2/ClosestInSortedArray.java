package class2;

public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        // Write your solution here
        if (array==null || array.length==0){
            return -1;
        }
        int left =0;
        int right=array.length-1;
        while(left<right-1){
            int mid = left+(right-left)/2;
            if(array[mid]==target){
                return mid;
            }else if(array[mid]>target){
                right=mid;
            }else{
                left=mid;
            }
        }
        if (Math.abs(target-array[right])<=Math.abs(target-array[left])){      //error1:Math.abs
            return right;
        }else{
            return left;
        }
    }
    public static void main(String[] args){
        ClosestInSortedArray result = new ClosestInSortedArray();
        int[] array = new int[] {3,4,5,6,6,12,16};
        int id = result.closest(array,10);
        System.out.println(id);
    }
}

