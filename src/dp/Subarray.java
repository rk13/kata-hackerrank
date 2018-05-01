package dp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Subarray {

    static int[] maxSubarray(int[] weights) {

        int subSeqSum;
        boolean hasPositive = Arrays.stream(weights).filter(x -> x >= 0).findFirst().isPresent();
        if (hasPositive) {
            subSeqSum = Arrays.stream(weights).filter(x -> x >= 0).sum();
        } else {
            subSeqSum = Arrays.stream(weights).max().orElseThrow(RuntimeException::new);
        }

        int[] f = new int[weights.length + 1];

        f[1] = weights[0];
        for (int i = 2; i <= weights.length; i++) {
            f[i] = Math.max(weights[i - 1], f[i - 1] + weights[i - 1]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < f.length; i++) {
            result = Math.max(result, f[i]);
        }

        return new int[] {result, subSeqSum};
    }

    public static void main1(String[] args) {
        int[] weight = Arrays.stream("2 -1 2 3 4 -5".split(" ")).mapToInt(Integer::parseInt).toArray();
        maxSubarray(weight);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            int[] result = maxSubarray(arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}
