class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] results = new int[rows][cols];

        for(int i = 0; i < rows; i ++) {
            for(int j = 0; j < cols; j++) {
                results[i][j] = 0;
            }
        }


        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                
                if(i == 0 && j == 0 && obstacleGrid[0][0] != 1) {
                    results[i][j] = 1;
                }
                else {
                    int upside = i == 0 ? 0 : results[i-1][j];
                    int leftside = j == 0 ? 0 : results[i][j-1];
                    results[i][j] = obstacleGrid[i][j] == 1 ? 0 : (upside + leftside);
                }
                
            }
        }

        return results[rows-1][cols-1];
    }
}
