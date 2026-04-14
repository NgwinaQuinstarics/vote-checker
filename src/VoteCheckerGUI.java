import javax.swing.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.File;

public class VoteCheckerGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Vote Checker App");
        frame.setSize(520, 360);
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

        // Check button
        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(100, 170, 120, 35);
        frame.add(btnCheck);

        // ===== PROFILE PICTURE (TOP RIGHT) =====

        JLabel picLabel = new JLabel();
        picLabel.setBounds(300, 20, 150, 100);
        picLabel.setBorder(BorderFactory.createTitledBorder("Profile"));
        frame.add(picLabel);

        JButton btnUpload = new JButton("Choose Image");
        btnUpload.setBounds(300, 130, 150, 25);
        frame.add(btnUpload);

        // Image chooser action
        btnUpload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

                    // Resize image to fit label
                    Image img = imageIcon.getImage().getScaledInstance(
                            picLabel.getWidth(),
                            picLabel.getHeight(),
                            Image.SCALE_SMOOTH
                    );

                    picLabel.setIcon(new ImageIcon(img));
                }
            }
        });

        // ===== RESULT BOX =====

        JTextArea resultBox = new JTextArea();
        resultBox.setBounds(300, 170, 180, 120);
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

                    if (name.isEmpty() || gender.isEmpty()) {
                        resultBox.setText("Please fill all fields!");
                        return;
                    }

                    if (age >= 18) {
                        resultBox.setText(
                                "Name: " + name +
                                "\nAge: " + age +
                                "\nSex: " + gender +
                                "\n\nEligible to vote"
                        );
                    } else {
                        resultBox.setText(
                                "Name: " + name +
                                "\nAge: " + age +
                                "\nSex: " + gender +
                                "\n\nNOT eligible to vote"
                        );
                    }

                } catch (Exception ex) {
                    resultBox.setText("Enter a valid age!");
                }
            }
        });

        frame.setVisible(true);
    }
}