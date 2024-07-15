class Solution {
    public int uniquePaths(int m, int n) {
        int[][]result = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        return uniquePaths(0, 0, m - 1, n - 1, result);
    }

    private int uniquePaths(int row, int column, int destinationRow, int destinationColumn, int[][] result) {

        if(row == destinationRow && column == destinationColumn) {
            return 1;
        }

        else if (row > destinationRow || column >  destinationColumn) {
            return 0;
        }

        else if(result[row][column] != -1) {
            return result[row][column];
        }

        else {

            int a = 0;
            int b = 0;

            if(row < destinationRow) {
                a = uniquePaths(row + 1, column, destinationRow, destinationColumn, result);
            }

            if(column < destinationColumn) {
                b = uniquePaths(row, column + 1, destinationRow, destinationColumn, result); 
            }

            result[row][column] = a + b;

            return a + b;
        }
    }
}
