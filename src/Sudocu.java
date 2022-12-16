public class Sudocu {
    // Matrix settings.
    private static int _MatrixSize = Const.MatrixSize;
    private static int _ClusterSize = Const.ClusterSize;

    // Available values settings.
    private static int _FirstDigit = Const.FirstDigit;
    private static int _LastDigit = Const.LastDigit;

    // Input poinf for recurcive grid processing.
    public static boolean ProcessGrid(int grid[][]) {
        return _processGrid(grid, 0, 0);
    }

    // Recurcive handler, runs for every cell.
    private static boolean _processGrid(int grid[][], int row, int col)
    {
        // Check, is it end of matrix.
        if (row == _MatrixSize - 1 && col == _MatrixSize)
            return true;
 
        // Check, is it last colonum in the row,
        // Go to next row, if it is true.
        if (col == _MatrixSize) {
            row++;
            col = 0;
        }
        
        // Check does we already have solve this cell.
        // If true, make pooling to recursion for next cell in the row
        if (grid[row][col] != 0)
            return _processGrid(grid, row, col + 1);
 
        // Check all available values on compatibility with matrix
        for (int num = _FirstDigit; num < _LastDigit; num++) {           
            if (_isValid(grid, row, col, num)) {
                // Correcr value was finded, save it.
                grid[row][col] = num;

                // Recurcive pooling to next cell in the row.
                if (_processGrid(grid, row, col + 1))
                    // Move up, all values are finded.
                    return true;
            }
            // This value doesn't abble to this cell.
            // Clear it and try another values.
            grid[row][col] = 0;
        }

        // We haven't compatible value for this cell.
        // Move up, it means that matrix can't be solved.
        return false;
    }
 
    // Check does this value are compatible to other matrix values.
    private static boolean _isValid(int[][] grid, int row, int col, int num)
    {
        // Check row
        for (int x = 0; x < _MatrixSize; x++)
            if (grid[row][x] == num)
                return false;
 
        // Check column
        for (int x = 0; x < _MatrixSize; x++)
            if (grid[x][col] == num)
                return false;
 
        // Check current cluster
        int startRow = row - row % _ClusterSize;
        int startCol = col - col % _ClusterSize;
        for (int i = 0; i < _ClusterSize; i++)
            for (int j = 0; j < _ClusterSize; j++)
                if (grid[i + startRow][j + startCol] == num)
                    return false;
 
        // All right, value is able to solve this cell.
        return true;
    }
}
