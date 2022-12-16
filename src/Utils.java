import java.util.Arrays;

public class Utils {

    private static int _MatrixSize = Const.MatrixSize;

    // Print two N*N arrays to console in same row
    public static void PrintDoubleGrid(int[][] input, int[][] solved)
    {
        for (int i = 0; i < _MatrixSize; i++) {

            for (int j = 0; j < _MatrixSize; j++) {
                int value = input[i][j];
                if (value == 0)
                    System.out.print("_ ");
                else
                    System.out.print(value + " ");
            }

            System.out.print("\t");

            for (int j = 0; j < _MatrixSize; j++) {
                int value = solved[i][j];
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }

    // Simple print N*N aray as grid to console
    public static void PrintGrid(int[][] grid)
    {
        for (int i = 0; i < _MatrixSize; i++) {
            for (int j = 0; j < _MatrixSize; j++) {
                int value = grid[i][j];
                if (value == 0)
                    System.out.print("_ ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Make value-based array copy, 
    // without reference to source object.
    public static int[][] CloneArray(int[][] a) {
        int[][] b = new int[_MatrixSize][];
        for (int i = 0; i < _MatrixSize; i++) {
            b[i] = Arrays.copyOf(a[i], a[i].length);
        }
        return b;
    }
}
