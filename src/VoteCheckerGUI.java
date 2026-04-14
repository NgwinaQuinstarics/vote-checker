import javax.swing.*;
import java.awt.event.*;

public class VoteCheckerGUI {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Vote Checker App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Name label + field
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 30, 100, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(150, 30, 150, 25);
        frame.add(txtName);

        // Age label + field
        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(30, 70, 100, 25);
        frame.add(lblAge);

        JTextField txtAge = new JTextField();
        txtAge.setBounds(150, 70, 150, 25);
        frame.add(txtAge);

        // Gender radio buttons
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 110, 70, 25);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(220, 110, 100, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        frame.add(male);
        frame.add(female);

        // Button
        JButton btnCheck = new JButton("Check Vote");
        btnCheck.setBounds(120, 150, 150, 30);
        frame.add(btnCheck);

        // Result label
        JLabel lblResult = new JLabel("");
        lblResult.setBounds(50, 200, 300, 25);
        frame.add(lblResult);

        // Button action
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());

                String gender = "";
                if (male.isSelected()) {
                    gender = "Male";
                } else if (female.isSelected()) {
                    gender = "Female";
                }

                if (age >= 18) {
                    lblResult.setText(name + " (" + gender + ") is eligible to vote ✅");
                } else {
                    lblResult.setText(name + " (" + gender + ") is NOT eligible ❌");
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}