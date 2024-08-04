package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Experience {
    private List<ExperienceDetail> experienceDetails;

    public Experience() {
        experienceDetails = new ArrayList<>();
    }

    public void showExperienceForm() {
        JFrame frame = new JFrame("Experience");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        panel.add(new JLabel("Company Name:"));
        JTextField companyNameField = new JTextField(20);
        panel.add(companyNameField);

        panel.add(new JLabel("Worked Duration:"));
        JTextField durationField = new JTextField(20);
        panel.add(durationField);

        panel.add(new JLabel("Job Role:"));
        JTextField jobRoleField = new JTextField(20);
        panel.add(jobRoleField);

        panel.add(new JLabel("Job Type:"));
        String[] jobTypes = {"Full Time", "Part Time", "Remote"};
        JComboBox<String> jobTypeField = new JComboBox<>(jobTypes);
        panel.add(jobTypeField);

        panel.add(new JLabel("Your Contribution:"));
        JTextArea contributionArea = new JTextArea(3, 20);
        panel.add(new JScrollPane(contributionArea));

        JButton addButton = new JButton("Add Another Slot");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	/*
            	panel.add(new JLabel("Company Name:"));
                JTextField companyNameField = new JTextField(20);
                panel.add(companyNameField);

                panel.add(new JLabel("Worked Duration:"));
                JTextField durationField = new JTextField(20);
                panel.add(durationField);

                panel.add(new JLabel("Job Role:"));
                JTextField jobRoleField = new JTextField(20);
                panel.add(jobRoleField);

                panel.add(new JLabel("Job Type:"));
                String[] jobTypes = {"Full Time", "Part Time", "Remote"};
                JComboBox<String> jobTypeField = new JComboBox<>(jobTypes);
                panel.add(jobTypeField);

                panel.add(new JLabel("Your Contribution:"));
                JTextArea contributionArea = new JTextArea(3, 20);
                panel.add(new JScrollPane(contributionArea));
                */
            	
                ExperienceDetail detail = new ExperienceDetail(
                        companyNameField.getText(),
                        durationField.getText(),
                        jobRoleField.getText(),
                        (String) jobTypeField.getSelectedItem(),
                        contributionArea.getText()
                );
                experienceDetails.add(detail);

                companyNameField.setText("");
                durationField.setText("");
                jobRoleField.setText("");
                contributionArea.setText("");
            }
        });
        panel.add(addButton);

        JButton saveButton = new JButton("Save and Return");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExperienceDetail detail = new ExperienceDetail(
                        companyNameField.getText(),
                        durationField.getText(),
                        jobRoleField.getText(),
                        (String) jobTypeField.getSelectedItem(),
                        contributionArea.getText()
                );
                experienceDetails.add(detail);

                frame.dispose();
            }
        });
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public List<ExperienceDetail> getExperienceDetails() {
        return experienceDetails;
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

public class Experience 
{
    private List<ExperiencePanel> experiencePanels;

    public Experience() 
    {
        experiencePanels = new ArrayList<>();
    }

    public void showExperienceForm() 
    {
        JFrame frame = new JFrame("Experience");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        ExperiencePanel initialExperiencePanel = new ExperiencePanel();
        experiencePanels.add(initialExperiencePanel);
        addExperienceFields(panel, initialExperiencePanel);

        JButton addExperienceButton = new JButton("Add Another Slot");
        addExperienceButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ExperiencePanel experiencePanel = new ExperiencePanel();
                experiencePanels.add(experiencePanel);
                addExperienceFields(panel, experiencePanel);
                frame.revalidate();
                frame.repaint();
            }
        });

        panel.add(addExperienceButton);
        frame.add(panel);
        frame.setVisible(true);
    }

    private void addExperienceFields(JPanel panel, ExperiencePanel experiencePanel) 
    {
        panel.add(new JLabel("Company Name:"));
        panel.add(experiencePanel.getCompanyNameField());

        panel.add(new JLabel("Worked Duration:"));
        panel.add(experiencePanel.getDurationField());

        panel.add(new JLabel("Job Role:"));
        panel.add(experiencePanel.getJobRoleField());

        panel.add(new JLabel("Job Type:"));
        panel.add(experiencePanel.getJobTypeField());

        panel.add(new JLabel("Your Contribution:"));
        panel.add(new JScrollPane(experiencePanel.getContribution()));
    }

    public List<ExperienceDetail> getExperienceDetails() 
    {
        List<ExperienceDetail> details = new ArrayList<>();
        for (ExperiencePanel panel : experiencePanels) 
        {
            ExperienceDetail detail = new ExperienceDetail(
                panel.getCompanyNameField().getText(),
                panel.getDurationField().getText(),
                panel.getJobRoleField().getText(),
                panel.getJobTypeField().getSelectedItem().toString(),
                panel.getContribution().getText()
            );
            details.add(detail);
        }
        return details;
    }
}

class ExperienceDetail 
{
    private String companyName;
    private String duration;
    private String jobRole;
    private String jobType;
    private String contribution;

    public ExperienceDetail(String companyName, String duration, String jobRole, String jobType, String contribution) 
    {
        this.companyName = companyName;
        this.duration = duration;
        this.jobRole = jobRole;
        this.jobType = jobType;
        this.contribution = contribution;
    }

    public String getCompanyName() 
    {
        return companyName;
    }

    public String getDuration() 
    {
        return duration;
    }

    public String getJobRole() 
    {
        return jobRole;
    }

    public String getJobType() 
    {
        return jobType;
    }

    public String getContribution() 
    {
        return contribution;
    }
}
*/
