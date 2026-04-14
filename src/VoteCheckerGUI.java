import javax.swing.*;
import java.awt.Image;

public class VoteCheckerGUI {
    public static void main(String[] args) {

        JFrame f = new JFrame("Vote Checker");
        f.setSize(520, 360);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inputs
        JLabel nL = new JLabel("Name:"), aL = new JLabel("Age:"), sL = new JLabel("Sex:");
        nL.setBounds(30,30,100,25); aL.setBounds(30,70,100,25); sL.setBounds(30,110,100,25);

        JTextField nF = new JTextField(), aF = new JTextField();
        nF.setBounds(120,30,150,25); aF.setBounds(120,70,150,25);

        JRadioButton m = new JRadioButton("Male"), fe = new JRadioButton("Female");
        m.setBounds(120,110,70,25); fe.setBounds(190,110,100,25);

        ButtonGroup g = new ButtonGroup();
        g.add(m); g.add(fe);

        JButton check = new JButton("Check");
        check.setBounds(100,170,120,35);

        // Profile picture
        JLabel pic = new JLabel();
        pic.setBounds(300,20,150,100);
        pic.setBorder(BorderFactory.createTitledBorder("Profile"));

        JButton upload = new JButton("Choose Image");
        upload.setBounds(300,130,150,25);

        // Result box
        JTextArea out = new JTextArea();
        out.setBounds(300,170,180,120);
        out.setEditable(false);
        out.setBorder(BorderFactory.createTitledBorder("Result"));

        // Upload action 
        upload.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
                ImageIcon ic = new ImageIcon(fc.getSelectedFile().getPath());
                Image img = ic.getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
                pic.setIcon(new ImageIcon(img));
            }
        });

        // Check action 
        check.addActionListener(e -> {
            try {
                String name = nF.getText();
                int age = Integer.parseInt(aF.getText());
                String sex = m.isSelected() ? "Male" : fe.isSelected() ? "Female" : "";

                if (name.isEmpty() || sex.isEmpty()) {
                    out.setText("Fill all fields!");
                    return;
                }

                String result = age >= 18 ? "Eligible to vote" : "NOT eligible to vote";

                out.setText("Name: " + name +
                        "\nAge: " + age +
                        "\nSex: " + sex +
                        "\n\n" + result);

            } catch (Exception ex) {
                out.setText("Enter valid age!");
            }
        });

        // Add everything
        f.add(nL); f.add(aL); f.add(sL);
        f.add(nF); f.add(aF);
        f.add(m); f.add(fe);
        f.add(check);
        f.add(pic); f.add(upload);
        f.add(out);

        f.setVisible(true);
    }
}