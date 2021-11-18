import java.util.*;
import java.io.*;

public class Partition3 {

    private static void spreadOut(int[] array){
        Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
        }
    }

    private static int[] remove(int[] a, List<Integer> selected){
        ArrayList<Integer> newA = new ArrayList<Integer>();

        for (int i : a) {
            if(selected.contains(i)){
                selected.remove(Integer.valueOf(i));
            } else {
                newA.add(i);
            }
        }

        return newA.stream().mapToInt(Integer::intValue).toArray();
    }

    private static List<Integer> printSelected(boolean[][] res, int[] a) {
        int i = a.length, j = res[0].length - 1;
        List<Integer> selected = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (!res[i - 1][j]) {
                selected.add(a[i - 1]);
                j = j - a[i - 1];
                i = i - 1;
            } else {
                i = i - 1;
            }
        }

        return selected;
    }

    private static boolean[][] subsetSumProblem(int[] a, int sum) {
        boolean[][] res = new boolean[a.length + 1][sum + 1];

        for (int i = 0; i <= a.length; i++) {
            res[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            res[0][i] = false;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (a[i - 1] <= j) {
                    res[i][j] = res[i - 1][j] || res[i - 1][j - a[i - 1]];
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
            // if (res[i][sum])
            // return true;
        }
        return res;
    }

    private static int partition3(int[] A) {
        int sum = 0;

        for (int i : A) {
            sum += i;
        }

        if(sum % 3 != 0)
            return 0;
        
        spreadOut(A);
        boolean res[][] = subsetSumProblem(A, sum/3);
        
        if(res[A.length][sum/3]){
            int[] newA = remove(A,printSelected(res, A));
            boolean finalRes[][] = subsetSumProblem(newA, sum/3);

            if(finalRes[newA.length][sum/3])
                return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
        A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
        // System.out.println(subsetSumProblem(new int[] { 1, 5, 5, 11 }, 11));
    }
}
