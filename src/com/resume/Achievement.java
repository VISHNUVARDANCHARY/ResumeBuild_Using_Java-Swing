package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.resume.AchievementDetails;

public class Achievement {
    private JFrame frame;
    private List<AchievementDetails> achievements;
    private JPanel achievementPanel;
    private JButton saveButton;

    public Achievement() {
        achievements = new ArrayList<>();
    }

    public void showAchievementForm() {
        frame = new JFrame("Achievements");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        achievementPanel = new JPanel();
        achievementPanel.setLayout(new BoxLayout(achievementPanel, BoxLayout.Y_AXIS));

        addAchievementFields();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton addAchievementButton = new JButton("Add Another Achievement");
        addAchievementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAchievementFields();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAchievements();
                frame.dispose(); // Close the form after saving
            }
        });

        buttonPanel.add(addAchievementButton);
        buttonPanel.add(saveButton);

        frame.add(new JScrollPane(achievementPanel), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addAchievementFields() {
        JPanel achievementFieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        achievementFieldsPanel.setBorder(BorderFactory.createTitledBorder("Achievement"));

        JTextField achievementNameField = new JTextField();
        JTextField impactField = new JTextField();

        achievementFieldsPanel.add(new JLabel("Achievement Name:"));
        achievementFieldsPanel.add(achievementNameField);
        achievementFieldsPanel.add(new JLabel("Impact:"));
        achievementFieldsPanel.add(impactField);

        // Temporarily add empty details, will update when saving
        achievements.add(new AchievementDetails("", ""));

        achievementPanel.add(achievementFieldsPanel);
        achievementPanel.revalidate();
        achievementPanel.repaint();
    }

    private void saveAchievements() {
        // Update the achievements list with the current values from the fields
        achievements.clear(); // Clear the list first
        for (Component component : achievementPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                JTextField achievementNameField = (JTextField) panel.getComponent(1);
                JTextField impactField = (JTextField) panel.getComponent(3);
                achievements.add(new AchievementDetails(achievementNameField.getText(), impactField.getText()));
            }
        }

        // Save achievements to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("achievements.txt"))) {
            for (AchievementDetails details : achievements) {
                writer.write("Achievement: " + details.getAchievementName() + ", Impact: " + details.getImpact());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(frame, "Achievements saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving achievements: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<AchievementDetails> getAchievements() {
        return achievements;
    }
}





/*
package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Achievement {
    private JFrame frame;
    private List<AchievementDetails> achievements;
    private JPanel achievementPanel;
    private JButton saveButton;

    public Achievement() {
        achievements = new ArrayList<>();
    }

    public void showAchievementForm() {
        frame = new JFrame("Achievements");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        achievementPanel = new JPanel();
        achievementPanel.setLayout(new BoxLayout(achievementPanel, BoxLayout.Y_AXIS));

        addAchievementFields();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton addAchievementButton = new JButton("Add Another Achievement");
        addAchievementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAchievementFields();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAchievements();
            }
        });

        buttonPanel.add(addAchievementButton);
        buttonPanel.add(saveButton);

        frame.add(new JScrollPane(achievementPanel), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addAchievementFields() {
        JPanel achievementFieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        achievementFieldsPanel.setBorder(BorderFactory.createTitledBorder("Achievement"));

        JTextField achievementNameField = new JTextField();
        JTextField impactField = new JTextField();

        achievementFieldsPanel.add(new JLabel("Achievement Name:"));
        achievementFieldsPanel.add(achievementNameField);
        achievementFieldsPanel.add(new JLabel("Impact:"));
        achievementFieldsPanel.add(impactField);

        achievements.add(new AchievementDetails(achievementNameField.getText(), impactField.getText()));

        achievementPanel.add(achievementFieldsPanel);
        achievementPanel.revalidate();
        achievementPanel.repaint();
    }

    private void saveAchievements() {
        // Logic to save achievements goes here
        // For example, you could display a message
        JOptionPane.showMessageDialog(frame, "Achievements saved successfully!");
    }

    public List<AchievementDetails> getAchievements() {
        return achievements;
    }
}
*/
