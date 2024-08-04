package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelevantCourses {
    private JFrame frame;
    private JTextField academicCoursesField;
    private JTextArea certificateCoursesArea;
    private JTextField anotherCoursesField;
    private RelevantCoursesDetails relevantCoursesDetails;

    public void showRelevantCoursesForm() {
        frame = new JFrame("Relevant Courses");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(4, 2, 10, 10));

        frame.add(new JLabel("Academic Courses:"));
        academicCoursesField = new JTextField();
        frame.add(academicCoursesField);

        frame.add(new JLabel("Certificate Courses (Name, Institution):"));
        certificateCoursesArea = new JTextArea(5, 20);
        frame.add(new JScrollPane(certificateCoursesArea));

        frame.add(new JLabel("Other Courses:"));
        anotherCoursesField = new JTextField();
        frame.add(anotherCoursesField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relevantCoursesDetails = new RelevantCoursesDetails(
                    academicCoursesField.getText(),
                    certificateCoursesArea.getText(),
                    anotherCoursesField.getText()
                );
                JOptionPane.showMessageDialog(frame, "Relevant Courses saved successfully!");
                frame.dispose();
            }
        });
        frame.add(saveButton);

        frame.setVisible(true);
    }

    public RelevantCoursesDetails getRelevantCoursesDetails() {
        return relevantCoursesDetails;
    }
}
