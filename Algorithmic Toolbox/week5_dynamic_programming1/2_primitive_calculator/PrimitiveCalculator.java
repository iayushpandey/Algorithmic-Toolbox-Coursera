import java.util.*;

public class PrimitiveCalculator {

    private static int[] genSeq(int a) {
        int[] res = new int[a + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i <= a; i++) {
            if (i % 3 == 0) {
                res[i] = Math.min(res[i / 3], res[i - 1]) + 1;
            } else if (i % 2 == 0) {
                res[i] = Math.min(res[i / 2], res[i - 1]) + 1;
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }

    private static List<Integer> getSequence(int[] seq){
        List<Integer> ans =  new ArrayList<>();
        int i  = seq.length - 1;
        while (i > 0) {
            ans.add(i);
            if (i % 3 == 0) {
                if (seq[i / 3] == seq[i] - 1) {
                    i /= 3;
                } else {
                    i -= 1;
                }
            } else if (i % 2 == 0) {
                if (seq[i / 2] == seq[i] - 1) {
                    i /= 2;
                } else {
                    i -= 1;
                }
            } else {
                i -= 1;
            }
        }
        return ans;
    }

    private static List<Integer> optimal_sequence(int n) {
        int[] seq = genSeq(n);
        List<Integer> getSeq = getSequence(seq);
        return getSeq;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for(int i = sequence.size() - 1; i >= 0; i--){
            System.out.print(sequence.get(i) + " ");
        }
    }
}
