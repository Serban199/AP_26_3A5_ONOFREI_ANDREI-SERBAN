package hm;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    DrawingPannel draw = new DrawingPannel();

    public MainFrame() {
        super("maze generator - homework");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);

        add(new ConfigPannel(this), BorderLayout.NORTH);
        add(draw, BorderLayout.CENTER);
        add(new ControlPannel(this), BorderLayout.SOUTH);
    }
}