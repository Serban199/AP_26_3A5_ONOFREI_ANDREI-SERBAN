package Advanced;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.*;

public class DrawingPannel extends JPanel {
    Cell[][] grid;
    int n = 10;

    public DrawingPannel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (grid == null) return;
                int w = getWidth() / n;
                int h = getHeight() / n;
                int c = e.getX() / w;
                int r = e.getY() / h;

                if (r >= n || c >= n || r < 0 || c < 0) return;

                int dx = e.getX() - c * w;
                int dy = e.getY() - r * h;

                int distTop = dy;
                int distBottom = h - dy;
                int distLeft = dx;
                int distRight = w - dx;

                int min = Math.min(Math.min(distTop, distBottom), Math.min(distLeft, distRight));

                if (min == distTop) {
                    grid[r][c].top = !grid[r][c].top;
                    if (r > 0) grid[r-1][c].bottom = grid[r][c].top;
                } else if (min == distBottom) {
                    grid[r][c].bottom = !grid[r][c].bottom;
                    if (r < n - 1) grid[r+1][c].top = grid[r][c].bottom;
                } else if (min == distLeft) {
                    grid[r][c].left = !grid[r][c].left;
                    if (c > 0) grid[r][c-1].right = grid[r][c].left;
                } else if (min == distRight) {
                    grid[r][c].right = !grid[r][c].right;
                    if (c < n - 1) grid[r][c+1].left = grid[r][c].right;
                }
                repaint();
            }
        });
    }

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

    public void carveAnim(int delay) {
        if (grid == null) return;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j].visited = false;
                grid[i][j].top = true;
                grid[i][j].bottom = true;
                grid[i][j].left = true;
                grid[i][j].right = true;
            }
        }

        new Thread(() -> {
            dfsAnim(0, 0, delay);
            for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) grid[i][j].visited = false;
            repaint();
        }).start();
    }

    private void dfsAnim(int r, int c, int delay) {
        grid[r][c].visited = true;
        repaint();
        try { Thread.sleep(delay); } catch (Exception e) {}

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
                dfsAnim(nr, nc, delay);
            }
        }
    }

    public boolean isValidPath() {
        if (grid == null) return false;
        boolean[][] v = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        v[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            if (r == n - 1 && c == n - 1) return true;

            if (!grid[r][c].top && r > 0 && !v[r-1][c]) { v[r-1][c] = true; q.add(new int[]{r-1, c}); }
            if (!grid[r][c].bottom && r < n - 1 && !v[r+1][c]) { v[r+1][c] = true; q.add(new int[]{r+1, c}); }
            if (!grid[r][c].left && c > 0 && !v[r][c-1]) { v[r][c-1] = true; q.add(new int[]{r, c-1}); }
            if (!grid[r][c].right && c < n - 1 && !v[r][c+1]) { v[r][c+1] = true; q.add(new int[]{r, c+1}); }
        }
        return false;
    }

    public void exportPng() {
        if (grid == null) return;
        try {
            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = img.createGraphics();
            paintComponent(g2d);
            g2d.dispose();
            ImageIO.write(img, "png", new File("maze.png"));
            JOptionPane.showMessageDialog(this, "salvat");
        } catch (Exception e) {}
    }

    public void saveMaze() {
        if (grid == null) return;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("maze.dat"))) {
            out.writeObject(grid);
            out.writeInt(n);
            JOptionPane.showMessageDialog(this, "salvat");
        } catch (Exception e) {}
    }

    public void loadMaze() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("maze.dat"))) {
            grid = (Cell[][]) in.readObject();
            n = in.readInt();
            repaint();
        } catch (Exception e) {}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grid == null) return;

        int w = getWidth() / n;
        int h = getHeight() / n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = j * w, y = i * h;

                if (grid[i][j].visited) {
                    g.setColor(new Color(255, 200, 200));
                    g.fillRect(x, y, w, h);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, w, h);
                }

                g.setColor(Color.BLACK);
                if (grid[i][j].top) g.drawLine(x, y, x + w, y);
                if (grid[i][j].bottom) g.drawLine(x, y + h, x + w, y + h);
                if (grid[i][j].left) g.drawLine(x, y, x, y + h);
                if (grid[i][j].right) g.drawLine(x + w, y, x + w, y + h);
            }
        }
    }
}