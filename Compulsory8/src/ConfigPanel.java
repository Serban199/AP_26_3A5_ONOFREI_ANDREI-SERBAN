import javax.swing.*;

public class ConfigPanel extends JPanel {
    JTextField dimInput = new JTextField("10", 3);

    public ConfigPanel(MainFrame frame) {
        add(new JLabel("dimensiune:"));
        add(dimInput);

        JButton drawBtn = new JButton("draw");
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