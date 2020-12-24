package se.slyntan.applications;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ApplicationWindow {

    JFrame frame;
    JPanel panel;
    Map<String, JComponent> componentMap;

    public ApplicationWindow(Map<String, JComponent> componentMap) {
        this.componentMap = componentMap;
        this.frame = new JFrame("JFrame Example");
        this.panel = new JPanel();

        this.componentMap.values().forEach(component -> {
            panel.add(component);
        });
        panel.setLayout(new FlowLayout());

        frame.add(panel);
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getPanel() {
        return panel;
    }
}
