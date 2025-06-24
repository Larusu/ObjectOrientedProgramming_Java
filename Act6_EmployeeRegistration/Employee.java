package Act6_EmployeeRegistration;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Employee extends Person implements Displayable{
    
    String department;
    String position;
    double salary;
    String gender;
    int employeeID;

    JFrame frame = new JFrame();
    Panel panel = new Panel();

    @Override
    public void display(){

        try{
            
            frame.setTitle("Employee Registration");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(frame, "Invalid Number Input!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void initializingData(){

        name = ((JTextField) panel.getInputFields(0)).getText() + " " + ((JTextField) panel.getInputFields(1)).getText();
        age = Integer.parseInt(((JTextField) panel.getInputFields(2)).getText());
        gender = ((JTextField) panel.getInputFields(3)).getText();
        contactDetails[0] = ((JTextField) panel.getInputFields(4)).getText();
        contactDetails[1] = ((JTextField) panel.getInputFields(5)).getText();
        department = ((JTextField) panel.getInputFields(6)).getText();
        position = ((JTextField) panel.getInputFields(7)).getText();
        employeeID = Integer.parseInt(((JTextField) panel.getInputFields(8)).getText());
        salary = Integer.parseInt(((JTextField) panel.getInputFields(9)).getText());
    }
}
