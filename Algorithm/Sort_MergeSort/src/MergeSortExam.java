import java.util.Arrays;

public class MergeSortExam {
    
    public static void mergeSort(int[] a, int len) {
        if (len < 2) return;
        
        int mid = len / 2;
        int[] l = new int[mid];
        int[] r = new int[len - mid];
        
        for (int i = 0; i < mid; ++i) {
            l[i] = a[i];
        }
        
        for (int i = mid; i < len; ++i) {
            r[i - mid] = a[i];
        }
        
        mergeSort(l, mid);
        mergeSort(r, len - mid);
        merge(a, l, r, mid, len - mid);

        
    }

    public static void merge(int[] a, int[] l, int[] r, int lLen, int rLen) {
        int i = 0;  // i index of l
        int j = 0;  // j index of r
        int k = 0;  // k index of a
        
        while (i<lLen && j<rLen) {
            if(l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }
        
        while (i<lLen) {
            a[k++] = l[i++];
        }
        
        while (j<rLen) {
            a[k++] = r[j++];
        }
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void main(String a[]) {
        int[] arr = { 9, 5, 1, 0, 6, 2, 3, 4, 7, 8 };
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, arr.length);
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr));
    }

}