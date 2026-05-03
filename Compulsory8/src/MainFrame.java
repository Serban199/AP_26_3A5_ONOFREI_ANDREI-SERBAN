import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    DrawingPanel draw = new DrawingPanel();

    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);

        add(new ConfigPanel(this), BorderLayout.NORTH);
        add(draw, BorderLayout.CENTER);
        add(new ControlPanel(this), BorderLayout.SOUTH);
    }
}