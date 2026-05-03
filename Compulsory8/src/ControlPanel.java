import javax.swing.*;

public class ControlPanel extends JPanel {
    public ControlPanel(MainFrame frame) {
        JButton createBtn = new JButton("create");
        createBtn.addActionListener(e -> frame.draw.carve());
        add(createBtn);

        JButton resetBtn = new JButton("reset");
        resetBtn.addActionListener(e -> frame.draw.init(frame.draw.n));
        add(resetBtn);

        JButton exitBtn = new JButton("exit");
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);
    }
}