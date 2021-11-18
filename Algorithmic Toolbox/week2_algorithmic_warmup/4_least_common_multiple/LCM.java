import java.util.*;

public class LCM {
  private static long lcm_naive(int a, int b) {
    if (a == 0 && b == 0)
      return 0;
    return (long) a * b / gcd_naive(a, b);
  }

  static int gcd_naive(int a, int b) {
    int big, small;
    if (a > b) {
      big = a;
      small = b;
    } else {
      big = b;
      small = a;
    }
    while (big > 0 && small > 0) {
      int temp = small;
      small = big % small;
      big = temp;
    }
    return big;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
