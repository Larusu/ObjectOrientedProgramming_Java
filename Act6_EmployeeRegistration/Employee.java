package Act6_EmployeeRegistration;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Employee extends Person implements Displayable{
    
    String department;
    String position;
    double salary;
    String gender;
    int employeeID;

    public final int maxHeight = 500;
    public final int maxWidth = 500;

    JFrame frame = new JFrame();
    BodyPanel bodypanel = new BodyPanel(maxWidth, maxHeight);

    @Override
    public void display(){

        frame.setTitle("Employee Registration");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(bodypanel, BorderLayout.NORTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
