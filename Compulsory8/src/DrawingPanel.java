import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DrawingPanel extends JPanel {
    Cell[][] grid;
    int n = 10;

    public void init(int dim) {
        n = dim;
        grid = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
        repaint();
    }

    public void carve() {
        if (grid == null) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j].visited = false;
            }
        }
        dfs(0, 0);
        repaint();
    }

    private void dfs(int r, int c) {
        grid[r][c].visited = true;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        ArrayList<Integer> order = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Collections.shuffle(order);

        for (int i : order) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n && !grid[nr][nc].visited) {
                if (i == 0) { grid[r][c].top = false; grid[nr][nc].bottom = false; }
                if (i == 1) { grid[r][c].right = false; grid[nr][nc].left = false; }
                if (i == 2) { grid[r][c].bottom = false; grid[nr][nc].top = false; }
                if (i == 3) { grid[r][c].left = false; grid[nr][nc].right = false; }
                dfs(nr, nc);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grid == null) return;

        int w = getWidth() / n;
        int h = getHeight() / n;
        g.setColor(Color.BLACK);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = j * w, y = i * h;
                if (grid[i][j].top) g.drawLine(x, y, x + w, y);
                if (grid[i][j].bottom) g.drawLine(x, y + h, x + w, y + h);
                if (grid[i][j].left) g.drawLine(x, y, x, y + h);
                if (grid[i][j].right) g.drawLine(x + w, y, x + w, y + h);
            }
        }
    }
}