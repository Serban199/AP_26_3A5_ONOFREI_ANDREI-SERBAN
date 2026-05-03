package hm;

import javax.swing.*;

public class ConfigPannel extends JPanel {
    JTextField dimInput = new JTextField("11", 5);

    public ConfigPannel(MainFrame frame) {
        add(new JLabel("dimensiune:"));
        add(dimInput);

        JButton drawBtn = new JButton("draw grid");
        drawBtn.addActionListener(e -> {
            try {
                int dim = Integer.parseInt(dimInput.getText());
                frame.draw.init(dim);
            } catch (Exception ex) {
            }
        });
        add(drawBtn);
    }
}