package Midterms_UserRegistrationForm;

import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[] args) {
        
        Panel panel = new Panel();

        Main frame = new Main();
        frame.setTitle("User Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
