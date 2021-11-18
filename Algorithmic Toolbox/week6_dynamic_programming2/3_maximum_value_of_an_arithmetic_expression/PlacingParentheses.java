import java.util.Scanner;

public class PlacingParentheses {

    private static long[] getMinAndMax(int i,int j,char[] op,long[][] m,long[][] M){
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int k = i; k < j; k++){
            long a =  eval(M[i][k],M[k+1][j],op[k]);
            long b =  eval(M[i][k],m[k+1][j],op[k]);
            long c =  eval(m[i][k],M[k+1][j],op[k]);
            long d =  eval(m[i][k],m[k+1][j],op[k]);
            min = Math.min(min, Math.min(a, Math.min(b , Math.min(c , d))));
            max = Math.max(max, Math.max(a, Math.max(b , Math.max(c , d))));
        }
        return new long[]{min, max};
    }
    private static long getMaximValue(String exp) {
        char[] eq = exp.toCharArray();
        int lena = exp.length()/2+1;
        long[][] M = new long[lena][lena];
        long[][] m = new long[lena][lena];
        char[] op = new char[exp.length()-lena];
        for(int i = 0,t = 0; i < eq.length; i+=2, t++){
            M[t][t] = Character.getNumericValue(eq[i]);
            m[t][t] = Character.getNumericValue(eq[i]);
        }
        for(int i = 1,t = 0; i < eq.length; i+=2, t++){
            op[t] = eq[i];
        }

        for(int s = 1; s < lena; s++){
            for(int i = 0; i < lena-s; i++){
                int j = i + s;
                long mM[] = getMinAndMax(i, j, op, m, M);
                m[i][j] = mM[0];
                M[i][j] = mM[1];
            }
        }
        

        // for(int i = 0; i < lena; i++){
        //     for(int j = 0; j < lena; j++){
        //         System.out.print(M[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0; i < lena; i++){
        //     for(int j = 0; j < lena; j++){
        //         System.out.print(m[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        return M[0][lena-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

