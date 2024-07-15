class Solution {
    public int uniquePaths(int m, int n) {
        int[][]result = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                result[i][j] = 0;
            }
        }
        
        //set for all rows with column 0
        for(int i = 0; i < m; i++) {
            result[i][0] = 1; 
        }

        //set for all columns with row 0
        for(int i = 1; i < n; i++) {
            result[0][i] = 1;
        }

        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j++) {
                result[i][j] = result[i][j-1] + result[i-1][j];
            }
        }

        return result[m-1][n-1];

        
    }

    
}
