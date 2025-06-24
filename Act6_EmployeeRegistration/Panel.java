package Act6_EmployeeRegistration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel extends JPanel {

    final int width = 500;
    final int height = 500;
    
    Employee employee = new Employee();
    JTextArea textArea;
    ArrayList<JComponent> inputFields;

    Panel(){

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(width, height));

        inputFields = new ArrayList<>();
        this.add(bodyPanel(), BorderLayout.NORTH);
    }

    JPanel bodyPanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 0, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Employee Registration Form"));
        panel.setPreferredSize(new Dimension(width, height - 100));

        JLabel label;
        String[] labelStrings = {"First Name", "Last Name", "Age", "Gender", "Email",
                                "Contact No.", "Department", "Position", "Employee ID", "Salary"};
        String[] genderList = {"Male", "Female", "Non-Binary"};
        
        for(String strings : labelStrings){
            label = new JLabel(strings + ":");
            label.setHorizontalAlignment(SwingConstants.LEFT);
            panel.add(label);

            if(strings.equals("Gender")){
                JComboBox<String> gender  = new JComboBox<>(genderList);
                gender.setPreferredSize(new Dimension(width / 2, 30));
                inputFields.add(gender);
                panel.add(gender);
                continue;
            }
            JTextField textField = new JTextField();
            textField.setPreferredSize(new Dimension(width / 2, 30));
            inputFields.add(textField);
            panel.add(textField);
        }
        return panel;
    }   
}
