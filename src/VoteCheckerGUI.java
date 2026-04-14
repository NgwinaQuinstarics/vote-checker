import javax.swing.*;
import java.awt.event.*;

public class VoteCheckerGUI {

    public static void main(String[] args) {

        // Frame
        JFrame frame = new JFrame("Vote Checker App");
        frame.setSize(500, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // ===== LEFT SIDE =====

        // Name
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(30, 30, 100, 25);
        frame.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(120, 30, 150, 25);
        frame.add(txtName);

        // Age
        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(30, 70, 100, 25);
        frame.add(lblAge);

        JTextField txtAge = new JTextField();
        txtAge.setBounds(120, 70, 150, 25);
        frame.add(txtAge);

        // Sex
        JLabel lblSex = new JLabel("Sex:");
        lblSex.setBounds(30, 110, 100, 25);
        frame.add(lblSex);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(120, 110, 70, 25);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(190, 110, 100, 25);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        frame.add(male);
        frame.add(female);

        // Button
        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(100, 170, 120, 35);
        frame.add(btnCheck);

        // ===== RIGHT SIDE (RESULT BOX) =====

        JTextArea resultBox = new JTextArea();
        resultBox.setBounds(300, 30, 160, 180);
        resultBox.setEditable(false);
        resultBox.setBorder(BorderFactory.createTitledBorder("Result"));
        frame.add(resultBox);

        // ===== BUTTON ACTION =====

        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = txtName.getText();
                    int age = Integer.parseInt(txtAge.getText());

                    String gender = "";
                    if (male.isSelected()) {
                        gender = "Male";
                    } else if (female.isSelected()) {
                        gender = "Female";
                    }

                    // Validation
                    if (name.isEmpty() || gender.isEmpty()) {
                        resultBox.setText("Please fill all fields!");
                        return;
                    }

                    // Result
                    if (age >= 18) {
                        resultBox.setText(
                            "Name: " + name +
                            "\nAge: " + age +
                            "\nSex: " + gender +
                            "\n\nYou are eligible to vote."
                        );
                    } else {
                        resultBox.setText(
                            "Name: " + name +
                            "\nAge: " + age +
                            "\nSex: " + gender +
                            "\n\nYou are NOT eligible to vote."
                        );
                    }

                } catch (Exception ex) {
                    resultBox.setText("Enter a valid age!");
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}