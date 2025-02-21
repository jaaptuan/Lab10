package Lab10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setSize(300 , 200) ;

        JPanel panel = new JPanel() ;
        panel.setLayout(new GridLayout(2, 3));

        JLabel num1Label = new JLabel("Enter Number 1 ") ;
        num1Label.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField num1Field = new JTextField() ;

        JLabel num2Label = new JLabel("Enter Number 2") ;
        num2Label.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField num2Field = new JTextField() ;

        JLabel cal = new JLabel("Choose option to calculate") ;
        JButton AdditionButton = new JButton("Addition (+)");
        JButton SubtractioButton = new JButton("Subtraction (-)") ;

        JLabel greetingLabel = new JLabel(" ");
        
        panel.add(num1Label) ;
        panel.add(num1Field) ;
        panel.add(num2Label) ;
        panel.add(num2Field) ;
        panel.add(new JLabel("")) ;
        panel.add(cal) ;
        panel.add(AdditionButton) ;
        panel.add(SubtractioButton) ;
        panel.add(greetingLabel) ;
        
        AdditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(num1Field.getText()) ;
            int num2 = Integer.parseInt(num2Field.getText()) ;
            int sum = num1 + num2 ;
            greetingLabel.setText(num1 + " + " + num2 + " is " + sum);
            }
        });

        SubtractioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(num1Field.getText()) ;
                int num2 = Integer.parseInt(num2Field.getText()) ;
                int sum = num1 - num2 ;
                greetingLabel.setText(num1 + " - " + num2 + " is " + sum);
            }
        });

        // Add the panel to the frame
        frame.add(panel);
        // Set the frame to be visible
        frame.setVisible(true);
    }

}
