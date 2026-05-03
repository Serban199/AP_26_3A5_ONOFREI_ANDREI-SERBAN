public class Cell {
    int row, col;
    boolean top = true, right = true, bottom = true, left = true;
    boolean visited = false;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}