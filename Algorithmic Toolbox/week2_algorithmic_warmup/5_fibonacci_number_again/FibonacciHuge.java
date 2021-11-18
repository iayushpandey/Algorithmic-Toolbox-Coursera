import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, int m) {
        ArrayList<Integer> series = new ArrayList<Integer>();
        int i = 2;
        int previous = 0;
        int current = 1;
        series.add(0);
        series.add(1);
        while (true) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            series.add(current);
            if (series.get(i) == 1 && series.get(i - 1) == 0)
                break;
            i++;
        }
        return (long) series.get((int) (n % (series.size() - 2)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
