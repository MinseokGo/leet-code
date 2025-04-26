class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1}; 

    public int numIslands(char[][] grid) {
        int island = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island += 1;
                    bfs(grid, i, j);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];

                if (isValidPosition(nx, ny, grid.length, grid[0].length) && grid[nx][ny] == '1') {
                    queue.add(new Position(nx, ny));
                    grid[nx][ny] = 1;
                }
            }
        }
    }

    private boolean isValidPosition(int x, int y, int mapX, int mapY) {
        return x >= 0 && y >= 0 && x < mapX && y < mapY;
    }

    private static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
