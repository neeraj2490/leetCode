class Solution {
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        List<Coordinates> visit = new ArrayList<>(); 

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                
                if(grid[i][j] == '1') {
                    //island found, visit the island;
                    visit.add(new Coordinates(i, j));
                    //change the coordinate to visted;
                    grid[i][j] = 'V';
                    visitIsland(visit, grid, rows, cols);
                    count ++;
                }
            }
        }

        return count;
    }

    private void visitIsland(List<Coordinates> c, char[][] grid, int rows, int cols) {

        while(c.size() > 0) {
            Coordinates a = c.get(0);
            c.remove(0);

            int i = a.x;
            int j = a.y;

            if( i + 1 < rows && grid[i+1][j] == '1') {
                grid[i+1][j] = 'V';
                c.add(new Coordinates(i+1, j));
            }

            if(j+1 < cols && grid[i][j+1] == '1') {
                grid[i][j+1] = 'V';
                c.add(new Coordinates(i, j+1));
            }

            if(i-1 >= 0 && grid[i-1][j] == '1') {
                grid[i-1][j] = 'V';
                c.add(new Coordinates(i-1, j));
            }

            if(j-1 >= 0 && grid[i][j-1] == '1') {
                grid[i][j-1] = 'V';
                c.add(new Coordinates(i, j-1));
            }
        }
    }
}

class Coordinates {
    public int x;
    public int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
