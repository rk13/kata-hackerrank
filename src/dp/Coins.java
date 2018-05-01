package dp;

import java.util.Scanner;

public class Coins {

    static long getWays(int n, int[] weights) {

        long[][] f = new long[weights.length + 1][n + 1];

        for (int coin = 1; coin <= weights.length; coin++) {

            for (int sum = 1; sum <= n; sum++) {
                if (sum < weights[coin - 1]) {
                    f[coin][sum] = f[coin - 1][sum];
                } else {
                    int remaining = sum - weights[coin - 1];

                    long withCurrentCoin;
                    if (remaining == 0) {
                        withCurrentCoin = 1;
                    } else {
                        withCurrentCoin = f[coin][remaining];
                    }
                    f[coin][sum] = f[coin - 1][sum] + withCurrentCoin;
                }
            }
        }

        return f[weights.length][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for (int c_i = 0; c_i < m; c_i++) {
            c[c_i] = in.nextInt();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
