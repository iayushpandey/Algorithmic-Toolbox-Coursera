import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int[] coins = new int[]{1,3,4};
        int[] t = new int[m+1];
        t[0] = 0;
        for(int i = 1; i < t.length; i++){
            t[i] = 10000;
        }
        for(int j:coins){
            for(int i = 0; i < t.length; i++){
                if(i >= j)
                    t[i] = Math.min(t[i], 1 + t[i - j]);
            }
        }
        return t[t.length-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

