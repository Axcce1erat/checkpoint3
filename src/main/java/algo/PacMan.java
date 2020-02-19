package algo;

public class PacMan {

    /**
     *
     * @param grid, eg: {
     *     {'o', '.', '.'},
     *     {' ', 'x', ' '},
     *     {'.', '.', 'o'}
     * }
     * @param level, eg: 2
     * @return score, eg: 224
     */
    public static int play(char[][] grid, int level) {

        int points = 0;

        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[i].length; j++){
                switch (grid[i][j]){
                    case '.': {
                        points += 1;
                        break;
                    }
                    case 'o': {
                        points += 10;
                        break;
                    }
                    case 'x': {
                        points += 100 * level;
                        break;
                    }
                }
            }
        }
        return points;
    }
}
