import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagicSquare {

    private static void findCubes2 (List<Integer> selected, Set<int[]> acc) {
        if (selected.size() == 9) {

            int[] ix = selected.stream().mapToInt(Integer::intValue).toArray();

            int[] i = new int[10];
            System.arraycopy(ix, 0, i, 1, ix.length);

            int sum = i[1] + i[2] + i[3];

            if ((i[4] + i[5] + i[6]) == sum
                    && (i[7] + i[8] + i[9]) == sum
                    && (i[1] + i[4] + i[7]) == sum
                    && (i[2] + i[5] + i[8]) == sum
                    && (i[3] + i[6] + i[9]) == sum
                    && (i[1] + i[5] + i[9]) == sum
                    && (i[3] + i[5] + i[7]) == sum) {

                acc.add(i);
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (!selected.contains(i)) {
                findCubes2(combine(selected, i), acc);
            }
        }

    }

    private static List<Integer> combine(List<Integer> selected, int i) {
        List<Integer> tmp = new ArrayList<>();
        tmp.addAll(selected);
        tmp.add(i);
        return tmp;
    }


    private static void findCubes () {

        Set<int[]> acc = new HashSet<>();

        findCubes2(new ArrayList<>(), acc);

        for (int[] a : acc) {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            for (int i = 1; i < a.length; i++) {
                sb.append(a[i]);
                if (i < a.length - 1) {
                    sb.append(',');
                }
            }
            sb.append('}').append(',');
            System.out.println(sb.toString());
        }


    }


    public static void main(String[] args) {
        findCubes();
    }
}