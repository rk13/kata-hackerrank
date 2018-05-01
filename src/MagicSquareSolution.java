import java.util.Scanner;

public class MagicSquareSolution {

    static int[][] cubes = new int[][] {
            {6,1,8,7,5,3,2,9,4},
            {2,9,4,7,5,3,6,1,8},
            {8,1,6,3,5,7,4,9,2},
            {4,3,8,9,5,1,2,7,6},
            {6,7,2,1,5,9,8,3,4},
            {2,7,6,9,5,1,4,3,8},
            {4,9,2,3,5,7,8,1,6},
            {8,3,4,1,5,9,6,7,2},};

    static int formingMagicSquare(int[][] s) {

        int[] in = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                in[i * 3 + j] = s[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int[] a : cubes) {
            int tmp = 0;
            for (int i = 0; i < a.length; i++) {
                tmp += Math.abs(a[i] - in[i]);
            }
            min = Math.min(tmp, min);
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }

}
