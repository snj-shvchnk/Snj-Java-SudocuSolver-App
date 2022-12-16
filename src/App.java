public class App {
    public static void main(String[] args) {
        System.out.println("Hello, Snj!");

        int grid_easy[][] = 
        { 
            { 0, 1, 3, 8, 0, 0, 4, 0, 5 }, 
            { 0, 2, 4, 6, 0, 5, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 9, 3, 0 }, 
            { 4, 9, 0, 3, 0, 6, 0, 0, 0 }, 
            { 0, 0, 1, 0, 0, 0, 5, 0, 0 }, 
            { 0, 0, 0, 7, 0, 1, 0, 9, 3 }, 
            { 0, 6, 9, 0, 0, 0, 7, 4, 0 }, 
            { 0, 0, 0, 2, 0, 7, 6, 8, 0 }, 
            { 1, 0, 2, 0, 0, 8, 3, 5, 0 }
        };
        _solveGrid(grid_easy);

        int grid_hard[][] = 
        { 
            { 0, 0, 2, 0, 0, 0, 0, 4, 1 },
            { 0, 0, 0, 0, 8, 2, 0, 7, 0 },
            { 0, 0, 0, 0, 4, 0, 0, 0, 9 },
            { 2, 0, 0, 0, 7, 9, 3, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 8, 0 },
            { 0, 0, 6, 8, 1, 0, 0, 0, 4 },
            { 1, 0, 0, 0, 9, 0, 0, 0, 0 },
            { 0, 6, 0, 4, 3, 0, 0, 0, 0 },
            { 8, 5, 0, 0, 0, 0, 4, 0, 0 }
        };
        _solveGrid(grid_hard);

        int grid_unsolved[][] = 
        { 
            { 0, 0, 2, 0, 9, 0, 0, 4, 1 },
            { 1, 0, 0, 0, 0, 2, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 0, 0, 0, 9 },
            { 2, 0, 0, 0, 0, 0, 3, 0, 0 },
            { 0, 1, 0, 0, 0, 0, 0, 8, 0 },
            { 0, 9, 0, 0, 0, 0, 0, 0, 4 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 9, 4, 3, 0, 0, 0, 0 },
            { 8, 5, 0, 0, 0, 0, 0, 0, 0 }
        };
        _solveGrid(grid_unsolved);

        int grid_current[][] = 
        { 
            { 0, 0, 4, 7, 1, 0, 0, 0, 0 },
            { 0, 7, 2, 8, 0, 6, 5, 0, 0 },
            { 0, 0, 0, 0, 0, 5, 0, 0, 7 },
            { 0, 1, 0, 6, 9, 0, 2, 0, 0 },
            { 3, 9, 0, 0, 5, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 8, 5 },
            { 0, 0, 1, 2, 3, 0, 8, 0, 4 },
            { 0, 0, 3, 5, 0, 4, 0, 0, 2 },
            { 2, 4, 0, 9, 0, 0, 0, 0, 0 }
        };
        _solveGrid(grid_current);
    }

    private static void _solveGrid(int grid[][]) {
        System.out.println("\nSolver runs...");
        long startTime = System.currentTimeMillis();
    
        int[][] result = Utils.CloneArray(grid);
        boolean isSolved = Sudocu.ProcessGrid(result);
        if (isSolved) {
            System.out.println("Input:\t\t\tSolved:");
            Utils.PrintDoubleGrid(grid, result);
        } else {
            System.out.println("Input:\t\t\tNo Solution exists!");
            Utils.PrintGrid(grid);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("DONE. Elapsed time: " + (endTime - startTime) + "ms;");            
    }
}
