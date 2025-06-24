package Act6_EmployeeRegistration;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Employee extends Person implements Displayable{
    
    String department;
    String position;
    double salary;

    @Override
    public void display(){

        JFrame frame = new JFrame();
        try{
            
            frame.setTitle("Employee Registration");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Panel panel = new Panel();
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(frame, "Invalid Number Input!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    
}
