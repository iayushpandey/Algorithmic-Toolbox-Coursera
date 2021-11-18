import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int i = 1, y = 1;
        while (n > 0) {
            if (n - i > y) {
                summands.add(i);
                n = n - i;
                y = i + 1;
                i++;
            } else {
                summands.add(n);
                n = 0;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
