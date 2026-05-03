package hm;

import javax.swing.*;

public class ControlPannel extends JPanel {
    public ControlPannel(MainFrame frame) {
        JButton createBtn = new JButton("create");
        createBtn.addActionListener(e -> frame.draw.randomCarve());
        add(createBtn);

        JButton validateBtn = new JButton("validate");
        validateBtn.addActionListener(e -> {
            boolean ok = frame.draw.isValidPath();
            JOptionPane.showMessageDialog(frame, ok ? "drum valid spre final!" : "nu se poate ajunge la final.");
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