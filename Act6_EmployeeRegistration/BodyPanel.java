package Act6_EmployeeRegistration;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BodyPanel extends JPanel {

    int width = 0;
    int height = 0;
    
    private ArrayList<JComponent> inputFields;
    JTextArea outputTextArea = new JTextArea();

    BodyPanel(int width, int height){
        
        this.width = width;
        this.height = height;
        inputFields = new ArrayList<>();

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(width, height));

        this.add(panelBody(),BorderLayout.NORTH);
        
        outputTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        outputTextArea.setPreferredSize(new Dimension(width - 40, 100));
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        this.add(outputTextArea, BorderLayout.SOUTH);
    }

    JPanel panelBody(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2, 15, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Employee Registration Form"));
        panel.setPreferredSize(new Dimension(width - 20, height - 100));

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
        JButton submitBtn = new JButton("Register");
        submitBtn.setPreferredSize(new Dimension(width / 2, 30));
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitButtonOutput();
            }
        });
        panel.add(submitBtn);

        return panel;
    } 
    void submitButtonOutput(){
            
        Employee emp = register();
        if(emp != null){
            StringBuilder output = new StringBuilder();
            output.append("Name:        : " + emp.name + '\t');
            output.append("Contact No.  : " + emp.contactDetails[1] + '\n');
            output.append("Age          : " + emp.age + "\t");
            output.append("Department   : " + emp.department + '\n');
            output.append("Gender       : " + emp.gender + '\t');
            output.append("Position     : " + emp.position + '\n');
            output.append("Email        : " + emp.contactDetails[0] + "\t");
            output.append("Employee ID: : " + emp.employeeID + '\n');
            output.append("Salary       : " + String.format("%.2f", emp.salary));

            outputTextArea.setText(output.toString());
        }
    }

    public Employee register(){

        for(JComponent component : inputFields){
            if(component instanceof JTextField){
                JTextField textField = (JTextField) component;
                if(textField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return null;
                }
            }
        }
        try{
            Integer.parseInt(((JTextField)inputFields.get(2)).getText());
            Long.parseLong(((JTextField)inputFields.get(5)).getText());
            Integer.parseInt(((JTextField)inputFields.get(8)).getText());
            Double.parseDouble(((JTextField)inputFields.get(9)).getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid Number Input!", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Employee emp = new Employee();
        assignData(emp);

        return emp;
    }

    private void assignData(Employee emp){

        emp.name = ((JTextField)inputFields.get(0)).getText() + " " + ((JTextField)inputFields.get(1)).getText();
        emp.age = Integer.parseInt(((JTextField)inputFields.get(2)).getText());
        emp.gender = (String) ((JComboBox<?>)inputFields.get(3)).getSelectedItem();
        emp.contactDetails[0] = ((JTextField)inputFields.get(4)).getText();
        emp.contactDetails[1] = ((JTextField)inputFields.get(5)).getText();
        emp.department = ((JTextField)inputFields.get(6)).getText();
        emp.position = ((JTextField)inputFields.get(7)).getText();
        emp.employeeID = Integer.parseInt(((JTextField)inputFields.get(8)).getText());
        emp.salary = Double.parseDouble(((JTextField)inputFields.get(9)).getText());
    }
}
