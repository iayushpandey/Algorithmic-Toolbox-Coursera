import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] res = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); i++) {
      res[i][0] = i;
    }
    for (int i = 0; i <= t.length(); i++) {
      res[0][i] = i;
    }
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)){
          res[i][j] = res[i - 1][j - 1];
        } else {
          res[i][j] = 1 + Math.min(res[i - 1][j], Math.min(res[i - 1][j - 1], res[i][j - 1]));
        }

      }
    }
    
    return res[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
