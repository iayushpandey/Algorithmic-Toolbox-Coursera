import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    long first = 0, second = 1, temp = 0;
    int i = 2;
    if (n == 0)
      return (long) 0;
    while (i <= n) {
      temp = first + second;
      first = second;
      second = temp;
      i++;
    }
    return second;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
