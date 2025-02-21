package Lab10;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Scientific {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator with Modes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JMenuBar menuBar = new JMenuBar();
        JMenu modeMenu = new JMenu("Mode");
        JMenuItem normalModeItem = new JMenuItem("Normal");
        JMenuItem scientificModeItem = new JMenuItem("Scientific");
        modeMenu.add(normalModeItem);
        modeMenu.add(scientificModeItem);
        menuBar.add(modeMenu);
        frame.setJMenuBar(menuBar);

        JPanel normalPanel = new JPanel(new GridLayout(5 , 2));
        JTextField num1Field = new JTextField();
        JTextField num2Field = new JTextField();
        JLabel resultLabel = new JLabel("Result: ");
        
        JButton addButton = new JButton("+");
        addButton.setBackground(Color.red);
        JButton subtractButton = new JButton("-");
        subtractButton.setBackground(Color.GREEN);
        JButton multiplyButton = new JButton("*");
        multiplyButton.setBackground(Color.PINK);
        JButton divideButton = new JButton("/");
        divideButton.setBackground(Color.BLUE);

        normalPanel.add(new JLabel("Number 1:"));
        normalPanel.setLocation(100,100);
        normalPanel.setFont(new Font("Arial", Font.PLAIN, 20));
        normalPanel.add(num1Field);
        normalPanel.add(new JLabel("Number 2:"));
        normalPanel.setLocation(100,100);
        normalPanel.setFont(new Font("Arial", Font.PLAIN, 20));
        normalPanel.add(num2Field);
        normalPanel.add(addButton);
        normalPanel.add(subtractButton);
        normalPanel.add(multiplyButton);
        normalPanel.add(divideButton);
        normalPanel.add(resultLabel);

        ActionListener normalListener = e -> {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result = 0;
                if (e.getSource() == addButton) result = num1 + num2;
                else if (e.getSource() == subtractButton) result = num1 - num2;
                else if (e.getSource() == multiplyButton) result = num1 * num2;
                else if (e.getSource() == divideButton) {
                    if (num2 != 0) result = num1 / num2;
                    else {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    }
                }
                resultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
            }
        };

        addButton.addActionListener(normalListener);
        subtractButton.addActionListener(normalListener);
        multiplyButton.addActionListener(normalListener);
        divideButton.addActionListener(normalListener);

        JPanel scientificPanel = new JPanel(new GridLayout(6, 2));
        JTextField sciField = new JTextField();
        JLabel sciResultLabel = new JLabel("Result: ");

        JButton sinButton = new JButton("sin");
        JButton cosButton = new JButton("cos");
        JButton tanButton = new JButton("tan");
        JButton logButton = new JButton("log");

        scientificPanel.add(new JLabel("Enter number:"));
        scientificPanel.add(sciField);
        scientificPanel.add(sinButton);
        scientificPanel.add(cosButton);
        scientificPanel.add(tanButton);
        scientificPanel.add(logButton);
        scientificPanel.add(sciResultLabel);

        ActionListener sciListener = e -> {
            try {
                double num = Double.parseDouble(sciField.getText());
                double result = 0;
                if (e.getSource() == sinButton) result = Math.sin(Math.toRadians(num));
                else if (e.getSource() == cosButton) result = Math.cos(Math.toRadians(num));
                else if (e.getSource() == tanButton) result = Math.tan(Math.toRadians(num));
                else if (e.getSource() == logButton) {
                    if (num > 0) result = Math.log(num);
                    else {
                        sciResultLabel.setText("Error: Log of non-positive number");
                        return;
                    }
                }
                sciResultLabel.setText("Result: " + result);
            } catch (NumberFormatException ex) {
                sciResultLabel.setText("Invalid input!");
            }
        };

        sinButton.addActionListener(sciListener);
        cosButton.addActionListener(sciListener);
        tanButton.addActionListener(sciListener);
        logButton.addActionListener(sciListener);

        mainPanel.add(normalPanel, "Normal");
        mainPanel.add(scientificPanel, "Scientific");

        normalModeItem.addActionListener(e -> cardLayout.show(mainPanel, "Normal"));
        scientificModeItem.addActionListener(e -> cardLayout.show(mainPanel, "Scientific"));

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

