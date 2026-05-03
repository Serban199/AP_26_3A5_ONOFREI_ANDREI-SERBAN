package Advanced;
import javax.swing.*;

public class ControlPannel extends JPanel {
    JSlider speedSlider;

    public ControlPannel(MainFrame frame) {
        speedSlider = new JSlider(1, 100, 50);
        add(new JLabel("viteza animatie:"));
        add(speedSlider);

        JButton createBtn = new JButton("create");
        createBtn.addActionListener(e -> {
            int delay = 1000 / speedSlider.getValue();
            frame.draw.carveAnim(delay);
        });
        add(createBtn);

        JButton validateBtn = new JButton("validate");
        validateBtn.addActionListener(e -> {
            boolean ok = frame.draw.isValidPath();
            JOptionPane.showMessageDialog(frame, ok ? "drum valid!" : "nu se poate ajunge la final.");
        });
        add(validateBtn);

        JButton saveBtn = new JButton("save");
        saveBtn.addActionListener(e -> frame.draw.saveMaze());
        add(saveBtn);

        JButton loadBtn = new JButton("load");
        loadBtn.addActionListener(e -> frame.draw.loadMaze());
        add(loadBtn);

        JButton exportBtn = new JButton("export png");
        exportBtn.addActionListener(e -> frame.draw.exportPng());
        add(exportBtn);

        JButton exitBtn = new JButton("exit");
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);
    }
}