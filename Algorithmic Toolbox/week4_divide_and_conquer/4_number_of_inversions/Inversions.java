import java.util.*;

public class Inversions {

    private static long merge(int[] a, int[] l, int[] r, int left, int right) {
        long sum = 0;
        int mid = (left + right) / 2;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
                sum += mid - i;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        return sum;
    }

    public static long mergeSort(int[] a, int n) {
        if (n < 2) {
            return 0;
        }
        long sum = 0;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
     
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        sum += mergeSort(l, mid);
        sum += mergeSort(r, n - mid);     
        sum += merge(a, l, r, mid, n - mid);
        return sum;
    }

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        return mergeSort(a, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}
