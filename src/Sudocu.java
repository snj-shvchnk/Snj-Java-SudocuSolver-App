public class Sudocu {

    static int N = Const.Size;

    static boolean processGrid(int grid[][], int row, int col)
    {
        if (row == N - 1 && col == N)
            return true;
 
        if (col == N) {
            row++;
            col = 0;
        }
        
        if (grid[row][col] != 0)
            return processGrid(grid, row, col + 1);
 
        for (int num = 1; num < 10; num++) {           
            if (isValid(grid, row, col, num)) {
                grid[row][col] = num;
                if (processGrid(grid, row, col + 1))
                    return true;
            }
            grid[row][col] = 0;
        }
        return false;
    }
 
    static boolean isValid(int[][] grid, int row, int col, int num)
    {
        // Check row
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == num)
                return false;
 
        // Check column
        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == num)
                return false;
 
        // Check local area
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;
 
        return true;
    }
}
