import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentRefill = 0, numRefill = 0;
        int[] allstop = new int[stops.length + 2];
        for (int i = 0; i < stops.length; i++) {
            allstop[i + 1] = stops[i];
        }
        allstop[stops.length + 1] = dist;
        /*
         * We make an array allstop which has an 0 as start point and dist as
         * destination
         */

        if (tank > dist)
            return 0;
        while (currentRefill < allstop.length) {
            int lastRefill = currentRefill;
            /*
             * We go up until we can go with the given fuel and refill only when we can't go
             * any futher. We go until the last stop in the stops given with
             * allstop.length-1
             */
            while (currentRefill < allstop.length - 1 && allstop[currentRefill + 1] - allstop[lastRefill] <= tank) {
                currentRefill += 1;
            }
            if (currentRefill == lastRefill) {
                return -1;
            }
            /*
             * if we have reached destination (all stops considered), we end the loop
             */
            if (currentRefill == allstop.length - 1)
                break;
            /*
             * when we break out of the inner while loop, we have to refill so we add it to
             * numRefills.
             */
            if (currentRefill < allstop.length)
                numRefill++;
        }
        return numRefill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        // System.out.println(computeMinRefills(950, 400, new int[]{200,375,550,750}));
    }
}
