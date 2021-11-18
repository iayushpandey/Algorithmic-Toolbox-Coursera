import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int ans = 0;
        ans = m / 10;
        m = m % 10;
        ans += m / 5;
        m = m % 5;
        ans += m;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

}
