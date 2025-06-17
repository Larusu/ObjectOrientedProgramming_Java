package Midterms_UserRegistrationForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel extends JPanel{
    
    final int maxHeight = 300;
    final int maxWidth = 700;
    final int contentHeight = 19;
    Font font = new Font("Arial", Font.PLAIN, 13);

    public Panel(){

        this.setPreferredSize(new Dimension(maxWidth, maxHeight));
        //this.setBackground(Color.GRAY);
        this.setLayout(new BorderLayout()); //hgap, vgap
        this.add(body(), BorderLayout.CENTER);
        //this.add(footer(), BorderLayout.AFTER_LINE_ENDS);
    }

    JPanel body(){

        String[] countries = {"Philippines", "United States", "Canada", "Japan", "Dubai"};
        String[] hobbies = {"Reading", "Traveling", "Gaming"};
        String[] gender = {"Male", "Female"};

        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setOpaque(false);
        body.add(contentWithSpinner(countries, "First Name:", "Country:"));
        body.add(contentSimple("Last Name: ", "Username:"));
        body.add(contentSimple("Email:", "Password:"));
        body.add(contentWithRadioButton(hobbies, "Phone:", "Hobbies:"));
        body.add(contentWithOnlySpinner(gender, "Gender"));
        body.add(footer());
        
        return body;
    }

    JPanel footer(){

        JPanel content = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0)); // Left
        content.setOpaque(false);
        content.setPreferredSize(new Dimension(300, 300));

        JButton btn1 = new JButton("Submit");
        JButton btn2 = new JButton("Cancel");

        content.add(btn1);
        content.add(btn2);
        
        return content;
    }
    JPanel contentWithSpinner(String array[], String text, String secondText){
        
        JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 10));
        content.setOpaque(false);
        content.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0)); 

        JLabel firstText = new JLabel(text);
        firstText.setFont(font);
        firstText.setPreferredSize(new Dimension(75, contentHeight));
        JTextArea getText = new JTextArea();
        getText.setPreferredSize(new Dimension(125, contentHeight));

        JLabel arrayLabel = new JLabel(text);
        arrayLabel.setFont(font);
        arrayLabel.setPreferredSize(new Dimension(75, contentHeight));
        SpinnerListModel countrySelection = new SpinnerListModel(array);
        JSpinner spinner = new JSpinner(countrySelection);
        spinner.setPreferredSize(new Dimension(290, contentHeight));

        content.add(firstText);
        content.add(getText);
        content.add(arrayLabel);
        content.add(spinner);

        return content;
    }

    JPanel contentSimple(String firstText, String secondText){
        
        JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 10));
        content.setOpaque(false);

        JLabel text = new JLabel(firstText);
        text.setFont(font);
        text.setPreferredSize(new Dimension(75, contentHeight));
        JTextArea lastText = new JTextArea();
        lastText.setPreferredSize(new Dimension(125, contentHeight));

        JLabel arrayLabel = new JLabel(secondText);
        arrayLabel.setFont(font);
        arrayLabel.setPreferredSize(new Dimension(75, contentHeight));
        JTextArea lastArrayLabel = new JTextArea();
        lastArrayLabel.setPreferredSize(new Dimension(290, contentHeight));

        content.add(text);
        content.add(lastText);
        content.add(arrayLabel);
        content.add(lastArrayLabel);

        return content;
    }

    JPanel contentWithRadioButton(String[] option, String firstText, String secondText){

        JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 10));
        content.setOpaque(false);

        JLabel text = new JLabel(firstText);
        text.setFont(font);
        text.setPreferredSize(new Dimension(75, contentHeight));
        JTextArea lastText = new JTextArea();
        lastText.setPreferredSize(new Dimension(125, contentHeight));

        JLabel comboLabel = new JLabel(secondText);
        comboLabel.setFont(font);
        comboLabel.setPreferredSize(new Dimension(75, contentHeight));

        content.add(text);
        content.add(lastText);
        content.add(comboLabel);
        
        for(String options : option){
            JRadioButton radioButton = new JRadioButton(options);
            radioButton.setPreferredSize(new Dimension(80, contentHeight));
            content.add(radioButton);
        }

        return content;
    }
    JPanel contentWithOnlySpinner(String[] option, String text){

        JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT, 25, 10));
        content.setOpaque(false);

        JLabel arrayLabel = new JLabel(text);
        arrayLabel.setFont(font);
        arrayLabel.setPreferredSize(new Dimension(75, contentHeight));
        SpinnerListModel countrySelection = new SpinnerListModel(option);
        JSpinner spinner = new JSpinner(countrySelection);
        spinner.setPreferredSize(new Dimension(125, contentHeight));
        
        content.add(arrayLabel);
        content.add(spinner);

        return content;
    }

}
