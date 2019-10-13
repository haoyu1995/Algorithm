package class2;

public class Kclosest {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        if (array.length==0){
            return new int[] {-1};
        }
        int left=0;
        int right=array.length-1;
        int[] result=new int[k];
        while(left<right-1){
            int mid = left+(right-left)/2;
            if (array[mid]==target){
                left=mid;
                right=mid;
            }else if (array[mid]>target){
                right = mid;
            }else{
                left = mid;
            }
        }
        //post processing
        for(int i=0;i<k;i++){ //逻辑运算符按顺序计算，如果先计算array【left】就有可能出界报错
            if( left<0 || (right<=array.length-1 && Math.abs(array[left]-target)>=Math.abs(array[right]-target))){
                result[i]=array[right];
                right++;
            }else{
                result[i]=array[left];
                left--;
            }
        }
        return result;
    }
    public static void main (String[] args){
        Kclosest result = new Kclosest();
        int[] array = new int[] {1,5};
        System.out.println(result.kClosest(array,10,2));

    }
}
