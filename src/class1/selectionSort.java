package class1;

public class selectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int globalMin = i;
            for (int j = i; j < array.length; j++) {
                if (array[globalMin] > array[j]) {
                    globalMin = j;
                }
            }
            int temp = array[globalMin];
            array[globalMin] = array[i];
            array[i] = temp;

        }
        return array;
    }
}
