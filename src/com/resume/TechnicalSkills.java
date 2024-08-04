package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TechnicalSkills {
    private JFrame frame;
    private JTextField programmingLanguagesField;
    private JTextField toolsField;
    private TechnicalSkillsDetails technicalSkillsDetails;

    public void showTechnicalSkillsForm() {
        frame = new JFrame("Technical Skills");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(3, 2, 10, 10));

        frame.add(new JLabel("Programming Languages:"));
        programmingLanguagesField = new JTextField();
        frame.add(programmingLanguagesField);

        frame.add(new JLabel("Tools:"));
        toolsField = new JTextField();
        frame.add(toolsField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                technicalSkillsDetails = new TechnicalSkillsDetails(
                    programmingLanguagesField.getText(),
                    toolsField.getText()
                );
                JOptionPane.showMessageDialog(frame, "Technical Skills saved successfully!");
                frame.dispose();
            }
        });
        frame.add(saveButton);

        frame.setVisible(true);
    }

    public TechnicalSkillsDetails getTechnicalSkillsDetails() {
        return technicalSkillsDetails;
    }
}
