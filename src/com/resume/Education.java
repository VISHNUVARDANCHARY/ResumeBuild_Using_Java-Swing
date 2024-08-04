package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Education {
    private List<EducationDetail> educationDetails = new ArrayList<>();

    public void showEducationForm() {
        JFrame frame = new JFrame("Education");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Degree/Certificate:"));
        JTextField degreeField = new JTextField(20);
        panel.add(degreeField);

        panel.add(new JLabel("Institute:"));
        JTextField instituteField = new JTextField(20);
        panel.add(instituteField);

        panel.add(new JLabel("CGPA/Percentage:"));
        JTextField cgpaField = new JTextField(20);
        panel.add(cgpaField);

        panel.add(new JLabel("Year:"));
        JTextField yearField = new JTextField(20);
        panel.add(yearField);

        JButton addButton = new JButton("Add Another Slot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(new JLabel("Degree/Certificate:"));
                JTextField newDegreeField = new JTextField(20);
                panel.add(newDegreeField);

                panel.add(new JLabel("Institute:"));
                JTextField newInstituteField = new JTextField(20);
                panel.add(newInstituteField);

                panel.add(new JLabel("CGPA/Percentage:"));
                JTextField newCgpaField = new JTextField(20);
                panel.add(newCgpaField);

                panel.add(new JLabel("Year:"));
                JTextField newYearField = new JTextField(20);
                panel.add(newYearField);

                frame.revalidate();
                frame.repaint();
            }
        });
        panel.add(addButton);

        JButton saveButton = new JButton("Save and Return");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                educationDetails.add(new EducationDetail(
                        degreeField.getText(),
                        instituteField.getText(),
                        cgpaField.getText(),
                        yearField.getText()
                ));
                frame.dispose();
            }
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public List<EducationDetail> getEducationDetails() {
        return educationDetails;
    }
}

