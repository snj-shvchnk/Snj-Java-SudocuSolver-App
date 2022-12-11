import java.util.Arrays;

public class Utils {

    static int N = Const.Size;

    public static void printDoubleGrid(int[][] input, int[][] solved)
    {
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                int value = input[i][j];
                if (value == 0)
                    System.out.print("_ ");
                else
                    System.out.print(value + " ");
            }

            System.out.print("\t");

            for (int j = 0; j < N; j++) {
                int value = solved[i][j];
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    static void printGrid(int[][] grid)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = grid[i][j];
                if (value == 0)
                    System.out.print("_ ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] cloneArray(int[][] a) {
        int[][] b = new int[N][];
        for (int i = 0; i < N; i++) {
            b[i] = Arrays.copyOf(a[i], a[i].length);
        }
        return b;
    }
}
