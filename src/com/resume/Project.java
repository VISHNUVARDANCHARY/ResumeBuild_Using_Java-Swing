package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private List<ProjectDetail> projectDetails;

    public Project() {
        projectDetails = new ArrayList<>();
    }

    public void showProjectForm() {
        JFrame frame = new JFrame("Project");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1)); // Initialize the panel with a GridLayout

        panel.add(new JLabel("Project Name:"));
        JTextField projectNameField = new JTextField(20);
        panel.add(projectNameField);

        panel.add(new JLabel("GitHub Link:"));
        JTextField gitHubLinkField = new JTextField(20);
        panel.add(gitHubLinkField);

        panel.add(new JLabel("About Project:"));
        JTextArea aboutProjectArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(aboutProjectArea));

        JButton addButton = new JButton("Add Another Slot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectDetail detail = new ProjectDetail(
                        projectNameField.getText(),
                        gitHubLinkField.getText(),
                        aboutProjectArea.getText()
                );
                projectDetails.add(detail);

                projectNameField.setText("");
                gitHubLinkField.setText("");
                aboutProjectArea.setText("");
            }
        });
        panel.add(addButton);

        JButton saveButton = new JButton("Save and Return");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectDetail detail = new ProjectDetail(
                        projectNameField.getText(),
                        gitHubLinkField.getText(),
                        aboutProjectArea.getText()
                );
                projectDetails.add(detail);

                frame.dispose();
            }
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public List<ProjectDetail> getProjectDetails() {
        return projectDetails;
    }
}



/*
package resumePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Project {
    private List<ProjectDetail> projectDetails;

    public Project() {
        projectDetails = new ArrayList<>();
    }

    public void showProjectForm() {
        JFrame frame = new JFrame("Project");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        panel.add(new JLabel("Project Name:"));
        JTextField projectNameField = new JTextField(20);
        panel.add(projectNameField);

        panel.add(new JLabel("GitHub Link:"));
        JTextField gitHubLinkField = new JTextField(20);
        panel.add(gitHubLinkField);

        panel.add(new JLabel("About Project:"));
        JTextArea aboutProjectArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(aboutProjectArea));

        JButton addButton = new JButton("Add Another Slot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectDetail detail = new ProjectDetail(
                        projectNameField.getText(),
                        gitHubLinkField.getText(),
                        aboutProjectArea.getText()
                );
                projectDetails.add(detail);

                projectNameField.setText("");
                gitHubLinkField.setText("");
                aboutProjectArea.setText("");
            }
        });
        panel.add(addButton);

        JButton saveButton = new JButton("Save and Return");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectDetail detail = new ProjectDetail(
                        projectNameField.getText(),
                        gitHubLinkField.getText(),
                        aboutProjectArea.getText()
                );
                projectDetails.add(detail);

                frame.dispose();
            }
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public List<ProjectDetail> getProjectDetails() {
        return projectDetails;
    }
}
*/

