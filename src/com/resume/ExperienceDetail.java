package com.resume;

public class ExperienceDetail {
    private String companyName;
    private String duration;
    private String jobRole;
    private String jobType;
    private String contribution;

    public ExperienceDetail(String companyName, String duration, String jobRole, String jobType, String contribution) {
        this.companyName = companyName;
        this.duration = duration;
        this.jobRole = jobRole;
        this.jobType = jobType;
        this.contribution = contribution;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDuration() {
        return duration;
    }

    public String getJobRole() {
        return jobRole;
    }

    public String getJobType() {
        return jobType;
    }

    public String getContribution() {
        return contribution;
    }
}



/*
package resumePack;

import javax.swing.*;

public class ExperiencePanel 
{
    private JTextField companyNameField;
    private JTextField durationField;
    private JTextField jobRoleField;
    private JComboBox<String> jobTypeField;
    private JTextArea contribution;

    public ExperiencePanel() 
    {
        companyNameField = new JTextField(20);
        durationField = new JTextField(20);
        jobRoleField = new JTextField(20);
        jobTypeField = new JComboBox<>(new String[]{"Full Time", "Part Time", "Remote"});
        contribution = new JTextArea(5, 20);
    }

    public JTextField getCompanyNameField() 
    {
        return companyNameField;
    }

    public JTextField getDurationField() 
    {
        return durationField;
    }

    public JTextField getJobRoleField() 
    {
        return jobRoleField;
    }

    public JComboBox<String> getJobTypeField() 
    {
        return jobTypeField;
    }

    public JTextArea getContribution() 
    {
        return contribution;
    }
}
*/
