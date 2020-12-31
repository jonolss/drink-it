package se.slyntan.applications;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        JLabel label = new JLabel("JFrame By Example");
        JButton button = new JButton();
        button.setText("Button");

        Map<String, JComponent> baseWindowComponents = new HashMap<>();
        baseWindowComponents.putIfAbsent("BaseLabel", label);
        baseWindowComponents.putIfAbsent("SimpleButton1", button);

        ApplicationWindow applicationWindow = new ApplicationWindow(baseWindowComponents);

        // Needs textfield for input of ingredients

        // Needs to be able to create search query

        // Needs to read recepies from file

        // Needs to use search query to find recepies

        // Needs to display recepies
    }
}

