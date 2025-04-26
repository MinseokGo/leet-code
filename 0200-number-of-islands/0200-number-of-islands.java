class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int n;
    private static int m;

    public int numIslands(char[][] grid) {
        int island = 0;
        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    island += 1;
                    dfs(grid, i, j);
                }
            }
        }

        return island;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!isOutOfBounds(nx, ny) && grid[nx][ny] == '1') {
                dfs(grid, nx, ny);
            }
        }
    }

    private boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
