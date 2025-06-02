package Act2_SimpleBankingApp;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main {
    private static double balance = 0.0;

    public static void main (String[] args){
        JFrame frame = new JFrame("Activity 2: Simple Bank App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);

        JMenuBar header = headerLayout();
        frame.setJMenuBar(header);
        
        JLabel statusLabel = new JLabel("Current Balance: 0.0");
        statusLabel.setBounds(20, 250, 300, 25);
        frame.add(statusLabel);

        JTextField nameField = inputField(frame, "Account Name:", 20);
        JTextField numberField = inputField(frame, "Account Number:", 60);
        JTextField balanceField = inputField(frame, "Account Balance:", 100);
        JTextField amountField = inputField(frame, "Amount:", 140);

        buttonLayout(frame, balanceField, amountField, statusLabel);

        frame.setVisible(true);
    }

    public static JMenuBar headerLayout(){
        JMenuBar header = new JMenuBar();
        header.setOpaque(true);
        header.setBackground(new Color(128, 128, 128));
        header.setPreferredSize(new Dimension(200, 50));
        header.setLayout(new BorderLayout());
        
        Font fontHeader = new Font("Comic Sans MS", Font.BOLD, 28);
        JLabel headerLabel = new JLabel("ATM Machine", JLabel.CENTER);
        headerLabel.setFont(fontHeader);

        header.add(headerLabel, BorderLayout.CENTER);
        
        return header;
    }

    public static JTextField inputField(JFrame frame, String labelText, int y){
        JLabel label = new JLabel(labelText);
        label.setBounds(20, y, 120, 25);
        frame.add(label);

        JTextField textField = new JTextField("tite");
        textField.setBounds(150, y, 200, 25);
        frame.add(textField);

        return textField;
    }

    public static void buttonLayout(JFrame frame, JTextField balanceField, JTextField amountField, JLabel statusLabel) {
        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(20, 180, 100, 30);
        frame.add(saveBtn);

        JButton depositBtn = new JButton("Deposit");
        depositBtn.setBounds(140, 180, 100, 30);
        frame.add(depositBtn);

        JButton withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(260, 180, 100, 30);
        frame.add(withdrawBtn);

        saveBtn.addActionListener(e -> {
            try {
                balance = Double.parseDouble(balanceField.getText());
                statusLabel.setText("Current Balance: " + balance);
                JOptionPane.showMessageDialog(frame, "Account saved!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid deposit amount!");
            }
        });

        depositBtn.addActionListener(e -> {
            try {
                double deposit = Double.parseDouble(amountField.getText());// converting string input into double
                balance += deposit;
                statusLabel.setText("Current Balance: " + balance);
                JOptionPane.showMessageDialog(frame, "Deposit successful!"); // for a popup message box
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid deposit amount!");
            }
        });

        withdrawBtn.addActionListener(e -> {
            try {
                double withdraw = Double.parseDouble(amountField.getText());
                if (withdraw > balance) {
                    JOptionPane.showMessageDialog(frame, "Not enough balance!");
                } else {
                    balance -= withdraw;
                    statusLabel.setText("Current Balance: " + balance);
                    JOptionPane.showMessageDialog(frame, "Withdraw successful!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid withdraw amount!");
            }
        });
    }
}
