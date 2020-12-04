import java.util.Arrays;

public class QuickSortExam {    
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) return;

        int partitionIndex = partition(arr, begin, end);
        quickSort(arr, begin, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, j, ++i);
            }
        }
        swap(arr, end, ++i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void main(String a[]) {
        int[] arr = { 9, 5, 1, 0, 6, 2, 3, 4, 7, 8 };
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr));
    }
}