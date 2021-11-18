import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int j = values.length - 1;

        double[][] ratio = new double[values.length][3];
        for (int i = 0; i < values.length; i++) {
            ratio[i][0] = (double) values[i] / weights[i];
            ratio[i][1] = values[i];
            ratio[i][2] = weights[i];
        }

        java.util.Arrays.sort(ratio, (a, b) -> Double.compare(a[0], b[0]));

        while (capacity != 0 && j >= 0) {
            if (ratio[j][2] < capacity) {
                value += ratio[j][1];
                capacity -= ratio[j][2];
            } else {
                value += (ratio[j][1] / ratio[j][2]) * capacity;
                capacity = 0;
            }
            j--;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
